package ru.surovcev.project.springboot.service.demoresthello.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaymentDetails {
    private String paymentId;
    private double amount;

    public String getPaymentId() {return paymentId;}
    public void setPaymentId(String paymentId) {this.paymentId = paymentId;}

    public double getAmount() {return amount;}
    public void setAmount(double amount) {this.amount = amount;}
}
