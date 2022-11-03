package com.example.stos_kolejka

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.LinkedList
import java.util.Queue
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val kolejka: Queue<Int> = LinkedList<Int>()
        val butt_dodaj_do_kolejki = findViewById<Button>(R.id.but_dodaj)
        val butt_usun_z_kolejki = findViewById<Button>(R.id.but_usun)
        val butt_pierw_i_ost_w_kolejce = findViewById<Button>(R.id.but_ostatniel)
        val txt_ile_w_kolejce = findViewById<TextView>(R.id.ilosc)
        val txt_pierwszy_w_kolejce = findViewById<TextView>(R.id.ostatni_element)
        val txt_ostatni_w_kolejce = findViewById<TextView>(R.id.pierwszy_element)
        val length = Toast.LENGTH_SHORT
        var numer = 1
        var ilosc_kolejka = 0

        butt_dodaj_do_kolejki.setOnClickListener {
            Toast.makeText(applicationContext, "Twój numer elementu  to: " + numer, length).show()
            kolejka.add(numer)
            numer += 1
            ilosc_kolejka += 1
            txt_ile_w_kolejce.text = ilosc_kolejka.toString()
        }
        butt_usun_z_kolejki.setOnClickListener {
            if (!kolejka.isEmpty()) {
                Toast.makeText(
                    applicationContext,
                    "Usunieto element: " + kolejka.element() + " z kolejki!",
                    length
                ).show()
                kolejka.remove()
                ilosc_kolejka -= 1
                txt_ile_w_kolejce.text = ilosc_kolejka.toString()

            } else {
                Toast.makeText(applicationContext, "Brak elementow w kolejce", length).show()
            }
        }
        butt_pierw_i_ost_w_kolejce.setOnClickListener {
            if (!kolejka.isEmpty()) {
                val pierw = kolejka.element()
                val ost = kolejka.last()
                txt_pierwszy_w_kolejce.text = pierw.toString()
                txt_ostatni_w_kolejce.text = ost.toString()
            } else {
                Toast.makeText(applicationContext, "Brak elementow  w kolejce", length).show()
                txt_pierwszy_w_kolejce.text = "brak elementow w kolejce"
                txt_ostatni_w_kolejce.text = "brak elementow w kolejce"
            }
        }
    }
}

