package hr.mobile.apps.course.lab10.model;

import com.google.gson.annotations.SerializedName;

public class Book {

    private long id;

    private String title;
    private long publisherId;
    private long pages;

    @SerializedName("publication_date")
    private String publicationDate;

    @SerializedName("book_rate")
    private double bookRate;
    private long isbn13;

    @SerializedName("bestseller_rank")
    private int bestsellerRank;
    private String image;
    private String description;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("updated_at")
    private String updatedAt;

    private Publisher publisher;

    private boolean isInCollection;

    public Book(long id,
                String title,
                long publisherId,
                long pages,
                String publicationDate,
                double bookRate,
                long isbn13,
                int bestsellerRank,
                String image,
                String description,
                String createdAt,
                String updatedAt,
                Publisher publisher) {
        this.id = id;
        this.title = title;
        this.publisherId = publisherId;
        this.pages = pages;
        this.publicationDate = publicationDate;
        this.bookRate = bookRate;
        this.isbn13 = isbn13;
        this.bestsellerRank = bestsellerRank;
        this.image = image;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.publisher = publisher;
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

    public long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(long publisherId) {
        this.publisherId = publisherId;
    }

    public long getPages() {
        return pages;
    }

    public void setPages(long pages) {
        this.pages = pages;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public double getBookRate() {
        return bookRate;
    }

    public void setBookRate(double bookRate) {
        this.bookRate = bookRate;
    }

    public long getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(long isbn13) {
        this.isbn13 = isbn13;
    }

    public int getBestsellerRank() {
        return bestsellerRank;
    }

    public void setBestsellerRank(int bestsellerRank) {
        this.bestsellerRank = bestsellerRank;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public boolean isInCollection() {
        return isInCollection;
    }

    public void setInCollection(boolean inCollection) {
        isInCollection = inCollection;
    }
}
