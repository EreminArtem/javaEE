package ru.eremin.enterprise.service;

import com.sun.deploy.net.HttpRequest;
import ru.eremin.enterprise.Constants;
import ru.eremin.enterprise.enity.User;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.auth.message.AuthException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Named
@RequestScoped
public class AuthService {

    @Inject
    private HttpServletRequest request;

    @Inject
    private UserService service;

    public boolean openSession(final String login, final String password) {
        final boolean check = service.checkAuth(login, password);
        if (!check) return false;
        final User user = service.getUserByLogin(login);
        if (user == null) return false;
        final HttpSession session = request.getSession();
        session.setAttribute(Constants.USER_ID, user.getId());
        session.setAttribute(Constants.LOGIN, user.getLogin());
        session.setAttribute(Constants.PERMISSION_LEVEL, user.getPermissionLevel());
        return true;
    }

    public void closeSession() {
        request.getSession().invalidate();
    }

    public String getUserLogin() throws AuthException {
        final HttpSession session = request.getSession();
        if (session == null) throw new AuthException();
        final Object value = session.getAttribute(Constants.LOGIN);
        if (value == null) throw new AuthException();
        return (String) value;
    }

    public String getUserId() throws AuthException {
        final HttpSession session = request.getSession();
        if (session == null) throw new AuthException();
        final Object value = session.getAttribute(Constants.USER_ID);
        if (value == null) throw new AuthException();
        return (String) value;
    }

    public int getUserPermissionLevel() throws AuthException {
        final HttpSession session = request.getSession();
        if (session == null) throw new AuthException();
        final Object value = session.getAttribute(Constants.PERMISSION_LEVEL);
        if (value == null) throw new AuthException();
        return (int) value;
    }

    public boolean isAuth(final HttpSession session) {
        if (session == null) return false;
        final boolean hasLogin = session.getAttribute(Constants.LOGIN) != null;
        final boolean hasId = session.getAttribute(Constants.USER_ID) != null;
        final boolean hasPermissionLevel = session.getAttribute(Constants.PERMISSION_LEVEL) != null;
        return hasLogin && hasId && hasPermissionLevel;
    }

    public boolean isAuth(){
        final HttpSession session = request.getSession();
        return isAuth(session);
    }

}
