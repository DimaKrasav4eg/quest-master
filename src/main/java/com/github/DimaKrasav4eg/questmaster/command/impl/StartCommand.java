package com.github.DimaKrasav4eg.questmaster.command.impl;

import com.github.DimaKrasav4eg.questmaster.command.Command;
import com.github.DimaKrasav4eg.questmaster.repository.entity.User;
import com.github.DimaKrasav4eg.questmaster.service.SendBotMessageService;
import com.github.DimaKrasav4eg.questmaster.service.UserService;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.github.DimaKrasav4eg.questmaster.command.CommandsInfo.START;

public class StartCommand implements Command {

    private final SendBotMessageService sendBotMessageService;
    private final UserService userService;

    public StartCommand(SendBotMessageService sendBotMessageService, UserService userService){
        this.sendBotMessageService = sendBotMessageService;
        this.userService = userService;
    }

    @Override
    public void execute(Update update) {
        Long chatId = update.getMessage().getChatId();
        userService.findByChatId(chatId).ifPresentOrElse(
                user -> {
                    user.setActive(true);
                    this.userService.save(user);
                },
                () -> {
                    User user = new User();
                    user.setActive(true);
                    user.setChatId(chatId);
                    user.setTgTag(update.getMessage().getFrom().getUserName());
                    userService.save(user);
                }
        );

        this.sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), START.getReplyMessage());
    }
}
