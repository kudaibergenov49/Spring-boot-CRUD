package ru.sber.prof.sberdata.testproject.user.user.service.impl;

import org.springframework.stereotype.Service;
import ru.sber.prof.sberdata.testproject.user.user.model.User;
import ru.sber.prof.sberdata.testproject.user.user.repository.UserRepository;
import ru.sber.prof.sberdata.testproject.user.user.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public User findById(Long id) {
    return userRepository.getOne(id);
  }

  @Override
  public User findByName(String name) {
    return userRepository.findByName(name);
  }

  @Override
  public User findByEmail(String email) {
    return userRepository.findByEmail(email);
  }

  @Override
  public List<User> findAll() {
    return userRepository.findAll();
  }

  @Override
  public void save(User user) {
    userRepository.save(user);
  }

  @Override
  public void deleteById(Long id) {
    userRepository.deleteById(id);
  }
}
