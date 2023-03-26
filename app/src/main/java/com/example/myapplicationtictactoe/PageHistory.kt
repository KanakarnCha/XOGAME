package com.example.myapplicationtictactoe

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.example.myapplicationtictactoe.databinding.ActivityMainBinding
import com.example.myapplicationtictactoe.databinding.ActivityPageHistoryBinding

class PageHistory : AppCompatActivity() {
    lateinit var binding:ActivityPageHistoryBinding
    var text = ""
    var user1 = 0
    var user2 = 0
    var draw = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPageHistoryBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)
        show()
    }

    @SuppressLint("Range")
    fun show(){
        val dbHelper = MyDatabaseHelper(this.applicationContext) // create an instance of your SQLiteOpenHelper subclass
        val db = dbHelper.readableDatabase // get a readable database instance

        val cursor = db.rawQuery("SELECT * FROM history_tb", null)

        while (cursor.moveToNext()) {
            val id = cursor.getInt(cursor.getColumnIndex("id"))
            val name = cursor.getInt(cursor.getColumnIndex("win_match"))
            val age = cursor.getString(cursor.getColumnIndex("timestamp"))
            text += "เลขที่ ${id}  :  ผู้ชนะ : ${if (name == 3) "เสมอ" else name } : ${age} \n\n\n"
            if (name == 1){
                user1++
            }
            if (name == 2){
                user2++
            }
            if(name == 3){
                draw++
            }
            Log.e("CheckText", text)
            binding.tvHistory.setText(text)

        }

        println("========================")
        println(user1)
        cursor.close()
        binding.scoreUser1.setText(user1.toString())
        binding.scoreUser2.setText(user2.toString())
        binding.tvDraw.setText(draw.toString())

    }
}