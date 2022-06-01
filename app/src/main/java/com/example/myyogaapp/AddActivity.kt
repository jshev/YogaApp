package com.example.myyogaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {

    lateinit var repo:PoseRepo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        repo = PoseRepo(this)

        insertButton.setOnClickListener() {
            var name = editNewName.text.toString()
            var desc = editNewDesc.text.toString()

            if (name != "" && desc != "") {
                repo.insertPose(Pose(null, name, desc))
                var intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }


    }
}