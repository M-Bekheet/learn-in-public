# React Native - Apps

_Note_: To build APK files of your project, follow this [article](https://instamobile.io/android-development/generate-react-native-release-build-android/). Also, set `enableProguardInReleaseBuilds` to `true` in `/android/app/build.gradle` as it decreases the build size.

## [Guess Number Game](/react/react-native-the-practical-guide/guess-number-mobile-app/)

The idea is pretty simple. You enter a number from 1 to 100 and the app will start guessing it based on your hints.

Stack: React Native JS & Expo.

Topics learned while building the app:

- Inputs validation.
- React Native logic management.
- Styling & Responsive Layouts creation based on device orientation/dimensions.
- Platform agnostic styling and behavior.

## [Meals App](/react/react-native-the-practical-guide/meals-mobile-app/)

This app shows categorized meals, ingredients, and how to make them.

Stack: React Native,React Navigation / Context API / Redux RTK, and Expo.

Topics learned while building this app:

- Building multi-routes & nested-routes screens through React Navigation.
- Using Expo Icons library.
- Building shared favorite meals store through the context API & RTK.

## [Expenses Tracking App](/react/react-native-the-practical-guide/expenses-tracker/)

Expenses tracker app that stores your expenses on a host

New Topics learned while building this app:

- Integration with Firebase.
- Form Validation.
- Loading Fallback.
- Expo Environment Variables Usage.

## [Authentication App](/react/react-native-the-practical-guide/auth-app/)

React Native Mobile App that handles authentication through Firebase.

New Topics learned while building this app:

- Authentication management in RN.
- Authentication with Firebase.

## [Native Features App](/react/react-native-the-practical-guide/native-features/)

Places Management app that manages places by saving them to mobile storage and pick images of them.

New Topics learned while building this app:

- Camera & Location Usage.
- Presentation of Maps and Images.
- Store to local database with SQLite.
- Usage of Google Maps Static API.

## [Bare React Native Apps](/react/react-native-the-practical-guide/bare-react-app/)

## [Bare Expo App](/react/react-native-the-practical-guide/bare-expo-app)

These are 2 apps that are built in React Native Workflow directly or by Expo bare workflow.
Building such apps without expo is somehow a cumbersome, but this gives you more control on your application.

I faced issues while building and running them for Android. Here how I fixed them:

- Changed my JDK and Java Version. I degraded the version from 20 to JDK Temurin-17.0.7 and installed gradle.

  ```
  Gradle 8.5
  Kotlin: 1.9.20
  Groovy: 3.0.17
  Ant: Apache Ant(TM) version 1.10.13 compiled on January 4 2023
  JVM: 21.0.1 (Homebrew 21.0.1)
  OS: Mac OS X 14.2.1 aarch64
  ```

- Changed distributionUrl in `android/gradle/wrapper/gradle-wrapper.properties` to be path of a local zip file I downloaded as it seems its url is blocked in my country!

  `distributionUrl=gradle-8.0.1-all.zip`

- Opened the project in Android directory in Android Studio to let it build with gradle works

## [Push Notifications App](/react/react-native-the-practical-guide/notifications-app/)

A limited functionality and simple app for pushing local and remote notifications.

Note: This project did not work with me using `npm` so I used `yarn` instead.

New Topics learned while building this app:

- Setting up scheduled notifications.
- Getting notifications remotely (eg. using FCM).
