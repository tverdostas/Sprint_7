package ru.practicum;

public class Credentials {

    private String login;
    private String password;

    public Credentials(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Credentials() {
    }

    public static Credentials from(Courier courier) {
        Credentials cred = new Credentials();
        cred.setLogin(courier.getLogin());
        cred.setPassword(courier.getPassword());

        return cred;
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
}
