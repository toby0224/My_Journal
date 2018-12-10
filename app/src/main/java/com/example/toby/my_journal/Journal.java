package com.example.toby.my_journal;


import org.w3c.dom.Text;



public class Journal {
    private int id;
    private String title;
    private String description;
    private String date;
    private String time;
    private String location;

    public Journal() {}
    public Journal(int id, String title, String description, String date,
                   String  time, String location) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
        this.time = time;
        this.location = location;
    }

    // id
    public void setID(int id) {
        this.id = id;
    }
    public int getID() {
        return this.id;
    }

    // title
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return this.title;
    }
    // description
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return this.description;
    }

    // date
    public void setDate(String date) {
        this.date = date;
    }
    public String getDate() {
        return this.date;
    }

    // time
    public void setTime(String time) {
        this.time = time;
    }
    public String getTime() {
        return this.time;
    }

    // location
    public void setLocation(String location) {
        this.location = location;
    }
    public String getLocation() {
        return this.location;
    }






}
