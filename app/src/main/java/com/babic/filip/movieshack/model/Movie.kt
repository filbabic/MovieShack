package com.babic.filip.movieshack.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

import com.google.gson.annotations.SerializedName

@Entity(tableName = "movies")
data class Movie(@PrimaryKey
                 @ColumnInfo(name = "id")
                 var id: String,
                 var title: String?,
                 @SerializedName("overview") var description: String?,
                 @SerializedName("vote_count") var numberOfVotes: Int,
                 @SerializedName("vote_average") var averageScore: Float,
                 @SerializedName("poster_path")
                 var image: String?,
                 @SerializedName("release_date")
                 var releaseDate: String?,
                 var popularity: String?,
                 var type: String? //this will be added post-fetching, to differentiate movie type
)
