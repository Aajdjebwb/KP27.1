package com.pr27.data.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "Book",
        indices = {
                @Index("Id"),
        })
public class BookEntity {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    public int id;

    @ColumnInfo(name = "book name")
    public String name;

    @ColumnInfo(name = "book autor")
    public String autor;

    @ColumnInfo(name = "book year")
    public String year;

    public BookEntity() {

    }
    @Ignore
    public BookEntity(String name, String autor, String year) {
        this.name = name;
        this.autor = autor;
        this.year = year;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {this.year = year;
    }
}
