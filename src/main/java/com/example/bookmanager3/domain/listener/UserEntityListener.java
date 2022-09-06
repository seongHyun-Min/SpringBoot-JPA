package com.example.bookmanager3.domain.listener;

import com.example.bookmanager3.domain.User;
import com.example.bookmanager3.domain.UserHistory;
import com.example.bookmanager3.repository.UserHistoryRepository;
import com.example.bookmanager3.support.BeanUtils;


import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class UserEntityListener {
    @PrePersist
    @PreUpdate
    public void prePersistAndPreUpdate(Object o) {
        UserHistoryRepository userHistoryRepository = BeanUtils.getBean(UserHistoryRepository.class);

        User user = (User) o;

        UserHistory userHistory = new UserHistory();
        userHistory.setUserId(user.getId());
        userHistory.setName(user.getName());
        userHistory.setEmail(user.getEmail());

        userHistoryRepository.save(userHistory);
    }
}