package com.example.myyogaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_update.*

class UpdateActivity : AppCompatActivity() {

    lateinit var repo:PoseRepo
    var poseID :Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        repo = PoseRepo(this)

        var extras : Bundle? = getIntent().getExtras()
        if (extras != null) {
            poseID = extras.getInt("ID")
        }

        var pose = repo.getPose(poseID)
        if (pose != null) {
            editName.setText(pose.name)
            editDesc.setText(pose.desc)

            saveButton.setOnClickListener() {
                repo.updatePose(Pose(poseID, editName.text.toString(), editDesc.text.toString()))
                var intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }

            deletePoseButton.setOnClickListener() {
                repo.deletePose(Pose(poseID, editName.text.toString(), editDesc.text.toString()))
                var intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }

        }


    }
}