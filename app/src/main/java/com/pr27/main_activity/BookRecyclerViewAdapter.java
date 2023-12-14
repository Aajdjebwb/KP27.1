package com.pr27.main_activity;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.pr27.R;
import com.pr27.data.Book;

import java.util.List;

public class BookRecyclerViewAdapter extends RecyclerView.Adapter<BookRecyclerViewAdapter.BookHolder> {

    private final MainActivityBookViewModel autor;
    private List<Book> list;

    public BookRecyclerViewAdapter(MainActivityBookViewModel autor, List<Book> list) {
        this.autor = autor;
        this.list = list;
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        autor.getListMutableLiveData().observeForever(this::reInit);
    }

    @SuppressLint("NotifyDataSetChanged")
    public void reInit(List<Book> newItems) {
        if (list == null || list.isEmpty()) {
            list = newItems;
            notifyDataSetChanged();
            return;
        }
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new BooksDiffUtils(list, newItems));
        list = newItems;
        diffResult.dispatchUpdatesTo(this);
    }

    @NonNull
    @Override
    public BookRecyclerViewAdapter.BookHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item, parent, false);
        return new BookHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookRecyclerViewAdapter.BookHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class BookHolder extends RecyclerView.ViewHolder {

        private final TextView name;
        private final TextView autor;
        private final TextView year;


        public BookHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.Name);
            autor = itemView.findViewById(R.id.Autor);
            year = itemView.findViewById(R.id.Year);
        }

        @SuppressLint("SetTextI18n")
        public void bind(Book item) {
            name.setText(item.getName());
            autor.setText(item.getAutor());
            year.setText("year"+item.getYear());
        }
    }

}

