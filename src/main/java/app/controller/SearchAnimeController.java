package app.controller;

import app.api.AnimeAPI;
import app.domain.model.Anime;
import app.domain.store.AnimeStore;
import org.json.JSONArray;
import org.json.JSONObject;

public class SearchAnimeController {

    private App app;

    public SearchAnimeController() {
        this.app = App.getInstance();
    }

    public JSONObject searchAnime(String name) {
        JSONObject body = AnimeAPI.getAnimeData(name.trim());
        JSONArray data = body.getJSONArray("data");
        JSONObject anime = data.getJSONObject(0);
        return anime.getJSONObject("attributes");
    }
}
