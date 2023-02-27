package be.kdg.arno.enrico.boterkaaseieren.domain.view;

import be.kdg.arno.enrico.boterkaaseieren.domain.model.BKEApplication;
import be.kdg.arno.enrico.boterkaaseieren.domain.model.BoterKaasEieren;

public class BKEPresenter {
    private BKEApplication application;
    private BKEView view;

    public BKEPresenter(BKEApplication application, BKEView view) {
        this.application = application;
        this.view = view;
        addEventHandlers();
    }
    private void addEventHandlers() {
       //TODO button bullshit
    }
}
