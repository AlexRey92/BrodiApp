package com.e.brodiapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.e.brodiapp.LOGIN.ProfilePicture

class BrodiAdapter: ListAdapter<ProfilePicture,BrodiAdapter.ViewHolder>(DiffCallback){
    lateinit var onItemClickListener:(ProfilePicture)-> Unit
    inner class ViewHolder(private val view:View): RecyclerView.ViewHolder(view){
        val photo:ImageView=view.findViewById(R.id.imageViewRV)
        fun onbind(Photo: ProfilePicture){
            val image= when(Photo.photo) {
                ProfilePicture.picture.BOCA -> R.drawable.juanci
                ProfilePicture.picture.NICEGUY -> R.drawable.jalvo
                ProfilePicture.picture.TALL -> R.drawable.devlin
                ProfilePicture.picture.SMALL -> R.drawable.turini
                ProfilePicture.picture.TUDENTS -> R.drawable.asol
                ProfilePicture.picture.IMPOSTOR -> R.drawable.tierra
            }
            photo.setImageResource(image)
            view.setOnClickListener { onItemClickListener(Photo) }
        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val myView:View=LayoutInflater.from(parent.context).inflate(R.layout.item_task,parent,false)
        return ViewHolder(myView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val holding=getItem(position)
        holder.onbind(holding)
    }
    companion object DiffCallback : DiffUtil.ItemCallback<ProfilePicture>() {
        override fun areItemsTheSame(oldItem: ProfilePicture, newItem: ProfilePicture): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ProfilePicture, newItem: ProfilePicture): Boolean {
            return oldItem == newItem
        }
    }
}
