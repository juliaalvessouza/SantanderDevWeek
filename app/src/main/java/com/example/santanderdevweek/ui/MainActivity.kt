package com.example.santanderdevweek.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.santanderdevweek.R
import com.example.santanderdevweek.data.Conta

class MainActivity : AppCompatActivity() {
    private lateinit var mainviewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar_main))

        mainviewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        buscarContaCliente()

//        throw RuntimeException("Teste Crash")
    }

    fun buscarContaCliente(){
        mainviewModel.bucarContaCliente().observe(this, Observer { result ->
            bindIdView(result)
        });
    }

    fun bindIdView(conta: Conta){
        findViewById<TextView>(R.id.tv_agencia).text = conta.agencia
        findViewById<TextView>(R.id.tv_c_corrente).text = conta.numero
        findViewById<TextView>(R.id.tv_saldo).text = conta.saldo
        findViewById<TextView>(R.id.tv_limite).text = conta.limite
        findViewById<TextView>(R.id.tv_usuario).text = conta.cliente.nome
        findViewById<TextView>(R.id.tv_cartao_final_value).text = conta.cartao.numeroCartao
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_1 ->{
                Log.d("CLICK", "Item 1 selecionado")
                true
            }
//            R.id.item_2 ->{
//                Log.d("CLICK", "Item 2 selecionado")
//                true
//            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}