package com.pr27.data.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {BookEntity.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract BookDao getBookDao();
}