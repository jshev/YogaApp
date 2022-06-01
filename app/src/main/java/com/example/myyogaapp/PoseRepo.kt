package com.example.myyogaapp

import android.content.Context

class PoseRepo(context: Context) {
    var db:PoseDao? = AppDatabase.getInstance(context)?.poseDao()

    fun getAllPoses(): List<Pose> {
        return db?.selectPoses() ?: listOf<Pose>()
    }

    fun getPose(key: Int) : Pose? {
        return db?.selectPose(key)
    }

    fun search(name: String): List<Pose> {
        return db?.search("%" + name + "%") ?: listOf<Pose>()
    }

    fun deleteAllPoses() {
        db?.deletePoses()
    }

    fun insertPose(pose: Pose) {
        db?.insertPose(pose)
    }

    fun updatePose(pose: Pose) {
        db?.updatePose(pose)
    }

    fun deletePose(pose: Pose) {
        db?.deletePose(pose)
    }
}