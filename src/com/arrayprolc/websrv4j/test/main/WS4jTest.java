package com.arrayprolc.websrv4j.test.main;

import com.arrayprolc.websrv4j.command.CommandInterpreter;
import com.arrayprolc.websrv4j.command.CommandManager;
import com.arrayprolc.websrv4j.test.listener.ListenLog;
import com.arrayprolc.websrv4j.test.listener.ListenResponse;
import com.arrayprolc.websrv4j.webserver.WebServer;

public class WS4jTest {

    private static WebServer srv;

    public static int PORT = 4157;

    public static void main(String[] args) {
        CommandManager.initCommands();
        srv = new WebServer(new ListenLog(), new ListenResponse(), PORT);
        srv.enable();
        CommandInterpreter i = new CommandInterpreter();
        i.listen();
    }

    public static WebServer getServer() {
        return srv;
    }

}
