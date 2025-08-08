package taller.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import taller.model.Character;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

public class HttpService {

    private static final Logger logger = LogManager.getLogger(HttpService.class);

    public static List<Character> get(String url) throws IOException {

        if (url == null || url.isEmpty()) {
            logger.error("URL cannot be null or empty");
            throw new IllegalArgumentException("URL cannot be null or empty");
        }

        try {

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();

            JsonObject jsonResponse = gson.fromJson(response.body(), JsonObject.class);

            Character[] dragonballArray = gson.fromJson(jsonResponse.getAsJsonArray("items"), Character[].class);

            return Arrays.asList(dragonballArray);

        } catch (Exception e) {
            logger.error("Error fetching data from URL: {}", url, e);
            throw new IOException("Failed to fetch data from URL: " + url, e);

        }
    }

}
