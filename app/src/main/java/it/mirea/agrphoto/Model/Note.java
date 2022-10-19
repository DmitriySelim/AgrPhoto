package it.mirea.agrphoto.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table")
public class Note {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "Title")
    private final String title;
    @ColumnInfo(name = "Description")
    private final String description;
    @ColumnInfo(name = "Date")
    private final String date;
    @ColumnInfo(name = "Priority")
    private final int priority;

    public Note(String title, String description,String date, int priority) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.priority = priority;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }
}
