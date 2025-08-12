package com.jesil.pomodoro.feature.new_task

import androidx.lifecycle.ViewModel
import com.jesil.pomodoro.feature.new_task.models.NewTaskActions
import com.jesil.pomodoro.feature.new_task.models.NewTaskState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class NewTaskViewModel: ViewModel() {

    private val _taskState = MutableStateFlow(NewTaskState())
    val taskState = _taskState.asStateFlow()

    fun onAction(action: NewTaskActions){
        when(action){
            is NewTaskActions.SetTaskName -> {
                _taskState.update {
                    it.copy(
                        taskName = action.name,
                        hours = action.name,
                        minutes = action.name,
                        seconds = action.name
                    )
                }
            }
            is NewTaskActions.StartTask -> {}
            is NewTaskActions.CancelTask -> {}
            is NewTaskActions.PauseTask -> {}
            is NewTaskActions.ResumeTask -> {}
            is NewTaskActions.DeleteTask -> {}
        }
    }
}