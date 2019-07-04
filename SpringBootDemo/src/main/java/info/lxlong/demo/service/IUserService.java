package info.lxlong.demo.service;

import info.lxlong.demo.domain.User;

import java.util.List;

public interface IUserService {

    /**
     * 新增
     * @param user
     * @return
     */
    public User save(User user);

    /**
     * Id获取
     * @param id
     * @return
     */
    public User getById(Long id);

    List<User> getAll();
}
