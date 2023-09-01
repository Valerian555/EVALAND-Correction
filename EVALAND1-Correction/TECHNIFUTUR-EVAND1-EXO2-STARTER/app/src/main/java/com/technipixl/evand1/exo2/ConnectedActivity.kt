package com.technipixl.evand1.exo2

import android.app.Activity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.TextView
import java.util.*

class ConnectedActivity : Activity() {
    private val listItems = mutableListOf<String>()
    private var textViewContent: TextView? = null
    private var numberOfItems = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_connected)
        loadData()
        textViewContent = findViewById<View>(R.id.textViewContent) as TextView
        displayData()
    }

    private fun loadData() {
        listItems.clear()
        listItems.add("Item1")
        listItems.add("Item2")
        listItems.add("Item3")
        listItems.add("Item4")
        listItems.add("Item5")
        listItems.add("Item6")
        numberOfItems = listItems.size
        updateData()
    }

    private fun updateData() {
        //remove last item
        listItems.removeAt(listItems.size - 1)
    }

    private fun displayData() {
        val stringBuilder = StringBuilder()
        for (i in 0 until numberOfItems - 1) {
            stringBuilder.append(
                listItems[i].trimIndent()
            )
            stringBuilder.appendLine()
        }
        textViewContent?.text = stringBuilder.toString()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.connected, menu)
        return true
    }
}