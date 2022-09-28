package app.ui.console;

import app.controller.ListAllSeriesController;
import app.mappers.dto.SerieDTO;

import java.util.List;

public class ListAllSeriesUI implements Runnable {

    private ListAllSeriesController ctrl;

    public ListAllSeriesUI() {
        ctrl = new ListAllSeriesController();
    }

    public void run() {

        List<SerieDTO> ser_lst = ctrl.listAllSeries();
        System.out.println("\n| List of all series |");
        for(SerieDTO i : ser_lst) {
            System.out.println("===================");
            System.out.println("Name: " + i.getName());
            System.out.println("Aired: " + i.getAired());
            System.out.println("Genres: " + i.getGenres());
            System.out.println("Duration: " + i.getDuration());
            System.out.println("Score: " + i.getScore());
            System.out.println("Number of episodes: " + i.getNum_episodes());
            System.out.println("===================");
        }

    }
}
