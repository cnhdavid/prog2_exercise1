package at.ac.fhcampuswien.fhmdb.api;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import com.google.gson.reflect.TypeToken;
import okhttp3.OkHttpClient;
import com.google.gson.Gson;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MovieAPI {
    private final OkHttpClient client = new OkHttpClient();
    private final Gson gson = new Gson();
    private final String baseUrl = "https://prog2.fh-campuswien.ac.at/api/movies";

    public List<Movie> fetchMovies(String query, String genre) throws IOException {
        String url = baseUrl + "?query=" + query + "&genre=" + genre;

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            Type listType = new TypeToken<ArrayList<Movie>>(){}.getType();
            return gson.fromJson(response.body().string(), listType);
        }
    }


}

