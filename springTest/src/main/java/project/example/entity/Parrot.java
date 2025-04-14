package project.example.entity;

// Создаём класс, который далее мы собираем передавать Spring как @Bean (в качестве примера для первых упражнений)

public class Parrot {
    private String name;

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    @Override
    public String toString() {
        return name;
    }

}
