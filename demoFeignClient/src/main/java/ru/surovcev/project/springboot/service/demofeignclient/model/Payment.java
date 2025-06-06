package ru.surovcev.project.springboot.service.demofeignclient.model;

/**
 * по сути этот класс - это Это DTO (объект, который передаётся между клиентом и сервером)
 */
public class Payment {
    private String paymentId;
    private double amount;

    public String getPaymentId() {return paymentId;}
    public void setPaymentId(String paymentId) {this.paymentId = paymentId;}

    public double getAmount() {return amount;}
    public void setAmount(double amount) {this.amount = amount;}
}
