package com.arrayprolc.websrv4j.command;

import java.util.ArrayList;

import com.arrayprolc.websrv4j.commands.CommandStop;

public class CommandManager {

    private static CommandManager manager;
    public ArrayList<Command> commands = new ArrayList<Command>();

    public static CommandManager getInstance() {
        if (manager == null) {
            manager = new CommandManager();
        }
        return manager;
    }

    public static void initCommands() {
        getInstance().commands.add(new CommandStop());
    }

}