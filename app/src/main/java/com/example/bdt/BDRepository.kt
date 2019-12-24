package com.example.bdt

import androidx.lifecycle.LiveData

    class BDRepository (private val bdDao: BDDao) { // can access dao function like insert

    val alldb : LiveData<List<BD>> = bdDao.getAllBD()

        suspend fun insertBD (bd:BD) {// suspend for couroutine de function like insert, select no need
            bdDao.insertBD(bd)

        }

}