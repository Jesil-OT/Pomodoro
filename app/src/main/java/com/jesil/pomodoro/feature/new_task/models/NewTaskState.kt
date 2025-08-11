package com.jesil.pomodoro.feature.new_task.models

data class NewTaskState(
    val taskName: String = "",
    val recentTime: List<RecentTime> = emptyList(),
)

data class RecentTime(
    val timeFormatInHMS: String = "",
    val timeFormatInDuration: String
)
