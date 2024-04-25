package com.example.cfshopping.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.cfshopping.model.User;
import java.util.List;
import io.reactivex.rxjava3.core.Completable;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAll();

    @Insert
    Completable insertAll(User... users);


}
