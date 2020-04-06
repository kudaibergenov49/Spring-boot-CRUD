package ru.sber.prof.sberdata.testproject.user.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sber.prof.sberdata.testproject.user.user.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

  User findByName(String name);
  User findByEmail(String email);
}
