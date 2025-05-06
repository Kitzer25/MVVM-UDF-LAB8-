package com.example.mvvmudf.Logica.View_Model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmudf.Logica.View_Model.MVVM.Task
import com.example.mvvmudf.Logica.View_Model.MVVM.TaskDAO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ViewModel(private val dao: TaskDAO): ViewModel() {

    private val tasks = MutableStateFlow<List<Task>>(emptyList())
    val tks: StateFlow<List<Task>> = tasks

    init {
        //Cargar la información de la Base de Datos
        viewModelScope.launch {
            tasks.value = dao.getAllTasks()
        }
    }

    fun addTask(descript: String){
        val newTask = Task(descripcion = descript)
        viewModelScope.launch {
            dao.insertTask(newTask)

            //Recarga la lista
            tasks.value = dao.getAllTasks()
        }
    }

    //Alterna el estado de una tarea
    fun toggleTask(activity: Task){
        viewModelScope.launch {
            val updateTask = activity.copy(isCompleted = !activity.isCompleted)
            dao.updateTasks(updateTask)
            tasks.value = dao.getAllTasks()
        }
    }

    //Elimina toda la data
    fun deleteAllTask(){
        viewModelScope.launch {
            dao.deleteAllTasks()
            tasks.value = emptyList()
        }
    }

}