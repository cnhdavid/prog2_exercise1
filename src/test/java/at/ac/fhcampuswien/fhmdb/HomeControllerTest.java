package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class HomeControllerTest {


    @Test
    void test_Filter_Movies_By_Comedy_Genre() {
        // Given
        HomeController homeController = new HomeController();
        homeController.allMovies = Movie.initializeMovies();

        List<String> expectedComedyTitles = List.of("Comedy Chaos");

        // When
        List<Movie> filteredMovies = homeController.filterMoviesByGenre(Movie.Genre.COMEDY);

        // Then
        assertFalse(filteredMovies.isEmpty());

        List<String> filteredMovieTitles = filteredMovies.stream()
                .map(Movie::getTitle)
                .collect(Collectors.toList());
        assertTrue(filteredMovieTitles.containsAll(expectedComedyTitles) && expectedComedyTitles.containsAll(filteredMovieTitles));
    }

    @Test
    void test_Filter_Movies_By_Adventure_Genre() {
        // Given
        HomeController homeController = new HomeController();
        homeController.allMovies = Movie.initializeMovies();

        List<String> expectedComedyTitles = List.of("The Adventure Quest","Sci-Fi Odyssey");

        // When
        List<Movie> filteredMovies = homeController.filterMoviesByGenre(Movie.Genre.ADVENTURE);

        // Then
        assertFalse(filteredMovies.isEmpty());

        List<String> filteredMovieTitles = filteredMovies.stream()
                .map(Movie::getTitle)
                .collect(Collectors.toList());
        assertTrue(filteredMovieTitles.containsAll(expectedComedyTitles) && expectedComedyTitles.containsAll(filteredMovieTitles));
    }
    @Test
    void test_Filter_Movies_By_Fantasy_Genre() {
        // Given
        HomeController homeController = new HomeController();
        homeController.allMovies = Movie.initializeMovies();

        List<String> expectedComedyTitles = List.of("The Adventure Quest");

        // When
        List<Movie> filteredMovies = homeController.filterMoviesByGenre(Movie.Genre.FANTASY);

        // Then
        assertFalse(filteredMovies.isEmpty());

        List<String> filteredMovieTitles = filteredMovies.stream()
                .map(Movie::getTitle)
                .collect(Collectors.toList());
        assertTrue(filteredMovieTitles.containsAll(expectedComedyTitles) && expectedComedyTitles.containsAll(filteredMovieTitles));
    }

    @Test
    public void test_Initialize_Movies() {
        // Given
        List<Movie> movies = Movie.initializeMovies();

        // When
        assertNotNull(movies);
        assertFalse(movies.isEmpty());

        // Then
        for (Movie movie : movies) {
            assertNotNull(movie.getTitle());
            assertNotNull(movie.getDescription());
            assertNotNull(movie.getGenres());
            assertFalse(movie.getGenres().isEmpty());
        }
    }

    //Test to check if Movies get sorted as expected in ascending Order
    @Test
    void testSortMoviesAscending() {
        // Given
        List<Movie> unsortedMovies = Arrays.asList(
                new Movie("Title A", "Description A"),
                new Movie("Title C", "Description C"),
                new Movie("Title B", "Description B")
        );

        // When
        HomeController controller = new HomeController();
        controller.sortMoviesAscending(unsortedMovies);

        // Then
        List<Movie> expectedMovies = Arrays.asList(
                new Movie("Title A", "Description A"),
                new Movie("Title B", "Description B"),
                new Movie("Title C", "Description C")
        );

        for (int i = 0; i < expectedMovies.size(); i++) {
            assertEquals(expectedMovies.get(i).getTitle(), unsortedMovies.get(i).getTitle());
            assertEquals(expectedMovies.get(i).getDescription(), unsortedMovies.get(i).getDescription());
        }
    }

    //Test to check if Movies get sorted as expected in descending Order
    @Test
    void testSortMoviesDescending() {
        // Given
        List<Movie> unsortedMovies = Arrays.asList(
                new Movie("Title A", "Description A"),
                new Movie("Title C", "Description C"),
                new Movie("Title B", "Description B")
        );

        // When
        HomeController controller = new HomeController();
        controller.sortMoviesDescending(unsortedMovies);

        // Then
        List<Movie> expectedMovies = Arrays.asList(
                new Movie("Title C", "Description C"),
                new Movie("Title B", "Description B"),
                new Movie("Title A", "Description A")
        );

        // Compare each movie individually
        for (int i = 0; i < expectedMovies.size(); i++) {
            assertEquals(expectedMovies.get(i).getTitle(), unsortedMovies.get(i).getTitle());
            assertEquals(expectedMovies.get(i).getDescription(), unsortedMovies.get(i).getDescription());
        }
    }

}









