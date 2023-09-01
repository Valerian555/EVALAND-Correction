package com.technipixl.evand1.exo1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.View

class AboutActivity : Activity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        findViewById<View>(R.id.buttonContactUs).setOnClickListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.about, menu)
        return true
    }

    override fun onClick(view: View) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        val mailList = arrayOf("mail@neopixl.com")
        intent.putExtra(Intent.EXTRA_EMAIL, mailList)
        startActivity(Intent.createChooser(intent, "Send Email"))
    }
}