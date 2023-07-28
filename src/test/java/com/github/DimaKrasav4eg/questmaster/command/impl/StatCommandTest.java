package com.github.DimaKrasav4eg.questmaster.command.impl;

import com.github.DimaKrasav4eg.questmaster.command.AbstractCommandTest;
import com.github.DimaKrasav4eg.questmaster.command.Command;

import static com.github.DimaKrasav4eg.questmaster.command.CommandsInfo.STAT;

class StatCommandTest extends AbstractCommandTest {

    @Override
    protected Command getCommand() {
        return new StatCommand(this.sendBotMessageService, this.userService);
    }

    @Override
    protected String getCommandName() {
        return STAT.getCommandName();
    }

    @Override
    protected String getCommandMessage() {
        return String.format(STAT.getReplyMessage(), 0);
    }
}