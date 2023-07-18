package com.github.DimaKrasav4eg.questmaster.service;

import com.github.DimaKrasav4eg.questmaster.tgbot.QuestMasterBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class SendBotMessageServiceImpl implements SendBotMessageService{
    final QuestMasterBot questMasterBot;

    @Autowired
    public SendBotMessageServiceImpl(QuestMasterBot questMasterBot) {
        this.questMasterBot = questMasterBot;
    }

    @Override
    public void sendMessage(String chatId, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(text);
        try{
            questMasterBot.execute(sendMessage);
        } catch (TelegramApiException e){
            //TODO add logging
            e.printStackTrace();
        }
    }
}
