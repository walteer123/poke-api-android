package br.com.wab.myapplication.di

import br.com.wab.myapplication.ui.activity.MainActivity
import dagger.Component

@Component
interface MainActivityComponent {

    fun inject(activity: MainActivity)
}