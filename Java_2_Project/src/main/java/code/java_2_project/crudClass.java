package code.java_2_project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class crudClass extends matchData{
    protected ObservableList<matchData> matchDataObservableList;

    public crudClass() {
        super();
        matchDataObservableList = FXCollections.observableArrayList(
                (new matchData(1, "Juggernaut", 10, 7, false)),
                (new matchData(2, "Spectre", 20, 2, true)),
                (new matchData(3, "Drow Ranger", 12, 1, true)),
                (new matchData(4, "Phantom Lancer", 17, 4, true)),
                (new matchData(5, "Arc Warden", 10, 10, false)),
                (new matchData(6, "Alchemist", 13, 2, true)),
                (new matchData(7, "Abaddon", 9, 4, true)),
                (new matchData(8, "Chen", 0, 7, false)),
                (new matchData(9, "Enigma", 4, 4, false)),
                (new matchData(10, "Zeus", 9, 1, true)),
                (new matchData(11, "Death Prophet", 11, 6, true)),
                (new matchData(12, "Necrophos", 4, 2, false)),
                (new matchData(13, "Naga Siren", 12, 0, true)),
                (new matchData(14, "Terrorblade", 22, 3, true)),
                (new matchData(15, "Bloodseeker", 6, 6, false)),
                (new matchData(16, "Centaur", 7, 2, false)),
                (new matchData(17, "Kunkka", 10, 4, true)),
                (new matchData(18, "Phantom Assasin", 18, 6, true)),
                (new matchData(19, "Meepo", 15, 3, true)),
                (new matchData(20, "Crystal Maiden", 2, 10, false)),
                (new matchData(21, "Warlock", 5, 8, false)),
                (new matchData(22, "Pudge", 16, 12, true)),
                (new matchData(23, "Mirana", 1, 11, false)),
                (new matchData(24, "Anti-Mage", 17, 0, true)),
                (new matchData(25, "Silencer", 17, 4, true)),
                (new matchData(26, "Venomancer", 17, 4, true)),
                (new matchData(27, "Skywrath Mage", 17, 4, true)),
                (new matchData(28, "Lina", 17, 4, true)),
                (new matchData(29, "Luna", 17, 4, true)),
                (new matchData(30, "Pangolier", 17, 4, true))
        );
    }

    public void add(int matchID, String hero, int kills, int deaths, boolean win) {   // add a new object to list
        matchDataObservableList.add(new matchData(matchID, hero, kills, deaths, win));

    }

    public ObservableList<matchData> getData() {    // use to publish list on the tableView Items
        return matchDataObservableList;
    }
}
