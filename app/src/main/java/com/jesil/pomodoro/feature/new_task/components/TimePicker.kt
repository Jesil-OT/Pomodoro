package com.jesil.pomodoro.feature.new_task.components

import android.widget.TimePicker
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jesil.pomodoro.core.theme.PomodoroTheme
import com.jesil.pomodoro.core.theme.ThemeAnnotation

/**
 * for now this class is begin used as a first
 * component, later we will change this to a scrollable wheel
 * to select the time
 * **/
@Composable
fun TimePicker(
    hour: (String),
    minute: String,
    second: String,
//    onHoursChange: (String) -> Unit,
//    onMinuteChanged: (String) -> Unit,
//    onSecondChange: (String) -> Unit,
    onValueChange: (String, String, String) -> Unit,
    modifier: Modifier = Modifier
) {
    val textHintColor = if (isSystemInDarkTheme()) Color(0xFF91ADC9) else Color(0xFF4D7399)

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        content = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                TaskTextField(
                    modifier = Modifier.weight(1f),
                    value = hour,
                    singleLine = true,
                    keyboardType = KeyboardType.Number,
                    onValueChange = {
                        onValueChange(it, minute, second)
                    },
                    placeHolder = {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontSize = 16.sp,
                                textAlign = TextAlign.Center
                            ),
                            color = textHintColor,
                            text = "00",
                        )
                    }
                )
                Spacer(modifier = Modifier.width(16.dp))
                TaskTextField(
                    modifier = Modifier.weight(1f),
                    value = minute,
                    singleLine = true,
                    keyboardType = KeyboardType.Number,
                    onValueChange = {
                        onValueChange(hour, it, second)
                    },
                    placeHolder = {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontSize = 16.sp,
                                textAlign = TextAlign.Center
                            ),
                            color = textHintColor,
                            text = "00",
                        )
                    }
                )
                Spacer(modifier = Modifier.width(16.dp))
                TaskTextField(
                    modifier = Modifier.weight(1f),
                    value = second,
                    singleLine = true,
                    onValueChange = {
                        onValueChange(hour, minute, it)
                    },
                    keyboardType = KeyboardType.Number,
                    placeHolder = {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontSize = 16.sp,
                                textAlign = TextAlign.Center
                            ),
                            color = textHintColor,
                            text = "00",
                        )
                    }
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = "Hours",
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center
                    ),
                    color = MaterialTheme.colorScheme.onPrimary
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    modifier = Modifier.weight(1f),
                    text = "Minutes",
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center
                    ),
                    color = MaterialTheme.colorScheme.onPrimary
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    modifier = Modifier.weight(1f),
                    text = "Seconds",
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontSize = 16.sp,
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
fun TimePickerPreview() {
    PomodoroTheme {
        TimePicker(
            modifier = Modifier.fillMaxSize(),
            hour = "00",
            minute = "00",
            second = "00",
            onValueChange = {_, _, _ ->}
        )
    }
}