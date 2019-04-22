package hr.mobile.apps.course.lab6.model;

import java.io.Serializable;

public class Book implements Serializable {

    private long id;
    private String title;
    private String author;

    private int year;
    private double cost;

    public Book(long id, String title, String author, int year, double cost) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.cost = cost;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
