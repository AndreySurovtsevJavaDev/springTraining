package ru.surovcev.project.springboot.service.demoresthello.model;

public class Country {
    private String name;
    private int population;

    /**
     * Чтобы было проще, опредедлили для экземпляра Country статический метод генерации объекта, который принимает наименование
     * и количество жителей и возвращает экземпляр с указанными значениями
     * @return
     */
    public static Country of(String name, int population) {
        Country country = new Country();
        country.setName(name);
        country.setPopulation(population);
        return country;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public int getPopulation() {return population;}
    public void setPopulation(int population) {this.population = population;}
}
