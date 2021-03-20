package com.example.semana_6

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.core.app.ActivityCompat.startActivityForResult
import com.example.semana_6.modelo.Desejo
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var desejos: ListView
    private lateinit var adiciona: FloatingActionButton
    private lateinit var desejosListados: List<Desejo>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.desejos = findViewById(R.id.listarDesejos)
        this.adiciona = findViewById(R.id.adicionarDesejos)
        this.adiciona.setOnClickListener(ClickFloatingActionButton())

        this.desejos.adapter = ArrayAdapter<Desejo>(this,android.R.layout.simple_list_item_1,this.desejosListados)

    }

    inner class ClickFloatingActionButton: View.OnClickListener {
        override fun onClick(v: View?) {
            var intent = Intent(this@MainActivity, activity_formulario::class.java)
            startActivityForResult(intent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK && requestCode == 1){
            var des = data?.getSerializableExtra("DESEJO") as Desejo

            (this.desejos.adapter as ArrayAdapter<Desejo>).add(des)
        }
    }
}
