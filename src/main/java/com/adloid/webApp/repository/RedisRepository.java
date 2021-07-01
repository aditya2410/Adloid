package com.adloid.webApp.repository;

import com.adloid.webApp.model.*;

public interface RedisRepository {

    /**
     * Add user pair to Redis.
     */
    void add(User user);
    
    /**
     * find a User
     */
    User findUser(String emailId);
    
}
