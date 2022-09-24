package com.bignerdranch.android.lab11json.data.models

import android.provider.BaseColumns
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bignerdranch.android.lab11json.data.TASKS_TABLE


/**
 * Класс задачи
 * @property id - Идентификатор задачи [Int]
 * @property preorityId - Приоритет задачи [String]
 * @property nameTask - Название задачи [String]
 * @property creatTask - Создатель задачи [String]
 * @property text - Суть задачи [String]
 * @property dateTask - Дата задачи [String]
 *
 * @author Таскаев Дмитрий
 */

@Entity(tableName = TASKS_TABLE)
data class Tasks (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = BaseColumns._ID)
    val id: Int,
    @ColumnInfo(index = true)
    var preorityId: Boolean,
    var nameTask: String,
    var creatTask: String,
    var text: String,
    var dateTask: String
)