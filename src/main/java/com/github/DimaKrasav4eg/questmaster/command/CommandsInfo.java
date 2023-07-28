package com.github.DimaKrasav4eg.questmaster.command;

/**
 * Enumeration for {@link Command}'s.
 */

public enum CommandsInfo {
    START("/start", "Hi! I help you remember your tasks."),
    STOP("/stop", "All entries have been deleted"),
    HELP("/help", String.format("""
            Here's what I can do
            %s - restart bot
            %s - stop bot
            %s - get help
            """, START.getCommandName(), STOP.getCommandName(), "/help")),
    STAT("/stat", "This boе used by %s persons");

    private final String commandName;
    private final String replyMessage;

    CommandsInfo(String commandName, String replyMessage) {
        this.commandName = commandName;
        this.replyMessage = replyMessage;
    }

    public String getCommandName() {
        return commandName;
    }
    public String getReplyMessage() {
        return replyMessage;
    }

}
