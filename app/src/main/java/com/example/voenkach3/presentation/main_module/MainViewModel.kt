package com.example.voenkach3.presentation.main_module

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class CustomDetailInformation(
    val nameOfDetail: String = "",
    val descriptionOfDetail: String = "",
    val isDetailCardOpen: Boolean = false
)

data class MainState(
    val detailList: MutableMap<String, Boolean> = mutableMapOf(),
    val nameOfVehicle: String = "",
    val serialNumberOfVehicle: String = "",
    val customDetailInformation: CustomDetailInformation = CustomDetailInformation()
)

class MainViewModel:ViewModel() {
    private val _mainState = MutableStateFlow(MainState())
    val mainState = _mainState.asStateFlow()

    fun changeNameOfVehicle(nameOfVehicle: String){
        _mainState.update { currentState ->
            currentState.copy(nameOfVehicle = nameOfVehicle)
        }
    }

    fun changeSerialNumberOfVehicle(serialNumberOfVehicle: String){
        _mainState.update { currentState ->
            currentState.copy(serialNumberOfVehicle = serialNumberOfVehicle)
        }
    }

    fun addDetailToList(nameOfDetail: String){
        val newDetailList = _mainState.value.detailList.toMutableMap()
        newDetailList[nameOfDetail] = false
        _mainState.update { currentState ->
            currentState.copy(detailList = newDetailList)
        }
    }

    fun changeStateOfDetail(nameOfDetail: String){
        val newDetailList = _mainState.value.detailList.toMutableMap()
        newDetailList[nameOfDetail] = !newDetailList.getValue(nameOfDetail)
        _mainState.update { currentState ->
            currentState.copy(detailList = newDetailList) }
    }

    fun removeDetailFromList(nameOfDetail: String){
        val newDetailList = _mainState.value.detailList.toMutableMap()
        newDetailList.remove(nameOfDetail)
        _mainState.update { currentState ->
            currentState.copy(detailList = newDetailList)
        }
    }

    fun changeStateOfCustomDetailCard(isDetailCardOpen: Boolean){
        _mainState.update { currentState ->
            val newCustomDetailInformation = CustomDetailInformation(isDetailCardOpen = isDetailCardOpen)
            currentState.copy(customDetailInformation = newCustomDetailInformation)
        }
    }

    fun changeNameOfDetail(nameOfDetail: String){
        _mainState.update { currentState ->
            val newCustomDetailInformation = CustomDetailInformation(nameOfDetail = nameOfDetail)
            currentState.copy(customDetailInformation = newCustomDetailInformation)
        }
    }

    fun changeDescriptionOfDetail(descriptionOfDetail: String){
        _mainState.update { currentState ->
            val newCustomDetailInformation = CustomDetailInformation(descriptionOfDetail = descriptionOfDetail)
            currentState.copy(customDetailInformation = newCustomDetailInformation)
        }
    }
}