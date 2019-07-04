package info.lxlong.demo.service.impl;

import info.lxlong.demo.dao.IUserDao;
import info.lxlong.demo.domain.User;
import info.lxlong.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServcie implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public User save(User user) {
       return userDao.save(user);
    }

    @Override
    public User getById(Long id) {
        return userDao.getOne(id);
    }

    @Override
    public List<User> getAll() {
        return userDao.findAll();
    }
}
