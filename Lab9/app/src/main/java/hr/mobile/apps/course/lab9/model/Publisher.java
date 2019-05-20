package hr.mobile.apps.course.lab9.model;

import com.google.gson.annotations.SerializedName;

public class Publisher {
    private long id;
    private String name;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("updated_at")
    private String updateAt;

    public Publisher(long id, String name, String createdAt, String updateAt) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }
}
