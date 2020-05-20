package sample;

import java.io.Serializable;

public class admin implements Serializable {
    private String login;
    private String password;
    private int id;
    private static final long serialVersionUID=9180844317717290831L;

    public admin(String login, String password, int id) {
        this.login = login;
        this.password = password;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public admin(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
