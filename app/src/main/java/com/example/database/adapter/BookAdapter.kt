package com.example.database.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.database.R
import com.example.database.entity.BookEntity

class BookAdapter(val bookList: ArrayList<BookEntity>) : RecyclerView.Adapter<BookViewHolder>() {
    override fun getItemCount(): Int {
        return bookList.size
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bookId.text = (bookList[position].bookId).toString()
        holder.bookName.text = bookList[position].bookName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_second, parent, false)
        return BookViewHolder(view)
    }
}

class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val bookId = itemView.findViewById<TextView>(R.id.txt_bid)
    val bookName = itemView.findViewById<TextView>(R.id.txt_bname)
}