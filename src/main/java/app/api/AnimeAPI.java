package app.api;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AnimeAPI {

    static public JSONObject getAnimeData(String name) {

        String ref_name = AnimeAPI.reformatName(name);
        HttpResponse<String> response = null;

        try {
            String str = String.format("https://kitsu.io/api/edge/anime?filter[text]=%s", ref_name );
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(str))
                    .header("Accept" , "application/vnd.api+json")
                    .header("Content-Type" , "application/vnd.api+json")
                    .GET()
                    .build();

            HttpClient client = HttpClient.newHttpClient();
            response = client.send(request , HttpResponse.BodyHandlers.ofString());

        }catch (Exception e) {
            System.err.println("Error 404 : Failed to load anime data from API");
        }

        return new JSONObject(response.body());
    }

    static public String reformatName(String name) {
        String[] arr = name.split(" ");
        String name2 = "";
        for(int i = 0 ; i < arr.length ; i++) {
            if( i == 0) {
                name2 = arr[i];
            }else{
                name2 = name2.concat("%20").concat(arr[i]);
            }
        }
        return name2;
    }

}
