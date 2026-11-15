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
            case "red":
                redTeam.addPlayerToTheTeam(playerThatInput);
                source.getSender().sendRichMessage("<green>[The Towers]</green> <red>¡Ingresaste al equipo rojo!");
                return;
            case "blue":
                blueTeam.addPlayerToTheTeam(playerThatInput);
                source.getSender().sendRichMessage("<green>[The Towers]</green> <blue>¡Ingresaste al equipo azul!");
                return;
        }
    
    }
}
