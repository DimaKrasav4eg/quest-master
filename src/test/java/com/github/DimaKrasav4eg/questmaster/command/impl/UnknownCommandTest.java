package com.github.DimaKrasav4eg.questmaster.command.impl;

import com.github.DimaKrasav4eg.questmaster.command.AbstractCommandTest;
import com.github.DimaKrasav4eg.questmaster.command.Command;

import static com.github.DimaKrasav4eg.questmaster.command.impl.UnknownCommand.UNKNOWN_COMMAND_MESSAGE;

class UnknownCommandTest extends AbstractCommandTest {

    private final static String unknownCommandEx = "/unknown_command_ex";
    @Override
    protected Command getCommand() {
        return new UnknownCommand(sendBotMessageService);
    }

    @Override
    protected String getCommandName() {
        return unknownCommandEx;
    }

    @Override
    protected String getCommandMessage() {
        return UNKNOWN_COMMAND_MESSAGE;
    }

}