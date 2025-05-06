package com.example.mvvmudf.Logica.View_Model.MVVM

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "descripcion") val descripcion: String,
    @ColumnInfo(name = "completado") val isCompleted: Boolean = false
)