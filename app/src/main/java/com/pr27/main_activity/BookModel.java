package com.pr27.main_activity;

import androidx.annotation.NonNull;

public class BookModel {
    private String name = "";
    private String autor = "";
    private String year = "";

    private boolean needToSwitchView = false;
    private boolean needToShowErrors = false;

    public BookModel() {
    }

    public boolean isNeedToSwitchView() {
        return needToSwitchView;
    }

    public void setNeedToSwitchView(boolean needToSwitchView) {
        this.needToSwitchView = needToSwitchView;
    }

    public boolean isNeedToShowErrors() {
        return needToShowErrors;
    }

    public void setNeedToShowErrors(boolean needToShowErrors) {
        this.needToShowErrors = needToShowErrors;
    }

    public BookModel(String name, String autor, String year) {
        this.name = name;
        this.autor  = autor;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @NonNull
    @Override
    public String toString() {
        return "Book{" +
                "book name='" + name + '\'' +
                ", book autor='" + autor + '\'' +
                ", book year=" + year +
                '}';
    }
}
