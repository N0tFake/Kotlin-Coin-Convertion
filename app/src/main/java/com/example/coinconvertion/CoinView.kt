package com.example.coinconvertion

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CoinView: ViewModel() {
    private val _reais = MutableStateFlow<Double>(0.0)
    val reais = _reais.asStateFlow()

    private val _dollar = MutableStateFlow<Double>(0.0)
    val dollar = _dollar.asStateFlow()

    private val _euro = MutableStateFlow<Double>(0.0)
    val euro = _euro.asStateFlow()

    private val _libra = MutableStateFlow<Double>(0.0)
    val libra = _libra.asStateFlow()

    private val _yuan = MutableStateFlow<Double>(0.0)
    val yuan = _yuan.asStateFlow()


    fun changeValues(value: Double){
        _reais.value = value
        _dollar.value = _reais.value * 5
        _euro.value = _reais.value * 5.3
        _libra.value = _reais.value * 6.3
        _yuan.value = _reais.value * 0.69
    }
}