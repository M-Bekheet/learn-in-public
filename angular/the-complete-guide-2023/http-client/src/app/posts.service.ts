import {
  HttpClient,
  HttpEventType,
  HttpHeaders,
  HttpParams,
} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Post } from './post.model';
import { map, catchError, tap } from 'rxjs/operators';
import { Subject, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class PostsService {
  error = new Subject<string>();
  firebaseURL = 'CHANGE_THIS_VALUE';
  constructor(private http: HttpClient) {}

  createAndStorePost(title: string, content: string) {
    // Send Http request
    const postData = { title, content };
    this.http
      .post<{ name: string }>(this.firebaseURL, postData, {
        observe: 'response',
      })
      .subscribe(
        (responseData) => {
          console.log(responseData);
        },
        (error) => this.error.next(error.message)
      );
  }
  fetchPosts() {
    return this.http
      .get<{ [key: string]: Post }>(this.firebaseURL, {
        headers: new HttpHeaders({
          'Custom-Header': 'Hello',
        }),
        params: new HttpParams().appendAll({
          custom: 'yes',
          print: 'pretty',
        }),
      })
      .pipe(
        map((responseData) => {
          const posts: Post[] = [];
          for (const key in responseData)
            if (responseData.hasOwnProperty(key))
              posts.push({ ...responseData[key], id: key });
          return posts;
        }),
        catchError((errorRes) => {
          return throwError(errorRes);
        })
      );
  }

  deletePosts() {
    this.http
      .delete(this.firebaseURL, {
        observe: 'events',
      })
      .pipe(
        tap((event) => {
          console.log(event);
          if (event.type === HttpEventType.Sent) {
          } else if (event.type === HttpEventType.Response) {
            console.log(event.body);
          }
        })
      )
      .subscribe();
  }
}
