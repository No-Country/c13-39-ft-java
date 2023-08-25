package com.nicoz.NZWanderlust;

public class NewCommentRequest {
    private Long buyerId;
    private Long sellerId;
    private String title;
    private String details;
    private String score;

    public NewCommentRequest(Long buyerId, Long sellerId, String title, String details, String score) {
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.title = title;
        this.details = details;
        this.score = score;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
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
