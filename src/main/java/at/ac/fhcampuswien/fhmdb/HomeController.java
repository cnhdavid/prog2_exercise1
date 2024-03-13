package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import at.ac.fhcampuswien.fhmdb.ui.MovieCell;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class HomeController implements Initializable {
    @FXML
    public JFXButton searchBtn;

    @FXML
    public TextField searchField;

    @FXML
    public JFXListView movieListView;

    @FXML
    public JFXComboBox genreComboBox;

    @FXML
    public JFXButton sortBtn;

    public List<Movie> allMovies = Movie.initializeMovies();

    private final ObservableList<Movie> observableMovies = FXCollections.observableArrayList();   // automatically updates corresponding UI elements when underlying data changes

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        observableMovies.addAll(allMovies);         // add dummy data to observable list

        // initialize UI stuff
        movieListView.setItems(observableMovies);   // set data of observable list to list view
        movieListView.setCellFactory(movieListView -> new MovieCell()); // use custom cell factory to display data

        // TODO add genre filter items with genreComboBox.getItems().addAll(...)
        genreComboBox.setPromptText("Filter by Genre");
        genreComboBox.getItems().addAll("ACTION", "ADVENTURE", "ANIMATION", "BIOGRAPHY", "COMEDY",
                "CRIME", "DRAMA", "DOCUMENTARY", "FAMILY", "FANTASY", "HISTORY", "HORROR",
                "MUSICAL", "MYSTERY", "ROMANCE", "SCIENCE_FICTION", "SPORT", "THRILLER", "WAR",
                "WESTERN");

        // TODO add event handlers to buttons and call the regarding methods
        // either set event handlers in the fxml file (onAction) or add them here

        // Sort button example:
        sortBtn.setOnAction(actionEvent -> {
            if(sortBtn.getText().equals("Sort (asc)")) {

                sortBtn.setText("Sort (desc)");
                sortMoviesAscending();
            } else {

                sortBtn.setText("Sort (asc)");
                sortMoviesDescending();
            }
        });
    }
    private void sortMoviesAscending() {
        List<Movie> movieList = movieListView.getItems();
        movieList.sort(Comparator.comparing(Movie::getTitle));
        movieListView.setItems(FXCollections.observableArrayList(movieList));
        movieListView.setCellFactory(movieListView -> new MovieCell());
    }
    private void sortMoviesDescending() {
        List<Movie> movieList = movieListView.getItems();
        movieList.sort(Comparator.comparing(Movie::getTitle).reversed());
        movieListView.setItems(FXCollections.observableArrayList(movieList));
        movieListView.setCellFactory(movieListView -> new MovieCell());
    }
    @FXML
    private void filterMovies(ActionEvent event) {



        String searchText = searchField.getText().trim().toLowerCase();
        String selectedGenre = (String) genreComboBox.getValue();


        // Filter movies based on search text and selected genre
        List<Movie> filteredMovies = allMovies.stream()
                .filter(movie -> searchText.isEmpty() ||
                        movie.getTitle().toLowerCase().contains(searchText) ||
                        movie.getDescription().toLowerCase().contains(searchText))
                .filter(movie -> selectedGenre == null ||
                        movie.getGenres().contains(Movie.Genre.valueOf(selectedGenre)))
                .collect(Collectors.toList());
        Reset();
        movieListView.setItems(FXCollections.observableArrayList(filteredMovies));
        movieListView.setCellFactory(movieListView -> new MovieCell());
        filteredMovies.clear();

    }

    private void Reset() {

        movieListView.setItems(FXCollections.observableArrayList(allMovies));
        movieListView.setCellFactory(movieListView -> new MovieCell());}

    private boolean DoesGenreMatch(Movie movie, String selectedGenre) {
        if (selectedGenre == null || selectedGenre.isEmpty()) {
            return true;}
        try {
            Movie.Genre genre = Movie.Genre.valueOf(selectedGenre.toUpperCase());
            return movie.getGenres().contains(genre);
        } catch (IllegalArgumentException e) {
            return false;}
    }
    public List<Movie> filterMoviesByGenre(Movie.Genre genre) {
        return allMovies.stream()
                .filter(movie -> movie.getGenres().contains(genre))
                .collect(Collectors.toList());
    }

}
