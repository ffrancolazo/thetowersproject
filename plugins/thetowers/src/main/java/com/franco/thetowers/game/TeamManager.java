package com.franco.thetowers.game;

import java.util.ArrayList;

public class TeamManager {

    private final Team redTeam;
    private final Team blueTeam;

    public TeamManager() {
        this.redTeam = new Team("red", new ArrayList<>(), 0);
        this.blueTeam = new Team("blue", new ArrayList<>(), 0);
    }

    public Team getRedTeam() {
        return redTeam;
    }

    public Team getBlueTeam() {
        return blueTeam;
    }
}
