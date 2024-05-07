package web.dao;

import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(User user) {
        em.persist(user);
    }

    @Override
    public List<User> index() {
        return em.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void delete(long id) {
        em.remove(findById(id));
    }

    @Override
    public void update(User updatedUser) {
        em.merge(updatedUser);
    }

    @Override
    public User findById(long id) {
        return em.find(User.class, id);
    }
}
