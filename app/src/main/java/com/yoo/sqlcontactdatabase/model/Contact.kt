package com.yoo.sqlcontactdatabase.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Contact(
    val id: Int=0,
    val name: String,
    val number: String
): Parcelable
