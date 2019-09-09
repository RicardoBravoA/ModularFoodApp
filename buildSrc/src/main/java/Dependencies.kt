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
    val loggingInterceptor = "3.14.2"
    val converterGson = "2.5.0"
    val okhttp = "3.14.2"
    val mockitoCore = "2.23.0"
    val coroutinesTest = "1.3.0-M2"
    val playServices = "12.0.1"
    val lifecycleRuntime = "2.0.0"
    val coroutinesAdapter = "0.9.2"
}

object SupportLibraries {
    val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    val material = "com.google.android.material:material:${Versions.material}"
    val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleExtensions}"
    val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleViewModel}"
    val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycleCompiler}"
    val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime:${Versions.lifecycleRuntime}"
}

object TestLibraries {
    val jUnit = "junit:junit:${Versions.jUnit}"
    val testRunner = "androidx.test:runner:${Versions.testRunner}"
    val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    val mockitoCore = "org.mockito:mockito-core:${Versions.mockitoCore}"
    val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesTest}"
}

object CoroutinesLibraries {
    val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesCore}"
    val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesAndroid}"
}

object ImageLibraries {
    val picasso = "com.squareup.picasso:picasso:${Versions.picasso}"
}

object PlayServicesLibraries {
    val playServices = "com.google.android.gms:play-services:${Versions.playServices}"
}

object NetworkingLibraries {
    val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"
    val converterGson = "com.squareup.retrofit2:converter-gson:${Versions.converterGson}"
    val gson = "com.google.code.gson:gson:${Versions.gson}"
    val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    val artifactoryLibrary = "com.rba.demo.artifactory.library:library:${Versions.artifactoryLibrary}"
    val coroutinesAdapter = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.coroutinesAdapter}"

}