package com.example.bellybalance.views

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.Index

@Entity(
    indices = [Index(value = ["email"], unique = true)]
)
data class User(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var name: String,
    var email: String,
    var password: String,
    var appversion: String,
    var notification: Boolean
)

@Entity(
    foreignKeys = [ForeignKey(
        entity = User::class,
        parentColumns = ["id"],
        childColumns = ["userId"],
        onDelete = ForeignKey.CASCADE // specify onDelete behavior
    )]
)
data class HealthData(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var userId: Int, // Assuming userId is of type Int and refers to com.example.bellybalance.views.User.id
    var food: String,
    var foodTime: String,
    var poopType: String,
    var poopTime: String,
    var conditions: String,

    )

