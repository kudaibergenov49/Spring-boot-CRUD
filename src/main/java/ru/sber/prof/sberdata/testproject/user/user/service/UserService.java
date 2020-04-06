package ru.sber.prof.sberdata.testproject.user.user.service;

import ru.sber.prof.sberdata.testproject.user.user.model.User;

import java.util.List;

public interface UserService {

  User findById(Long id);
  User findByName(String name);
  User findByEmail(String email);
  List<User> findAll();
  void save(User user);
  void deleteById(Long id);
}
