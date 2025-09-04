package br.edu.ifsp.scl.ads.prdm.sc3033945.havagas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.scl.ads.prdm.sc3033945.havagas.databinding.ActivityMainBinding

// o AppCompatActivity é o que faz o main activity ser uma tela
class MainActivity : AppCompatActivity() {
    // val é uma variavel de leitura apenas
    // o by lazy significa que o que está dentro da chaves só será criado uma vez,
    // depois fica em cache

    private val amb : ActivityMainBinding by lazy {
        // pega o layout correspondente a ActivityMainBinding
        // como saber se um layout corresponde a class? Existe um padrao de nomenclatura, o nome da
        // class corresponse ao nome do xml de seu layout em PascalCase acompanhado da palavra
        // Binding
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}