package com.pamella.elevador

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG

class MainActivity : AppCompatActivity() {

    var txtandar:EditText? = null
    lateinit var botEntrar: Button
    lateinit var botSair: Button
    lateinit var botIrAndar: Button
    lateinit var andarAtual: TextView
    lateinit var Ocupacao: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // coloca o app em fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(R.layout.activity_main)


        txtandar = findViewById(R.id.Irandar)
        botEntrar = findViewById(R.id.bEntrar)
        botSair = findViewById(R.id.bSair)
        botIrAndar = findViewById(R.id.BAndar)
        andarAtual = findViewById(R.id.andarAtual)
        Ocupacao = findViewById(R.id.ocupacao)

        var oc:Int = 0
        Ocupacao.text = "Ocupação: $oc/5 "

        andarAtual.text = "Andar atual: Térreo"



        class elevador(){

            var proxAndar :String = ""

            fun entrar() {
                if (oc >= 5){
                    Toast.makeText(this@MainActivity, "Ocupação máxima alcançada", LENGTH_LONG).show()
            }
                else{
                    oc += 1
            }
            Ocupacao.text = "Ocupação: $oc/5 "
            }

            fun sair(){
                if(oc <= 0){
                Toast.makeText(this@MainActivity, "Elevador vazio", LENGTH_LONG).show()
            }
            else {
                oc -= 1
            }
            Ocupacao.text = "Ocupação: $oc/5 "
            }

            fun escolherandar(){
                proxAndar = txtandar?.text.toString()
                if (proxAndar.toInt() <= 6) {
                    andarAtual.text = "Andar atual: $proxAndar °"
                    if(proxAndar.toInt() == 0){
                        andarAtual.text = "Andar atual: Térreo"
                    }}
                else {
                    Toast.makeText(this@MainActivity, "Andar inexistente.", LENGTH_LONG).show()
                }
            }

            }

        val eleva = elevador()

        botIrAndar.setOnClickListener {
            eleva.escolherandar()
        }

        botEntrar.setOnClickListener(){
            eleva.entrar()
        }
        botSair.setOnClickListener { eleva.sair() }
        }
}