package project.example.entity;


// Глава 2
// ch.3 ex.1
// Создаём класс человек, экземпляры класса будут владельцами попугаев и / или воронов, созданных ранее.

public class Person {
    private String name;
    // т.к человек будет владеть попугаем добавляем этот объект атрибутом и делаем для него сеттер и геттер, чтобы работать с ним в конфиге
    private Parrot parrot;

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public Parrot getParrot() {return parrot;}
    // Далее, указан метод для прямого монтажа, который будет использоваться в конфиг-файле.
    public void setParrot(Parrot parrot) {this.parrot = parrot;}

    @Override
    public String toString() {
        return "Person" + name;
    }
}
