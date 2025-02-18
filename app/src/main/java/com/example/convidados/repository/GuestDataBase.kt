package com.example.convidados.repository

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Build.VERSION
import com.example.convidados.constants.DataBaseConstants

class GuestDataBase(context: Context) : SQLiteOpenHelper(context, NAME, null, VERSION){

    companion object{
        private const val NAME = "questdb"
        private const val VERSION = 2
    }

    override fun onCreate(db: SQLiteDatabase) {
//        db.execSQL("CREATE TABLE Guest(id integer primary key autoincrement, name text, presence integer);")

        db.execSQL("CREATE TABLE " + DataBaseConstants.GUEST.TABLE_NAME + " (" +
            DataBaseConstants.GUEST.COLUMNS.ID + " integer primary key autoincrement, " +
            DataBaseConstants.GUEST.COLUMNS.NAME + " text, " +
            DataBaseConstants.GUEST.COLUMNS.PRESENCE + " integer, " +
            DataBaseConstants.GUEST.COLUMNS.LEVAREI + " text )" )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }


}