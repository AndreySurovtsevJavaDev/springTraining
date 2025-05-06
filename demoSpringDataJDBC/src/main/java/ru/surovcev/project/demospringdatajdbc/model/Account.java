package ru.surovcev.project.demospringdatajdbc.model;

import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

public class Account {
    @Id
    private long id;

    private String ownerName;
    private BigDecimal amount;

    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    public String getOwnerName() {return ownerName;}
    public void setOwnerName(String ownerName) {this.ownerName = ownerName;}

    public BigDecimal getAmount() {return amount;}
    public void setAmount(BigDecimal amount) {this.amount = amount;}
}
