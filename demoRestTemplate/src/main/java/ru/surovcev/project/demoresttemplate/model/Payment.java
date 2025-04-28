package ru.surovcev.project.demoresttemplate.model;

/**
 * POJO класс, экземпляров платежа
 *
 */
public class Payment {
    private String id;
    private int amount;

    public void setId(String id) {this.id = id;}
    public void setAmount(int amount) {this.amount = amount;}
    public String getId() {return id;}
    public int getAmount() {return amount;}
}
