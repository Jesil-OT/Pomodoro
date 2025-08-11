package com.jesil.pomodoro.core.di

import com.jesil.pomodoro.feature.new_task.NewTaskViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { NewTaskViewModel() }
}