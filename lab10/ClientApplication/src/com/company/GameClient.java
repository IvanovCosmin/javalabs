package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class GameClient {
    GameClient () throws IOException {
        String serverAddr = "127.0.0.1";
        int PORT = 8082;
        while (true) {
            Socket socket = new Socket(serverAddr, PORT);
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader input = new BufferedReader( new InputStreamReader(socket.getInputStream()));
            Scanner keyboard = new Scanner(System.in);
            System.out.print("CMD>");
            String request = keyboard.nextLine();
            if (request.equals("exit")) {
                System.out.println("Bye bye");
                System.exit(0);
            }
            output.println(request);

            String response = input.readLine();
            System.out.println(response);
        }
    }
}
