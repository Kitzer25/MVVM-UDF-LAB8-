package com.example.mvvmudf.Logica.View_Model.MVVM

import androidx.room.Database
import androidx.room.RoomDatabase

//Define las entidades a manejar
@Database(entities = [Task::class], version = 1)
abstract class Database: RoomDatabase() {
    abstract fun taskDao(): TaskDAO
}