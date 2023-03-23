package be.kdg.arno.enrico.tictactoe.domain.model;

import be.kdg.arno.enrico.tictactoe.domain.model.player.Player;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PlayedGames {
    static GameRecord grSave;
    private static LocalDateTime now = LocalDateTime.now();
    private static DateTimeFormatter nowFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public void save(Player playerName1, Player playerName2, int boardSize, String result) {
        now.format(nowFormat);
        System.out.println("Saving: " + playerName1.getName() + " + " + playerName2.getName() + " + " + boardSize + "x" + boardSize + " + " + result);
        /*grSave = new GameRecord(String.valueOf(now), playerName1.getName(), playerName2.getName(), boardSize + "x" + boardSize, result);*/
        Path path = Paths.get("./playedgames.csv");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile(), true))) {
            writer.write(String.valueOf(now));
            writer.write(";");
            writer.write(playerName1.getName());
            writer.write(";");
            writer.write(playerName2.getName());
            writer.write(";");
            writer.write(boardSize + "x" + boardSize);
            writer.write(";");
            writer.write(result);
            writer.write(";");
            writer.write("\n");
        } catch (IOException e) {
            System.out.println("Can't read the file");
            System.out.println(e.getMessage());
        }
    }

    public List<String> load() {
        List<String> lines = new ArrayList<>();
        Path path = Paths.get("./playedgames.csv");
        try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(";");
                String date = fields[0];
                String nameX = fields[1];
                String nameO = fields[2];
                String boardSize = fields[3];
                String result = fields[4];

                lines.add(date);
                lines.add(nameX);
                lines.add(nameO);
                lines.add(boardSize);
                lines.add(result);
            }
        } catch (IOException e) {
            System.out.println("Can't read the file");
            System.out.println(e.getMessage());
        }
        return lines;
    }

    public String[] loadDate() {
        List<String> lines = load();
        String[] dates = new String[lines.size() / 5];
        int j = 0;
        for (int i = 0; i < lines.size(); i += 5) {
            dates[j] = lines.get(i);
            j++;
        }
        return dates;
    }

    public String[] loadNameX() {
        List<String> lines = load();
        String[] namesX = new String[lines.size() / 5];
        int j = 0;
        for (int i = 1; i < lines.size(); i += 5) {
            namesX[j] = lines.get(i);
            j++;
        }
        return namesX;
    }

    public String[] loadNameO() {
        List<String> lines = load();
        String[] namesO = new String[lines.size() / 5];
        int j = 0;
        for (int i = 2; i < lines.size(); i += 5) {
            namesO[j] = lines.get(i);
            j++;
        }
        return namesO;
    }

    public String[] loadBoardSize() {
        List<String> lines = load();
        String[] boardSizes = new String[lines.size() / 5];
        int j = 0;
        for (int i = 3; i < lines.size(); i += 5) {
            boardSizes[j] = lines.get(i);
            j++;
        }
        return boardSizes;
    }

    public String[] loadResults() {
        List<String> lines = load();
        String[] results = new String[lines.size() / 5];
        int j = 0;
        for (int i = 4; i < lines.size(); i += 5) {
            results[j] = lines.get(i);
            j++;
        }
        return results;
    }
}
