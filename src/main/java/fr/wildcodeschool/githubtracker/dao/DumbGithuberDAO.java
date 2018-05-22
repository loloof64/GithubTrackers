package fr.wildcodeschool.githubtracker.dao;

import fr.wildcodeschool.githubtracker.model.Githuber;

import java.util.Arrays;
import java.util.List;

public class DumbGithuberDAO implements GithuberDAO {

    @Override
    public List<Githuber> getGithubers() {
        return Arrays.asList(
                new Githuber("Tartempion L.", "crazy.wilder@wildschool.com", "CrazyWilder", 1, "http://smartility.fr/wp-content/uploads/2017/02/avatar-maker-595x549.jpg"),
                new Githuber("Dupond W.", "dupond.lasagne@wildschool.com", "FastBooter", 2, "https://openclipart.org/image/2400px/svg_to_png/215868/Awesome-Tux.png"),
                new Githuber("Oruma W.", "oruma.wilfried@wildschool.com","Goleador", 3, "https://cdn.pixabay.com/photo/2016/08/20/05/38/avatar-1606916_960_720.png"),
                new Githuber("ChevalHaie M.", "mie.chelle.cheval@haie.com", "Scientist", 4, "http://www.web-soluces.net/webmaster/avatar/AnimeFaceMaker-Femme.png"),
                new Githuber("WasHuntMe Guillaume", "was.me@lying.com", "Liar", 5, "http://www.web-soluces.net/webmaster/avatar/AvatarsMakersFactory-Fille.png")

        );
    }
}
