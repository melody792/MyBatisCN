package org.apache.ibatis.pzb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Blog extends Article implements Serializable {
    private int id;
    private String title;
    private User author;
    private String body;
    private List<Comment> comments;
    Map<String, Object> labels;
    private boolean isPublished;

    public boolean isPublished() {
        return isPublished;
    }

    public boolean getPublished() {
        return isPublished;
    }

    public void setPublished(boolean published) {
        isPublished = published;
    }

    public Blog() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Map<String, Object> getLabels() {
        return labels;
    }

    public void setLabels(Map<String, Object> labels) {
        this.labels = labels;
    }
}
