package fr.wildcodeschool.githubtracker.model;

public class Githuber {

    private final String name;
    private final String email;
    private final String login;
    private final int id;
    private final String avatarUrl;

    public Githuber(String name, String email, String login, int id, String avatarUrl) {
        this.name = name;
        this.email = email;
        this.login = login;
        this.id = id;
        this.avatarUrl = avatarUrl;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public int getId() {
        return id;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    @Override
    public String toString() {
        return "Githuber{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", id=" + id +
                ", avatarUrl='" + avatarUrl + '\'' +
                '}';
    }
}
