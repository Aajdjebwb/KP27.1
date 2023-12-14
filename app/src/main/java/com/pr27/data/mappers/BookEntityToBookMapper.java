package com.pr27.data.mappers;

import com.pr27.data.Book;
import com.pr27.data.room.BookEntity;

public class BookEntityToBookMapper implements Mapper<BookEntity, Book> {
    @Override
    public Book map(BookEntity val) {
        return new Book(val.getId(), val.getName(), val.getAutor(), String.valueOf(val.getYear()));
    }
}