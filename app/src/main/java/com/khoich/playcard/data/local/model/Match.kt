package com.khoich.playcard.data.local.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Match (
    @PrimaryKey(autoGenerate = true)
    val matchId: Int,
): Parcelable {
    constructor(parcel: Parcel) : this(parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(matchId)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Match> {
        override fun createFromParcel(parcel: Parcel): Match {
            return Match(parcel)
        }

        override fun newArray(size: Int): Array<Match?> {
            return arrayOfNulls(size)
        }
    }
}

data class Game(
    @PrimaryKey(autoGenerate = true)
    val gameId: Int
)

data class Player(
    @PrimaryKey(autoGenerate = true)
    val playerId: Int,
    val playerImage: Int,
    val playerName: String,
    val playerScore: Int
)