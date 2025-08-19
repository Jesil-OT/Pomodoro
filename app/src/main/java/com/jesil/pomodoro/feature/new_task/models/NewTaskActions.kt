package com.jesil.pomodoro.feature.new_task.models

sealed interface NewTaskActions {
    object StartTask : NewTaskActions
    object CancelTask : NewTaskActions
    object PauseTask : NewTaskActions
    object ResumeTask : NewTaskActions
    object DeleteTask : NewTaskActions
    data class SetTaskName(val name: String) : NewTaskActions
    data class SetHours(val hours: String) : NewTaskActions
    data class SetMinutes(val minutes: String) : NewTaskActions
    data class SetSeconds(val seconds: String) : NewTaskActions
}