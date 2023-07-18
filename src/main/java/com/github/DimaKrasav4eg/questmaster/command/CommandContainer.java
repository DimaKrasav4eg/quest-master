package com.github.DimaKrasav4eg.questmaster.command;

import com.github.DimaKrasav4eg.questmaster.service.SendBotMessageService;
import com.google.common.collect.ImmutableMap;

import static com.github.DimaKrasav4eg.questmaster.command.CommandName.*;


public class CommandContainer {
    private final ImmutableMap<String, Command> commandMap;

    public CommandContainer(SendBotMessageService sendBotMessageService) {
        commandMap = ImmutableMap.<String, Command>builder()
                .put(START.getCommandName(), new StartCommand(sendBotMessageService))
                .put(HELP.getCommandName(), new HelpCommand(sendBotMessageService))
                .put(STOP.getCommandName(), new StopCommand(sendBotMessageService)).build();
    }
    public Command extractCommand(String commandName){
        return commandMap.get(commandName);
    }

}
