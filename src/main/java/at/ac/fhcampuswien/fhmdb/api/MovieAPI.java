package at.ac.fhcampuswien.fhmdb.api;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import com.google.gson.reflect.TypeToken;
import okhttp3.OkHttpClient;
import com.google.gson.Gson;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class MovieAPI {
    private final OkHttpClient client = new OkHttpClient();
    private final Gson gson = new Gson();
    private final String baseUrl = "https://prog2.fh-campuswien.ac.at/movies";

    public List<Movie> fetchMovies(String searchText, String genre) throws IOException {

        searchText = searchText != null ? searchText : "";
        genre = genre != null ? genre : "";
        // URL-Encoding
        String encodedSearchText = URLEncoder.encode(searchText, "UTF-8");
        String encodedGenre = URLEncoder.encode(genre, "UTF-8");


        String url = baseUrl;
        List<String> params = new ArrayList<>();
        if (!searchText.isEmpty()) {
            params.add("searchText=" + encodedSearchText);
        }
        if (!genre.isEmpty()) {
            params.add("genre=" + encodedGenre);
        }
        if (!params.isEmpty()) {
            url += "?" + String.join("&", params);
        }

        // Logging der Anfrage-URL für Debugging-Zwecke
        System.out.println("Request URL: " + url);

        Request request = new Request.Builder()
                .url(url)
                .addHeader("User-Agent", "http.agent")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response + " with body " + response.body().string());
            }
            System.out.println("Response" + response);

            Type listType = new TypeToken<ArrayList<Movie>>() {}.getType();
            List<Movie> movies = gson.fromJson(response.body().string(), listType);
            return movies != null ? movies : new ArrayList<>();
        }
    }
}




