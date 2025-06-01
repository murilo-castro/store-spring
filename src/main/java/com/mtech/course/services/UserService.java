package com.mtech.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.mtech.course.entities.User;
import com.mtech.course.repositories.UserRepository;
import com.mtech.course.services.exceptions.DatabaseException;
import com.mtech.course.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	public UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(Long id) {
		Optional<User> user = userRepository.findById(id);

		return user.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public User insert(User user) {
		return userRepository.save(user);
	}
	
	public User update(Long id, User user) {
		User userEntity = userRepository.getReferenceById(id);
		updateData(userEntity, user);
		
		return userRepository.save(userEntity);
	}

	private void updateData(User userEntity, User user) {
		userEntity.setName(user.getName());
		userEntity.setEmail(user.getEmail());
		userEntity.setPhone(user.getPhone());
	}

	public void delete(Long id) {
		try {
			if (! userRepository.existsById(id)) {
				throw new ResourceNotFoundException(id);
			}			
				
			userRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
}
