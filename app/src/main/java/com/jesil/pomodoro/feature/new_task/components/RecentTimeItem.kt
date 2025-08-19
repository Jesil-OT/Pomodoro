package com.jesil.pomodoro.feature.new_task.components

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jesil.pomodoro.core.theme.PomodoroTheme
import com.jesil.pomodoro.core.theme.ThemeAnnotation
import com.jesil.pomodoro.feature.new_task.models.RecentTime

@Composable
fun RecentTimeItem(
    modifier: Modifier = Modifier,
    state: RecentTime,
    onStartTimer: (String) -> Unit
) {
    val backgroundColor = if (isSystemInDarkTheme()) Color(0xFF243647) else Color(0xFFE8EDF2)
    val textHintColor = if (isSystemInDarkTheme()) Color(0xFF91ADC9) else Color(0xFF4D7399)

    Row(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(
                vertical = 8.dp,
                horizontal = 8.dp
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = state.timeFormatInHMS,
                style = MaterialTheme.typography.labelMedium.copy(
                    color = textHintColor,
                    fontSize = 30.sp
                ),
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = state.timeFormatInDuration,
                style = MaterialTheme.typography.labelMedium.copy(
                    color = textHintColor,
                    fontSize = 9.sp
                )
            )
        }
        FloatingActionButton(
            shape = CircleShape,
            containerColor = MaterialTheme.colorScheme.primary,
            elevation = FloatingActionButtonDefaults.elevation(0.dp),
            onClick = { onStartTimer(state.timeFormatInHMS) },
            content = {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = "Play this recent time from ${state.timeFormatInDuration}",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        )
    }
}

@ThemeAnnotation
@Composable
fun RecentTimeItemPreview() {
    PomodoroTheme {
        RecentTimeItem(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background),
            state = RecentTime(
                timeFormatInHMS = "10:50:00",
                timeFormatInDuration = "10 hours, 50 min"
            ),
            onStartTimer = {}

        )
    }
}