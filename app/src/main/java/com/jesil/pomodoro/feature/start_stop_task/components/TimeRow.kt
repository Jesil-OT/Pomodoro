package com.jesil.pomodoro.feature.start_stop_task.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jesil.pomodoro.core.theme.PomodoroTheme
import com.jesil.pomodoro.core.theme.ThemeAnnotation

@Composable
fun TimeRow(
    modifier: Modifier = Modifier,
    taskHours: String,
    taskMinutes: String,
    taskSeconds: String
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        content = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                TimeItem(
                    modifier = Modifier.height(56.dp).weight(1f),
                    time = taskHours,
                )
                Spacer(modifier = Modifier.width(16.dp))
                TimeItem(
                    modifier = Modifier.height(56.dp).weight(1f),
                    time = taskMinutes,
                )
                Spacer(modifier = Modifier.width(16.dp))
                TimeItem(
                    modifier = Modifier.height(56.dp).weight(1f),
                    time = taskSeconds,
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = "Hours",
                    style = MaterialTheme.typography.labelSmall.copy(
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center
                    ),
                    color = MaterialTheme.colorScheme.onPrimary
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    modifier = Modifier.weight(1f),
                    text = "Minutes",
                    style = MaterialTheme.typography.labelSmall.copy(
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center
                    ),
                    color = MaterialTheme.colorScheme.onPrimary
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    modifier = Modifier.weight(1f),
                    text = "Seconds",
                    style = MaterialTheme.typography.labelSmall.copy(
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center
                    ),
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    )
}

@ThemeAnnotation
@Composable
fun TimeRowPreview() {
    PomodoroTheme {
        TimeRow(
            taskHours = "10",
            taskMinutes = "50",
            taskSeconds = "00"
        )
    }
}