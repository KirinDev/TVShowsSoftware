package app.api;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimeAPITest {

    @Test
    void getAllData() {
        JSONObject body = AnimeAPI.getAllData("Attack%20on%20Titan");
        JSONArray data = body.getJSONArray("data");
        JSONObject attributes = data.getJSONObject(0);
        JSONObject att = attributes.getJSONObject("attributes");
        String title = att.getString("canonicalTitle");
        System.out.println(title);

    }
}