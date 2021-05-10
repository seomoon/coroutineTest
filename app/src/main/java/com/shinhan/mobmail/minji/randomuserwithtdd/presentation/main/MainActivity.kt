package com.shinhan.mobmail.minji.randomuserwithtdd.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.shinhan.mobmail.minji.randomuserwithtdd.R
import com.shinhan.mobmail.minji.randomuserwithtdd.databinding.ActivityMainBinding
import com.shinhan.mobmail.minji.randomuserwithtdd.presentation.ViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter = MainAdapter()

    private val mainViewModel: MainViewModel by viewModels {
        ViewModelFactory.getInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )

        binding.viewModel= mainViewModel
        binding.lifecycleOwner = this
        binding.recyclerView.adapter = adapter

        mainViewModel.getUserList()
        setObserver()
    }

    private fun setObserver() {
        mainViewModel.userList.observe(this) { userList ->
            with(adapter) {
                list.clear()
                list.addAll(userList)
                notifyDataSetChanged()

                if(list.size > 0){
                    binding.progressBar.visibility = View.GONE
                } else {
                    binding.progressBar.visibility = View.VISIBLE
                }
            }
        }
    }
}