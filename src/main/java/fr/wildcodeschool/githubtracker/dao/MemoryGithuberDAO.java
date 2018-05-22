package fr.wildcodeschool.githubtracker.dao;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

@Dependent
public class MemoryGithuberDAO implements GithuberDAO {

    private Map<String, Githuber> githubers = new HashMap<>();

    @Inject
    private ObjectMapper objectMapper;

    @Override
    public List<Githuber> getGithubers() {
        return new ArrayList<>(githubers.values());
    }

    @Override
    public void saveGithuber(Githuber githuberToAdd) {
        githubers.put(githuberToAdd.getLogin(), githuberToAdd);
    }

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

    @PostConstruct
    private void initGithubers(){
        List<String> logins = new ArrayList<>();
        Collections.addAll(logins, "loloof64", "sebaurel", "fabmars", "kobanogit", "mbentejac");

        for (String currLogin : logins){
            Githuber currentGithuber = parseGithuber(currLogin);
            saveGithuber(currentGithuber);
        }
    }
}
