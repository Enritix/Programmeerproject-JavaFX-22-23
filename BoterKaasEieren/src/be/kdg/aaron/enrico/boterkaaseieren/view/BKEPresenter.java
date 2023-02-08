package be.kdg.aaron.enrico.boterkaaseieren.view;

import be.kdg.aaron.enrico.boterkaaseieren.model.BKEModel;

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
