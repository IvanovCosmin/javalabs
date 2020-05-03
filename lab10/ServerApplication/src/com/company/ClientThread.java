package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public  class ClientThread extends Thread {
    private Socket socket = null;
    ClientThread(Socket socket) {
        this.socket = socket;
    }
    public void run () {
        try {
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            String request = input.readLine();

            PrintWriter output = new PrintWriter(socket.getOutputStream());
            if (request.equals("stop")) {
                String response = "Server says bye bye";
                output.println(response);
                output.flush();
                socket.close();
                System.exit(0);
            }
            String response = "Server received this request: " + request;
            output.println(response);
            output.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try{
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
