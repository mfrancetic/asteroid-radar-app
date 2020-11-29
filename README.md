# Project Title

Asteroid Radar

## Getting Started

Asteroid Radar is an app to view the asteroids detected by NASA that pass near Earth, you can view all the detected asteroids in a period of time, their data (Size, velocity, distance to Earth) and if they are potentially hazardous.

The app consists of two screens: A Main screen with a list of all the detected asteroids and a Details screen that displays the data of that asteroid once it´s selected in the Main screen list. The main screen also shows the NASA image of the day to make the app more striking.

### Screenshots

![Screenshot 1](starter/screenshots/screen_1.png)
![Screenshot 2](starter/screenshots/screen_2.png)
![Screenshot 3](starter/screenshots/screen_3.png)
![Screenshot 4](starter/screenshots/screen_4.png)

### Dependencies

    implementation fileTree(dir: 'libs', include: ['*.jar'])
    implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"
    implementation 'androidx.appcompat:appcompat:1.2.0'
    implementation 'androidx.core:core-ktx:1.3.2'
    implementation 'androidx.constraintlayout:constraintlayout:2.0.4'

    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0"
    implementation "androidx.lifecycle:lifecycle-livedata-ktx:2.2.0"
    implementation 'androidx.fragment:fragment-ktx:1.2.5'

    implementation "androidx.navigation:navigation-fragment-ktx:2.3.1"
    implementation "androidx.navigation:navigation-ui-ktx:2.3.1"

    implementation "com.squareup.moshi:moshi:1.8.0"
    implementation "com.squareup.moshi:moshi-kotlin:1.8.0"

    implementation "com.squareup.retrofit2:retrofit:2.9.0"
    implementation "com.squareup.retrofit2:converter-moshi:2.9.0"
    implementation 'com.squareup.retrofit2:converter-scalars:2.5.0'

    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.9"
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9"
    implementation "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2"

    implementation "androidx.recyclerview:recyclerview:1.1.0"

    implementation 'com.squareup.picasso:picasso:2.5.2'

    implementation "androidx.room:room-ktx:2.2.5"
    implementation "androidx.room:room-runtime:2.2.5"
    kapt "androidx.room:room-compiler:2.2.5"

    implementation "android.arch.work:work-runtime-ktx:1.0.1"

    testImplementation 'junit:junit:4.13.1'
    androidTestImplementation 'androidx.test.ext:junit:1.1.2'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.3.0'

### Installation

## Project Instructions

The most important dependencies used are:
- Retrofit to download the data from the Internet.
- Moshi to convert the JSON data we are downloading to usable data in form of custom classes.
- Picasso to download and cache images.
- RecyclerView to display the asteroids in a list.

The following components from the Jetpack library are used:
- ViewModel
- Room
- LiveData
- Data Binding
- Navigation


The application:
- Includes the Main screen with a list of clickable asteroids
- Includes a Details screen that displays the selected asteroid data once it’s clicked in the Main screen
- Downloads and parses data from the NASA NeoWS (Near Earth Object Web Service) API.
- Once an asteroid is saved in the database, the list of asteroids is displayed
- The asteroids data is cached by using a worker, so it downloads and saves week asteroids in background when device is charging and wifi is enabled, as well as deleted the asteroids data of the previous day
- App works in multiple screen sizes and orientations, also it provides talk back and push button navigation.


## Built With

To build this project the NASA NeoWS (Near Earth Object Web Service) API is used, which can be found here:
https://api.nasa.gov/

In order to run the app, you need an API Key which is provided for you in that same link, just fill the fields in the form and click Signup.
