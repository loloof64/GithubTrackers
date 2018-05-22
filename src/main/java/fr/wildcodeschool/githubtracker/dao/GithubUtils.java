package fr.wildcodeschool.githubtracker.dao;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@Dependent
public class GithubUtils {

    @Inject
    private ObjectMapper objectMapper;

    public Githuber parseGithuber(String login){
        try {
            URL requestURL = new URL("https://api.github.com/users/"+login);
            return objectMapper.readValue(requestURL, Githuber.class);
        }
        catch (MalformedURLException ex) {
            ex.printStackTrace();
            return null;
        } catch (JsonParseException e) {
            e.printStackTrace();
            return null;
        } catch (JsonMappingException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
