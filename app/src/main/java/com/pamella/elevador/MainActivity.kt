@file:Suppress("DEPRECATION")

package com.pamella.elevador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG

class MainActivity : AppCompatActivity() {

    private var floorTxt: EditText? = null
    private lateinit var enterButton: Button
    private lateinit var exitButton: Button
    private lateinit var goToFloorButton: Button
    private lateinit var currentFloorTxt: TextView
    private lateinit var occupancyTxt: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // coloca o app em fullscreen
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_main)

        bindView()

        val lift = Elevator()
        var people = 0
        var nextFloor: String

        enterButton.setOnClickListener {
            lift.enter(people)
            if (lift.occup){Toast.makeText(this@MainActivity, "Ocupação máxima alcançada", LENGTH_LONG).show() }
            else{
                people = lift.currentOccupation
                occupancyTxt.text = "Ocupação: $people/5 "
            }
        }

        exitButton.setOnClickListener {
            lift.exit(people)
            if (lift.occup){Toast.makeText(this@MainActivity, "Elevador vazio", LENGTH_LONG).show() }
            else{
                people = lift.currentOccupation
                occupancyTxt.text = "Ocupação: $people/5 "
            }}


        goToFloorButton.setOnClickListener {
            nextFloor = floorTxt?.text.toString()
            lift.chooseFloor(nextFloor)
            if(lift.floor == 0)
            {
                currentFloorTxt.text = lift.text
            }
            else{
                Toast.makeText(this@MainActivity, "Andar inexistente.", LENGTH_LONG).show()
            }

        }

    }

    private fun bindView() {
        floorTxt = findViewById(R.id.Irandar)
        enterButton = findViewById(R.id.bEntrar)
        exitButton = findViewById(R.id.bSair)
        goToFloorButton = findViewById(R.id.BAndar)
        currentFloorTxt = findViewById(R.id.andarAtual)
        occupancyTxt = findViewById(R.id.ocupacao)

        val initialOccupancy = 0
        occupancyTxt.text = "Ocupação: $initialOccupancy/5 "
        currentFloorTxt.text = "Andar atual: Térreo"
    }

}


//
//
//        goToFloorButton.setOnClickListener {
//            elevator.GetTopFloor(topFloor)
//            if (elevator.OverTopFloor(nextFloor1) || elevator.UnderMinFloor(nextFloor1)) {
//                Toast.makeText(this@MainActivity, "Andar inexistente.", LENGTH_LONG).show()
//            }
//            else{
//                currentFloorTxt.text = "Andar atual: $nextFloor1 °"
//            }
//
