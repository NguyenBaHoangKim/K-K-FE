package com.example.k_k_application.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.common.utils.Extensions.Companion.toBitMap
import com.example.k_k_application.R
import com.example.k_k_application.model.UserStr

class UserAdapter(var mList: List<UserStr>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>()
{
    inner class UserViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val image : ImageView = itemView.findViewById(R.id.avt_str)
        val name : TextView = itemView.findViewById(R.id.name)
    }

    fun setFilteredList(mList: List<UserStr>){
        this.mList = mList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.container_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        println("set img")
        println(mList[position].avatar)
        holder.image.setImageBitmap(mList[position].avatar?.toBitMap())
        println("set name")
        holder.name.text = mList[position].username

    }

    override fun getItemCount(): Int {
        return mList.size
    }
}