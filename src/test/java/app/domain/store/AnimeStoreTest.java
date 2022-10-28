package app.domain.store;

import app.domain.model.Anime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnimeStoreTest {

    AnimeStore store =  new AnimeStore();

    Anime anime1 = new Anime("Berserk" , 2015 , "Action" , 23.0 , 10.0 , 23 , "Sussy" , "serie");
    Anime anime2 = new Anime("Konosuba" , 2015 , "Action" , 23.0 , 9.0 , 23 , "Sussy" , "serie");
    Anime anime3 = new Anime("Cyberpunk" , 2015 , "Action" , 23.0 , 9.7 , 23 , "Sussy" , "serie");
    Anime anime4 = new Anime("ERASED" , 2015 , "Action" , 23.0 , 6.5 , 23 , "Sussy" , "serie");
    Anime anime5 = new Anime("Naruto" , 2015 , "Action" , 23.0 , 9.5 , 23 , "Sussy" , "serie");

    List<Anime> orig_lst = new ArrayList<>();


    @Test
    void orderAscByScore() {
    }

    @org.junit.jupiter.api.Test
    void orderDesByScore() {
        orig_lst.add(anime1);
        orig_lst.add(anime2);
        orig_lst.add(anime3);
        orig_lst.add(anime4);
        orig_lst.add(anime5);

        List<Anime> lst = store.orderDesByScore();
        assertEquals(5 , lst.size());
    }
}