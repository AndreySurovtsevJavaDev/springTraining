package main;

import org.springframework.stereotype.Component;

// Поставив перед классом аннотацию @Component мы указываем спрингу, где находятся
// классы со стереотипными аннотациями
@Component
public class Parrot {
    private String name;

    public String getName(){return name;}

    public void setName(String name){this.name = name;}
}

