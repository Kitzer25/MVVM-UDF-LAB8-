package com.example.mvvmudf.Logica.View_Model.MVVM

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TaskDAO{

    //Listar - Obtener datos
    @Query("SELECT * FROM tasks")
    suspend fun getAllTasks(): List<Task>

    //Inserción de data
    @Insert
    suspend fun insertTask(task: Task)

    //Marcar actividad como realizada o no finaliada
    @Update
    suspend fun updateTasks(task: Task)

    //Eliminar toda la data
    @Query("DELETE FROM tasks")
    suspend fun deleteAllTasks()
}