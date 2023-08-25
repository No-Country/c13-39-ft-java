package com.nicoz.NZWanderlust;

import java.time.LocalDate;

public class NewTicketTravelBuyerRequest {
    private Long postId;
    private Long buyerId;
    private String price;
    private LocalDate startDate;
    private LocalDate endDate;

    public NewTicketTravelBuyerRequest(Long postId, Long buyerId, String price, LocalDate startDate, LocalDate endDate) {
        this.postId = postId;
        this.buyerId = buyerId;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
