package com.franco.thetowers.commands;

import java.util.ArrayList;

import org.bukkit.entity.Player;

import com.franco.thetowers.game.Team;

import io.papermc.paper.command.brigadier.BasicCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;

public class TeamCommand implements BasicCommand {

    private final Team redTeam = new Team("red", new ArrayList<>(), 0);
    private final Team blueTeam = new Team("blue", new ArrayList<>(), 0);

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
                if (redTeam.existPlayer(playerThatInput) || blueTeam.existPlayer(playerThatInput)) {
                    source.getSender().sendRichMessage("<green>[The Towers]</green> ¡Ya estás en un equipo!");
                    break;
                }

                redTeam.addPlayerToTheTeam(playerThatInput);
                source.getSender().sendRichMessage("<green>[The Towers]</green> <red>¡Ingresaste al equipo rojo!");
                break;
            case "blue":
                if (blueTeam.existPlayer(playerThatInput) || redTeam.existPlayer(playerThatInput)) {
                    source.getSender().sendRichMessage("<green>[The Towers]</green> ¡Ya estás en un equipo!");
                    break;
                }

                blueTeam.addPlayerToTheTeam(playerThatInput);
                source.getSender().sendRichMessage("<green>[The Towers]</green> <blue>¡Ingresaste al equipo azul!");
                break;
            case "exit":
                if (redTeam.existPlayer(playerThatInput)) {
                    redTeam.removePlayerFromTeam(playerThatInput);
                    source.getSender().sendRichMessage("<green>[The Towers]</green> Abandonaste tu equipo.");
                    break;
                }

                if (blueTeam.existPlayer(playerThatInput)) {
                    blueTeam.removePlayerFromTeam(playerThatInput);
                    source.getSender().sendRichMessage("<green>[The Towers]</green> Abandonaste tu equipo.");
                    break;
                }
        }

    }
}
