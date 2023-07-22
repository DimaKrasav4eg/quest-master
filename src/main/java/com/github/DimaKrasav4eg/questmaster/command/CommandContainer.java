package com.github.DimaKrasav4eg.questmaster.command;

import com.github.DimaKrasav4eg.questmaster.command.impl.HelpCommand;
import com.github.DimaKrasav4eg.questmaster.command.impl.StartCommand;
import com.github.DimaKrasav4eg.questmaster.command.impl.StopCommand;
import com.github.DimaKrasav4eg.questmaster.command.impl.UnknownCommand;
import com.github.DimaKrasav4eg.questmaster.service.SendBotMessageService;
import com.google.common.collect.ImmutableMap;

import static com.github.DimaKrasav4eg.questmaster.command.CommandsInfo.*;


public class CommandContainer {
    private final ImmutableMap<String, Command> commandMap;
    private final Command unknownCommand;

    public CommandContainer(SendBotMessageService sendBotMessageService) {
        commandMap = ImmutableMap.<String, Command>builder()
                .put(START.getCommandName(), new StartCommand(sendBotMessageService))
                .put(HELP.getCommandName(), new HelpCommand(sendBotMessageService))
                .put(STOP.getCommandName(), new StopCommand(sendBotMessageService)).build();
        this.unknownCommand = new UnknownCommand(sendBotMessageService);
    }
    public Command extractCommand(String commandName){
        return commandMap.getOrDefault(commandName, unknownCommand);
    }

}
