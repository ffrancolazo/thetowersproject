package com.franco.thetowers.commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.bukkit.entity.Player;
import com.franco.thetowers.game.Team;
import com.franco.thetowers.game.TeamManager;

import io.papermc.paper.command.brigadier.BasicCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;

public class TeamCommand implements BasicCommand {

    private final TeamManager tm;

    public TeamCommand (TeamManager tm) {
        this.tm = tm;
    }

    @Override
    public void execute(final CommandSourceStack source, final String[] args) {
        if (args.length == 0) {
            source.getSender().sendRichMessage("<green>[The Towers]</green> <dark_green>¡Debes indicar un equipo!");
            return;
        }

        Player playerThatInput = source.getSender().getServer().getPlayer(source.getSender().getName());

        switch (args[0].toLowerCase()) {
            case "list":
                source.getSender().sendRichMessage("<green>[The Towers]</green> <red>Red team: " + redTeam.getCountPlayers());
                source.getSender().sendRichMessage("<green>[The Towers]</green> <blue>Blue team: " + blueTeam.getCountPlayers());
                break;
            case "red":
                if (tm.getRedTeam().existPlayer(playerThatInput) || tm.getBlueTeam().existPlayer(playerThatInput)) {
                    source.getSender().sendRichMessage("<green>[The Towers]</green> ¡Ya estás en un equipo!");
                    break;
                }

                tm.getRedTeam().addPlayerToTheTeam(playerThatInput);
                source.getSender().sendRichMessage("<green>[The Towers]</green> <red>¡Ingresaste al equipo rojo!");
                break;
            case "blue":
                if (tm.getBlueTeam().existPlayer(playerThatInput) || tm.getRedTeam().existPlayer(playerThatInput)) {
                    source.getSender().sendRichMessage("<green>[The Towers]</green> ¡Ya estás en un equipo!");
                    break;
                }

                tm.getBlueTeam().addPlayerToTheTeam(playerThatInput);
                source.getSender().sendRichMessage("<green>[The Towers]</green> <blue>¡Ingresaste al equipo azul!");
                break;
            case "exit":
                if (tm.getRedTeam().existPlayer(playerThatInput)) {
                    tm.getRedTeam().removePlayerFromTeam(playerThatInput);
                    source.getSender().sendRichMessage("<green>[The Towers]</green> Abandonaste tu equipo.");
                    break;
                }

                if (tm.getBlueTeam().existPlayer(playerThatInput)) {
                    tm.getBlueTeam().removePlayerFromTeam(playerThatInput);
                    source.getSender().sendRichMessage("<green>[The Towers]</green> Abandonaste tu equipo.");
                    break;
                }
        }

    }

    @Override 
    public Collection<String> suggest(final CommandSourceStack source, final String[] args) {
        if (args.length == 1) {
            return List.of("list", "red", "blue", "exit");
        }
        return List.of();
    }

}
