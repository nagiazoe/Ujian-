package com.example.apkdata.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "user")
data class User(
        @PrimaryKey(autoGenerate = true) var uid: Int? = null,
        @ColumnInfo(name = "nama") var nama:String?,
        @ColumnInfo(name = "dataangkastart") var dataangkastart: Int?,
        @ColumnInfo(name = "namaketegoristart") var namaketegoristart:String?,
        @ColumnInfo(name = "namaketegoristart2") var namaketegoristart2:String?,
        @ColumnInfo(name = "namaketegoristart3") var namaketegoristart3:String?,
        @ColumnInfo(name = "namaketegoristart4") var namaketegoristart4:String?,
        @ColumnInfo(name = "namaketegoristart5") var namaketegoristart5:String?
        )

@Entity(tableName = "user2")
data class User2(
        @PrimaryKey(autoGenerate = true) var id2: Int? = null,
        @ColumnInfo(name = "juduldata") var juduldata:String?,
        @ColumnInfo(name = "masukanangka1") var masukanangka1: Int?,
        @ColumnInfo(name = "masukanangka2") var masukanangka2: Int?,
        @ColumnInfo(name = "namadataangka") var namadataangka:String?,
        @ColumnInfo(name = "jeniskategori") var jeniskategori:String?,
        @ColumnInfo(name = "jeniskategori2") var jeniskategori2:String?,
        @ColumnInfo(name = "jeniskategori3") var jeniskategori3:String?,
        @ColumnInfo(name = "namakategoricuy2") var namakategoricuy2:String?,
        @ColumnInfo(name = "namakategoricuy3") var namakategoricuy3:String?,
        @ColumnInfo(name = "namakategoricuy4") var namakategoricuy4:String?,
        @ColumnInfo(name = "namakategoricuy5") var namakategoricuy5:String?,
        @ColumnInfo(name = "namakategoricuy6") var namakategoricuy6:String?,
        @ColumnInfo(name = "namakategoricuy7") var namakategoricuy7:String?,
)
