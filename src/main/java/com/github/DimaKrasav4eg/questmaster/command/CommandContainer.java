package com.github.DimaKrasav4eg.questmaster.command;

import com.github.DimaKrasav4eg.questmaster.command.impl.*;
import com.github.DimaKrasav4eg.questmaster.service.SendBotMessageService;
import com.github.DimaKrasav4eg.questmaster.service.UserService;
import com.google.common.collect.ImmutableMap;

import static com.github.DimaKrasav4eg.questmaster.command.CommandsInfo.*;


public class CommandContainer {
    private final ImmutableMap<String, Command> commandMap;
    private final Command unknownCommand;

    public CommandContainer(SendBotMessageService sendBotMessageService, UserService userService) {
        commandMap = ImmutableMap.<String, Command>builder()
                .put(START.getCommandName(), new StartCommand(sendBotMessageService, userService))
                .put(HELP.getCommandName(), new HelpCommand(sendBotMessageService))
                .put(STOP.getCommandName(), new StopCommand(sendBotMessageService, userService))
                .put(STAT.getCommandName(), new StatCommand(sendBotMessageService, userService))
                .build();
        this.unknownCommand = new UnknownCommand(sendBotMessageService);
    }
    public Command extractCommand(String commandName){
        return commandMap.getOrDefault(commandName, unknownCommand);
    }

}
