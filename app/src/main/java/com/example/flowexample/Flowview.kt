package com.example.flowexample

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class Flowview : ViewModel() {

   val startCounter = flow<Int> {
           val counterflow = 10
           var changecounter = counterflow
           emit(counterflow)

           while (changecounter > 0) {
               delay(1000)
               changecounter--
               emit(changecounter)
           }

    }
    init {
        collectviewmodel()
    }
    private fun  collectviewmodel (){
/*viewModelScope.launch {
    startCounter.filter {
        it%3==0

    }.map {
        it+it
    }.collect{
      println("Count: ${it}" )
    }
}*/
startCounter.onEach {
    println(it)
}.launchIn(viewModelScope)
    }

}