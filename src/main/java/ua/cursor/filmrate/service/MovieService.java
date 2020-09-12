package ua.cursor.filmrate.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.cursor.filmrate.dto.MovieDTO;
import ua.cursor.filmrate.dto.ReviewDTO;
import ua.cursor.filmrate.dto.base.MovieBaseDTO;
import ua.cursor.filmrate.entity.Movie;
import ua.cursor.filmrate.entity.Rate;
import ua.cursor.filmrate.repository.MovieRepository;
import ua.cursor.filmrate.repository.ReviewRepository;
import ua.cursor.filmrate.service.mapper.MovieMapper;
import ua.cursor.filmrate.service.mapper.ReviewMapper;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final ReviewRepository reviewRepository;
    private final MovieMapper movieMapper;
    private final ReviewMapper reviewMapper;

    public List<MovieBaseDTO> getAllMovies() {
        return movieMapper.toMovieBaseDTOs(movieRepository.findAll());
    }

    public List<MovieBaseDTO> getAllMoviesSortedByRating() {
        return movieMapper.toMovieBaseDTOs(
                movieRepository.findAll().stream()
                        .sorted(Comparator.comparing((Movie movie) -> movie.getRate().getRateValue()).reversed())
                        .collect(Collectors.toList())
        );
    }

    public MovieDTO getMovieByIdWithReviews(long id) {
        Movie movie = movieRepository.getByIdWithReviews(id);
        System.out.println("FROM SERVICE BEFORE MAPPER " + movie.toString());
        return movieMapper.toMovieDTO(movie);
    }

    public void save(Movie movie) {
        movieRepository.save(movie);
    }

    public void saveReview(ReviewDTO reviewDTO) {
        System.out.println(reviewDTO.toString());
        reviewRepository.save(reviewMapper.toReviewEntityFromDTO(reviewDTO));
    }

    public void delete(long id) {
        movieRepository.deleteById(id);
    }

    public void addRate(Long movieId, Double rateValue) {
        Movie movie = movieRepository.getById(movieId);
        Rate rate = movie.getRate();
        System.out.println("Rate Value " + rateValue);
        Double rateFromDB = rate.getRateValue() == null ? 0 : rate.getRateValue();
        System.out.println("Rate from DB " + rateFromDB);
        Long votesCount = rate.getVotesCount() == null ? 0 : rate.getVotesCount();
        System.out.println("Votes Count " + votesCount);
        Double tmpRate = rateFromDB * votesCount++ + rateValue;
        System.out.println("TMP RATE " + tmpRate);
        tmpRate /= votesCount;
        System.out.println("Saved TmpRate " + tmpRate);
        rate.setRateValue(tmpRate);
        rate.setVotesCount(votesCount);
        movieRepository.save(movie);
    }

}

