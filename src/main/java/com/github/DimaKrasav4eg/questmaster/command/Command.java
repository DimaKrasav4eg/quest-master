package com.github.DimaKrasav4eg.questmaster.command;

import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Command interface for processing telegram bot commands
 */
public interface Command {
    /**
     * Executing command logic
     * @param update - the {@link Update} Object
     * that contains necessary information
     */
    void execute(Update update);
}
