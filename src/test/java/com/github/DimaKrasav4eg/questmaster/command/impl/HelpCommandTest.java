package com.github.DimaKrasav4eg.questmaster.command.impl;

import com.github.DimaKrasav4eg.questmaster.command.AbstractCommandTest;
import com.github.DimaKrasav4eg.questmaster.command.Command;

import static com.github.DimaKrasav4eg.questmaster.command.CommandsInfo.HELP;

class HelpCommandTest extends AbstractCommandTest {

    @Override
    protected Command getCommand() {
        return new HelpCommand(sendBotMessageService);
    }

    @Override
    protected String getCommandName() {
        return HELP.getCommandName();
    }

    @Override
    protected String getCommandMessage() {
        return HELP.getReplyMessage();
    }
}