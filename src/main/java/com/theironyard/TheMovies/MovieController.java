package com.theironyard.TheMovies;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class MovieController {


    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/medium_popular_long_name")
    public String mediumpopularlongname(Model model) {
        String movieUrl = "https://api.themoviedb.org/3/movie/now_playing?api_key=be2a38521a7859c95e2d73c48786e4bb";

        List<Movie> picky = getMovies((movieUrl));
        picky.stream()
                .filter(e -> e.popularity < 80 || e.popularity > 30)
                .filter(e -> e.title.length() > 10);

        model.addAttribute("movies", picky);
        return "medium_popular_long_name";
    }

    @RequestMapping("/now_playing")
    public String nowplaying(Model model) {
        String movieUrl = "https://api.themoviedb.org/3/movie/now_playing?api_key=be2a38521a7859c95e2d73c48786e4bb";

        List<Movie> results = getMovies((movieUrl));

        System.out.println( results == null ? "IT IS NULL!" : "IT's ALIVE!!!" );
        if (results != null) results.stream().forEach( m -> System.out.println(m.title));

        model.addAttribute("movies", results);
        return "now_playing";
    }

    public static List<Movie> getMovies(String route) {

        RestTemplate restTemplate = new RestTemplate();
        ResultsPage movieResult = restTemplate.getForObject(route, ResultsPage.class);
        return movieResult.results;
    }
}