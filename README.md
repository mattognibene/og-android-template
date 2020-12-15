## OG Android Template

The OG Android Template provides all the boilerplate, startercode, and dependencies needed for a Kotlin-first, clean architecture, MvI / MVVM Android application.

## Dependencies Included

 - Kotlin
 - AndroidX
 - Dagger
 - Espresso
 - Glide
 - OkHttp
 - Retrofit
 - Room
 - RoboElectric
 - Coroutines
 - RxJava
 - Timber
 - Moshi

## How to Get Started

### Cloning Repository

 1. `git clone https://github.com/mattognibene/og-android-template`
 2. `mv og-android-template <your project name here>`
 3. `cd` into the directory
 4. `yes | rm -r .git ; git init`
 5. `git add *`
 6. `git add .gitignore`
 7. `git commit -m "init"`
 8. `git remote add origin <your repo URL>`

### Setting Up Project
 1. Open the project in Android Studio. Open `app/java` and right click on the package `com.example` and press `Refactor` -> `Rename` -> `Rename Package` and rename the package to your application package name.
 2. In the `app` build.gradle file, change the `applicationId` to your new package name. Be sure to Gradle sync after making changes.
 3. Rename the class `ExampleApp` to you app name.BeneApp
 4. In strings.xml, change `app_name` to your app name.
 
### Key Stores
 1. Create two key store files, one for `develop` and one for `production`.
 2. Edit the `signingConfigs` in build.gradle to point to your new key stores.
