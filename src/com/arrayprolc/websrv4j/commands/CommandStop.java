package com.arrayprolc.websrv4j.commands;

import com.arrayprolc.websrv4j.command.Command;
import com.arrayprolc.websrv4j.test.main.WS4jTest;

public class CommandStop extends Command {

    public CommandStop() {
        super("stop");
        this.setDescription("Stop the server!");
    }

    @Override
    public String runCommand(String ip, boolean isLocal, String[] args, boolean isAdmin) {
        WS4jTest.getServer().disable();
        System.exit(0);
        return "Shutting down.";

    }

}
