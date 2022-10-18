package com.example.pr17

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : Activity(), View.OnClickListener {
    var btnWeb: Button? = null
    var btnMap: Button? = null
    var btnCall: Button? = null

    /** Called when the activity is first created.  */
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnWeb = findViewById<View>(R.id.btnWeb) as Button
        btnMap = findViewById<View>(R.id.btnMap) as Button
        btnCall = findViewById<View>(R.id.btnCall) as Button
        btnWeb!!.setOnClickListener(this)
        btnMap!!.setOnClickListener(this)
        btnCall!!.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val intent: Intent
        when (v.getId()) {
            R.id.btnWeb -> {
                intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://developer.android.com"))
                startActivity(intent)
            }
            R.id.btnMap -> {
                intent = Intent()
                intent.action = Intent.ACTION_VIEW
                intent.data = Uri.parse("geo:51.3819697,-0.031766")
                startActivity(intent)
            }
            R.id.btnCall -> {
                intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("tel:8805553535")
                startActivity(intent)
            }
        }
    }
}