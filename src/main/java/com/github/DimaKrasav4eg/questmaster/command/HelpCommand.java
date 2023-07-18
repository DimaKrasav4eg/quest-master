package com.github.DimaKrasav4eg.questmaster.command;

import com.github.DimaKrasav4eg.questmaster.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.github.DimaKrasav4eg.questmaster.command.CommandName.*;

public class HelpCommand implements Command {
    private final static String HELP_MESSAGE = String.format("""
            Here's what I can do
            %s - restart bot
            %s - stop bot
            %s - get help
            """, START.getCommandName(), STOP.getCommandName(), HELP.getCommandName());
    private final SendBotMessageService sendBotMessageService;
    public HelpCommand(SendBotMessageService sendBotMessageService){
        this.sendBotMessageService = sendBotMessageService;
    }
    @Override
    public void execute(Update update) {
        this.sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), HELP_MESSAGE);
    }
}
