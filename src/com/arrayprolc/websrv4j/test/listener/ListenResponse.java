package com.arrayprolc.websrv4j.test.listener;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.net.Socket;

import com.arrayprolc.websrv4j.listener.ResponseListener;
import com.arrayprolc.websrv4j.response.abs.Response;
import com.arrayprolc.websrv4j.response.types.TextResponse;
import com.arrayprolc.websrv4j.status.StatusCode;

public class ListenResponse extends ResponseListener {

    @Override
    public Response reply(Socket client, BufferedReader inFromClient, DataOutputStream outToClient, String query, String method) {
        TextResponse response = new TextResponse(StatusCode.OK, client, inFromClient, outToClient);
        response.setResponseString("OK, got " + query);
        try {
            response.sendResponse();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

}
