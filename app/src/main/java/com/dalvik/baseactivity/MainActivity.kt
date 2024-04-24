package com.dalvik.baseactivity

import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import com.dalvik.baseactivity.base.BaseActivity
import com.dalvik.baseactivity.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override fun createViewModel(): MainViewModel =
        ViewModelProvider(this)[MainViewModel::class.java]

    override fun createViewBinding(layoutInflater: LayoutInflater): ActivityMainBinding =
        ActivityMainBinding.inflate(layoutInflater)

    override fun setupUiBehaviors() {
        binding.customText.text = "Cambio"
        viewModel.msgError.postValue("error")
    }


}