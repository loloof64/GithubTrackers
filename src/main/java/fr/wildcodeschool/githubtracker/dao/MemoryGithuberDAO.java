package fr.wildcodeschool.githubtracker.dao;

import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.util.*;

@Dependent
@InMemory
public class MemoryGithuberDAO implements GithuberDAO {

    private static final String localBase = "jdbc:mysql://localhost:3306/githubtracker";
    private static final String USER = "admin";
    private static final String PASS = "admin";

    private Map<String, Githuber> githubers = new HashMap<>();

    @Inject
    private GithubUtils githubUtils;

    @Override
    public List<Githuber> getGithubers() {
        return new ArrayList<>(githubers.values());
    }

    @Override
    public void saveGithuber(Githuber githuberToAdd) {
        githubers.put(githuberToAdd.getLogin(), githuberToAdd);
    }

    @PostConstruct
    private void initGithubers(){
        List<String> logins = new ArrayList<>();
        Collections.addAll(logins, "fiongogo", "loloof64", "fabmars", "kobanogit", "mbentejac");

        for (String currLogin : logins){
            Githuber currentGithuber = githubUtils.parseGithuber(currLogin);
            saveGithuber(currentGithuber);
        }
    }
}
