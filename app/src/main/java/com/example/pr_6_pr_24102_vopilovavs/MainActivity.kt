package com.example.pr_6_pr_24102_vopilovavs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.example.pr_6_pr_24102_vopilovavs.ui.theme.PR6_PR24102_VopilovaVSTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PR6_PR24102_VopilovaVSTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState())
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        CounterSection()
                        InputSection()
                        RecompositionSection()
                        RememberSection()
                        StateInsideSection()
                    }
                }
            }
        }
    }
}

@Composable
fun CounterSection() {
    var count by remember { mutableStateOf(0) }

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(text = "Кликов: $count")

        Button(onClick = { count++ }) {
            Text(text = "Увеличить счётчик")
        }
    }
}

@Composable
fun InputSection() {
    var isChecked by remember { mutableStateOf(false) }
    var text by remember { mutableStateOf("") }

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = isChecked,
                onCheckedChange = { isChecked = it }
            )
            Text(text = "Я согласен с условиями")
        }

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Введите текст") },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun RecompositionSection() {
    var counter by remember { mutableStateOf(0) }

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        CounterDisplay(
            counter = counter,
            onIncrement = { counter++ }
        )

        InfoText(counter = counter)
    }
}

@Composable
fun CounterDisplay(
    counter: Int,
    onIncrement: () -> Unit
) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(text = "Счётчик: $counter")

        Button(onClick = onIncrement) {
            Text(text = "+")
        }
    }
}

@Composable
fun InfoText(counter: Int) {
    Text(
        text = if (counter < 3) "Ещё" else "Достаточно"
    )
}

class EvenOdd(
    private val uppercase: Boolean
) {
    fun check(value: Int): String {
        var result = if (value % 2 == 0) "Чётное" else "Нечётное"

        if (uppercase) {
            result = result.uppercase()
        }

        return result
    }
}

@Composable
fun RememberSection() {
    var counter by remember { mutableStateOf(0) }
    var uppercase by remember { mutableStateOf(false) }

    val evenOdd = remember(uppercase) {
        EvenOdd(uppercase)
    }

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = uppercase,
                onCheckedChange = { uppercase = it }
            )
            Text(text = "Показывать заглавными")
        }

        Text(text = "Число $counter — ${evenOdd.check(counter)}")

        Button(onClick = { counter++ }) {
            Text(text = "Изменить число")
        }
    }
}

@Composable
fun StateInsideSection() {
    var isExpanded by remember { mutableStateOf(false) }

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = isExpanded,
                onCheckedChange = { isExpanded = it }
            )
            Text(text = "Показать подробности")
        }

        if (isExpanded) {
            Text(
                text = "Дополнительная информация. " +
                        "Состояние хранится внутри Composable-функции с помощью remember."
            )
        }
    }
}