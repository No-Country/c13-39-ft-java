package com.nicoz.NZWanderlust;

public class NewSellerRequest {
    private String companyName;
    private String phone;

    public NewSellerRequest(String companyName, String phone, Long sellerId) {
        this.companyName = companyName;
        this.phone = phone;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
