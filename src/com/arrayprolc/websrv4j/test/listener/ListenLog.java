package com.arrayprolc.websrv4j.test.listener;

import com.arrayprolc.websrv4j.listener.LogListener;

public class ListenLog extends LogListener {

    @Override
    public void log(String prefix, String[] message) {
        for(String s : message) System.out.println("[" + prefix.replace("[", "").replace("]", "") + "] " + s);
    }

}
