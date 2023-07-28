package com.github.DimaKrasav4eg.questmaster.tgbot;

import com.github.DimaKrasav4eg.questmaster.command.CommandContainer;
import com.github.DimaKrasav4eg.questmaster.service.SendBotMessageServiceImpl;
import com.github.DimaKrasav4eg.questmaster.service.UserService;
import com.github.DimaKrasav4eg.questmaster.tgbot.config.BotConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


@Component
public class QuestMasterBot extends TelegramLongPollingBot {
    private final static String COMMAND_PREFIX = "/";

    private final BotConfig botConfig;
    private final CommandContainer commandContainer;

    @Autowired
    public QuestMasterBot(BotConfig botConfig, UserService userService){
        this.botConfig = botConfig;
        this.commandContainer = new CommandContainer(new SendBotMessageServiceImpl(this), userService);
    }

    @Override
    public String getBotUsername() {
        return botConfig.getBotName();
    }

    @Override
    public String getBotToken() {
        return botConfig.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()){
            String messageText = update.getMessage().getText().trim();
            long chatId = update.getMessage().getChatId();
            if (messageText.startsWith(COMMAND_PREFIX)) {
                String commandName = messageText.split(" ")[0].toLowerCase();
                commandContainer.extractCommand(commandName).execute(update);
            } else {
                sendMessage(chatId, messageText);
            }
        }

    }
    private void sendMessage(long chatId, String text){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(chatId));
        sendMessage.setText(text);
        try{
            execute(sendMessage);
        } catch (TelegramApiException e){
            e.printStackTrace();
        }
    }
}
