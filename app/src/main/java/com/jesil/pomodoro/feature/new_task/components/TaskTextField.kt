package com.jesil.pomodoro.feature.new_task.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jesil.pomodoro.core.theme.PomodoroTheme
import com.jesil.pomodoro.core.theme.ThemeAnnotation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskTextField(
    modifier: Modifier = Modifier,
    value: String,
    isHintVisible: Boolean = false,
    onValueChange: (String) -> Unit,
    placeHolder: @Composable () -> Unit,
    keyboardType: KeyboardType = KeyboardType.Text,
) {
    val textFieldBackgroundColor = if (isSystemInDarkTheme()) Color(0xFF243647) else Color(0xFFE8EDF2)

    val fieldColors = OutlinedTextFieldDefaults.colors(
        focusedBorderColor = Color.Transparent,
        unfocusedBorderColor = Color.Transparent,
        focusedContainerColor = textFieldBackgroundColor,
        unfocusedContainerColor = textFieldBackgroundColor,
        cursorColor = MaterialTheme.colorScheme.onPrimary,
    )
    BasicTextField(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(
                color = textFieldBackgroundColor,
                shape = RoundedCornerShape(12.dp)
            ),
        value = value,
        maxLines = 5,
        onValueChange = onValueChange,
        cursorBrush = SolidColor(MaterialTheme.colorScheme.onPrimary),
        textStyle = MaterialTheme.typography.labelSmall.copy(
            color = MaterialTheme.colorScheme.onPrimary,
            fontSize = 16.sp
        ),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        decorationBox = { innerTextField ->
            OutlinedTextFieldDefaults.DecorationBox(
                value = value,
                visualTransformation = VisualTransformation.None,
                innerTextField = {
                    Box{
                        if (isHintVisible) {
                            placeHolder.invoke()
                        } else {
                            innerTextField()
                        }
                    }
                },
                placeholder = placeHolder,
                interactionSource = remember { MutableInteractionSource() },
                colors = fieldColors,
                singleLine = false,
                enabled = true,
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
            )
        }
    )
}

@ThemeAnnotation
@Composable
fun TaskTextFieldPreview() {
    PomodoroTheme {
        TaskTextField(
            modifier = Modifier.fillMaxWidth(),
            value = "",
            onValueChange = {},
            placeHolder = {
                Text(text = "e.g, Write Report")
            }
        )
    }
}