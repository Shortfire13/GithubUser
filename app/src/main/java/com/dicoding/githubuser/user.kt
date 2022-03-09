package com.dicoding.githubuser

import android.os.Parcel
import android.os.Parcelable


data class user(
    val name: String?,
    val username: String?,
    val avatar: Int,
    val company: String?,
    val repository: String?,
    val follower: String?,
    val following: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(username)
        parcel.writeInt(avatar)
        parcel.writeString(company)
        parcel.writeString(repository)
        parcel.writeString(follower)
        parcel.writeString(following)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<user> {
        override fun createFromParcel(parcel: Parcel): user {
            return user(parcel)
        }

        override fun newArray(size: Int): Array<user?> {
            return arrayOfNulls(size)
        }
    }
}
