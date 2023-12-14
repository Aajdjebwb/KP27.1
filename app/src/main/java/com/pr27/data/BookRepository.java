package com.pr27.data;

import com.pr27.basic.concurency.TaskCallback;

import java.util.List;

public interface BookRepository {
    void getAllBook(TaskCallback<List<Book>> callback);
    void addBook(Book book);
}
