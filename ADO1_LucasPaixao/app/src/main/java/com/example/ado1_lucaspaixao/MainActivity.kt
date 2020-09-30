package com.example.ado1_lucaspaixao

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_consulta.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences = getSharedPreferences("sharedPreferencesProdutos", MODE_PRIVATE)

        btnCalcular.setOnClickListener { v: View ->
            val nome = txtNome.text.toString()
            val precoCusto = txtPrecoCusto.text.toString()
            val precoVenda = txtPrecoVenda.text.toString()

            val calculo = precoVenda.toFloat() - precoCusto.toFloat()

            sharedPreferences.edit().putString(nome+"NomeProduto", nome).apply()
            sharedPreferences.edit().putString(nome+"PrecoCustoProduto", precoCusto).apply()
            sharedPreferences.edit().putString(nome+"PrecoVendaProduto", precoVenda).apply()
            sharedPreferences.edit().putString(nome+"PrejuizoProduto", calculo.toString()).apply()

            if(calculo > 0){
                textViewLucro.setText("Lucro: " + calculo)

            }else if(calculo < 0){
                textViewLucro.setText("Prejuizo: " + calculo)
            }else {
                textViewLucro.setText("Você não obteve nem lucro e nem prejuizo")
            }

            txtNome.text.clear()
            txtPrecoCusto.text.clear()
            txtPrecoVenda.text.clear()
        }
        btnLimpar.setOnClickListener { v: View ->
            txtNome.text.clear()
            txtPrecoCusto.text.clear()
            txtPrecoVenda.text.clear()
            textViewLucro.setText("Lucro/Prejuizo:")
        }

        btnConsultar.setOnClickListener { v: View ->
                val nome = txtConsulta.text.toString()
                val nomeProduto = sharedPreferences.getString(nome + "NomeProduto","")
                val custo = sharedPreferences.getString(nome + "PrecoCustoProduto","")
                val venda = sharedPreferences.getString(nome + "PrecoVendaProduto","")
                val calculo = sharedPreferences.getString(nome + "PrejuizoProduto","")

                txtNome.setText(nomeProduto)
                txtPrecoCusto.setText(custo)
            txtPrecoVenda.setText(venda)

                if(calculo!!.toFloat() > 0){
                    textViewLucro.setText("Lucro: " + calculo)

                }else if(calculo!!.toFloat() < 0){
                    textViewLucro.setText("Prejuizo: " + calculo)
                }else {
                    textViewLucro.setText("Você não obteve nem lucro e nem prejuizo")
                }


        }
    }
}
