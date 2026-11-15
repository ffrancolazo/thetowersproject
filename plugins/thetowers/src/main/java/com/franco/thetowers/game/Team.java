package com.franco.thetowers.game;

import java.util.List;

import org.bukkit.entity.Player;

// Representar los equipos.
public class Team {

    private String name;
    private List<Player> players;
    private int score;

    public Team(String name, List<Player> players, int score) {
        this.name = name;
        this.players = players;
        this.score = score;
    }

    public void addPlayerToTheTeam(Player player) {
        if (players.contains(player)) {
            return;
        }

        if (players.size() > 3) {
            return;
        }

        players.add(player);
    }

    public void removePlayerFromTeam(Player player) {
        players.remove(player);
    }

    public int getCountPlayers() {
        return players.size();
    }

    public boolean existPlayer(Player player){
        return players.contains(player);
    }

};
