package ru.kutlubaev.boot.DAO;

import ru.kutlubaev.boot.entity.User;

import java.util.List;

public interface UserDAO {
    List<User> getAll();

    User getById(long id);

    void add(User user);

    void edit(User user);

    void delete(User user);
}
