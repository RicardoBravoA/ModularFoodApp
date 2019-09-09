object ApplicationId {
    val id = "pe.bcp.movie"
}

object Modules {
    val app = ":app"
    val navigator = ":navigator"
    val detail = ":detail"
    val list = ":list"
    val login = ":login"
    val movie = ":movie"
}

object Releases {
    val versionCode = 1
    val versionName = "1.0"
}

object Versions {
    val gradle = "3.4.2"
    val compileSdk = 28
    val minSdk = 21
    val targetSdk = 28
    val appcompat = "1.0.2"
    val coreKtx = "1.0.2"
    val constraintLayout = "1.1.3"
    val material = "1.0.0"
    val jUnit = "4.12"
    val testRunner = "1.2.0"
    val espressoCore = "3.2.0"
    val artifactoryLibrary = "0.0.3"
    val lifecycleExtensions = "2.0.0"
    val lifecycleViewModel = "2.0.0"
    val lifecycleCompiler = "2.0.0"
    val picasso = "2.71828"
    val gson = "2.8.5"
    val coroutinesCore = "1.2.1"
    val coroutinesAndroid = "1.2.1"
}

object SupportLibraries {
    val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    val material = "com.google.android.material:material:${Versions.material}"
    val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleExtensions}"
    val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleViewModel}"
    val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycleCompiler}"
}

object TestLibraries {
    val jUnit = "junit:junit:${Versions.jUnit}"
    val testRunner = "androidx.test:runner:${Versions.testRunner}"
    val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
}

object WorkaroundLibraries {
    val artifactoryLibrary = "com.rba.demo.artifactory.library:library:${Versions.artifactoryLibrary}"
    val gson = "com.google.code.gson:gson:${Versions.gson}"
    val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesCore}"
    val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesAndroid}"
}

object ImageLibraries {
    val picasso = "com.squareup.picasso:picasso:${Versions.picasso}"
}