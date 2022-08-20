package com.shangzheng.twitch.service;

import com.shangzheng.twitch.dao.RegisterDao;
import com.shangzheng.twitch.entity.db.User;
import com.shangzheng.twitch.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class RegisterService {

    @Autowired
    private RegisterDao registerDao;

    public boolean register(User user) throws IOException {
        user.setPassword(Util.encryptPassword(user.getUserId(), user.getPassword()));
        return registerDao.register(user);
    }
}

