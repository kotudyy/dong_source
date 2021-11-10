package com.example.databasedoit

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context): SQLiteOpenHelper(context, "TodoList", null, 1){
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table Todo_TB( " +
                "id integer primary key autoincrement," +
                "todo not null)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

}