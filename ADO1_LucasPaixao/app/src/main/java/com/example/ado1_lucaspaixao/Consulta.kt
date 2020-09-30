package com.example.ado1_lucaspaixao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_consulta.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.btnConsultar
import kotlinx.android.synthetic.main.activity_main.txtNome

class Consulta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consulta)

        val sharedPreferences = getSharedPreferences("sharedPreferencesProdutos", MODE_PRIVATE)



    }
}