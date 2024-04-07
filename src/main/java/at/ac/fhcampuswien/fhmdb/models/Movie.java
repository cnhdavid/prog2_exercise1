package at.ac.fhcampuswien.fhmdb.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Movie {
    private String title;
    private String description;
    private List<Genre.MovieGenre> genres = new ArrayList<>();
    private List<String> mainCast;

    public Movie(String title, String description, List<Genre.MovieGenre> genres) {
        this.title = title;
        this.description = description;
        this.genres = genres;
        this.mainCast = mainCast;
    }
    public Movie(String title, String description) {
        this.title = title;
        this.description = description;

    }
    @Override
    public String toString() {
        return "Movie: " + title;
    }


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<Genre.MovieGenre> getGenres() {
        return genres;
    }

    // Initialisierung der Movies
    public static List<Movie> initializeMovies() {
        List<Movie> movies = new ArrayList<>();

        // Movie 1
        Movie movie1 = new Movie("The Adventure Quest", "Join our heroes on an epic journey filled with danger, excitement, and  twists as they embark on the ultimate adventure quest to save the world.",
                List.of(Genre.MovieGenre.ADVENTURE, Genre.MovieGenre.FANTASY));
        movies.add(movie1);

        // Movie 2
        Movie movie2 = new Movie("Comedy Chaos", "Get ready for non-stop laughter in this hilarious comedy that follows the misadventures of a group of friends trying to navigate the ups and downs of life with a comedic twist.",
                List.of(Genre.MovieGenre.COMEDY, Genre.MovieGenre.ROMANCE));
        movies.add(movie2);

        // Movie 3
        Movie movie3 = new Movie("Mystery Mansion", "Step into the eerie world of Mystery Mansion, where dark secrets and enigmatic puzzles await. As the characters unfold the mystery, the suspense builds, keeping you on the edge of your seat.",
                List.of(Genre.MovieGenre.MYSTERY, Genre.MovieGenre.THRILLER));
        movies.add(movie3);

        // Movie 4
        Movie movie4 = new Movie("Sci-Fi Odyssey", "Embark on a mind-bending journey through time and space in this futuristic sci-fi odyssey. Immerse yourself in a world of advanced technology, alien encounters, and the endless possibilities of the cosmos.",
                List.of(Genre.MovieGenre.SCIENCE_FICTION, Genre.MovieGenre.ADVENTURE));
        movies.add(movie4);

        Movie movie5 = new Movie("The Wolf of Wall Street", "The Wolf of Wall Street is a high-octane biographical drama that follows the rise and fall of Jordan Belfort, a charismatic stockbroker who indulges in a hedonistic lifestyle of excess and corruption in the 1990s.",
                List.of(Genre.MovieGenre.BIOGRAPHY, Genre.MovieGenre.DRAMA));
        movies.add(movie5);

        Movie movie6 = new Movie("Titanic", "Titanic is a romantic drama that intertwines the tragic historical sinking of the RMS Titanic with a poignant love story between Jack, a penniless artist, and Rose, a wealthy young woman, set against the backdrop of the ill-fated maiden voyage.",
                List.of(Genre.MovieGenre.ROMANCE, Genre.MovieGenre.DRAMA));
        movies.add(movie6);

        Movie movie7 = new Movie("Inferno Protocol", "In a world on the brink of annihilation, a rogue special forces operative must embark on a high-stakes mission to prevent a diabolical mastermind from unleashing a devastating global weapon known as the \"Inferno Protocol.\" With time running out and enemies closing in from all sides, the protagonist battles through a series of explosive set pieces, showcasing jaw-dropping stunts and intense hand-to-hand combat. \"Inferno Protocol\" is a heart-pounding action thriller that keeps viewers on the edge of their seats.",
                List.of(Genre.MovieGenre.ACTION, Genre.MovieGenre.THRILLER));
        movies.add(movie7);

        Movie movie8 = new Movie("Thunderstrike", "When a powerful and enigmatic terrorist organization seizes control of a cutting-edge military satellite capable of causing catastrophic destruction, an elite team of renegade soldiers is assembled to thwart their plans. Led by a fearless ex-special forces commander, the squad engages in a relentless pursuit, facing relentless gunfire, breathtaking aerial combat, and explosive showdowns. \"Thunderstrike\" delivers adrenaline-fueled action, strategic warfare, and a race against time as the team battles to prevent the satellite from becoming the ultimate weapon of mass destruction.",
                List.of(Genre.MovieGenre.ACTION, Genre.MovieGenre.WAR));
        movies.add(movie8);

        Movie movie9 = new Movie("Elysium Odyssey", "Join a young hero on a magical quest to restore balance, encountering mythical creatures and breathtaking landscapes in this visually stunning animated fantasy adventure",
                List.of(Genre.MovieGenre.ANIMATION, Genre.MovieGenre.FANTASY));
        movies.add(movie9);

        Movie movie10 = new Movie("Starstream Chronicles", "Join a charismatic space captain and a ragtag crew in this animated space opera, as they uncover a galaxy-threatening conspiracy. ",
                List.of(Genre.MovieGenre.ANIMATION, Genre.MovieGenre.SCIENCE_FICTION));
        movies.add(movie10);

        Movie movie11 = new Movie("Rhythms of Resilience", "A Documentary capturing the inspiring journey of Maya Hartman, a jazz pianist who triumphs over a challenging past, finding solace and success in music.",
                List.of(Genre.MovieGenre.DOCUMENTARY, Genre.MovieGenre.DRAMA));
        movies.add(movie11);

        Movie movie12 = new Movie("Uncharted Horizons: The Elon Musk Story", "A Documentary unraveling the life of visionary entrepreneur Elon Musk, from revolutionizing space travel to leading the electric car movement. Gain insights into Musk's audacious ventures and indomitable spirit.",
                List.of(Genre.MovieGenre.DOCUMENTARY, Genre.MovieGenre.BIOGRAPHY));
        movies.add(movie12);

        Movie movie13 = new Movie("Laugh Therapy", "A rib-tickling comedy follows a group of friends navigating unconventional therapy sessions, filled with witty banter and hilarious escapades. ",
                List.of(Genre.MovieGenre.COMEDY));
        movies.add(movie13);

        Movie movie14 = new Movie("Frontier Enigma", " In the Wild West, a mysterious stranger disrupts a town's equilibrium, intertwining the lives of its inhabitants in a suspenseful blend of mystery and western.",
                List.of(Genre.MovieGenre.CRIME, Genre.MovieGenre.MYSTERY));
        movies.add(movie14);

        Movie movie15 = new Movie("Shadows of Deceit", "A seasoned detective confronts corruption and crime in the desert, blurring the lines between lawman and outlaw in this gripping mix of western and mystery. ",
                List.of(Genre.MovieGenre.CRIME, Genre.MovieGenre.WESTERN));
        movies.add(movie15);

        Movie movie16 = new Movie("Melody Meadows", "The Harmony family discovers a magical backyard world with talking animals and enchanting landscapes in this heartwarming family musical celebrating imagination and togetherness.",
                List.of(Genre.MovieGenre.FAMILY, Genre.MovieGenre.MUSICAL));
        movies.add(movie16);

        Movie movie17 = new Movie("Starlight Serenade", "Join a young prodigy's quest to save her family's music store with the help of animated musical instruments. \"Starlight Serenade\" is a toe-tapping family musical about friendship, perseverance, and the magic of music. ",
                List.of(Genre.MovieGenre.FAMILY, Genre.MovieGenre.MUSICAL));
        movies.add(movie17);

        Movie movie18 = new Movie("No Man's Land of Nightmares", "Trapped behind enemy lines in World War I, a squad of soldiers encounters supernatural horrors that prey on their fears in this chilling war horror.",
                List.of(Genre.MovieGenre.WAR, Genre.MovieGenre.HORROR));
        movies.add(movie18);

        Movie movie19 = new Movie("Bunker 13", "During World War II, Allied soldiers confront both enemy forces and supernatural entities in an abandoned bunker with a haunted past. \"Bunker 13\" is a suspenseful war horror blurring the lines between real and supernatural terrors. ",
                List.of(Genre.MovieGenre.WAR, Genre.MovieGenre.HORROR));
        movies.add(movie19);

        Movie movie20 = new Movie("Dusty Trails", "In the lawless Old West, a mysterious gunslinger seeks redemption in this gripping western tale of justice and revenge.",
                List.of(Genre.MovieGenre.WESTERN));
        movies.add(movie20);

        Movie movie21 = new Movie("Racing Against Fate", "An underdog race car driver battles the odds for a shot at a championship in this adrenaline-fueled sports drama of determination and dreams. ",
                List.of(Genre.MovieGenre.SPORT, Genre.MovieGenre.DRAMA));
        movies.add(movie21);

        Movie movie22 = new Movie("Bleachers of Glory", " In a small town, a group of misfit high school athletes forms an unlikely team in this heartwarming sports comedy celebrating teamwork and friendship. ",
                List.of(Genre.MovieGenre.SPORT, Genre.MovieGenre.COMEDY));
        movies.add(movie22);

        return movies;

    }

    public List<String> getMainCast() {
        return mainCast;
    }

    public Object getDirector() {
        return null;
    }
}