package com.github.DimaKrasav4eg.questmaster.command.impl;

import com.github.DimaKrasav4eg.questmaster.command.AbstractCommandTest;
import com.github.DimaKrasav4eg.questmaster.command.Command;

import static com.github.DimaKrasav4eg.questmaster.command.CommandsInfo.STOP;

class StopCommandTest extends AbstractCommandTest {

    @Override
    protected Command getCommand() {
        return new StopCommand(sendBotMessageService);
    }

    @Override
    protected String getCommandName() {
        return STOP.getCommandName();
    }

    @Override
    protected String getCommandMessage() {
        return STOP.getReplyMessage();
    }
}