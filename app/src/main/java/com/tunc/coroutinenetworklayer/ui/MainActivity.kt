package com.tunc.coroutinenetworklayer.ui

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.tunc.coroutinenetworklayer.R
import com.tunc.coroutinenetworklayer.base.AppCallback
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AppCallback {

    private lateinit var viewModel: MainActivityVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MainActivityVM::class.java)
        viewModel.setView(this)

        viewModel.getTodo()

        viewModel.todoLiveData.observe(this, Observer {

            var text = ""

            it.forEach { todo ->
                text += todo.title + "\n"
            }
            activity_main_tv.text = text


        })

    }

    override fun showLoading() {
        loading.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        loading.visibility = View.GONE
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }


}
