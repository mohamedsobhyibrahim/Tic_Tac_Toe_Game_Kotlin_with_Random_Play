package com.mohamedsobhy.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random as Random1

class MainActivity : AppCompatActivity() , View.OnClickListener{

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activePlayer = 1
    var function : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        function = intent.getStringExtra("1")

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        var cellID = 0
        val buttonChoice = v as Button

        when(buttonChoice.id){
            R.id.button1-> cellID=1
            R.id.button2-> cellID=2
            R.id.button3-> cellID=3
            R.id.button4-> cellID=4
            R.id.button5-> cellID=5
            R.id.button6-> cellID=6
            R.id.button7-> cellID=7
            R.id.button8-> cellID=8
            R.id.button9-> cellID=9
        }

        if (function == "1"){
            onePlayer(cellID , buttonChoice)
        }else{
            twoPlayer(cellID , buttonChoice)
        }

    }


    private fun twoPlayer(cellID : Int , buttonChoice : Button){
        if (activePlayer==1){
            buttonChoice.text = "X"
            buttonChoice.setBackgroundResource(R.color.colorBlue)
            player1.add(cellID)
            activePlayer = 2
        }else{
            buttonChoice.text = "O"
            buttonChoice.setBackgroundResource(R.color.colorDarkGreen)
            player2.add(cellID)
            activePlayer = 1
        }
        buttonChoice.isEnabled=false

        checkWinner()
    }

    private fun onePlayer(cellID : Int , buttonChoice : Button){
        if (activePlayer==1){
            buttonChoice.text = "X"
            buttonChoice.setBackgroundResource(R.color.colorBlue)
            player1.add(cellID)
            activePlayer = 2
            autoPlay()
            checkWinner()
        }else{
            buttonChoice.text = "O"
            buttonChoice.setBackgroundResource(R.color.colorDarkGreen)
            player2.add(cellID)
            activePlayer = 1
            checkWinner()
        }
        buttonChoice.isEnabled=false

    }

    private fun checkWinner(){
        var winner = -1

        // row 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winner = 1
        }

        if (player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winner = 2
        }

        // row 2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winner = 1
        }

        if (player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winner = 2
        }

        // row 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winner = 1
        }

        if (player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winner = 2
        }

        // col 1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winner = 1
        }

        if (player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winner = 2
        }

        // col 2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winner = 1
        }

        if (player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winner = 2
        }

        // col 3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winner = 1
        }

        if (player2.contains(3) && player2.contains(6) && player2.contains(8)){
            winner = 2
        }

        // cross 1
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)){
            winner = 1
        }

        if (player2.contains(1) && player2.contains(5) && player2.contains(9)){
            winner = 2
        }

        // cross 2
        if (player1.contains(3) && player1.contains(5) && player1.contains(7)){
            winner = 1
        }

        if (player2.contains(3) && player2.contains(5) && player2.contains(7)){
            winner = 2
        }

        if (winner != -1){
            if (winner == 1){
                Toast.makeText(this, "Player 1 win the game", Toast.LENGTH_SHORT).show()
                enableFalse()
            }else{
                Toast.makeText(this, "Player 2 win the game", Toast.LENGTH_SHORT).show()
                enableFalse()
            }
        }
    }

    private fun autoPlay(){
        val emptyCells = ArrayList<Int>()

        for (cellID in 1..9){
            if (!player1.contains(cellID) || player2.contains(cellID)){
                emptyCells.add(cellID)
            }
        }

        val random = Random()
        val randomIndex = random.nextInt(emptyCells.size - 0)+0
        val cellId= emptyCells[randomIndex]

        var buttonSelect :Button?
        buttonSelect = when(cellId){
            1-> button1
            2-> button2
            3-> button3
            4-> button4
            5-> button5
            6-> button6
            7-> button7
            8-> button8
            9-> button9
            else-> button1
        }

        onePlayer(cellId , buttonSelect)

    }

    private fun enableFalse(){
        button1.isEnabled = false
        button2.isEnabled = false
        button3.isEnabled = false
        button4.isEnabled = false
        button5.isEnabled = false
        button6.isEnabled = false
        button7.isEnabled = false
        button8.isEnabled = false
        button9.isEnabled = false
    }
}