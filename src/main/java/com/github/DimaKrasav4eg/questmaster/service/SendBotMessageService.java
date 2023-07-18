package com.github.DimaKrasav4eg.questmaster.service;

/**
 * Service interface for sending messages
 */
public interface SendBotMessageService {
    /**
     * Send message via telegram bot
     * @param chatId is the id of chat which message will be sent
     * @param text - the message that will be sent
     */
    void sendMessage(String chatId, String text);
}
