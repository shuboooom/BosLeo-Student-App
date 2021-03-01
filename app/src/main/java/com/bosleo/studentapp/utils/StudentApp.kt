package com.bosleo.studentapp.utils

import android.app.Application
import android.content.Context
import com.bosleo.studentapp.data.database.StudentDatabase
import com.bosleo.studentapp.data.database.StudentDao
import com.bosleo.studentapp.data.repository.StudentRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@HiltAndroidApp
class StudentApp : Application() {
}

@InstallIn(SingletonComponent::class)
@Module
object DBModule {

    @Provides
    fun provideStudentDao(@ApplicationContext appContext: Context) : StudentDao {
        return StudentDatabase.getDatabase(appContext).studentDao()
    }

    @Provides
    fun provideStudentDBRepository(studentDao: StudentDao) = StudentRepo(studentDao)

}