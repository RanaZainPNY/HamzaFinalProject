package com.example.smartprofilemanagement

import android.app.Application
import com.example.smartprofilemanagement.data.infrastructure.AppContainer
import com.example.smartprofilemanagement.data.infrastructure.IAppContainer

//import com.perspectivev.workouttracker.data.infrastructure.AppContainer
//import com.perspectivev.workouttracker.data.infrastructure.IAppContainer

class SmartProfileManagementApplication: Application() {
    lateinit var container: IAppContainer
    override fun onCreate() {
        super.onCreate()
        container = AppContainer(this)
    }
}
