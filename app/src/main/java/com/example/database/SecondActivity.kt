package com.example.database

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.database.adapter.BookAdapter
import com.example.database.database.AppDatabase
import com.example.database.entity.BookEntity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        var bookList =ArrayList<BookEntity>()
        var db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "BookDB").build()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(this)

        Thread {

            var bookEntity = BookEntity()

            bookEntity.bookId=1
            bookEntity.bookName="Java"
            db.bookDao().saveBooks(bookEntity)

            bookEntity.bookId=2
            bookEntity.bookName="Kotlin"
            db.bookDao().saveBooks(bookEntity)



            db.bookDao().getAllBooks().forEach() {
                Log.i("Fetch Records", "Id:  : ${it.bookId}")
                Log.i("Fetch Records", "Name:  : ${it.bookName}")
            }
            var list=db.bookDao().getAllBooks()
            bookList=list as ArrayList<BookEntity>
            val bookAdapter = BookAdapter(bookList)
            recyclerView.adapter=bookAdapter
        }.start()

    }
}