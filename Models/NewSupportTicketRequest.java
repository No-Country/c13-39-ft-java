package com.nicoz.NZWanderlust;

public class NewSupportTicketRequest {
    private Long UserId;
    private String status;
    private String details;
    private Boolean affected;

    public NewSupportTicketRequest(String status, String details, Boolean affected) {
        this.status = status;
        this.details = details;
        this.affected = affected;
    }

    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long userId) {
        UserId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Boolean getAffected() {
        return affected;
    }

    public void setAffected(Boolean affected) {
        this.affected = affected;
    }
}
