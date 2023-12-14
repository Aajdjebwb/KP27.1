package com.pr27.data;


import androidx.annotation.NonNull;

public class Book {

    private int id;
    private String name;
    private String autor;
    private int year;

    public Book(){}

    public Book(String name, String autor, int year) {
        this.name =  name;
        this.autor = autor;
        this.year = year;
    }

    public Book(int id, String name, String autor, String year) {
        this.id = id;
        this.name = name;
        this.autor = autor;
        this.year = Integer.parseInt(year);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
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
