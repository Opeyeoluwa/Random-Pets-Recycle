package com.driuft.random_pets_starter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PetAdapter (private val petList: List<String>) : RecyclerView.Adapter<PetAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.pet_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: PetAdapter.ViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load(petList[position])
            .centerCrop()
            .into(holder.petImage)

        holder.petImage.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Doggo at position $position clicked", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return petList.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val petImage: ImageView

        init {
            // Find our RecyclerView item's ImageView for future use
            petImage = view.findViewById(R.id.pet_image)
        }
    }
}

