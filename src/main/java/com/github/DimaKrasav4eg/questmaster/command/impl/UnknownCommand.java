package com.github.DimaKrasav4eg.questmaster.command.impl;

import com.github.DimaKrasav4eg.questmaster.command.Command;
import com.github.DimaKrasav4eg.questmaster.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class UnknownCommand implements Command {
    public final static String UNKNOWN_COMMAND_MESSAGE = "Sorry, you input incorrect command.\n" +
            "Use /help to find out the command of interest.";
    private final SendBotMessageService sendBotMessageService;

    public UnknownCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        this.sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), UNKNOWN_COMMAND_MESSAGE);
    }
}
