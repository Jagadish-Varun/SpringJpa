package com.example.demo.dto;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.entity.Customer;

public class CustomerPaymentDTO {

	 private String customerName;
	    private BigDecimal totalAmountPaid;
	    private List<String> rentedFilms;

	    public CustomerPaymentDTO(String customerName, BigDecimal totalAmountPaid, List<String> rentedFilms) {
	        this.customerName = customerName;
	        this.totalAmountPaid = totalAmountPaid;
	        this.rentedFilms = rentedFilms;
	    }

		public String getCustomerName() {
			return customerName;
		}

		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}

		public BigDecimal getTotalAmountPaid() {
			return totalAmountPaid;
		}

		public void setTotalAmountPaid(BigDecimal totalAmountPaid) {
			this.totalAmountPaid = totalAmountPaid;
		}

		public List<String> getRentedFilms() {
			return rentedFilms;
		}

		public void setRentedFilms(List<String> rentedFilms) {
			this.rentedFilms = rentedFilms;
		}
	    
	    

}
