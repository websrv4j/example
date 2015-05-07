package com.arrayprolc.websrv4j.command;

import java.util.Scanner;

import com.arrayprolc.websrv4j.webserver.WebServer;

/**
 * Not important, just manages commands to stop the server.
 * 
 * @author Justin
 *
 */
public class CommandInterpreter {

    public WebServer f;

    public CommandInterpreter() {
    }

    @SuppressWarnings("resource")
    public void listen() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("");
            String s = sc.nextLine();
            interpret(s);
        }
    }

    public void interpret(String s) {
        String commandName;
        String[] args;
        if (s.contains(" ")) {
            commandName = s.split(" ")[0];
            args = getArgs(s).split(" ");
        } else {
            commandName = s;
            args = new String[] {};
        }
        for (Command command : CommandManager.getInstance().commands) {
            if (command.getName().equalsIgnoreCase(commandName)) {
                try {
                    System.out.println(command.runCommand("127.0.0.1", true, args, true));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                return;
            }
        }
        for (Command command : CommandManager.getInstance().commands) {
            for (String subName : command.getSubNames()) {
                try {
                    if (subName.equalsIgnoreCase(commandName)) {
                        System.out.println(command.runCommand("127.0.0.1", true, args, true));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                return;

            }
        }
        System.out.println("[ERROR] Unknown command. Use \"help\" command to get a list of commands.");
        return;
    }

    public String getArgs(String s) {
        String remove = s.split(" ")[0];
        s = s.replaceFirst(remove + " ", "");
        return s;
    }

}