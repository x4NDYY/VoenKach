package com.example.voenkach3.presentation.main_module.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.voenkach3.R
import com.example.voenkach3.presentation.main_module.MainState
import com.example.voenkach3.presentation.main_module.MainViewModel

@Preview(showBackground = true)
@Composable
fun MainModulePreview(){
    //MainModule()
}
@Preview(showBackground = true)
@Composable
fun ProfileCardPreview(){
    ProfileCard()
}

@Preview(showBackground = true)
@Composable
fun CurrentTasksCardPreview(){
    //CurrentTasksCard()
}

@Composable
fun MainModule(navController: NavHostController, mainViewModel: MainViewModel = viewModel()){
    val mainState by mainViewModel.mainState.collectAsState()
    Box(modifier = Modifier.fillMaxSize()){
        if (mainState.customDetailInformation.isDetailCardOpen){
            AddDetailCard(mainState = mainState, mainViewModel = mainViewModel)
        }
        Image(painter = painterResource(id = R.drawable.green), contentDescription = "", contentScale = ContentScale.Crop, modifier = Modifier.matchParentSize())
        Column(modifier = Modifier
            .matchParentSize()
            .padding(16.dp)) {
            ProfileCard()
            Spacer(modifier = Modifier.height(16.dp))
            CurrentTasksCard(mainState = mainState, mainViewModel = mainViewModel)
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
fun CurrentTasksCard(mainState: MainState, mainViewModel: MainViewModel){
    Card(modifier = Modifier.fillMaxSize()) {
        Column(verticalArrangement = Arrangement.SpaceBetween, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFA9D3A8))
            .padding(16.dp)) {
            Text(text = "Тестирование военного образца:", fontWeight = FontWeight.Bold, modifier = Modifier.weight(0.04f))
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(vertical = 8.dp)) {
                Column(modifier = Modifier.weight(1f)) {
                    OutlinedTextField(
                        value = mainState.nameOfVehicle,
                        onValueChange = { mainViewModel.changeNameOfVehicle(it) },
                        maxLines = 1,
                        label = {
                            Text(
                                text = "Название техники"
                            )
                        })

                    Spacer(modifier = Modifier.width(8.dp))
                    OutlinedTextField(
                        value = mainState.serialNumberOfVehicle,
                        onValueChange = { mainViewModel.changeSerialNumberOfVehicle(it) },
                        maxLines = 1,
                        label = {
                            Text(
                                text = "Серийный номер", style = TextStyle(fontSize = 16.sp)
                            )
                        })
                }
                Spacer(modifier = Modifier.width(8.dp))
                Image(painter = painterResource(id = R.drawable.qr), contentDescription = "", modifier = Modifier.size(90.dp))

            }

            LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp), modifier = Modifier
                .fillMaxWidth()
                .weight(0.92f)) {
                itemsIndexed(mainState.detailList){index,detail->
                    Log.d("changeStateOfDetail", "Detail: ${ detail.nameOfDetail } : ${ detail.isDetailOk }")
                    DetailCard(isDetailOk = detail.isDetailOk, indexOfDetail = index, nameOfDetail = detail.nameOfDetail, changeStateOfDetail = mainViewModel::changeStateOfDetail, deleteDetailFromList = mainViewModel::removeDetailFromList)
                }
                item{
                    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()){
                        Image(painter = painterResource(id = R.drawable.plus), contentDescription = "", modifier = Modifier
                            .size(45.dp)
                            .clickable { mainViewModel.changeStateOfCustomDetailCard(true) })

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
    //AddDetailCard()
}

@Composable
fun AddDetailCard(mainState: MainState, mainViewModel: MainViewModel) {
    Dialog(onDismissRequest = {  }) {
        Card() {
            Column(Modifier.padding(16.dp)) {
                Row() {
                    Text(text = "Добавить деталь")
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(imageVector = Icons.Default.Close, contentDescription = "close", modifier = Modifier.clickable { mainViewModel.changeStateOfCustomDetailCard(false) })
                }
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = mainState.customDetailInformation.nameOfDetail,
                    onValueChange = { mainViewModel.changeNameOfDetail(it) },
                    minLines = 1,
                    modifier = Modifier.fillMaxWidth(),
                    label = {
                        Text(
                            text = "Название детали"
                        )
                    })
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = mainState.customDetailInformation.descriptionOfDetail,
                    onValueChange = { mainViewModel.changeDescriptionOfDetail(it) },
                    minLines = 4,
                    modifier = Modifier.fillMaxWidth(),
                    label = {
                        Text(
                            text = "Описание"
                        )
                    })
                Spacer(modifier = Modifier.height(16.dp))
                TextButton(onClick = { mainViewModel.addDetailToList(nameOfDetail = mainState.customDetailInformation.nameOfDetail)
                    mainViewModel.changeStateOfCustomDetailCard(false)  }, modifier = Modifier.align(alignment = Alignment.End)){
                    Text(text = "OK")
                }
            }
        }
    }
}


@Composable
fun DetailCard(isDetailOk: Boolean, indexOfDetail: Int, nameOfDetail: String, changeStateOfDetail: (String) -> Unit, deleteDetailFromList: (String) -> Unit) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF288B2C))
                .padding(16.dp)
        ) {
            Text(text = (indexOfDetail + 1).toString() + ". ")
            Text(text = nameOfDetail)
            Spacer(modifier = Modifier.weight(1f))
            Image(
                painter = painterResource(id = if (isDetailOk) R.drawable.grey else R.drawable.red),
                contentDescription = "",
                modifier = Modifier
                    .size(24.dp)
                    .clickable { changeStateOfDetail(nameOfDetail) }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Image(
                painter = painterResource(id = if (isDetailOk) R.drawable.greenn else R.drawable.grey),
                contentDescription = "",
                modifier = Modifier
                    .size(24.dp)
                    .clickable { changeStateOfDetail(nameOfDetail) }
            )
            Image(
                imageVector = Icons.Default.Close,
                contentDescription = "",
                modifier = Modifier
                    .size(24.dp)
                    .clickable { deleteDetailFromList(nameOfDetail) }
            )
        }
    }
}