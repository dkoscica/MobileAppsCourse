package hr.mobile.apps.course.lab7.model;

public class Book {

    private long id;
    private String title;
    private String author;
    private int year;
    private double cost;
    private String imageUrl;

    public Book(long id, String title, String author, int year, double cost, String imageUrl) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.cost = cost;
        this.imageUrl = imageUrl;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
