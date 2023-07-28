package com.github.DimaKrasav4eg.questmaster.command;

import com.github.DimaKrasav4eg.questmaster.command.impl.UnknownCommand;
import com.github.DimaKrasav4eg.questmaster.service.SendBotMessageService;
import com.github.DimaKrasav4eg.questmaster.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

class CommandContainerTest {

    private CommandContainer commandContainer;
    private final UserService userService = Mockito.mock(UserService.class);

    @BeforeEach
    public void init(){
        SendBotMessageService sendBotMessageService = Mockito.mock(SendBotMessageService.class);
        this.commandContainer = new CommandContainer(sendBotMessageService, userService);
    }

    @Test
    public void getAllExistCommands(){
        Arrays.stream(CommandsInfo.values()).forEach(commandName -> {
            Command command = commandContainer.extractCommand(commandName.getCommandName());
            Assertions.assertNotEquals(UnknownCommand.class, command.getClass());
        });
    }
    @Test
    public void returnUnknownCommand(){
        String unknownCommand = "/unknown_command_ex";

        Command command = commandContainer.extractCommand(unknownCommand);

        Assertions.assertEquals(UnknownCommand.class, command.getClass());
    }
}