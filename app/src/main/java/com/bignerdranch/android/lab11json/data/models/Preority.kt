package com.bignerdranch.android.lab11json.data.models

import android.provider.BaseColumns
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bignerdranch.android.lab11json.data.PRIOR_TABLE

/**
 * Класс приоритета
 * @property id - Идентификатор задачи [Int]
 * @property preority - Приоритет задачи [String]
 *
 * @author Таскаев Дмитрий
 */

@Entity(tableName = PRIOR_TABLE)
data class Priority (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = BaseColumns._ID)
    val id: Int,
    @ColumnInfo(index = true)
    var preority: String
)