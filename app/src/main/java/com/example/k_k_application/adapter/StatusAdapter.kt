package com.example.k_k_application.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.common.utils.Extensions.Companion.toBitMap
import com.example.k_k_application.R
import com.example.k_k_application.model.Status

class StatusAdapter(var mList: List<Status>): RecyclerView.Adapter<StatusAdapter.StatusViewHolder>() {
    inner class StatusViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val avt : ImageView = itemView.findViewById(R.id.avt)
        val userName : TextView = itemView.findViewById(R.id.userName)
        val status : TextView = itemView.findViewById(R.id.status_title)
        val image : ImageView = itemView.findViewById(R.id.img_status)
    }

    fun setFilteredList(mList: List<Status>){
        this.mList = mList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatusViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.container_status, parent, false)
        return StatusViewHolder(view)
    }

    override fun onBindViewHolder(holder: StatusViewHolder, position: Int) {
        holder.avt.setImageBitmap(mList[position].avt.toBitMap())
        holder.userName.text = mList[position].username
        holder.status.text = mList[position].status
        holder.image.setImageBitmap(mList[position].img.toBitMap())
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}