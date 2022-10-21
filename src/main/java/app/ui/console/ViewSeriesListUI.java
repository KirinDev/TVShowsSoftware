package app.ui.console;

import app.controller.ViewSeriesListController;
import app.mappers.dto.SerieDTO;
import app.ui.console.utils.Utils;

import java.util.List;

public class ViewSeriesListUI implements Runnable {

    private ViewSeriesListController ctrl;

    public ViewSeriesListUI() {
        ctrl = new ViewSeriesListController();
    }

    public void run() {
        System.out.println("| My Series List |");
        List<SerieDTO> lst = ctrl.getAllSeries();
        if( lst.size() > 0 ) {
            Utils.printSeriesInfo(lst);
        }else{
            System.out.println("\n* Your series list is empty *");
        }
    }
}
