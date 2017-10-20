package com.theironyard.TheMovies;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.ui.Model;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MovieController {
    final static String URL = "https://api.themoviedb.org/3/movie";
    final static String API_KEY = "api_key=be2a38521a7859c95e2d73c48786e4bb";

    final static String nowplayingUrl = URL + "/now_playing" + "?" + API_KEY;
    final static String allMoviesUrl = URL + "/popular" + "?" + API_KEY;

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/medium_popular_long_name")
    public String mediumpopularlongname(Model model) {
        List<Movie> results = getMovies(allMoviesUrl);
        results = results.stream()
                .filter(e -> e.popularity < 800 && e.popularity > 300)
                .filter(e -> e.title.length() > 10)
                .collect(Collectors.toList());

        model.addAttribute("pickys", results);
        return "medium_popular_long_name";
    }

    @RequestMapping("/now_playing")
    public String nowplaying(Model model) {
        List<Movie> results = getMovies(nowplayingUrl);
        model.addAttribute("movies", results);
        return "now_playing";
    }

    public static List<Movie> getMovies(String route) {

        RestTemplate restTemplate = new RestTemplate();
        ResultsPage movieResult = restTemplate.getForObject(route, ResultsPage.class);
        return movieResult.results;
    }

    @RequestMapping("/description/{id}")
    public String description(Model model, @PathVariable int id) {
        List<Movie> result = getMovies(allMoviesUrl);
        result = result.stream()
                .filter(e -> e.id == id)
                .collect(Collectors.toList());
        model.addAttribute("result", result);
        return "details";
    }
}

// .stream().foreach(create new local resource object & map fields & save to the record (which saves to the database))