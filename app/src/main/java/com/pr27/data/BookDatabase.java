package com.pr27.data;
import androidx.room.Room;
import android.content.Context;

import com.pr27.basic.concurency.TaskCallback;
import com.pr27.data.mappers.BookEntitiesListToBookList;
import com.pr27.data.mappers.BookToBookEntityMapper;
import com.pr27.data.room.AppDatabase;
import com.pr27.data.room.BookDao;
import com.pr27.data.room.BookEntity;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BookDatabase implements  BookRepository {

    private final ExecutorService executorService;
    private final BookDao bookDao;

    private final BookToBookEntityMapper bookToBookEntityMapper = new BookToBookEntityMapper();
    private final BookEntitiesListToBookList bookEntitiesListToBookList = new BookEntitiesListToBookList();

    public BookDatabase(Context context) {
        AppDatabase db = Room.databaseBuilder(context.getApplicationContext(),
                AppDatabase.class, "BookDB").build();
        executorService = Executors.newSingleThreadExecutor();
        bookDao = db.getBookDao();
    }

    @Override
    public void getAllBook(TaskCallback<List<Book>> callback) {
        executorService.submit(() -> {
            List<BookEntity> book = bookDao.getAllBook();
            callback.onCompleted(bookEntitiesListToBookList.map(book),null);
        });
    }

    @Override
    public void addBook(Book book) {
        executorService.submit(() -> bookDao.insertBook(bookToBookEntityMapper.map(book)));
    }
}
