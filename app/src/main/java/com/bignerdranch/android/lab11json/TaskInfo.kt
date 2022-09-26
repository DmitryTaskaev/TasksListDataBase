package com.bignerdranch.android.lab11json

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bignerdranch.android.lab11json.data.DATABASE_NAME
import com.bignerdranch.android.lab11json.data.TasksBD
import com.bignerdranch.android.lab11json.data.models.Priority
import com.bignerdranch.android.lab11json.data.models.Tasks
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.concurrent.Executors

class TaskInfo : AppCompatActivity() {

    private lateinit var addTask : ImageButton
    private lateinit var listTask: MutableList<TaskClass?>
    private var index : Int = -1
    private var yesorno : Int = 0

    private var kol_preority : Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_info)
        listTask = mutableListOf()
        DBtoList()
        addTask = findViewById(R.id.addTaskBtn)
        updateInformation()




        //Переход в окно добавления
        addTask.setOnClickListener {
            val reDir = Intent(this, MainActivity::class.java)
            startActivity(reDir)
        }
    }
    override fun onBackPressed() {
        AlertDialog.Builder(this).apply {
            setTitle("Подтверждение")
            setMessage("Вы уверены, что хотите выйти из программы?")
            setPositiveButton("Да"){ _, _ ->
                super.onBackPressed()
            }
            setNegativeButton("Нет"){ _, _ ->

            }
            setCancelable(true)
        }.create().show()
    }
    override fun onResume() {
        super.onResume()
        //DBtoList()
        updateInformation()
    }

    fun DBtoList(){
        if(yesorno == 0){
            var db: TasksBD = Room.databaseBuilder(this, TasksBD::class.java, DATABASE_NAME).build()
            val TaskDAO = db.TasksDAO()
            val Taskss = TaskDAO.getAllTasks()
            Taskss.observe(this, androidx.lifecycle.Observer {
                it.forEach {
                    listTask.add(TaskClass(it.nameTask,it.preorityId,it.creatTask,it.text,it.dateTask))
                }
            })
            yesorno = 1
        }
    }
    fun updateInformation(){
        Log.d("DBSSADD","updInfo выполнен")
        val rv = findViewById<RecyclerView>(R.id.TaskLisrRv)
        val adapter = TaskRVAdapter(this, listTask)
        val rvListener = object : TaskRVAdapter.ItemClickListener{
            override fun onItemClick(view: View?, position: Int) {
                val intent = Intent(this@TaskInfo, MainActivity::class.java)
                intent.putExtra("index", position)
                index = position
                startActivity(intent)
            }
        }
        adapter.setClickListener(rvListener)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = adapter
    }

}