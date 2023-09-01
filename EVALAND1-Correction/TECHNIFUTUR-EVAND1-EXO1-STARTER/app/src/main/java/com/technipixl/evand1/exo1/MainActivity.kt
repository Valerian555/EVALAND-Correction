package com.technipixl.evand1.exo1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.View

class MainActivity : Activity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.buttonAbout).setOnClickListener(this)
        findViewById<View>(R.id.buttonShop).setOnClickListener(this)
        findViewById<View>(R.id.buttonShopingLogs).setOnClickListener(this)
        findViewById<View>(R.id.buttonShoppingCart).setOnClickListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.buttonShop -> {
                val shops = Intent(this, ShopsActivity::class.java)
                startActivity(shops)
            }
            R.id.buttonShopingLogs -> {
                val shoppingLogs = Intent(this, ShoppingLogsActivity::class.java)
                startActivity(shoppingLogs)
            }
            R.id.buttonShoppingCart -> {
                val shoppingCartIntent = Intent(this, ShoppingCartActivity::class.java)
                startActivity(shoppingCartIntent)
            }
            R.id.buttonAbout -> {
                val about = Intent(this, AboutActivity::class.java)
                startActivity(about)
            }
            else -> {
                //TODO: Not implemented yet
            }
        }
    }
}