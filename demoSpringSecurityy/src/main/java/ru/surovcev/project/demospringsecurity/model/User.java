package ru.surovcev.project.demospringsecurity.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor // обязателен для JPA
public class User {
    @Id
    private long id;

    @Column(name = "first_name")
    private String firstname;


    @Column(name = "last_name")
    private String lastname;
}
