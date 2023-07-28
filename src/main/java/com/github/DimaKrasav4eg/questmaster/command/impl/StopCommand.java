package com.github.DimaKrasav4eg.questmaster.command.impl;

import com.github.DimaKrasav4eg.questmaster.command.Command;
import com.github.DimaKrasav4eg.questmaster.service.SendBotMessageService;
import com.github.DimaKrasav4eg.questmaster.service.UserService;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.github.DimaKrasav4eg.questmaster.command.CommandsInfo.STOP;

public class StopCommand implements Command {
    private final SendBotMessageService sendBotMessageService;
    private final UserService userService;
    public StopCommand(SendBotMessageService sendBotMessageService, UserService userService){
        this.sendBotMessageService = sendBotMessageService;
        this.userService = userService;
    }
    @Override
    public void execute(Update update) {
        Long chatId = update.getMessage().getChatId();
        this.userService.findByChatId(chatId).ifPresent(
                user -> {
                    user.setActive(false);
                    this.userService.save(user);
                }
        );
        this.sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), STOP.getReplyMessage());
    }
}
