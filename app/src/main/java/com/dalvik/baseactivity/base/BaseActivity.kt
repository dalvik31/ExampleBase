package com.dalvik.baseactivity.base

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding


abstract class BaseActivity<BINDING : ViewBinding, VM : BaseViewModel> : AppCompatActivity() {

    protected lateinit var viewModel: VM
    protected lateinit var binding: BINDING


    protected abstract fun createViewModel(): VM

    protected abstract fun createViewBinding(layoutInflater: LayoutInflater): BINDING

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = createViewBinding(LayoutInflater.from(this))
        setContentView(binding.root)
        viewModel = createViewModel()
        observers()
        setupUiBehaviors()
    }

    private fun observers() {
        viewModel.run {
            loading.observe(this@BaseActivity) {

                if (it) {
                    /***
                     *  Show progress dialog
                     * */
                } else {
                    /***
                     *  Hide progress dialog
                     * */
                }
            }

            msgError.observe(this@BaseActivity) {
                /***
                 *  Show  dialog with msg -> it
                 * */
                showMsg(it)
            }
        }
    }

    abstract fun setupUiBehaviors()

    private fun showMsg(msg: String?) {
        val toast = Toast.makeText(this, msg, Toast.LENGTH_LONG)
        toast.cancel()
        toast.show()
    }

}