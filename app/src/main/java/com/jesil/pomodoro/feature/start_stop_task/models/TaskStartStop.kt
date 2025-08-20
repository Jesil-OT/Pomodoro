package com.jesil.pomodoro.feature.start_stop_task.models

data class TaskStartStop(
    val taskName: String,
    val taskHours: String,
    val taskMinutes: String,
    val taskSeconds: String,
)