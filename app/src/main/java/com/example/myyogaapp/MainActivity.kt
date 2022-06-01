package com.example.myyogaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var repo:PoseRepo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        repo = PoseRepo(this)

        /*repo.insertPose(Pose(null,"Lotus",
            "A cross-legged sitting meditation pose, in which each foot is placed on the opposite thigh."))
        repo.insertPose(Pose(null, "Downward Dog",
            "A forward bend named after the resemblance to a dog stretching out with its hind legs extending upward and both head and forelegs facing downward."))
        repo.insertPose(Pose(null, "Fallen Angel",
            "A challenging arm balance and inversion, where the temple rests lightly on the ground."))
        */

        var poseList = repo.getAllPoses()

        if (poseList.isEmpty()) {
            //Toast.makeText(this, "No poses!", Toast.LENGTH_LONG).show()
            Log.d("CHECKED LIST","LIST EMPTY")
            emptyText.text = "LIST IS EMPTY"
        } else {
            //Toast.makeText(this, "POSE!", Toast.LENGTH_LONG).show()
            Log.d("CHECKED LIST","LIST NOT EMPTY")
            emptyText.text = ""
        }

        // get reference to view to populate
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // create adapter with data source and assign adapter
        var adapter = PoseAdapter(poseList)
        recyclerView.adapter = adapter

        deleteButton.setOnClickListener() {
            var intent = Intent(this, DeleteActivity::class.java)
            startActivity(intent)
        }

        addButton.setOnClickListener() {
            var intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }

        searchBar.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                var searchText = searchBar.text.toString()
                if (searchText == "") {
                    poseList = repo.getAllPoses()
                } else {
                    poseList = repo.search(searchText)
                }

                var adapter = PoseAdapter(poseList)
                recyclerView.adapter = adapter
            }
        })
    }
}