package com.github.DimaKrasav4eg.questmaster.service;

import com.github.DimaKrasav4eg.questmaster.tgbot.QuestMasterBot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static org.junit.jupiter.api.Assertions.*;

class SendBotMessageServiceTest {
    private SendBotMessageService sendBotMessageService;
    private QuestMasterBot questMasterBot;

    @BeforeEach
    public void init(){
        this.questMasterBot = Mockito.mock(QuestMasterBot.class);
        sendBotMessageService = new SendBotMessageServiceImpl(questMasterBot);
    }
    @Test
    public void sendMessageTest() throws TelegramApiException {
        String chatId = "test-chat-id";
        String messageText = "test message";

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(messageText);

        sendBotMessageService.sendMessage(chatId, messageText);

        Mockito.verify(questMasterBot).execute(sendMessage);
    }
}