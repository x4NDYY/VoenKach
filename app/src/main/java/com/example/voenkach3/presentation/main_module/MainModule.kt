package com.example.voenkach3.presentation.main_module

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.voenkach3.R

@Preview(showBackground = true)
@Composable
fun MainModulePreview(){
    MainModule()
}
@Preview(showBackground = true)
@Composable
fun ProfileCardPreview(){
    ProfileCard()
}

@Preview(showBackground = true)
@Composable
fun CurrentTasksCardPreview(){
    CurrentTasksCard()
}

@Composable
fun MainModule(){
    Box(modifier = Modifier.fillMaxSize()){
        Image(painter = painterResource(id = R.drawable.green), contentDescription = "", contentScale = ContentScale.Crop, modifier = Modifier.matchParentSize())
        Column(modifier = Modifier
            .matchParentSize()
            .padding(16.dp)) {
            ProfileCard()
            Spacer(modifier = Modifier.height(16.dp))
            CurrentTasksCard()
        }
    }
}

@Composable
fun ProfileCard(){
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFA9D3A8))
            .padding(16.dp)) {
            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier =  Modifier.fillMaxWidth()) {
                Image(painter = painterResource(id = R.drawable.admin), contentDescription = "", modifier = Modifier.size(70.dp))
                Text(text = "ВоенКач", fontSize = 32.sp, fontWeight = FontWeight.Bold)
                Image(painter = painterResource(id = R.drawable.rocket), contentDescription = "", modifier = Modifier.size(70.dp))
            }
            Spacer(modifier = Modifier.height(16.dp))
            Column {
                Text(text = "Имя: Александр", fontWeight = FontWeight.Bold)
                Text(text = "Фамилия: Тюленев ", fontWeight = FontWeight.Bold)
                Text(text = "Должность: Ген. директор", fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
fun CurrentTasksCard(){
    val tasksList: MutableList<String> = mutableListOf("Двигатель", "Ходовая часть",
                                                        "Трансмиссия", "Система охлаждения", "Электрическая система",
                                                        "Система тормозов")
    Card(modifier = Modifier.fillMaxSize()) {
        Column(verticalArrangement = Arrangement.SpaceBetween, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFA9D3A8))
            .padding(16.dp)) {
            Text(text = "Тестирование военного образца:", fontWeight = FontWeight.Bold, modifier = Modifier.weight(0.04f))
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp), modifier = Modifier
                .fillMaxWidth()
                .weight(0.92f)) {
                itemsIndexed(tasksList){index,task->
                    Card(modifier = Modifier.fillMaxWidth()) {
                        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(0xFF288B2C))
                            .padding(16.dp)) {
                            Row {
                                Text(text = (index + 1).toString() + ". ")
                                Text(text = task)
                            }
                            //Icon(imageVector = Icons.Default.Close, contentDescription = "")
                        }
                    }
                }
                item{
                    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()){
                        Image(painter = painterResource(id = R.drawable.plus), contentDescription = "", modifier = Modifier
                            .size(45.dp))
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Дата: 12.07.2024", fontWeight = FontWeight.Bold, modifier = Modifier.weight(0.04f))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddDetailCardPreview(){
    AddDetailCard()
}

@Composable
fun AddDetailCard() {
    Card() {
        Column(Modifier.padding(16.dp)) {
            Row() {
                Text(text = "Добавить деталь")
                Spacer(modifier = Modifier.weight(1f))
                Icon(imageVector = Icons.Default.Close, contentDescription = "close")
            }
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = "",
                onValueChange = {},
                minLines = 1,
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(
                        text = "Название детали"
                    )
                })
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = "",
                onValueChange = {},
                minLines = 4,
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(
                        text = "Описание"
                    )
                })
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "ОК", modifier = Modifier.align(alignment = Alignment.End))
        }
    }
}