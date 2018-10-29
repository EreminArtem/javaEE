package ru.eremin.enterprise.service;

import lombok.NonNull;
import ru.eremin.enterprise.enity.User;
import ru.eremin.enterprise.repository.UserRepository;
import ru.eremin.enterprise.utilities.Utilities;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class UserService {

    @Inject
    UserRepository repository;

    public void init(@NonNull final String login,
                     @NonNull final String password,
                     @NonNull final String email,
                     @NonNull final int permissionLevel) {
        if (repository.isEmailUnique(email)) return;
        if (repository.isLoginUnique(email)) return;
        create(login, password, email, permissionLevel);
    }

    private void create(final String login, final String password, final String email, final int permissionLevel) {
        if (login == null || login.isEmpty()) return;
        if (email == null || email.isEmpty()) return;
        if (password == null || password.isEmpty()) return;
        if (permissionLevel < 0) return;

        final User user = new User();
        user.setLogin(login);
        user.setHashPassword(Utilities.getHash(password));
        user.setEmail(email);
        user.setPermissionLevel(permissionLevel);
        repository.persist(user);
    }

    public boolean checkAuth(final String login, final String password) {
        if (login == null || login.isEmpty()) return false;
        if (password == null || password.isEmpty()) return false;
        final User user = repository.getUserByLogin(login);
        if(user == null) return false;
        final String hashPassword = Utilities.getHash(password);
        return hashPassword.equals(user.getHashPassword());
    }

    public User getUserByLogin(final String login){
        return repository.getUserByLogin(login);
    }
}
