package com.example.myapplicationtictactoe

import android.app.Activity
import android.app.AlertDialog
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

class ServicesTicTacToe(size:Int,var context: Context) {
    var size = size

    fun showMatrix(data: Array<Array<Int>>){
        for (element in data) {
            for (j in data.indices) {
                print("${element[j]} ")
            }
            println()
        }
        println()
    }


    fun setMatrix(position:Int,data: Array<Array<Int>>,player:Int):Array<Array<Int>>{
        var newData = data
        newData[position/newData.size][position%newData.size] = player
        return newData
    }


    fun loopLeftRight(inData: Array<Array<Int>>):Boolean {
        var checkUser1 = 0
        var checkUser2 = 0
        var leftToLight = 0
        for (i in 0..inData.size-1){
            Log.e("check", inData[i][leftToLight].toString())

            if (inData[i][leftToLight] == 1){
                checkUser1++
            }else if (inData[i][leftToLight] == 2) {
                checkUser2++
            }
            leftToLight++
        }
        return winner(checkUser1, checkUser2)
    }


    fun loopRightToLeft(inData: Array<Array<Int>>):Boolean{
        var checkUser1 = 0
        var checkUser2 = 0
        var rightToLeft = inData.size-1
        for (i in 0..inData.size-1){
            Log.e("check", inData[i][rightToLeft].toString())
            if (inData[i][rightToLeft] == 1){
                checkUser1++
            }else if (inData[i][rightToLeft] == 2) {
                checkUser2++
            }
            rightToLeft--
        }
       return winner(checkUser1, checkUser2)
    }


    fun checkRow(inData: Array<Array<Int>>):Boolean{
        var checkUser1 = 0
        var checkUser2 = 0
        for (i in 0..inData.size-1){
            checkUser1 = 0
            checkUser2 = 0
            for (j in 0..inData.size-1){
                if (inData[i][j] == 1){
                    checkUser1++
                }else if (inData[i][j] == 2) {
                    checkUser2++
                }
                if (winner(checkUser1,checkUser2)){
                    return true
                }else{
                    continue
                }
            }
        }
        return false
    }


    fun checkColumn(inData: Array<Array<Int>>):Boolean{
        var checkUser1 = 0
        var checkUser2 = 0
        for (i in 0..inData.size-1){
            checkUser1 = 0
            checkUser2 = 0
            for (j in 0..inData.size-1){
                if (inData[j][i] == 1){
                    checkUser1++
                }else if (inData[j][i] == 2) {
                    checkUser2++
                }
               if (winner(checkUser1,checkUser2)){
                   return true
               }else{
                   continue
               }
            }
        }
        return false
    }


    fun winner(checkUser1: Int, checkUser2: Int):Boolean{

        if (checkUser1 == size){
            diaolog(1)
            return true
        }
        else if (checkUser2 == size){
            diaolog(2)
            return true
        }
        return false
    }

    fun checkDraw(lr: Boolean, rl: Boolean, cr: Boolean, cc: Boolean, count: Int) {
        if (lr == false&&rl == false&&cr == false&&cc == false&&count == size*size){
            diaolog(3)
        }
    }
    fun diaolog(s: Int) {
        val builder1 = AlertDialog.Builder(context)
        builder1.setMessage("ยินดีด้วย ผู้เล่น ${if (s == 3) "เสมอ" else s} .")
        builder1.setCancelable(true)

        builder1.setPositiveButton(
            "ตกลง"
        ) { dialog, id ->

            saveDb(s)


            (context as Activity).finish()
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
        val alert11 = builder1.create()
        alert11.show()
    }
    fun saveDb(log: Int){
        val dbHelper = MyDatabaseHelper(context)
        val db = dbHelper.writableDatabase
        val currentTime = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(
            Date()
        )
        val values = ContentValues().apply {
            put("win_match", log)
            put("timestamp", currentTime)
        }

        db.insert("history_tb", null, values)

    }


}