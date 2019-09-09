package com.rba.food

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rba.navigation.Activity
import com.rba.navigation.intentTo

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Thread {
            Thread.sleep(1500)
            startActivity(intentTo(Activity.Main))
            finish()
        }.start()

    }

}
