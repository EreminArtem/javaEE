package ru.eremin.enterprise.view;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import lombok.Getter;
import lombok.Setter;
import ru.eremin.enterprise.service.AuthService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;


@Getter
@Setter
@ViewScoped
@ManagedBean
@URLMapping(id = "auth-page", pattern = "/auth-page", viewId = "/WEB-INF/pages/admin/auth-page.xhtml")
public class LoginController {

    @Inject
    AuthService authService;

    private String login = "";
    private String password = "";

    public String auth() {
        final boolean check = authService.openSession(login,password);
        if(check) return "admin-home";
        return "auth-page";

    }
}
