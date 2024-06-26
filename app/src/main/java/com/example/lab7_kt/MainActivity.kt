package com.example.lab7_kt

import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val tv1: TextView = findViewById(R.id.textView)
        val iv1: ImageView = findViewById(R.id.imageView)
        registerForContextMenu(tv1)
        registerForContextMenu(iv1)
    }

    companion object {
        const val MENU1_ID = 1
        const val MENU2_ID = 2
    }

    override fun onCreateContextMenu( // add textView to the context menu
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        var title=""
        super.onCreateContextMenu(menu, v, menuInfo)
//        when(v!!.id) {
//            R.id.textView -> title = "文字元件的選單"
//            R.id.imageView -> title = "影像元件的選單"
//        }
//        menu!!.add("本文選單1")
//        menu.add("本文選單2")
//        menu.setHeaderTitle("是${title}")

        menu!!.setHeaderTitle("是${title}")
        when (v!!.id) {
            R.id.textView -> {
                title = "文字元件的選單"
                menu.add(0, MENU1_ID, 0, "本文選單1")
            }

            R.id.imageView -> {
                title = "影像元件的選單"
                menu.add(0, MENU2_ID, 0, "本文選單2")
            }

        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        // set the action of the context menu
        var action = ""
        when (item.itemId) {
            MENU1_ID -> action = "本文選單1被點擊"
            MENU2_ID -> action = "本文選單2被點擊"
        }
        Toast.makeText(this, "!!${action}!!", Toast.LENGTH_SHORT).show()
        return super.onContextItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu1, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item1 -> Toast.makeText(
                this,
                "menu1 clicked", Toast.LENGTH_SHORT
            ).show()

            R.id.item3 -> Toast.makeText(this, "menu3 clicked", Toast.LENGTH_SHORT).show()
            R.id.item4 -> Toast.makeText(this, "menu4 clicked", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
}