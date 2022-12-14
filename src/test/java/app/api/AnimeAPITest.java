package app.api;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnimeAPITest {

    @Test
    void getAllData() {
        String name = "     Attack on Titan    ";
        String[] arr = name.split(" ");
        String name2 = "";
        for(int i = 0 ; i < arr.length ; i++) {
            if( i == 0) {
                name2 = arr[i];
            }else{
                name2 = name2.concat("%20").concat(arr[i]);
            }
        }

        JSONObject body = AnimeAPI.getAnimeData(name2.trim());
        JSONArray data = body.getJSONArray("data");
        JSONObject anime = data.getJSONObject(0);
        JSONObject attributes = anime.getJSONObject("attributes");
        String title = attributes.getString("canonicalTitle");
        System.out.println(title);
    }
}