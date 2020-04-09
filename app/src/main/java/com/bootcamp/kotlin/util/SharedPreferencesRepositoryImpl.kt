package com.bootcamp.kotlin.util

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import com.bootcamp.kotlin.base.Constants

/**
 * Created by jhon on 8/04/2020
 */
class SharedPreferencesRepositoryImpl(private val appCompatActivity: AppCompatActivity) : SharedPreferencesRepository {

    companion object {
        private lateinit var sharedPreferences: SharedPreferences
    }

    override fun initSharedPreferences() {
        sharedPreferences = appCompatActivity.getSharedPreferences(Constants.PREF_NAME, Constants.PRIVATE_MODE)
    }

    override fun checkIfUserExists(): String {
        return sharedPreferences.getString(Constants.USER_NAME, Constants.DEFAULT_STRING)!!
    }
}