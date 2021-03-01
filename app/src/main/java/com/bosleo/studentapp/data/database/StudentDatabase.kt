package biz.ctunes.callingtunes.data.db

import androidx.annotation.NonNull
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [],
    version = 1, exportSchema = false)

abstract class StudentDatabase : RoomDatabase() {
    abstract fun registeredContactsDao(): RegisteredContactsDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: StudentDatabase? = null

        fun getDatabase(): StudentDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                        CtuneApp.getAppContext(),
                        StudentDatabase::class.java,
                        "student_databse"
                ).fallbackToDestructiveMigration().build()

                INSTANCE = instance
                return instance
            }
        }
    }
}