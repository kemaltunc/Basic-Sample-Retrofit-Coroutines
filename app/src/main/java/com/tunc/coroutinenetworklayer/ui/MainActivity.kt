package com.tunc.coroutinenetworklayer.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.tunc.coroutinenetworklayer.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainActivityVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MainActivityVM::class.java)

        viewModel.getTodo()

        viewModel.todoLiveData.observe(this, Observer {

            var text = ""

            it.forEach { todo ->
                text += todo.title + "\n"
            }
            activity_main_tv.text = text


        })

    }

}
