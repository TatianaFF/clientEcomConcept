package com.example.ecommerceconcept

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//включить в manifest
@HiltAndroidApp
class MainApplication : Application()