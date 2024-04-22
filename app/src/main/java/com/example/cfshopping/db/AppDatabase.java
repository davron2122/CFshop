package com.example.cfshopping.db;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.cfshopping.model.User;

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao userDao();

}
