package ru.surovcev.project.demospringsecurity.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.surovcev.project.demospringsecurity.model.User;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query(value = "SELECT * FROM users", nativeQuery = true)
    List<User> findAll();


    User findById(long id);
}
