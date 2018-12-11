package com.example.toby.my_journal;


import org.w3c.dom.Text;



public class Journal {
    private int id;
    private String title;
    private String content;
    private String date;
    private String time;
    private String location;

    public Journal() {}
    public Journal(int id, String title, String content, String date,
                   String  time, String location) {
        this.id = id;
        this.title = title;
        this.content = content;
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

    // content
    public void setContent(String content) {
        this.content = content;
    }
    public String getContent() {
        return this.content;
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
    public String getLocation() { return this.location; }



}
