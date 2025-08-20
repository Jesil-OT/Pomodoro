package com.jesil.pomodoro.feature.start_stop_task

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jesil.pomodoro.core.theme.PomodoroTheme
import com.jesil.pomodoro.core.theme.ThemeAnnotation
import com.jesil.pomodoro.feature.start_stop_task.components.TimeRow
import com.jesil.pomodoro.feature.start_stop_task.models.TaskStartStop

@Composable
fun StartStopTaskScreen() {

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StartStopTaskScreenInner(
    modifier: Modifier = Modifier,
    onBackPress: () -> Unit,
    taskModel: TaskStartStop,
) {
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
                                text = "ZenFocus",
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
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(horizontal = 20.dp),
                content = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = taskModel.taskName,
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontSize = 22.sp
                        ),
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    TimeRow(
                        modifier = Modifier.fillMaxWidth(),
                        taskHours = taskModel.taskHours,
                        taskMinutes = taskModel.taskMinutes,
                        taskSeconds = taskModel.taskSeconds
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                    ) {
                        Button(
                            modifier = Modifier.weight(1f),
                            onClick = { /*TODO*/ },
                            content = {
                                Text(
                                    text = "Pause",
                                    style = MaterialTheme.typography.titleLarge.copy(
                                        fontSize = 16.sp,
                                        color = MaterialTheme.colorScheme.onPrimary
                                    )
                                )
                            }
                        )
                        Button(
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.error
                            ),
                            modifier = Modifier.weight(1f),
                            onClick = { /*TODO*/ },
                            content = {
                                Text(
                                    text = "Cancel",
                                    style = MaterialTheme.typography.titleLarge.copy(
                                        fontSize = 16.sp,
                                        color = MaterialTheme.colorScheme.onPrimary
                                    )
                                )
                            }
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                }
            )
        }
    )
}

@ThemeAnnotation
@Composable
fun StartStopTaskScreenPreview() {
    PomodoroTheme {
        StartStopTaskScreenInner(
            taskModel = TaskStartStop(
                taskName = "Deep Work Session",
                taskHours = "10",
                taskMinutes = "50",
                taskSeconds = "00"
            ),
            onBackPress = {}
        )
    }
}