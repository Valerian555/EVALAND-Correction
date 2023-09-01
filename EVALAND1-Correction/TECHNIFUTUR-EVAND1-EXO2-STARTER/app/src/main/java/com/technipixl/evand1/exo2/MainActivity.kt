package com.technipixl.evand1.exo2

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.EditText

class MainActivity : Activity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.buttonlogin).setOnClickListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onClick(v: View) {
        val loginEmail = (findViewById<View>(R.id.editTextEmail) as EditText).text.toString()
        val password = (findViewById<View>(R.id.editTextPassword) as EditText).text.toString()
        if (!isLoginValid(loginEmail)) {
            val builder =
                AlertDialog.Builder(this).setMessage("Login invalide").setPositiveButton("Ok", null)
            val alertDialog = builder.create()
            alertDialog.show()
            return
        }
        if (password.isEmpty()) {
            return
        }
        val intentConnection = Intent(this, ConnectedActivity::class.java)
        startActivity(intentConnection)
    }

    private fun isLoginValid(login: String): Boolean {
        return login.contains("@") && !Character.isDigit(login[0])
    }
}