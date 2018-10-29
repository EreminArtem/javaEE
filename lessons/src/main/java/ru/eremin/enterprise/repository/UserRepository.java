package ru.eremin.enterprise.repository;


import ru.eremin.enterprise.enity.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UserRepository {

    @PersistenceContext
    EntityManager em;

    public User persist(User user) {
        if (user == null) return null;
        em.persist(user);
        return user;
    }

    public User getUserByLogin(final String login) {
        if (login == null || login.isEmpty()) return null;
        return em.find(User.class, login);
    }

    public User getUserById(final String id) {
        if (id == null || id.isEmpty()) return null;
        return em.find(User.class, id);
    }

    public boolean isLoginUnique(final String login) {
        if (login == null || login.isEmpty()) return false;
        return em.createQuery("SELECT COUNT(e.id) FROM User e WHERE e.login = :login", Long.class)
                .setParameter("login", login).setMaxResults(1)
                .getSingleResult()
                .equals(0L);
    }

    public boolean isEmailUnique(final String email) {
        if (email == null || email.isEmpty()) return false;
        return em.createQuery("SELECT COUNT(e.email) FROM User e WHERE e.email = :email", Long.class)
                .setParameter("email", email).setMaxResults(1)
                .getSingleResult()
                .equals(0L);
    }

    public int getPermissionLevelById(final String id) {
        if (id == null || id.isEmpty()) return -1;
        final User user = em.createQuery("SELECT e FROM User e WHERE e.id = :id", User.class)
                .setParameter("id", id)
                .setMaxResults(1)
                .getSingleResult();
        return user.getPermissionLevel();
    }

    public int getPermissionLevelByLogin(final String login) {
        if (login == null || login.isEmpty()) return -1;
        final User user = em.createQuery("SELECT e FROM User e WHERE e.login = :login", User.class)
                .setParameter("login", login)
                .setMaxResults(1)
                .getSingleResult();
        return user.getPermissionLevel();
    }
}
