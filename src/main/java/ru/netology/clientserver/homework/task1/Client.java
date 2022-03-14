package ru.netology.clientserver.homework.task1;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

import static ru.netology.clientserver.homework.task1.Server.PORT;

public class Client {

    private static final String IP = "127.0.0.1";

    protected void start() {
        try (Socket socket = new Socket(IP, PORT);
             BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
             Scanner console = new Scanner(System.in)) {
            System.out.println("Input N number: ");
            String inputNumber = console.nextLine();
            output.println(inputNumber);
            System.out.printf("Your Fibonacci number: %s", input.readLine());
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
