package com.hangular.hangular.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hangular.hangular.data.model.Baca
import com.hangular.hangular.data.model.Hangul

@Dao
interface HangulDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertHangul(hangulList: List<Hangul>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBaca(bacaList : List<Baca>)

    @Query("SELECT * FROM hangul WHERE tipe = 1")
    fun getHangulVocal() : LiveData<List<Hangul>>

    @Query("SELECT * FROM hangul WHERE tipe= 2")
    fun getHangulKonsonan() : LiveData<List<Hangul>>

    @Query("SELECT * FROM hangul")
    fun getHangul() : LiveData<List<Hangul>>

    @Query("SELECT * FROM baca")
    fun getBaca() : LiveData<List<Baca>>

    @Query("SELECT * FROM hangul WHERE id = :id")
    fun getDetail(id: Int) : LiveData<Hangul>

    @Query ("SELECT * FROM hangul WHERE nama = :nama")
    fun getByName (nama : String ) : LiveData<Hangul>
}