package fr.wildcodeschool.githubtracker.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Githuber {


    private final String name;
    private final String email;
    private final String login;
    private final int id;
    private final String avatarUrl;

    @JsonCreator
    public Githuber(
            @JsonProperty("name")String name,
            @JsonProperty("email")String email,
            @JsonProperty("login")String login,
            @JsonProperty("id")int id,
            @JsonProperty("avatar_url")String avatarUrl) {
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
