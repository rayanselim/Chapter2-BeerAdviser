package com.hfad.beeradviser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val findBook = findViewById<Button>(R.id.find_book)
        findBook.setOnClickListener {
            //Code that runs when the button is clicked
            val bookType = findViewById<Spinner>(R.id.book_type)
            val type = bookType.selectedItem
            val bookList = getBooks(type.toString())
            val books = bookList.reduce { str, item -> str + '\n' + item }
            val brands = findViewById<TextView>(R.id.brands)
            brands.text = books
        }
    }
    fun getBooks(type: String): List<String> {
        return when (type) {
            "Horror" -> listOf("The Suffering", "The Lost Soul")
            "Non Fiction" -> listOf("The Alchemist", "Prisoner B-3087")
            "Literature" -> listOf("The Book Thief", "Wonder")
            else -> listOf("You Are My Happy", "The One and Only Ivan")
        }
    }
}