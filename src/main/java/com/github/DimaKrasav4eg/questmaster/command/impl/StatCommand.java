package com.github.DimaKrasav4eg.questmaster.command.impl;

import com.github.DimaKrasav4eg.questmaster.command.Command;
import com.github.DimaKrasav4eg.questmaster.service.SendBotMessageService;
import com.github.DimaKrasav4eg.questmaster.service.UserService;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.github.DimaKrasav4eg.questmaster.command.CommandsInfo.STAT;

public class StatCommand implements Command {

    private final SendBotMessageService sendBotMessageService;
    private final UserService userService;

    public StatCommand(SendBotMessageService sendBotMessageService, UserService userService) {
        this.sendBotMessageService = sendBotMessageService;
        this.userService = userService;
    }

    @Override
    public void execute(Update update) {
        int activeUsersCount = userService.extractAllActiveUsers().size();
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(),
                String.format(STAT.getReplyMessage(), activeUsersCount));
    }
}
