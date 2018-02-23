package com.effeta.miparroquiaandroid.di

import com.effeta.miparroquiaandroid.views.activities.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by aulate on 16/2/18.
 */
@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector()
    abstract fun bindMainActivity(): MainActivity

}