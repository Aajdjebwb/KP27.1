package com.pr27.main_activity;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.pr27.data.Book;
import com.pr27.data.BookRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class MainActivityBookViewModel extends ViewModel {

    private final BookRecyclerViewAdapter recyclerViewAdapter;
    private final MutableLiveData<List<Book>> listMutableLiveData;
    private final MutableLiveData<State> state;
    private final BookRepository bookRepository;

    public MainActivityBookViewModel(BookRepository BookRepository) {
        this.bookRepository = BookRepository;
        this.listMutableLiveData=new MutableLiveData<>(new ArrayList<>());
        this.state = new MutableLiveData<>(new State());
        this.recyclerViewAdapter = new BookRecyclerViewAdapter(MainActivityBookViewModel.this,listMutableLiveData.getValue());



        listMutableLiveData.observeForever(book -> {
            state.postValue(new State());
            reInitList();
        });
    }

    public BookRecyclerViewAdapter getRecyclerViewAdapter() {
        return recyclerViewAdapter;
    }

    public MutableLiveData<List<Book>> getListMutableLiveData(){
        return listMutableLiveData;
    }

    public void reInitList(){
        bookRepository.getAllBook((result, fault) -> {
            if(fault == null && result != null){
                listMutableLiveData.postValue(result);
            }
        });
    }

    public MutableLiveData<State> getState() {
        return state;
    }

    public class State{
        public boolean openNewBookActivity = false;

        public boolean isListEmpty() {
            return Objects.requireNonNull(listMutableLiveData.getValue()).isEmpty();
        }
    }
}
