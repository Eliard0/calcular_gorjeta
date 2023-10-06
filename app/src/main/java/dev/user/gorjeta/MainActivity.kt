package dev.user.gorjeta

import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import dev.user.gorjeta.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val progree: SeekBar = binding.sbValorPorcentagem
        progree.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekbar: SeekBar?, progresso: Int, fromUser: Boolean) {
                var porcentagem = progresso
                binding.tvPorcentagem.setText("$porcentagem %")
                conta(porcentagem)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })
    }

    fun conta(por: Int) {

        var valorConta = binding.inputValor.text.toString().toDouble()
        var gorjeta =  (valorConta * (por.toDouble()/100)).toInt()
            binding.tvValorGorjeta.setText(gorjeta.toString())

        var totalConta = valorConta + gorjeta
            binding.tvValorTotal.setText(totalConta.toString())
    }
}

