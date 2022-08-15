package com.kodilla.library.repository;

import com.kodilla.library.domain.Title;
import com.kodilla.library.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Override
    List<User> findAll();

    @Override
    User save(User user);

    @Override
    void deleteById(Long id);

}
