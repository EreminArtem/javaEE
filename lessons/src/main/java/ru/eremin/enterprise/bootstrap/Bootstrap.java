package ru.eremin.enterprise.bootstrap;

import ru.eremin.enterprise.service.UserService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Startup
@Singleton
public class Bootstrap {
    @Inject
    private UserService userService;

    @PostConstruct
    private void start() {
        userService.init("login", "pass", "email", 1);
    }
}
