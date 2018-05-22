package fr.wildcodeschool.githubtracker.controller;

import fr.wildcodeschool.githubtracker.dao.MemoryGithuberDAO;
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
    private MemoryGithuberDAO memoryGithuberDAO;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        Githuber githuber = memoryGithuberDAO.parseGithuber(login);
        boolean githuberDefined = githuber != null;
        if (githuberDefined) {
            memoryGithuberDAO.saveGithuber(githuber);
            List<Githuber> githubers = memoryGithuberDAO.getGithubers();
            req.getSession().setAttribute("listOfGithubers", githubers);
            resp.sendRedirect("githubers.jsp");
        }
    }
}
