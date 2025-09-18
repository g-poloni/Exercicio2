package com.example.nextview

import android.R
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.nextview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val items = listOf("masculino", "feminino")

        val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,items)

        binding.spinner.adapter=adapter

        binding.buttonCalculator.setOnClickListener {
            val sexoSelecionado = binding.spinner.selectedItem as String
            var idade = binding.editTextidade.text.toString().toLongOrNull()
            var resultado: Long = 0

            if (idade != null){
                if (idade <= 65 && sexoSelecionado.trim()=="masculino"){
                    resultado=65-idade
                    if(resultado==0L) {
                        binding.textview.text = "Idade de se aposentar"
                    }
                    else{
                        binding.textview.text = "Faltam $resultado anos para você se aposentar"
                    }
                }
                else if (idade <= 62 && sexoSelecionado.trim()=="feminino"){
                    resultado=62-idade
                    if(resultado==0L) {
                        binding.textview.text = "Idade de se aposentar"
                    }
                    else {
                        binding.textview.text = "Faltam $resultado anos para você se aposentar"
                    }
                }
                else if (idade > 65 && sexoSelecionado.trim()=="masculino" || idade > 62 && sexoSelecionado.trim()=="feminino") {
                    binding.textview.text = "A idade informada ultrapassou os limites do app"
                }
            }

            else{
                binding.textview.text= "Informe uma idade"

            }



        }

    }
}