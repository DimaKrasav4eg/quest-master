package com.github.DimaKrasav4eg.questmaster.command;

import com.github.DimaKrasav4eg.questmaster.service.SendBotMessageService;
import com.github.DimaKrasav4eg.questmaster.service.SendBotMessageServiceImpl;
import com.github.DimaKrasav4eg.questmaster.service.UserService;
import com.github.DimaKrasav4eg.questmaster.tgbot.QuestMasterBot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public abstract class AbstractCommandTest {
    private QuestMasterBot questMasterBot;
    protected SendBotMessageService sendBotMessageService;
    protected UserService userService;
    protected abstract Command getCommand();
    protected abstract String getCommandName();
    protected abstract String getCommandMessage();

    @BeforeEach
    public void init(){
        this.questMasterBot = Mockito.mock(QuestMasterBot.class);
        this.sendBotMessageService = new SendBotMessageServiceImpl(questMasterBot);
        this.userService = Mockito.mock(UserService.class);
    }

    @Test
    public void executeTest() throws TelegramApiException {
        Long chatId = 123456789L;
        String userName = "exampleUserName";
        Update update = new Update();

        User userExample = Mockito.mock(User.class);
        Mockito.when(userExample.getUserName()).thenReturn(userName);

        Message message = Mockito.mock(Message.class);
        Mockito.when(message.getChatId()).thenReturn(chatId);
        Mockito.when(message.getText()).thenReturn(getCommandName());
        Mockito.when(message.getFrom()).thenReturn(userExample);
        update.setMessage(message);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(chatId));
        sendMessage.setText(getCommandMessage());

        getCommand().execute(update);

        Mockito.verify(questMasterBot).execute(sendMessage);
    }
}
