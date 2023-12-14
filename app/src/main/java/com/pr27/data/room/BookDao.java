package com.pr27.data.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface BookDao {
    @Query("SELECT * FROM Book")
    List<BookEntity> getAllBook();

    @Insert
    void insertBook(BookEntity book);
}