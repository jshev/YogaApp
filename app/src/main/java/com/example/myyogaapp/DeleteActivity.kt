package com.example.myyogaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_delete.*

class DeleteActivity : AppCompatActivity() {

    lateinit var repo:PoseRepo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete)

        repo = PoseRepo(this)

        clearButton.setOnClickListener() {
            repo.deleteAllPoses()
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}