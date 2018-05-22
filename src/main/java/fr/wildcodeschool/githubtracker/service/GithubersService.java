package fr.wildcodeschool.githubtracker.service;

import fr.wildcodeschool.githubtracker.dao.GithuberDAO;
import fr.wildcodeschool.githubtracker.dao.InMemory;
import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.util.List;

@Dependent
public class GithubersService {

    @Inject
    @InMemory
    private GithuberDAO githuberDAO;

    public List<Githuber> getAllGithubers(){
        return githuberDAO.getGithubers();
    }

    public Githuber getGithuber(String login){
        return githuberDAO.getGithubers().stream().
                filter(currentGithuber -> currentGithuber.getLogin().equals(login)).findFirst().get();
    }

    public void track(String login){
        // todo
    }

}
