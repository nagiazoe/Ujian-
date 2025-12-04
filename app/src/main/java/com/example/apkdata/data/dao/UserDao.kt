package com.example.apkdata.data.dao

import androidx.room.*
import com.example.apkdata.data.entity.User
import com.example.apkdata.data.entity.User2

@Dao
interface UserDao {

    //dapatkan semua data
    @Query("SELECT * FROM user ORDER BY nama ASC")
    fun getAll(): List<User>

    @Query("SELECT * FROM user2 ORDER BY juduldata ASC")
    fun getAll2(): List<User2>

    //g tau
    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<User>

    @Query("SELECT * FROM user2 WHERE id2 IN (:user2Ids)")
    fun loadAllByIds2(user2Ids: IntArray): List<User2>

    //mencari berdasarkan id
    @Query(value = "SELECT * FROM user WHERE uid = :uid")
    fun get(uid: Int): User

    @Query(value = "SELECT * FROM user2 WHERE id2 = :id2")
    fun get2(id2: Int): User2

    //masukan data
    @Insert
    fun insertAll(vararg users: User)

    @Insert
    fun insertAll2(vararg users2: User2)

    //hapus data
    @Delete
    fun delete(user: User)

    @Delete
    fun delete(user2: User2)

    //update data
    @Update
    fun update (user: User)

    @Update
    fun update2 (user2: User2)

    //mencari data
    @Query ("SELECT * FROM user WHERE nama LIKE '%' || :search || '%' ")
    fun searchbynama(search: String): List<User>

    @Query ("SELECT * FROM user WHERE dataangkastart LIKE '%' || :search || '%' ")
    fun searchbydataangka(search: String): List<User>

    @Query ("SELECT * FROM user WHERE namaketegoristart LIKE '%' || :search || '%' ")
    fun searchbynamakategori(search: String): List<User>

    @Query ("SELECT * FROM user WHERE namaketegoristart2 LIKE '%' || :search || '%' ")
    fun searchbynamakategori2(search: String): List<User>

    @Query ("SELECT * FROM user WHERE namaketegoristart3 LIKE '%' || :search || '%' ")
    fun searchbynamakategori3(search: String): List<User>

    @Query ("SELECT * FROM user WHERE namaketegoristart4 LIKE '%' || :search || '%' ")
    fun searchbynamakategori4(search: String): List<User>

    @Query ("SELECT * FROM user WHERE namaketegoristart5 LIKE '%' || :search || '%' ")
    fun searchbynamakategori5(search: String): List<User>

    @Query ("SELECT * FROM user2 WHERE juduldata LIKE '%' || :search || '%' ")
    fun searchbyjuduldata(search: String): List<User2>

}