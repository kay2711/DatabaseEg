package com.example.database

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.room.Room
import com.example.database.database.AppDatabase
import com.example.database.entity.BookEntity

class MainActivity : AppCompatActivity() {



    var bId:Int=0
    var bName:String=""

    override fun onCreate(savedInstanceState: Bundle?) {

        var db = Room.databaseBuilder(applicationContext, AppDatabase::class.java,"BookDB").build()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var bookId = findViewById<EditText>(R.id.book_id)
        var bookName = findViewById<EditText>(R.id.book_name)

        var btnShow=findViewById<Button>(R.id.btn_show)
        var btnInsert=findViewById<Button>(R.id.btn_insert)

        btnShow.setOnClickListener {

        }
        btnInsert.setOnClickListener {
            bId=bookId.text.toString().toInt()
            bName=bookName.text.toString()

            var bookEntity1=BookEntity()
            bookEntity1.bookId=bId
            bookEntity1.bookName=bName

            Thread{
            db.bookDao().saveBooks(bookEntity1)

            db.bookDao().getAllBooks().forEach()
            {
                Log.i("Fetch Records", "Id:  : ${it.bookId}")
                Log.i("Fetch Records", "Name:  : ${it.bookName}")

            }
            }.start()
        }



        //Insert Case
        /*Thread {
            var bookEntity = BookEntity()
            bookEntity.bookId = 1
            bookEntity.bookName = "Kotlin for Android Developer"

            db.bookDao().saveBooks(bookEntity)

            bookEntity.bookId=2
            bookEntity.bookName="Java programming"

            db.bookDao().saveBooks(bookEntity)

            //fetch Records
            db.bookDao().getAllBooks().forEach()
            {
                Log.i("Fetch Records", "Id:  : ${it.bookId}")
                Log.i("Fetch Records", "Name:  : ${it.bookName}")
            }
        }.start()*/
    }
}
