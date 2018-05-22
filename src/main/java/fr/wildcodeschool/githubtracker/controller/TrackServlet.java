package fr.wildcodeschool.githubtracker.controller;

import fr.wildcodeschool.githubtracker.dao.GithubUtils;
import fr.wildcodeschool.githubtracker.dao.GithuberDAO;
import fr.wildcodeschool.githubtracker.dao.InMemory;
import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/track"})
public class TrackServlet extends HttpServlet {

    @Inject
    @InMemory
    private GithuberDAO githuberDAO;

    @Inject
    private GithubUtils githubUtils;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        Githuber githuber = githubUtils.parseGithuber(login);
        boolean githuberDefined = githuber != null;
        if (githuberDefined) {
            githuberDAO.saveGithuber(githuber);
            List<Githuber> githubers = githuberDAO.getGithubers();
            req.getSession().setAttribute("listOfGithubers", githubers);
            resp.sendRedirect("githubers.jsp");
        }
    }
}
