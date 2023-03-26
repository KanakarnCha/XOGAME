package com.example.myapplicationtictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplicationtictactoe.databinding.ActivityPageTicTacToe1Binding

class PageTicTacToe1 : AppCompatActivity() {
    lateinit var binding: ActivityPageTicTacToe1Binding
    lateinit var recyclerViewAdapter: MyTicTacToeAdapter
    var matrix: Array<Array<Int>>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPageTicTacToe1Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val bundle = intent.extras
        val data = bundle!!.getInt("inputSize",3)
        matrix = Array(data) { Array(data) { 0 } }
        recyclerViewAdapter = MyTicTacToeAdapter(this, matrix!!,binding.userRound)
        binding.recycleView.adapter = recyclerViewAdapter

        val myLinearLayoutManager = object : GridLayoutManager(this,data) {
            override fun canScrollVertically(): Boolean {
                return false
            }
        }
        binding.recycleView.layoutManager = myLinearLayoutManager
    }
}