module be.kdg.arno.enrico.boterkaaseieren.domain {
    requires javafx.controls;
    requires javafx.base;
    exports be.kdg.arno.enrico.tictactoe.domain;
    opens be.kdg.arno.enrico.tictactoe.domain.model to javafx.base;
}