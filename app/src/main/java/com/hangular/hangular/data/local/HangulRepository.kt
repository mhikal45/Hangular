package com.hangular.hangular.data.local

import android.app.Application
import androidx.lifecycle.LiveData
import com.hangular.hangular.data.model.Hangul
import com.hangular.hangular.utils.HangulKonsonan
import com.hangular.hangular.utils.HangulVokal
import java.util.concurrent.Executor
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class HangulRepository (application: Application) {

    private val mHangulDao : HangulDao
    private val executorService : ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val database = HangulDatabase.getDatabase(application)
        mHangulDao = database.hangulDao()
    }

    fun getHangulVocal () : LiveData<List<Hangul>> = mHangulDao.getHangulVocal()

    fun getHangulKonsonan() : LiveData<List<Hangul>> = mHangulDao.getHangulKonsonan()

    fun getHangul() : LiveData<List<Hangul>> = mHangulDao.getHangul()

    fun insertHangulVocal(hangulVocal : List<Hangul>) {
        executorService.execute { mHangulDao.insertHangul(hangulVocal) }
    }

    fun insertHangulKonsonan(hangulKonsonan : List<Hangul>) {
        executorService.execute { mHangulDao.insertHangul(hangulKonsonan) }
    }
}