package com.example.lukewhitworthassignment2.view

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lukewhitworthassignment2.R
import com.example.lukewhitworthassignment2.model.Track
import com.squareup.picasso.Picasso

class UserAdapter(private val list: List<Track>): RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    inner class UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun onBind(track: Track) {
            val tvTitle = itemView.findViewById<TextView>(R.id.tv_title)
            val tvArtist = itemView.findViewById<TextView>(R.id.tv_artist)
            val tvPrice  = itemView.findViewById<TextView>(R.id.tv_price)
            val ivThumbnail = itemView.findViewById<ImageView>(R.id.iv_artwork)

            tvTitle.text = track.trackName
            tvArtist.text = track.artistName
            val price = "${track.trackPrice} USD"
            tvPrice.text = price
            Picasso.get().load(track.artworkUrl60).placeholder(R.drawable.ic_launcher_foreground).fit().into(ivThumbnail)

            itemView.setOnClickListener {
                val intent = Intent()
                intent.action = Intent.ACTION_VIEW
                intent.setDataAndType(Uri.parse(track.previewUrl), "audio/*")
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val listItem = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return UserViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}