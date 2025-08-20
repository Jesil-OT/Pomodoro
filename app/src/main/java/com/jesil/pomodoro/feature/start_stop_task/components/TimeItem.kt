package com.jesil.pomodoro.feature.start_stop_task.components

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jesil.pomodoro.core.theme.PomodoroTheme
import com.jesil.pomodoro.core.theme.ThemeAnnotation

@Composable
fun TimeItem(
    modifier: Modifier = Modifier,
    time: String
) {
    val backgroundColor = if (isSystemInDarkTheme()) Color(0xFF243647) else Color(0xFFE8EDF2)
    val textHintColor = if (isSystemInDarkTheme()) Color(0xFF91ADC9) else Color(0xFF4D7399)

    Box(
        modifier = modifier.clip(
            RoundedCornerShape(12.dp)
        ).background(
            color = backgroundColor,
            shape = RoundedCornerShape(12.dp)
        ),
        contentAlignment = Alignment.Center,
        content = {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = time,
                style = MaterialTheme.typography.titleLarge.copy(
                    color = textHintColor,
                    fontSize = 18.sp
                ),
                textAlign = TextAlign.Center
            )
        }
    )
}

@ThemeAnnotation
@Composable
fun TimeItemPreview(modifier: Modifier = Modifier) {
    PomodoroTheme {
        TimeItem(
            modifier = modifier.fillMaxWidth(),
            time = "10"
        )
    }
}