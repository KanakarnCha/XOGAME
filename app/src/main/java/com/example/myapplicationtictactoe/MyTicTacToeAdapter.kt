package com.example.myapplicationtictactoe

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationtictactoe.databinding.BoxXOItemBinding

class MyTicTacToeAdapter(
    private val context: Context,
    val data: Array<Array<Int>>,
    var userRound: TextView
) :
    RecyclerView.Adapter<MyTicTacToeAdapter.ViewModel>() {
    var inData = data
    var statePosition = Array(data.size * data.size) { 0 }
    var count = 0
    var check = true
    inner class ViewModel(var itemModel: BoxXOItemBinding) : RecyclerView.ViewHolder(itemModel.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewModel {
        val binding = BoxXOItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewModel(binding)
    }

    override fun onBindViewHolder(holder: ViewModel, position: Int) {
        with(holder) {
            this.itemView.setOnClickListener {

                holder.itemView.isEnabled = false
                if (check == true) {
                    holder.itemView.setBackgroundResource(R.drawable.x_new)
                    inData = ServicesTicTacToe(inData.size, context).setMatrix(position, inData, 1)
                    statePosition[position] = 1
                    userRound.setText("รอบผู้เล่นที่ 2")
                    count++
                    loop()
                    check = false
                } else {
                    holder.itemView.setBackgroundResource(R.drawable.o_new)
                    inData = ServicesTicTacToe(inData.size, context).setMatrix(position, inData, 2)
                    statePosition[position] = 2
                    userRound.setText("รอบผู้เล่นที่ 1")
                    count++
                    loop()
                    check = true
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return data.size * data.size
    }

    fun loop() {
        val servicesTicTacToe = ServicesTicTacToe(data.size, context)
        var lr = servicesTicTacToe.loopLeftRight(data)
        var rl = servicesTicTacToe.loopRightToLeft(data)
        var cr = servicesTicTacToe.checkRow(data)
        var cc = servicesTicTacToe.checkColumn(data)
        servicesTicTacToe.checkDraw(lr,rl,cr,cc,count)
    }


}