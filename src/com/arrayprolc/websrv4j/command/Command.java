package com.arrayprolc.websrv4j.command;

/**
 * Not important, just manages commands to stop the server.
 * 
 * @author Justin
 *
 */
public abstract class Command {

    private String name;
    private String[] subNames;
    private String description = "undefined";
    private boolean requiresLogin = true;
    private static Command instance;

    public Command(String name) {
        this.name = name;
        this.subNames = new String[] {};
        instance = this;
    }

    public static Command getInstance() {
        return instance;
    }

    /**
     * For use inside of
     */
    String prepareCommandForRun(String ipAddress, boolean isLocal, String[] args, boolean isAdmin) {
        if (isRequiresLogin() && !isAdmin) {
            return "FAILED: You must be logged in to use that command!";
        }
        return runCommand(ipAddress, isLocal, args, isAdmin);
    }

    public abstract String runCommand(String ipAddress, boolean isLocal, String[] args, boolean isAdmin);

    public String throwError(String error) {
        System.out.println("[COMMAND ERROR] " + error);
        return "[COMMAND ERROR] " + error;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getSubNames() {
        return subNames;
    }

    public void setSubNames(String[] subNames) {
        this.subNames = subNames;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isRequiresLogin() {
        return requiresLogin;
    }

    public void setRequiresLogin(boolean requiresLogin) {
        this.requiresLogin = requiresLogin;
    }

}
