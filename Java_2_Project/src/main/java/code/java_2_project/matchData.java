package code.java_2_project;

public class matchData {
    private int matchID;
    private String hero;
    private int kills;
    private int deaths;
    private boolean win;



    public matchData(int matchID, String hero, int kills, int deaths, boolean win){
        this.matchID = matchID;
        this.hero = hero;
        this.kills = kills;
        this.deaths = deaths;
        this.win =win;
    }


    public matchData() {
    }

    @Override
    public String toString() {
        return "matchData--{" +
                "matchID=" + matchID +
                ", hero='" + hero + '\'' +
                ", kills=" + kills +
                ", deaths=" + deaths +
                ", win=" + win +
                '}';
    }

    //GETTERS
    public int getMatchID() {
        return matchID;
    }

    public String getHero() {
        return hero;
    }

    public boolean isWin() {
        return win;
    }

    public int getKills() {
        return kills;
    }

    public int getDeaths() {
        return deaths;
    }
}
