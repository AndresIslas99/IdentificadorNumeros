package edu.itesm.numeros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import edu.itesm.numeros.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val entradas = mutableListOf<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }

    private fun initUI(){
        binding.agregar.setOnClickListener {
            agregarfunc()
        }
        binding.promedio.setOnClickListener {
            promediofunc()
        }
        binding.mayor.setOnClickListener {
            mayorfunc()
        }
        binding.pares.setOnClickListener {
            paresfunc()
        }
    }

    private fun agregarfunc(){
        val amount = binding.editTextNumberSigned.text.toString()
        val amountValue = amount.toIntOrNull() ?: return
        entradas.add(amountValue)
        Toast.makeText(this,"${entradas}", Toast.LENGTH_LONG).show()
    }

    private fun promediofunc(){
        val prom=entradas.average()
        binding.resultados.text = "${prom}"
      }
    private fun mayorfunc(){
        val may = entradas.maxOrNull()
        binding.resultados.text = "${may}"
    }
    private fun paresfunc(){
        var filteredList = entradas.filter { x -> x % 2 == 0 }
        binding.resultados.text = "${filteredList}"
    }


}
