package com.example.santanderdevweek.data.local

import com.example.santanderdevweek.data.Cartao
import com.example.santanderdevweek.data.Cliente
import com.example.santanderdevweek.data.Conta

class FakeData {

    fun getLocalData() : Conta {
        val cliente = Cliente("Júlia")
        val cartao = Cartao("45666666877")
        return Conta("4445652-9",
                "4555-8",
                "1.452,36",
                "4.369,55",
                cliente,
                cartao)
    }
}