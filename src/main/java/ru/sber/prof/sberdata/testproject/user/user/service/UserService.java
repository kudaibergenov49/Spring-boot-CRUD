package ru.sber.prof.sberdata.testproject.user.user.service;

import org.springframework.stereotype.Service;
import ru.sber.prof.sberdata.testproject.user.user.model.User;
import ru.sber.prof.sberdata.testproject.user.user.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User findById(Long id){
		return userRepository.getOne(id);
	}

	public User findByName(String name) {
		return userRepository.findByName(name);
	}

	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public List<User> findAll(){
		return userRepository.findAll();
	}

	public void save(User user){
		userRepository.save(user);
	}

	public void deleteById(Long id){
		userRepository.deleteById(id);
	}
}