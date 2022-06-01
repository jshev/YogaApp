package com.example.myyogaapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


// (...) not necessary if table names are the same
@Entity(tableName = "yoga_poses")
data class Pose(@PrimaryKey(autoGenerate = true) var poseId:Int?,
                    @ColumnInfo(name = "name") var name:String,
                    @ColumnInfo(name = "desc") var desc:String) {

}