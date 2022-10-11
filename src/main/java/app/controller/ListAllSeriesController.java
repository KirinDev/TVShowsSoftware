package app.controller;

import app.domain.model.Serie;
import app.domain.store.SerieStore;
import app.mappers.SerieMapper;
import app.mappers.dto.SerieDTO;

import java.util.List;
import java.util.Set;

public class ListAllSeriesController {

    private App app;
    private SerieMapper mapper;

    public ListAllSeriesController() {
        this.app = App.getInstance();
        this.mapper = new SerieMapper();
    }

    public List<SerieDTO> listAllSeries() {
        SerieStore store = app.getCompany().getSerStore();
        List<Serie> lst = store.getAll();
        return mapper.toDTO(lst);
    }
}
