package com.technipixl.evand1.exo1

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.Menu
import java.util.ArrayList

class ShoppingLogsActivity : Activity(), DialogInterface.OnClickListener {
    private var shoppingLogs = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_logs)
    }

    override fun onStart() {
        super.onStart()
        testMyLogs()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.shopping_logs, menu)
        return true
    }

    private fun testMyLogs() {
        if (shoppingLogs.isEmpty()) {
            val builder = AlertDialog.Builder(this)
            builder.setMessage("Aucun historique n'est disponible.").setPositiveButton("Ok", this).setNegativeButton("Annuler", null)
            val alertDialog = builder.create()
            alertDialog.show()
        }
    }

    override fun onClick(dialog: DialogInterface, which: Int) {
        // TODO Auto-generated method stub
    }
}