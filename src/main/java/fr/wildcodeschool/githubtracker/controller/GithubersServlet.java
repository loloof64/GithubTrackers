package fr.wildcodeschool.githubtracker.controller;

import fr.wildcodeschool.githubtracker.service.GithubersService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/githubers"})
public class GithubersServlet extends HttpServlet {

    @Inject
    private GithubersService githubersService;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listOfGithubers", githubersService.getAllGithubers());
        req.getRequestDispatcher("/githubers.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listOfGithubers", githubersService.getAllGithubers());
        req.getRequestDispatcher("/githubers.jsp").forward(req, resp);
    }
}
