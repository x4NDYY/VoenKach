package com.example.voenkach3.presentation.main_module

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class DetailInfo(
    val nameOfDetail: String = "",
    var isDetailOk: Boolean = false,
)
data class CustomDetailInformation(
    val nameOfDetail: String = "",
    val descriptionOfDetail: String = "",
    val isDetailCardOpen: Boolean = false
)

data class MainState(
    val detailList: MutableList<DetailInfo> = mutableListOf(DetailInfo("Двигатель"), DetailInfo("Ходовая часть"),
        DetailInfo("Трансмиссия"), DetailInfo("Система охлаждения"), DetailInfo("Электрическая система"),
        DetailInfo("Система тормозов")),
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
        val newDetailList = _mainState.value.detailList.toMutableList()
        newDetailList.add(DetailInfo(nameOfDetail))
        _mainState.update { currentState ->
            currentState.copy(detailList = newDetailList)
        }
    }

    fun changeStateOfDetail(nameOfDetail: String){
        val newDetailList = _mainState.value.detailList.map { detail ->
            if (detail.nameOfDetail == nameOfDetail) {
                detail.copy(isDetailOk = !detail.isDetailOk)
            } else {
                detail
            }
        }

        // Обновляем состояние
        _mainState.update { currentState ->
            currentState.copy(detailList = newDetailList.toMutableList())
        }
    }

    fun removeDetailFromList(nameOfDetail: String){
        val newDetailList = _mainState.value.detailList.toMutableList()
        var removedDetail: DetailInfo? = null
        for (ix in newDetailList){
            if (ix.nameOfDetail == nameOfDetail){
                removedDetail = ix
            }
        }
        if (removedDetail != null){
            newDetailList.remove(removedDetail)
        }

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
            val newCustomDetailInformation = currentState.customDetailInformation.copy(nameOfDetail = nameOfDetail)
            currentState.copy(customDetailInformation = newCustomDetailInformation)
        }
    }

    fun changeDescriptionOfDetail(descriptionOfDetail: String){
        _mainState.update { currentState ->
            val newCustomDetailInformation = currentState.customDetailInformation.copy(descriptionOfDetail = descriptionOfDetail)
            currentState.copy(customDetailInformation = newCustomDetailInformation)
        }
    }
}