package ru.surovcev.project.demotransaction.model;

import java.math.BigDecimal;

public class Account {
    private int id;
    private String owner_name;
    private BigDecimal amount;

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getName() {return owner_name;}
    public void setName(String owner_name) {this.owner_name = owner_name;}

    public BigDecimal getAmount() {return amount;}
    public void setAmount(BigDecimal amount) {this.amount = amount;}
}
