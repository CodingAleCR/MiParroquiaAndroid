package com.effeta.miparroquiaandroid.common

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity

/**
 * Created by aulate on 5/1/18.
 */
abstract class BaseActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mLayout)
        initialize()
    }

    abstract val mLayout: Int

    private fun initialize() {
        initializeViewModels()
        initializeUI()
        observeLiveData()
    }

    abstract fun initializeViewModels()
    abstract fun initializeUI()
    abstract fun observeLiveData()
}