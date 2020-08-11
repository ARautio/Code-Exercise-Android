package com.example.candidatecodereview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var fragment: MainFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragment = MainFragment()
        fragment?.listener?.observe(this, Observer {
            toolbar.title = it?.toString()
        })
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment!!)
            .addToBackStack(MainFragment::class.java.name)
            .commit()
    }
}
