package com.github.DimaKrasav4eg.questmaster.command.impl;

import com.github.DimaKrasav4eg.questmaster.command.AbstractCommandTest;
import com.github.DimaKrasav4eg.questmaster.command.Command;

import static com.github.DimaKrasav4eg.questmaster.command.CommandsInfo.START;

public class StartCommandTest extends AbstractCommandTest {

    @Override
    protected Command getCommand() {
        return new StartCommand(sendBotMessageService);
    }

    @Override
    protected String getCommandName() {
        return START.getCommandName();
    }

    @Override
    protected String getCommandMessage() {
        return START.getReplyMessage();
    }
}