package com.github.DimaKrasav4eg.questmaster.command.impl;

import com.github.DimaKrasav4eg.questmaster.command.Command;
import com.github.DimaKrasav4eg.questmaster.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.github.DimaKrasav4eg.questmaster.command.CommandsInfo.START;

public class StartCommand implements Command {

    private final SendBotMessageService sendBotMessageService;

    public StartCommand(SendBotMessageService sendBotMessageService){
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        this.sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), START.getReplyMessage());
    }
}
