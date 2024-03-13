package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HomeControllerTest {


    @Test
    void testDoesGenreMatch() {
        // Given: A HomeController and a Movie object with a specific genre
        HomeController homeController = new HomeController();
        Movie comedyMovie = new Movie("Comedy Chaos", "", List.of(Movie.Genre.COMEDY));

        // When: Checking if the genre matches "COMEDY"
        boolean matchesComedy = homeController.doesGenreMatch(comedyMovie, "COMEDY");

        // Then: The result should be true as the genre matches
        assertTrue(matchesComedy, "The COMEDY genre should match.");

        // When: Checking if the genre matches "ACTION"
        boolean matchesAction = homeController.doesGenreMatch(comedyMovie, "ACTION");

        // Then: The result should be false as the genres do not match
        assertFalse(matchesAction, "The ACTION genre should not match.");

        // When: Checking if the genre matches "ALL"
        boolean matchesAll = homeController.doesGenreMatch(comedyMovie, "ALL");

        // Then: The result should be true as "ALL" should accept all genres
        assertTrue(matchesAll, "All genres should be accepted when 'ALL' is selected.");
    }
}

