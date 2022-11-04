package com.example.stos_kolejka

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.LinkedList
import java.util.Queue


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //  ************************* KOLEJKA *************************
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
            Toast.makeText(applicationContext, "Twój numer to: " + numer, length).show()
            kolejka.add(numer)
            numer += 1
            ilosc_kolejka += 1
            txt_ile_w_kolejce.text = ilosc_kolejka.toString()
        }

        butt_usun_z_kolejki.setOnClickListener {
            if (!kolejka.isEmpty()) {
                Toast.makeText(
                    applicationContext,
                    "Usunieto numer: " + kolejka.element() + " z kolejki!",
                    length
                ).show()
                kolejka.remove()
                ilosc_kolejka -= 1
                txt_ile_w_kolejce.text = ilosc_kolejka.toString()

            } else {
                Toast.makeText(applicationContext, "Brak osob w kolejce", length).show()
            }
        }
        butt_pierw_i_ost_w_kolejce.setOnClickListener {
            if (!kolejka.isEmpty()) {
                val pierw = kolejka.element()
                val ost = kolejka.last()
                txt_pierwszy_w_kolejce.text = pierw.toString()
                txt_ostatni_w_kolejce.text = ost.toString()
            } else {
                Toast.makeText(applicationContext, "Brak osob w kolejce", length).show()
                txt_pierwszy_w_kolejce.text = "brak osob w kolejce"
                txt_ostatni_w_kolejce.text = "brak osob w kolejce"
            }
        }


        //  ************************* STOS *************************

        val stos = LinkedList<Int>()
        val butt_dodaj_do_stosu = findViewById<Button>(R.id.dodaj_stos)
        val butt_usun_ze_stosu = findViewById<Button>(R.id.usun_stos)
        val butt_pierw_ele_w_stosie = findViewById<Button>(R.id.gora_stos)
        val edittext_dodaj_do_stosu = findViewById<EditText>(R.id.dodaj_el_stos)
        val txt_ile_w_stosie = findViewById<TextView>(R.id.ilosc2)
        val txt_gora_stosu = findViewById<TextView>(R.id.text_stos)
        var ilosc_ele_w_stosie = 0

        butt_dodaj_do_stosu.setOnClickListener {
            if(edittext_dodaj_do_stosu.text.toString() != "") {
                val liczba = edittext_dodaj_do_stosu.text.toString().toInt()
                Toast.makeText(applicationContext, "Dodano do stosu liczbe: " + liczba, length).show()
                stos.add(liczba)
                ilosc_ele_w_stosie += 1
                txt_ile_w_stosie.text = ilosc_ele_w_stosie.toString()
            }
            else
            {
                Toast.makeText(applicationContext, "Wpisz do pola nad przyciskiem, jaka liczbe chcesz dodac", length).show()
            }

        }

        butt_usun_ze_stosu.setOnClickListener {
            if (!stos.isEmpty())
            {
                val liczba = stos.last()
                Toast.makeText(applicationContext, "usunieto do stosu liczbe: " + liczba, length).show()
                stos.removeLast()
                ilosc_ele_w_stosie -= 1
                txt_ile_w_stosie.text = ilosc_ele_w_stosie.toString()
            }
            else
            {
                Toast.makeText(applicationContext, "Stos jest pusty", length).show()
            }
        }
        butt_pierw_ele_w_stosie.setOnClickListener {
            if (!stos.isEmpty())
            {
                val liczba = stos.last()
                txt_gora_stosu.text = liczba.toString()

            }
            else
            {
                Toast.makeText(applicationContext, "Stos jest pusty", length).show()
                txt_gora_stosu.text = "Stos jest pusty"
            }
        }
    }
}