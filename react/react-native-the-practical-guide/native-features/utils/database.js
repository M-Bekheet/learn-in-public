import * as SQLite from "expo-sqlite";
import { Place } from "../models/place";

const database = SQLite.openDatabase("places.db");

export function init() {
  const promise = new Promise((resolve, reject) => {
    database.transaction((t) => {
      t.executeSql(
        `CREATE TABLE IF NOT EXISTS places (
        id INTEGER PRIMARY KEY NOT NULL,
        title TEXT NOT NULL,
        imageUri TEXT NOT NULL,
        address TEXT NOT NULL,
        lat REAL NOT NULL,
        lng REAL NOT NULL
      )`,
        [],
        () => {
          resolve();
        },
        (_t, error) => {
          reject(error);
        }
      );
    });
  });
  return promise;
}

export function insertPlace(place) {
  const promise = new Promise((resolve, reject) => {
    database.transaction((t) => {
      t.executeSql(
        `INSERT INTO places (title, imageUri, address, lat, lng) VALUES ( ?, ?, ?, ?,?)`,
        [
          place.title,
          place.imageUri,
          place.address,
          place.location.lat,
          place.location.lng,
        ],
        (_, result) => {
          console.log(result);
          resolve();
        },
        (_t, error) => {
          console.log(error);
          reject(error);
        }
      );
    });
  });
  return promise;
}

export function fetchPlaces() {
  const promise = new Promise((resolve, reject) => {
    database.transaction((t) => {
      t.executeSql(
        `SELECT * FROM places`,
        [],
        (_t, result) => {
          const places = [];
          for (const dp of result.rows._array) {
            const place = new Place(
              dp.title,
              dp.imageUri,
              {
                lat: dp.lat,
                lng: dp.lng,
                address: dp.address,
              },
              dp.id
            );
            places.push(place);
          }
          resolve(places);
        },
        (_t, error) => reject(error)
      );
    });
  });
  return promise;
}

export async function fetchPlace(placeId) {
  const promise = new Promise((resolve, reject) => {
    database.transaction((t) => {
      t.executeSql(
        `SELECT * FROM places WHERE id = ?`,
        [placeId],
        (_t, result) => {
          const dp = result.rows._array[0];
          const place = new Place(
            dp.title,
            dp.imageUri,
            {
              lat: dp.lat,
              lng: dp.lng,
              address: dp.address,
            },
            dp.id
          );
          resolve(place);
        },
        (_t, error) => {
          reject(error);
        }
      );
    });
  });
  return promise;
}
