package be.kdg.arno.enrico.tictactoe.domain.model;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * This class saves the names and scores to the leaderboard.csv file.
 * You can also read the file with this class.
 *
 * @author Enrico Egghe
 * @author Arno Bruyninckx
 * @version 1.0
 */
public class Leaderboard {
    //Properties.
    public void clearFile(){
        Path path = Paths.get("./leaderboard.csv");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile(), false))) {

        } catch (IOException e) {
            System.out.println("Can't read the file");
            System.out.println(e.getMessage());
        }
    }

    //Methods.
    public void save(String player, String points) {    //write one player and points to leaderboard.csv
        System.out.println("Leaderboard: " + player + " earns " + points + " points.");
        Path path = Paths.get("./leaderboard.csv");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile(), true))) {
            writer.write(player.toUpperCase());
            writer.write(";");
            writer.write(points);
            writer.write(";");
            writer.write("\n");
        } catch (IOException e) {
            System.out.println("Can't read the file");
            System.out.println(e.getMessage());
        }
    }//save.


    public String getPosition(int p) {   //returns Score object that is in  p'th position (highest scores)
        ArrayList<Scores> scoreList = new ArrayList<>();
        Path path = Paths.get("./leaderboard.csv");
        try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(";");
                String name = fields[0];
                int points = Integer.parseInt(fields[1]);
                scoreList.add(new Scores(name, points));
            }
        } catch (IOException e) {
            System.out.println("Can't read the file");
            System.out.println(e.getMessage());
        }
        return scoreList.get(p - 1).getName() + " - " + scoreList.get(p - 1).getScores();
    }//getPosition.


    public void sort() {    //reads leaderboard.csv, combines and sorts the scores, overwrites the file with sorted scores.
        ArrayList<Scores> scoreList = new ArrayList<>();
        Path path = Paths.get("./leaderboard.csv");
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(";");
                String name = fields[0];
                int points = Integer.parseInt((fields[1]));

                scoreList.add(new Scores(name, points));
            }
            for (int index = 0; index < scoreList.size(); index++) {    //combines points of players with the same name
                int compareIndex = 0;
                do {
                    if (index != compareIndex && scoreList.get(index).getName().equals(scoreList.get(compareIndex).getName())) {  //if the index in the arraylist is different but name is the same
                        scoreList.get(index).setScores(scoreList.get(index).getScores() + scoreList.get(compareIndex).getScores());
                        scoreList.remove(compareIndex);
                    }else compareIndex++;
                }while (compareIndex < scoreList.size());
            }
            scoreList.sort(Scores::compareTo);  //sorts points from high to low
            Collections.reverse(scoreList);
        } catch (IOException e) {
            System.out.println("Can't read the file");
            System.out.println(e.getMessage());
        }
        clearFile();
        for (Scores score : scoreList) {
            String name = score.getName();
            String points = Integer.toString(score.getScores());

            save(name, points);
        }
    }//sort.

    public List<String> read() {
        List<String> lines = new ArrayList<>();
        Path path = Paths.get("./leaderboard.csv");
        try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(";");
                String name = fields[0];
                String score = fields[1];

                lines.add(name);
                lines.add(score);
            }
        } catch (IOException e) {
            System.out.println("Can't read the file");
            System.out.println(e.getMessage());
        }
        return lines;
    }//read.

    public List<String> readNames() {
        List<String> lines = new ArrayList<>();
        Path path = Paths.get("./leaderboard.csv");
        try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(";");
                String name = fields[0];

                lines.add(name);
            }
        } catch (IOException e) {
            System.out.println("Can't read the file");
            System.out.println(e.getMessage());
        }
        return lines;
    }//readNames.

    public List<String> readScores() {
        List<String> lines = new ArrayList<>();
        Path path = Paths.get("./leaderboard.csv");
        try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(";");
                String score = fields[1];

                lines.add(score);
            }
        } catch (IOException e) {
            System.out.println("Can't read the file");
            System.out.println(e.getMessage());
        }
        return lines;
    }//readScores.

    public String getScoreFromLeaderboard(String name) {
        List<String> lines = read();
        String searchName = name.toUpperCase();
        for (int i = 0; i < lines.size(); i++) {
            if (searchName.equals(lines.get(i))) {
                return lines.get(i + 1);
            }
        }
        return "0";
    }//getScoreFromLeaderboard.

    public List<String> getNameFromLeaderboard() {
        List<String> lines = readNames();
        List<String> names = new ArrayList<>();
        for (Iterator<String> iterator = lines.iterator(); iterator.hasNext(); ) {
            String next =  iterator.next();
            names.add(next);
        }
        return names;
    }//getNameFromLeaderboard.
}
