package com.technipixl.evand1.exo1

import android.app.Activity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Button

class ShoppingCartActivity : Activity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_cart)
        (findViewById<View>(R.id.buttonValidateShoppingCart) as Button).setOnClickListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.shopping_cart, menu)
        return true
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.buttonValidateShoppingCart -> finish()
            else -> {
                //TODO: Not implemented yet
            }
        }
    }
}