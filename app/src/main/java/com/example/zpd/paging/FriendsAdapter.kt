package com.example.zpd.paging

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.paging.PagingDataAdapter
import com.example.zpd.databinding.RecyclerViewUserBinding
//import com.bumptech.glide.Glide
import com.example.zpd.entities.User

class FriendsAdapter : PagingDataAdapter<User, FriendsAdapter.FriendViewHolder>(UserDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RecyclerViewUserBinding.inflate(inflater, parent, false)
        return FriendViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FriendViewHolder, position: Int) {
        val user = getItem(position)
        user?.let { holder.bind(it) }
    }

    inner class FriendViewHolder(private val binding: RecyclerViewUserBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            binding.text.text = user.nickname
            Log.d("FRIEND", user.nickname)
            //Glide.with(binding.root.context)
            //    .load(user.profileImageUrl)
            //    .circleCrop()  // Circular frame for photo
            //    .into(binding.userProfileImage)
        }
    }

    class UserDiffCallback : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }
    }
}