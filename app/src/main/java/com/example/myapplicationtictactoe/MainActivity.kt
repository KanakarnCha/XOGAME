package com.example.myapplicationtictactoe

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplicationtictactoe.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        click()
//        val dbHelper = MyDatabaseHelper(view.context)
//        val db = dbHelper.writableDatabase
//        db.delete("history_tb", null, null)
    }
    @SuppressLint("Range")
    fun click(){
        binding.btnPlayTic.setOnClickListener {
            val intent = Intent(applicationContext,PageTicTacToe1::class.java)
            val bundle = Bundle()

            if (binding.edtNum.text.toString() == ""){
                bundle.putInt("inputSize", 3)
            }else{
                bundle.putInt("inputSize", binding.edtNum.text.toString().toInt())
            }
            intent.putExtras(bundle)
            startActivity(intent)
            finish()
        }
        binding.btnPlayTicHistory.setOnClickListener {
            val intent = Intent(applicationContext,PageHistory::class.java)
            startActivity(intent)
        }

    }
}