package com.example.myyogaapp

import androidx.room.*

@Dao
interface PoseDao {

    // Create
    @Insert
    fun insertPose(pose: Pose)

    // Read
    @Query("select * from yoga_poses")
    fun selectPoses() : List<Pose>

    @Query("SELECT * from yoga_poses WHERE poseId = :key")
    fun selectPose(key: Int): Pose?

    @Query("select * from yoga_poses where name like :name")
    fun search(name: String) : List<Pose>

    // Update
    @Update
    fun updatePose(pose: Pose)

    // Delete
    @Delete
    fun deletePose(pose: Pose)

    @Query("delete from yoga_poses")
    fun deletePoses()

}