package com.shinhan.mobmail.minji.randomuserwithtdd.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.shinhan.mobmail.minji.randomuserwithtdd.R
import com.shinhan.mobmail.minji.randomuserwithtdd.databinding.ActivityMainBinding
import com.shinhan.mobmail.minji.randomuserwithtdd.presentation.ViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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

        setObserver()
        CoroutineScope(Dispatchers.Main).launch { // main을 view에서 생성 -> 로딩등 view의 관련된 코드분리 위해
            binding.progressBar.visibility = View.VISIBLE // 순차 실행 순서 바꾸면 다 받아온후 프로그레스 보여짐
            mainViewModel.getUserList() // 지연함수로 내부에서 IO 루팅 실행
        }
    }

    private fun setObserver() {
        mainViewModel.userList.observe(this) { userList ->
            with(adapter) {
                list.clear()
                list.addAll(userList)
                notifyDataSetChanged()
                binding.progressBar.visibility = View.GONE
                if(list.size <= 0){
                    Toast.makeText(applicationContext, "No Data", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}