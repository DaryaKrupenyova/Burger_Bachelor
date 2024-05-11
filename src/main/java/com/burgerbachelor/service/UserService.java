package com.burgerbachelor.service;

import com.burgerbachelor.entity.Order;
import com.burgerbachelor.entity.User;
import com.burgerbachelor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService{
    @Autowired
    private UserRepository userRepository;
    public User getUserByName(String userName)
    {
        return userRepository.getUserByName(userName);
    }
    public void addOrder(Order order, String name){
        var user = getUserByName(name);
        user.getOrders().add(order);
        userRepository.save(user);
    }
}
