package com.jesil.pomodoro.feature.new_task

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.jesil.pomodoro.core.theme.PomodoroTheme
import com.jesil.pomodoro.core.theme.ThemeAnnotation
import com.jesil.pomodoro.feature.new_task.components.RecentTimeItem
import com.jesil.pomodoro.feature.new_task.components.TaskTextField
import com.jesil.pomodoro.feature.new_task.components.TimePicker
import com.jesil.pomodoro.feature.new_task.models.NewTaskActions
import com.jesil.pomodoro.feature.new_task.models.NewTaskState
import com.jesil.pomodoro.feature.new_task.models.RecentTime
import org.koin.androidx.compose.koinViewModel


@Composable
fun NewTaskScreen(
    navController: NavController,
) {
    val viewModel : NewTaskViewModel = koinViewModel()
    val state = viewModel.taskState.collectAsStateWithLifecycle()

    NewTaskScreenInnerScreen(
        onBackPress = {
            navController.popBackStack()
        },
        state = state.value,
        onAction = viewModel::onAction
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewTaskScreenInnerScreen(
    onBackPress: () -> Unit = {},
    state: NewTaskState,
    onAction: (NewTaskActions) -> Unit,
) {
    val textHintColor = if (isSystemInDarkTheme()) Color(0xFF91ADC9) else Color(0xFF4D7399)

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        contentColor = MaterialTheme.colorScheme.onPrimary,
        topBar = {
            TopAppBar(
                colors = TopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    scrolledContainerColor = MaterialTheme.colorScheme.background,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary
                ),
                title = {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center,
                        content = {
                            Text(
                                modifier = Modifier.offset(x = (-18).dp),
                                text = "New Task",
                                style = MaterialTheme.typography.titleLarge.copy(
                                    fontSize = 18.sp,
                                )
                            )
                        }
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = onBackPress,
                        content = {
                            Icon(
                                imageVector = Icons.Default.Clear,
                                contentDescription = "Cancel Button"
                            )
                        }
                    )
                }
            )
        },
        content = {innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(horizontal = 20.dp),
                content = {
                    Text(
                        modifier = Modifier.padding(top = 10.dp),
                        text = "Task Name",
                        style = MaterialTheme.typography.labelMedium.copy(
                            fontSize = 16.sp
                        ),
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    TaskTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.taskName,
                        onValueChange = {onAction(NewTaskActions.SetTaskName(it))},
                        isHintVisible = state.taskName.isEmpty(),
                        placeHolder = {
                            Text(
                                text = "e.g, Write Report",
                                style = MaterialTheme.typography.labelSmall.copy(
                                    fontSize = 16.sp
                                ),
                                color = textHintColor
                            )
                        },
                        trailingIcon = {
                            Icon(
                                modifier = Modifier.clickable(onClick = { onAction(NewTaskActions.SetTaskName("")) }),
                                imageVector = Icons.Default.Clear,
                                contentDescription = "Clear Button"
                            )
                        }
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    TimePicker(
                        modifier = Modifier.fillMaxWidth(),
                        hour = state.hours,
                        minute = state.minutes,
                        second = state.seconds,
                        onValueChange = {h, m, s ->
                            onAction(NewTaskActions.SetHours(h))
                            onAction(NewTaskActions.SetMinutes(m))
                            onAction(NewTaskActions.SetSeconds(s))
                        }
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    Button(
                        modifier = Modifier
                            .fillMaxWidth(),
                        onClick = {
                            onAction(NewTaskActions.StartTask)
                        },
                    ) {
                        Text(
                            text = "Start",
                            style = MaterialTheme.typography.titleLarge.copy(
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.onPrimary
                            )
                        )
                    }
                    Spacer(modifier = Modifier.height(32.dp))
                    AnimatedVisibility(
                        visible = state.recentTime.isNotEmpty(),
                    ) {
                        LazyColumn(
                            verticalArrangement = Arrangement.spacedBy(16.dp),
                        ) {
                            item {
                                Text(
                                    text = "Recents",
                                    style = MaterialTheme.typography.labelMedium.copy(
                                        fontSize = 16.sp,
                                        color = MaterialTheme.colorScheme.onPrimary
                                    ),
                                )
                            }
                            items(state.recentTime) { recent ->
                                RecentTimeItem(
                                    modifier = Modifier.fillMaxWidth(),
                                    state = recent,
                                    onStartTimer = {
                                    }
                                )
                            }
                        }
                    }
                }
            )
        }
    )

}

@ThemeAnnotation
@Composable
fun NewTaskScreenInnerScreenPreview() {
    PomodoroTheme {
        NewTaskScreenInnerScreen(
            state = NewTaskState(
                recentTime = fakeRecentTime
            ),
            onAction = {},
        )
    }
}

private val fakeRecentTime = listOf<RecentTime>(
    RecentTime(
        timeFormatInHMS = "10:50:00",
        timeFormatInDuration = "10 hours, 50 min"
    ),
    RecentTime(
        timeFormatInHMS = "20:30:10",
        timeFormatInDuration = "20 hours, 30 min, 10 sec"
    ),
    RecentTime(
        timeFormatInHMS = "50:00",
        timeFormatInDuration = "50 min"
    ),
    RecentTime(
        timeFormatInHMS = "50:20",
        timeFormatInDuration = "50 min, 20 sec"
    ),
    RecentTime(
        timeFormatInHMS = "10:50:00",
        timeFormatInDuration = "10 hours, 50 min"
    ),
    RecentTime(
        timeFormatInHMS = "50:20",
        timeFormatInDuration = "50 min, 20 sec"
    )
)