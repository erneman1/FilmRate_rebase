package ua.cursor.filmrate.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.cursor.filmrate.entity.Category;
import ua.cursor.filmrate.entity.Movie;
import ua.cursor.filmrate.entity.Rate;
import ua.cursor.filmrate.entity.Review;
import ua.cursor.filmrate.repository.MovieRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public List<Movie> getAllMoviesSortedByRating() {
        return movieRepository.findAll().stream()
                .sorted(Comparator.comparing((Movie movie) -> movie.getRate().getRateValue()).reversed())
                .collect(Collectors.toList());
    }

    public Movie getMovieByIdWithReviews(long id) {
        return movieRepository.getByIdWithReviews(id);
    }

    public List<Movie> getAllByCategoriesContains(List<Category> categories) {
        return movieRepository.getAllByCategoriesContains(categories);
    }

    public void save(Movie movie) {
        movieRepository.save(movie);
    }

    public void delete(long id) {
        movieRepository.deleteById(id);
    }

    public void addReview(Long movieId, Review review) {
        Movie movie = movieRepository.getByIdWithReviews(movieId);
        movie.getReviews().add(review);
        save(movie);
    }

    public void addRate(Long movieId, Double rateValue) {
        Movie movie = movieRepository.getById(movieId);
        Rate rate = movie.getRate();
        Double rateFromDB = rate.getRateValue() != null ? rate.getRateValue() : 0;
        Long votesCount = rate.getVotesCount() != null ? rate.getVotesCount() : 0;
        Double tmpRate = rateFromDB * votesCount++ + rateValue;
        tmpRate /= votesCount;
        rate.setRateValue(tmpRate);
        rate.setVotesCount(votesCount);
        movieRepository.save(movie);
    }
}
