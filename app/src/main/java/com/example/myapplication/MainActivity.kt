package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var taille: EditText
    private lateinit var poids: EditText
    private lateinit var btn: Button
    private lateinit var result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        taille = findViewById(R.id.taille)
        poids = findViewById(R.id.poids)
        btn = findViewById(R.id.btn)
        result = findViewById(R.id.result)

        btn.setOnClickListener {
            val t = taille.text.toString().toDoubleOrNull()
            val p = poids.text.toString().toDoubleOrNull()

            if (t != null && p != null) {
                val r = p/ (t * t)
                var res = ""

                if (r > 0.0040) {
                    res = "Obèse"
                } else if (r > 0.0035) {
                    res = "Surpoids"
                } else {
                    res = "Poids normal"
                }

                result.text = "IMC: %.2f - $res".format(r*100)
            } else {
                result.text = "Veuillez saisir des valeurs valides."
            }
        }
    }
}


