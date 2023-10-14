import { Component, OnDestroy, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Post } from './post.model';
import { PostsService } from './posts.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit, OnDestroy {
  loadedPosts: Post[] = [];
  fetching = true;
  error = null;
  errSub: Subscription;

  constructor(private http: HttpClient, private postsService: PostsService) {}
  ngOnInit() {
    this.onFetchPosts();
    this.errSub = this.postsService.error.subscribe((err) => {
      this.fetching = false;
      this.error = err;
    });
  }

  onFetchPosts() {
    this.fetching = true;
    this.postsService.fetchPosts().subscribe(
      (posts) => {
        this.loadedPosts = posts;
        this.fetching = false;
      },
      (error) => {
        this.fetching = false;
        this.error = error.message;
      }
    );
  }

  onCreatePost(postData: Post) {
    this.fetching = true;
    this.postsService.createAndStorePost(postData.title, postData.content);
    this.fetching = false;
  }

  onClearPosts() {
    this.postsService.deletePosts();
    this.loadedPosts = [];
  }

  onHandleError() {
    this.error = null;
  }
  ngOnDestroy() {
    this.errSub.unsubscribe();
  }
}
