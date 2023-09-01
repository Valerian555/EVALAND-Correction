package com.technipixl.evand1.exo1

import android.app.Activity
import android.os.Bundle
import android.view.Menu

class ShopsActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.shop, menu)
        return true
    }
}