package be.kdg.arno.enrico.boterkaaseieren.domain.view;


public class GamePresenter {
    private GameView view;

    public GamePresenter(GameView view) {
        this.view = view;
        addEventHandlers();
    }
    private void addEventHandlers() {
       //TODO button bullshit
    }
}
