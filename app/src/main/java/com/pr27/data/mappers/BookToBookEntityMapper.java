package com.pr27.data.mappers;

import com.pr27.data.Book;
import com.pr27.data.room.BookEntity;

public class BookToBookEntityMapper implements Mapper<Book, BookEntity> {
    @Override
    public BookEntity map(Book val) {
        return new BookEntity(val.getName(),val.getAutor(), String.valueOf(val.getYear()));
    }
}
