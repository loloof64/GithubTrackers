package fr.wildcodeschool.githubtracker.service;

import fr.wildcodeschool.githubtracker.dao.GithuberDAO;
import fr.wildcodeschool.githubtracker.model.Githuber;

import java.util.List;

public class GithubersService {

    private GithuberDAO githuberDAO;

    public GithubersService(GithuberDAO githuberDAO){
        this.githuberDAO = githuberDAO;
    }

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
