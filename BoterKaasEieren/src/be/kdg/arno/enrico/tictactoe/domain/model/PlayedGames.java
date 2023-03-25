package be.kdg.arno.enrico.tictactoe.domain.model;

import be.kdg.arno.enrico.tictactoe.domain.model.player.Player;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * This class saves the played games to the playedgames.csv file.
 * You can also read the file with this class.
 *
 * @author Enrico Egghe
 * @author Arno Bruyninckx
 * @version 1.0
 */
public class PlayedGames {
    //Properties.
    private static LocalDate nowDate = LocalDate.now();
    private static DateTimeFormatter nowDateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static LocalTime nowTime = LocalTime.now();
    private static DateTimeFormatter nowTimeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");

    //Methods.
    public void save(Player playerName1, Player playerName2, int boardSize, String result) {
        nowDate.format(nowDateFormat);
        nowTime.format(nowTimeFormat);
        String formattedTime = nowDate.format(nowDateFormat) + " " + nowTime.format(nowTimeFormat);
        System.out.println("Saving: " + playerName1.getName() + " + " + playerName2.getName() + " + " + boardSize + "x" + boardSize + " + " + result);
        Path path = Paths.get("./playedgames.csv");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile(), true))) {
            writer.write(formattedTime);
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
    }//save.

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
    }//load.

    public String[] loadDate() {
        List<String> lines = load();
        String[] dates = new String[lines.size() / 5];
        int j = 0;
        for (int i = 0; i < lines.size(); i += 5) {
            dates[j] = lines.get(i);
            j++;
        }
        return dates;
    }//loadDate.

    public String[] loadNameX() {
        List<String> lines = load();
        String[] namesX = new String[lines.size() / 5];
        int j = 0;
        for (int i = 1; i < lines.size(); i += 5) {
            namesX[j] = lines.get(i);
            j++;
        }
        return namesX;
    }//loadNameX.

    public String[] loadNameO() {
        List<String> lines = load();
        String[] namesO = new String[lines.size() / 5];
        int j = 0;
        for (int i = 2; i < lines.size(); i += 5) {
            namesO[j] = lines.get(i);
            j++;
        }
        return namesO;
    }//loadNameO.

    public String[] loadBoardSize() {
        List<String> lines = load();
        String[] boardSizes = new String[lines.size() / 5];
        int j = 0;
        for (int i = 3; i < lines.size(); i += 5) {
            boardSizes[j] = lines.get(i);
            j++;
        }
        return boardSizes;
    }//loadBoardSize.

    public String[] loadResults() {
        List<String> lines = load();
        String[] results = new String[lines.size() / 5];
        int j = 0;
        for (int i = 4; i < lines.size(); i += 5) {
            results[j] = lines.get(i);
            j++;
        }
        return results;
    }//loadResults.

    public void clearFile() {
        Path path = Paths.get("./playedgames.csv");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile(), false))) {
            //This can be empty, as the append false basically means it will overwrite everything
            // instead of when it's true, add it on a new line.
        } catch (IOException e) {
            System.out.println("Can't read the file");
            System.out.println(e.getMessage());
        }
    }//clearFile.
}
