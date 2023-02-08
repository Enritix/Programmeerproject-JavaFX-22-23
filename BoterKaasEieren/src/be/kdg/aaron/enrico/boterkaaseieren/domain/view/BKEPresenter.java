package be.kdg.aaron.enrico.boterkaaseieren.domain.view;

import be.kdg.aaron.enrico.boterkaaseieren.domain.model.BKEModel;

public class BKEPresenter {
    private BKEModel model;
    private BKEView view;

    public BKEPresenter(BKEModel model, BKEView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
    }
    private void addEventHandlers() {
       //TODO button bullshit
    }
}
