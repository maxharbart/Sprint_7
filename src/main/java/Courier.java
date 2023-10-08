package org.example;

public class Courier {
    private String login;
    private String password;
    private String name;

    public Courier(String login, String password, String firstName) {
        this.login = login;
        this.password = password;
        this.name = firstName;
    }

    public Courier() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}