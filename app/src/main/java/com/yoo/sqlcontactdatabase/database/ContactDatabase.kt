package com.yoo.sqlcontactdatabase.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.yoo.sqlcontactdatabase.model.Contact
import com.yoo.sqlcontactdatabase.util.Constants

class ContactDatabase(context:Context):
    SQLiteOpenHelper(context, Constants.DB_NAME, null,1), DatabaseService {
    override fun onCreate(db: SQLiteDatabase?) {
        val query="CREATE TABLE ${Constants.TABLE_NAME} (${Constants.ID} INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, ${Constants.NAME} TEXT NOT NULL, ${Constants.NUMBER} TEXT NOT NULL)"

        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE IF EXISTS ${Constants.TABLE_NAME}")
    }

    override fun saveContact(contact: Contact) {
        val db=this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(Constants.NAME, contact.name)
        contentValues.put(Constants.NUMBER, contact.number)
        db.insert(Constants.TABLE_NAME, null, contentValues)
    }
    var contactList= mutableListOf<Contact>()
    override fun getAllContact(): List<Contact> {
        val database=this.readableDatabase
        val query="SELECT * FROM ${Constants.TABLE_NAME} ORDER BY ${Constants.ID} DESC"
        val cursor =database.rawQuery(query, null)
        if (cursor.moveToFirst()){
            do {
                val contact=Contact(
                cursor.getInt(0),
                cursor.getString(1),
                cursor.getString(2)
                )
                contactList.add(contact)
            } while (cursor.moveToNext())
        }
        cursor.close()
        database.close()
        return contactList
    }
}