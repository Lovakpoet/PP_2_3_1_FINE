package web.dao;

import web.model.User;
import java.util.List;

public interface UserDao {

    void save(User user);

    List<User> index();

    void delete(long id);

    void update(User updatedUser);

    User findById(long id);
}