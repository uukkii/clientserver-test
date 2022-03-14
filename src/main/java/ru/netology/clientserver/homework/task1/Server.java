package ru.netology.clientserver.homework.task1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    protected static final int PORT = 8003;

    protected void start() {
        try (ServerSocket serverSocket = new ServerSocket(PORT);
             Socket socket = serverSocket.accept();
             PrintWriter output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
             BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            int nNumber = Integer.parseInt(input.readLine());
            System.out.printf("The number %d has gotten.", nNumber);
            int fibonacciNumber = calculateFibonacciNumber(nNumber);
            String line = String.valueOf(fibonacciNumber);
            output.println(line);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    protected int calculateFibonacciNumber(int number) {
        if (number == 1 || number == 0) {
            return number;
        }
        int number0 = 0, number1 = 1;
        int temp;
        for (int i = 2; i < number; i++) {
            temp = number0 + number1;
            number0 = number1;
            number1 = temp;
        }
        return number1;
    }
}
