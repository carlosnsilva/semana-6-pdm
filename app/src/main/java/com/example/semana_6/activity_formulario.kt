package com.example.semana_6

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.semana_6.modelo.Desejo
import java.io.Serializable

class activity_formulario : AppCompatActivity() {
    private lateinit var campoDescricao: EditText
    private lateinit var campoValor: EditText
    private lateinit var botaoCancelar: Button
    private lateinit var botaoCadastrar: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)

        this.campoDescricao = findViewById(R.id.Descricao)
        this.campoValor = findViewById(R.id.Valor)
        this.botaoCadastrar = findViewById(R.id.botaoCadastrar)
        this.botaoCancelar = findViewById(R.id.botaoCancelar)

        this.botaoCadastrar.setOnClickListener(clickCadastrar())
        this.botaoCancelar.setOnClickListener(clickCancelar())
    }

    inner class clickCadastrar: View.OnClickListener{
        override fun onClick(v: View?) {
            var descricao: String = this@activity_formulario.campoDescricao.text.toString()
            var valor: Float = this@activity_formulario.campoValor.text.toString().toFloat()

            var des = Desejo(descricao, valor)
            Log.i("Desejo", des.toString())

            var intent = Intent()
            intent.putExtra("DESEJO", des as Serializable)
            setResult(Activity.RESULT_OK, intent)
            finish()

        }
    }

    inner class clickCancelar: View.OnClickListener{
        override fun onClick(v: View?) {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }
}