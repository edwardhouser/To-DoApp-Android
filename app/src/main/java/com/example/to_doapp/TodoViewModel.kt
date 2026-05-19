package com.example.to_doapp

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class TodoViewModel : ViewModel() {
    //private value so only this class can modify it
    private val _tasks = mutableStateListOf<Task>()

    //public for UI to read
    val task : List<Task> get() = _tasks

    //Counter used to generate a unique ID for each new task
    private var nextId = 1

    // adds new task to the list
    fun addTask(title: String) {
        if (title.isNotBlank()){
            _tasks.add(Task(id = nextId++, title = title.trim()))
        }

    }
    
    
    fun removeTask(taskId: Int){
        _tasks.removeAll {it.id == taskId }
    }

    // returns number of tasks curenelt in the list
    fun getTaskCount(): Int = _tasks.size

    //returns true if a task with the given title exists in the list
    fun containsTask(title: String) : Boolean {
        return _tasks.any{it.title == title}
    }

}