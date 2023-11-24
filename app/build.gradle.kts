plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.beerlens"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.beerlens"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
   //flavors
    buildTypes {
        release {
            // url en el supuesto caso que estamos en Releaseee
            buildConfigField ("String", "API_URL",  "\"https://api.punkapi.com/v2/\"")
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

        }
        debug {
            //La url puede cambiar segun productivo o lab
            buildConfigField ("String", "API_URL", "\"https://api.punkapi.com/v2/\"")

        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        viewBinding = true
        buildConfig = true

    }
}


dependencies {
    // dependences added for the project
    val lifecycleVersion = "2.5.1"
    val navVersion = "2.5.3"
    val picasso = "2.8"
    val retrofit = "2.9.0"
    val room_version = "2.6.0"



    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel:$lifecycleVersion")
    // LiveData
    implementation("androidx.lifecycle:lifecycle-livedata:$lifecycleVersion")


    // navigation Component
    implementation("androidx.navigation:navigation-fragment:$navVersion")
    implementation("androidx.navigation:navigation-ui:$navVersion")


    //Picasso
    implementation("com.squareup.picasso:picasso:$picasso")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:$retrofit")
    implementation("com.squareup.retrofit2:converter-gson:$retrofit")

    // Room
    implementation("androidx.room:room-runtime:$room_version")
    annotationProcessor("androidx.room:room-compiler:$room_version")


    // depences added by Android Studio
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}