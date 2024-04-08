package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class HomeControllerTest {



/*

    // TestsCase for correct Genre
    @Test
    void test_Filter_Movies_By_Comedy_Genre() {
        // Given
        HomeController homeController = new HomeController();
        homeController.allMovies = Movie.initializeMovies();

        List<String> expectedComedyTitles = List.of("Comedy Chaos","Laugh Therapy","Bleachers of Glory");

        // When
        List<Movie> filteredMovies = homeController.filterMoviesByGenre(Genre.MovieGenre.COMEDY);

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

        List<String> expectedAdventureTitles = List.of("The Adventure Quest","Sci-Fi Odyssey");

        // When
        List<Movie> filteredMovies = homeController.filterMoviesByGenre(Genre.MovieGenre.ADVENTURE);

        // Then
        assertFalse(filteredMovies.isEmpty());

        List<String> filteredMovieTitles = filteredMovies.stream()
                .map(Movie::getTitle)
                .collect(Collectors.toList());
        assertTrue(filteredMovieTitles.containsAll(expectedAdventureTitles) && expectedAdventureTitles.containsAll(filteredMovieTitles));
    }
    @Test
    void test_Filter_Movies_By_Fantasy_Genre() {
        // Given
        HomeController homeController = new HomeController();
        homeController.allMovies = Movie.initializeMovies();

        List<String> expectedFantasyTitles = List.of("The Adventure Quest","Elysium Odyssey");

        // When
        List<Movie> filteredMovies = homeController.filterMoviesByGenre(Genre.MovieGenre.FANTASY);

        // Then
        assertFalse(filteredMovies.isEmpty());

        List<String> filteredMovieTitles = filteredMovies.stream()
                .map(Movie::getTitle)
                .collect(Collectors.toList());
        assertTrue(filteredMovieTitles.containsAll(expectedFantasyTitles) && expectedFantasyTitles.containsAll(filteredMovieTitles));
    }

    @Test
    void test_Filter_Movies_By_Romance_Genre() {
        // Given
        HomeController homeController = new HomeController();
        homeController.allMovies = Movie.initializeMovies();

        List<String> expectedRomanceTitles = List.of("Titanic","Comedy Chaos");

        // When
        List<Movie> filteredMovies = homeController.filterMoviesByGenre(Genre.MovieGenre.ROMANCE);

        // Then
        assertFalse(filteredMovies.isEmpty());

        List<String> filteredMovieTitles = filteredMovies.stream()
                .map(Movie::getTitle)
                .collect(Collectors.toList());
        assertTrue(filteredMovieTitles.containsAll(expectedRomanceTitles) && expectedRomanceTitles.containsAll(filteredMovieTitles));
    }
    @Test
    void test_Filter_Movies_By_Mystery_Genre() {
        // Given
        HomeController homeController = new HomeController();
        homeController.allMovies = Movie.initializeMovies();

        List<String> expectedMysteryTitles = List.of("Mystery Mansion","Frontier Enigma");

        // When
        List<Movie> filteredMovies = homeController.filterMoviesByGenre(Genre.MovieGenre.MYSTERY);

        // Then
        assertFalse(filteredMovies.isEmpty());

        List<String> filteredMovieTitles = filteredMovies.stream()
                .map(Movie::getTitle)
                .collect(Collectors.toList());
        assertTrue(filteredMovieTitles.containsAll(expectedMysteryTitles) && expectedMysteryTitles.containsAll(filteredMovieTitles));
    }
    @Test
    void test_Filter_Movies_By_SCIENCE_FICTION_Genre() {
        // Given
        HomeController homeController = new HomeController();
        homeController.allMovies = Movie.initializeMovies();

        List<String> expectedScienceFictionTitles = List.of("Sci-Fi Odyssey","Starstream Chronicles");

        // When
        List<Movie> filteredMovies = homeController.filterMoviesByGenre(Genre.MovieGenre.SCIENCE_FICTION);

        // Then
        assertFalse(filteredMovies.isEmpty());

        List<String> filteredMovieTitles = filteredMovies.stream()
                .map(Movie::getTitle)
                .collect(Collectors.toList());
        assertTrue(filteredMovieTitles.containsAll(expectedScienceFictionTitles) && expectedScienceFictionTitles.containsAll(filteredMovieTitles));
    }
    @Test
    void test_Filter_Movies_By_War_Genre() {
        // Given
        HomeController homeController = new HomeController();
        homeController.allMovies = Movie.initializeMovies();

        List<String> expectedWarTitles = List.of("Thunderstrike","No Man's Land of Nightmares","Bunker 13");

        // When
        List<Movie> filteredMovies = homeController.filterMoviesByGenre(Genre.MovieGenre.WAR);

        // Then
        assertFalse(filteredMovies.isEmpty());

        List<String> filteredMovieTitles = filteredMovies.stream()
                .map(Movie::getTitle)
                .collect(Collectors.toList());
        assertTrue(filteredMovieTitles.containsAll(expectedWarTitles) && expectedWarTitles.containsAll(filteredMovieTitles));
    }
    @Test
    void test_Filter_Movies_By_Musical_Genre() {
        // Given
        HomeController homeController = new HomeController();
        homeController.allMovies = Movie.initializeMovies();

        List<String> expectedMusicalTitles = List.of("Starlight Serenade","Melody Meadows");

        // When
        List<Movie> filteredMovies = homeController.filterMoviesByGenre(Genre.MovieGenre.MUSICAL);

        // Then
        assertFalse(filteredMovies.isEmpty());

        List<String> filteredMovieTitles = filteredMovies.stream()
                .map(Movie::getTitle)
                .collect(Collectors.toList());
        assertTrue(filteredMovieTitles.containsAll(expectedMusicalTitles) && expectedMusicalTitles.containsAll(filteredMovieTitles));
    }
    @Test
    void test_Filter_Movies_By_Family_Genre() {
        // Given
        HomeController homeController = new HomeController();
        homeController.allMovies = Movie.initializeMovies();

        List<String> expectedFamilyTitles = List.of("Starlight Serenade","Melody Meadows");

        // When
        List<Movie> filteredMovies = homeController.filterMoviesByGenre(Genre.MovieGenre.FAMILY);

        // Then
        assertFalse(filteredMovies.isEmpty());

        List<String> filteredMovieTitles = filteredMovies.stream()
                .map(Movie::getTitle)
                .collect(Collectors.toList());
        assertTrue(filteredMovieTitles.containsAll(expectedFamilyTitles) && expectedFamilyTitles.containsAll(filteredMovieTitles));
    }
    @Test
    void test_Filter_Movies_By_Thriller_Genre() {
        // Given
        HomeController homeController = new HomeController();
        homeController.allMovies = Movie.initializeMovies();

        List<String> expectedThrillerTitles = List.of("Mystery Mansion","Inferno Protocol");

        // When
        List<Movie> filteredMovies = homeController.filterMoviesByGenre(Genre.MovieGenre.THRILLER);

        // Then
        assertFalse(filteredMovies.isEmpty());

        List<String> filteredMovieTitles = filteredMovies.stream()
                .map(Movie::getTitle)
                .collect(Collectors.toList());
        assertTrue(filteredMovieTitles.containsAll(expectedThrillerTitles) && expectedThrillerTitles.containsAll(filteredMovieTitles));
    }
    @Test
    void test_Filter_Movies_By_Horror_Genre() {
        // Given
        HomeController homeController = new HomeController();
        homeController.allMovies = Movie.initializeMovies();

        List<String> expectedHorrorTitles = List.of("Bunker 13","No Man's Land of Nightmares");

        // When
        List<Movie> filteredMovies = homeController.filterMoviesByGenre(Genre.MovieGenre.HORROR);

        // Then
        assertFalse(filteredMovies.isEmpty());

        List<String> filteredMovieTitles = filteredMovies.stream()
                .map(Movie::getTitle)
                .collect(Collectors.toList());
        assertTrue(filteredMovieTitles.containsAll(expectedHorrorTitles) && expectedHorrorTitles.containsAll(filteredMovieTitles));
    }
    @Test
    void test_Filter_Movies_By_Documentary_Genre() {
        // Given
        HomeController homeController = new HomeController();
        homeController.allMovies = Movie.initializeMovies();

        List<String> expectedDocumentaryTitles = List.of("Uncharted Horizons: The Elon Musk Story","Rhythms of Resilience");

        // When
        List<Movie> filteredMovies = homeController.filterMoviesByGenre(Genre.MovieGenre.DOCUMENTARY);

        // Then
        assertFalse(filteredMovies.isEmpty());

        List<String> filteredMovieTitles = filteredMovies.stream()
                .map(Movie::getTitle)
                .collect(Collectors.toList());
        assertTrue(filteredMovieTitles.containsAll(expectedDocumentaryTitles) && expectedDocumentaryTitles.containsAll(filteredMovieTitles));
    }
    @Test
    void test_Filter_Movies_By_Biography_Genre() {
        // Given
        HomeController homeController = new HomeController();
        homeController.allMovies = Movie.initializeMovies();

        List<String> expectedBiographyTitles = List.of("Uncharted Horizons: The Elon Musk Story","The Wolf of Wall Street");

        // When
        List<Movie> filteredMovies = homeController.filterMoviesByGenre(Genre.MovieGenre.BIOGRAPHY);

        // Then
        assertFalse(filteredMovies.isEmpty());

        List<String> filteredMovieTitles = filteredMovies.stream()
                .map(Movie::getTitle)
                .collect(Collectors.toList());
        assertTrue(filteredMovieTitles.containsAll(expectedBiographyTitles) && expectedBiographyTitles.containsAll(filteredMovieTitles));
    }
    @Test
    void test_Filter_Movies_By_Drama_Genre() {
        // Given
        HomeController homeController = new HomeController();
        homeController.allMovies = Movie.initializeMovies();

        List<String> expectedDramaTitles = List.of("The Wolf of Wall Street","Titanic","Rhythms of Resilience","Racing Against Fate");

        // When
        List<Movie> filteredMovies = homeController.filterMoviesByGenre(Genre.MovieGenre.DRAMA);

        // Then
        assertFalse(filteredMovies.isEmpty());

        List<String> filteredMovieTitles = filteredMovies.stream()
                .map(Movie::getTitle)
                .collect(Collectors.toList());
        assertTrue(filteredMovieTitles.containsAll(expectedDramaTitles) && expectedDramaTitles.containsAll(filteredMovieTitles));
    }
    @Test
    void test_Filter_Movies_By_Western_Genre() {
        // Given
        HomeController homeController = new HomeController();
        homeController.allMovies = Movie.initializeMovies();

        List<String> expectedWesternTitles = List.of("Dusty Trails","Shadows of Deceit");

        // When
        List<Movie> filteredMovies = homeController.filterMoviesByGenre(Genre.MovieGenre.WESTERN);

        // Then
        assertFalse(filteredMovies.isEmpty());

        List<String> filteredMovieTitles = filteredMovies.stream()
                .map(Movie::getTitle)
                .collect(Collectors.toList());
        assertTrue(filteredMovieTitles.containsAll(expectedWesternTitles) && expectedWesternTitles.containsAll(filteredMovieTitles));
    }
    @Test
    void test_Filter_Movies_By_Sport_Genre() {
        // Given
        HomeController homeController = new HomeController();
        homeController.allMovies = Movie.initializeMovies();

        List<String> expectedSportTitles = List.of("Racing Against Fate","Bleachers of Glory");

        // When
        List<Movie> filteredMovies = homeController.filterMoviesByGenre(Genre.MovieGenre.SPORT);

        // Then
        assertFalse(filteredMovies.isEmpty());

        List<String> filteredMovieTitles = filteredMovies.stream()
                .map(Movie::getTitle)
                .collect(Collectors.toList());
        assertTrue(filteredMovieTitles.containsAll(expectedSportTitles) && expectedSportTitles.containsAll(filteredMovieTitles));
    }
    @Test
    void test_Filter_Movies_By_Crime_Genre() {
        // Given
        HomeController homeController = new HomeController();
        homeController.allMovies = Movie.initializeMovies();

        List<String> expectedCrimeTitles = List.of("Frontier Enigma","Shadows of Deceit");

        // When
        List<Movie> filteredMovies = homeController.filterMoviesByGenre(Genre.MovieGenre.CRIME);

        // Then
        assertFalse(filteredMovies.isEmpty());

        List<String> filteredMovieTitles = filteredMovies.stream()
                .map(Movie::getTitle)
                .collect(Collectors.toList());
        assertTrue(filteredMovieTitles.containsAll(expectedCrimeTitles) && expectedCrimeTitles.containsAll(filteredMovieTitles));
    }
    @Test
    void test_Filter_Movies_By_Animation_Genre() {
        // Given
        HomeController homeController = new HomeController();
        homeController.allMovies = Movie.initializeMovies();

        List<String> expectedAnimationTitles = List.of("Elysium Odyssey","Starstream Chronicles");

        // When
        List<Movie> filteredMovies = homeController.filterMoviesByGenre(Genre.MovieGenre.ANIMATION);

        // Then
        assertFalse(filteredMovies.isEmpty());

        List<String> filteredMovieTitles = filteredMovies.stream()
                .map(Movie::getTitle)
                .collect(Collectors.toList());
        assertTrue(filteredMovieTitles.containsAll(expectedAnimationTitles) && expectedAnimationTitles.containsAll(filteredMovieTitles));
    }
    @Test
    void test_Filter_Movies_By_Action_Genre() {
        // Given
        HomeController homeController = new HomeController();
        homeController.allMovies = Movie.initializeMovies();

        List<String> expectedActionTitles = List.of("Inferno Protocol","Thunderstrike");

        // When
        List<Movie> filteredMovies = homeController.filterMoviesByGenre(Genre.MovieGenre.ACTION);

        // Then
        assertFalse(filteredMovies.isEmpty());

        List<String> filteredMovieTitles = filteredMovies.stream()
                .map(Movie::getTitle)
                .collect(Collectors.toList());
        assertTrue(filteredMovieTitles.containsAll(expectedActionTitles) && expectedActionTitles.containsAll(filteredMovieTitles));
    }

    //This test checks that filtering by a nonexistent genre yields an empty list.
    @Test
    void test_Filter_Movies_By_Nonexistent_Genre() {
        // Given
        HomeController homeController = new HomeController();
        homeController.allMovies = Movie.initializeMovies();


        Genre.MovieGenre nonExistentGenre = Genre.MovieGenre.UNKNOWN;

        // When
        List<Movie> filteredMovies = homeController.filterMoviesByGenre(nonExistentGenre);

        // Then
        assertTrue(filteredMovies.isEmpty());
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




    // Checks if list is empty
    // Checks if list is empty
    @Test
    void test_Filter_Movies_With_Empty_List() {
        // Given
        HomeController homeController = new HomeController();
        homeController.allMovies = new ArrayList<>(); // sets an empty MovieList

        // When
        List<Movie> filteredMovies = homeController.filterMoviesByGenre(Genre.MovieGenre.COMEDY);

        // Then
        assertTrue(filteredMovies.isEmpty());}




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
 @Test
 void testSearchMovies() {
     // Given
     List<Movie> movies = Arrays.asList(
             new Movie("Title A", "Description A"),
             new Movie("Title B", "Description B"),
             new Movie("Title C", "Description C")
     );

     HomeController controller = new HomeController();

     // When searching for "Title A"
     String query = "Title A";
     List<Movie> searchResult = controller.filterMovies(movies, query);

     // Then
     assertEquals(1, searchResult.size());
     assertEquals("Title A", searchResult.get(0).getTitle());

     // When searching for "Title"
     query = "Title";
     searchResult = controller.filterMovies(movies, query);

     // Then
     assertEquals(3, searchResult.size());
     assertTrue(searchResult.stream().anyMatch(movie -> movie.getTitle().equals("Title A")));
     assertTrue(searchResult.stream().anyMatch(movie -> movie.getTitle().equals("Title B")));
     assertTrue(searchResult.stream().anyMatch(movie -> movie.getTitle().equals("Title C")));



     // When searching for "Unknown Title"
     query = "Unknown Title";
     searchResult = controller.filterMovies(movies, query);

     // Then
     assertTrue(searchResult.isEmpty());
 }

 */

}








