package com.jpa.api.service;

import com.jpa.api.model.User;
import com.jpa.api.model.request.UserRequest;
import com.jpa.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class apiService {

    private final UserRepository userRepo;

    public User createUser(UserRequest request) {
        User user = User.builder()
                .userId(request.getUserId())
                .password(request.getUserId())
                .name(request.getName())
                .build();
        return userRepo.save(user);
    }

}
