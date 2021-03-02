package com.bosleo.studentapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bosleo.studentapp.data.database.dao.StudentDao
import com.bosleo.studentapp.data.pojo.Divison
import com.bosleo.studentapp.data.pojo.Student

@Database(entities = [Student::class,Divison::class],
    version = 1, exportSchema = false)

abstract class StudentDatabase : RoomDatabase() {
    abstract fun studentDao(): StudentDao

    companion object {
        @Volatile
        private var INSTANCE: StudentDatabase? = null

        fun getDatabase(appContext : Context): StudentDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                        appContext,
                        StudentDatabase::class.java,
                        "student_databse"
                ).fallbackToDestructiveMigration().build()

                INSTANCE = instance
                return instance
            }
        }
    }
}