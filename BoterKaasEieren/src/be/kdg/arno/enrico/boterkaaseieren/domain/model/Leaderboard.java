package be.kdg.arno.enrico.boterkaaseieren.domain.model;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Leaderboard {
    private static Map<String, Score> scores = new TreeMap<>(Collections.reverseOrder());


    public static void addScore(String player, Score stars) {
        if (scores.containsKey(player)) {
            scores.get(player).setStars(scores.get(player).getStars() + stars.getStars());
        } else {
            scores.put(player, stars);
        }
    }

    public static void printLeaderboard() {
        for (Map.Entry<String, Score> entry : scores.entrySet()) {
            System.out.println(entry.getKey() + ": ⭐" + entry.getValue());
        }
    }
}
