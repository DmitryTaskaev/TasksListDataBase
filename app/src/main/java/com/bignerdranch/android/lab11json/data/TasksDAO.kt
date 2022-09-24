package com.bignerdranch.android.lab11json.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.bignerdranch.android.lab11json.data.models.Priority
import com.bignerdranch.android.lab11json.data.models.Tasks

@Dao
interface TasksDAO {

    /*
    *   Таблица Preority
    *   Запрос запрашивает все данные таблицы приоритета
    */

    @Query("SELECT * FROM $PRIOR_TABLE")
    fun getAllPreority(): LiveData<MutableList<Priority>>

    //Добавление приоритета
    @Insert
    fun addPreoruty(preority: Priority)

    //Изменения приоритета
    @Update
    fun savePreoruty(preority: Priority)

    //Удаление приоритета
    @Delete
    fun delPreoruty(preority: Priority)

    /*
    *   Таблица Tasks
    *   Запрос запрашивает все данные таблицы задач
    */

    @Query("SELECT * FROM $TASKS_TABLE")
    fun getAllTasks(): LiveData<MutableList<Tasks>>

    @Query("SELECT * FROM $TASKS_TABLE WHERE _id=:id")
    fun getTasks(id: Int): LiveData<MutableList<Tasks>>

    //Добавление задачи
    @Insert
    fun addTasks(tasks: Tasks)

    //Изменение задачи
    @Update
    fun saveTasks(tasks: Tasks)

    //Удаление задачи
    @Delete
    fun delTasks(tasks: Tasks)
}