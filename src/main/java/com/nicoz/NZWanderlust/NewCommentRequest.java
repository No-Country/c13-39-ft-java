package com.nicoz.NZWanderlust;

public class NewCommentRequest {
    private Long userId;
    private String title;
    private String details;
    private String score;

    public NewCommentRequest(Long userId, String title, String details, String score) {
        this.userId = userId;
        this.title = title;
        this.details = details;
        this.score = score;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
