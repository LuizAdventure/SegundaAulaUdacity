package com.example.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName("Leitura")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.myName = myName

        //findViewById<Button>(R.id.done_button).setOnClickListener {
        //  addName(it)
        //}
        binding.doneButton.setOnClickListener {
            addName(it)
        }
    }

    private fun addName(view: View) {
        //val editText = findViewById<EditText>(R.id.name_edit)
        //val textView = findViewById<TextView>(R.id.name_view)

        binding.apply {
            myName?.nickname = nameEdit.text.toString()
            invalidateAll()
            binding.nameView.text = binding.nameEdit.text
            binding.nameEdit.visibility = View.GONE
            binding.doneButton.visibility = View.GONE
            binding.nameView.visibility = View.VISIBLE
        }
        //keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)
       }
}