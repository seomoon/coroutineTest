package com.shinhan.mobmail.minji.randomuserwithtdd.presentation.main

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shinhan.mobmail.minji.randomuserwithtdd.databinding.ItemUserBinding
import com.shinhan.mobmail.minji.randomuserwithtdd.domain.entity.User

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    val list = mutableListOf<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        Log.i("민지", "recyclerView onCreateViewHolder")
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.i("민지", "recyclerView onBindViewHolder")

        holder.bind(list[position])
    }

    class ViewHolder(
        private val binding: ItemUserBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            binding.user = user
            Log.i("민지", "binding : $user")
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
