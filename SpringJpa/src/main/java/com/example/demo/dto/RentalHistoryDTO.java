package com.example.demo.dto;

import java.math.BigDecimal;

public class RentalHistoryDTO {

	private String firstName;
    private String lastName;
    private String filmTitle;
    private String category;
    private BigDecimal paymentAmount;

    public RentalHistoryDTO(String firstName, String lastName, String filmTitle, 
                            String category, BigDecimal paymentAmount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.filmTitle = filmTitle;
        this.category = category;
        this.paymentAmount = paymentAmount;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFilmTitle() {
        return filmTitle;
    }

    public void setFilmTitle(String filmTitle) {
        this.filmTitle = filmTitle;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }
}
