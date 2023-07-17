package com.github.DimaKrasav4eg.questmaster.tgbot;

import com.github.DimaKrasav4eg.questmaster.tgbot.config.BotConfig;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


@Component
public class QuestMasterBot extends TelegramLongPollingBot {

    final BotConfig botConfig;
    public QuestMasterBot(BotConfig botConfig){
        this.botConfig = botConfig;
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
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();
            if (messageText.equals("/start"))
                helloMessage(chatId, update.getMessage().getChat().getFirstName());
            else
                sendMessage(chatId, messageText);
        }

    }
    private void helloMessage(long chatId, String name){
        String answer = "Hi, " + name;
        sendMessage(chatId, answer);
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
