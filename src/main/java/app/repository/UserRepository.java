package app.repository;

import app.domain.entity.User;

public interface UserRepository {

    void save(User user);

    User findByUsernameAndPassword(String username, String password);
}
