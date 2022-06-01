package com.example.myyogaapp

import android.content.Intent
import android.os.Debug
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class PoseAdapter(private val poseList: List<Pose>): RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflate
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.yoga_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // add element to view holder
        val itemVM = poseList[position]
        holder.name.text = itemVM.name
        holder.desc.text = itemVM.desc
        holder.id.text = itemVM.poseId.toString()

        holder.card.setOnClickListener() {
            //Toast.makeText(holder.card.getContext(), "Clicked! C:", Toast.LENGTH_SHORT).show()
            Log.d("CARD CLICKED",itemVM.poseId.toString())
            var context = holder.card.getContext()
            var intent = Intent(context, UpdateActivity::class.java)
            intent.putExtra("ID", itemVM.poseId )
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        // size of the list/datasource
        return poseList.size
    }
}

class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val name : TextView = view.findViewById(R.id.title_text)
    val desc : TextView = view.findViewById(R.id.desc_text)
    val id : TextView = view.findViewById(R.id.id_text)
    val card : CardView = view.findViewById(R.id.card_view)
}