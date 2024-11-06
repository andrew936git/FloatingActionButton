package com.example.floatingactionbutton.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class ViewScreen {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    fun Displaying() {
        val noteList = arrayListOf<String>()
        val input = rememberSaveable {
            mutableStateOf("")
        }

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 50.dp, start = 8.dp, end = 8.dp, bottom = 30.dp)

        )
        {
            Column(
                modifier = Modifier
                    .background(Color.LightGray)
                    .fillMaxSize()

            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.DarkGray)
                        .fillMaxWidth()
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .size(height = 50.dp, width = 0.dp)
                    )
                    {
                        Text(
                            text = "Заметки",
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            color = Color.White
                        )
                    }
                    TextField(
                        modifier = Modifier
                            .fillMaxWidth(),
                        value = input.value,
                        placeholder = { Text(text = "Введите заметку") },
                        onValueChange = { newText ->
                            input.value = newText
                        })

                }
                LazyColumn(
                    contentPadding = PaddingValues(vertical = 8.dp),
                    modifier = Modifier
                        .padding(start = 18.dp, end = 18.dp)
                        .fillMaxWidth()
                        .background(Color.LightGray),

                ) {
                    items(noteList) { note ->
                        Row(verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(shape = RoundedCornerShape(10.dp))
                                .background(Color.White)
                                .border(2.dp, Color.White)
                                .padding(2.dp)

                        ) {
                            Text(
                                text = note,
                                fontSize = 24.sp,
                                textAlign = TextAlign.Start,
                                modifier = Modifier.padding(start = 5.dp)
                                )

                            IconButton(
                                onClick = {
                                noteList.remove(note)
                                input.value = "."
                                input.value = ""
                            }
                            ) {
                                Icon(
                                    Icons.Filled.Delete,
                                    "",
                                    tint = Color.Black
                                )
                            }
                            Spacer(modifier = Modifier.padding(6.dp))
                        }
                    }
                }
                FloatingActionButton(
                    onClick = {
                        noteList.add(input.value)
                        input.value = ""
                    },
                    containerColor = Color.DarkGray,
                    contentColor = Color.White,
                    modifier = Modifier
                        .align(Alignment.End)
                ) {
                    Icon(Icons.Filled.Add, "")
                }
            }
        }
    }
}




