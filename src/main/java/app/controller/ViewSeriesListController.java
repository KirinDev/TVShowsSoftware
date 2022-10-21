package app.controller;

import app.domain.model.Serie;
import app.domain.store.CompSerieStore;
import app.mappers.SerieMapper;
import app.mappers.dto.SerieDTO;

import java.util.List;

public class ViewSeriesListController {

    private App app;
    private SerieMapper mapper;

    public ViewSeriesListController() {
        this.app = App.getInstance();
        this.mapper = new SerieMapper();
    }

    public List<SerieDTO> getAllSeries() {
        CompSerieStore store = this.app.getCompany().getCompSerStore();
        List<Serie> lst = store.getAll();
        return this.mapper.toDTO(lst);
    }
}
