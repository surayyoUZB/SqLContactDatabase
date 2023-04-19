package com.yoo.sqlcontactdatabase.database

import com.yoo.sqlcontactdatabase.model.Contact

interface DatabaseService {
    fun saveContact(contact:Contact)
    fun getAllContact():List<Contact>
}