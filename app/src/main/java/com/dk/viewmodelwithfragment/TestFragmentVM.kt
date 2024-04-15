package com.dk.viewmodelwithfragment

import androidx.lifecycle.ViewModel

class TestFragmentVM : ViewModel() {

    var countVal = 0

    fun plus(){
        countVal++
    }

    fun minus(){
        countVal--
    }

    fun getCnt() : Int{
        return countVal
    }
}