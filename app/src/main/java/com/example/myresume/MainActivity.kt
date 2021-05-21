package com.example.myresume

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myresume.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val nameObject: MyName = MyName("Sarthak Handa")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = nameObject
        binding.doneButton.setOnClickListener {
            saveNickname(it)
        }
    }

    private fun saveNickname(view: View) {

        binding.apply {
            myName?.nickname = userName.text.toString()
            invalidateAll()
            userName.visibility = View.GONE
            view.visibility = View.GONE
            nickname.visibility = View.VISIBLE
        }

        // Hide the keyboard.
        val hideKeyboard = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        hideKeyboard.hideSoftInputFromWindow(view.windowToken, 0)
    }
}