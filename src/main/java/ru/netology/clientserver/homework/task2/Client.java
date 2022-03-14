package ru.netology.clientserver.homework.task2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static ru.netology.clientserver.homework.task2.Server.PORT;

public class Client {

    private static final String IP = "127.0.0.1";
    private static final String EXIT_WORD = "end";

    protected void start() {
        InetSocketAddress inetSocketAddress = new InetSocketAddress(IP, PORT);
        try {
            final SocketChannel socketChannel = SocketChannel.open();
            socketChannel.connect(inetSocketAddress);

            try (Scanner console = new Scanner(System.in)) {
                final ByteBuffer input = ByteBuffer.allocate(2 << 10);
                String inputLine;

                while (true) {
                    System.out.println("Type your line or 'end' to exit:");
                    inputLine = console.nextLine();
                    if (EXIT_WORD.equals(inputLine)) {
                        break;
                    }
                    socketChannel.write(ByteBuffer.wrap(inputLine.getBytes(StandardCharsets.UTF_8)));
                    Thread.sleep(2000);
                    int bytesCount = socketChannel.read(input);
                    String lineWithoutGaps = new String(input.array(), 0, bytesCount, StandardCharsets.UTF_8);
                    System.out.printf("Your line without spaces: %s\n", lineWithoutGaps);
                    input.clear();
                }
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            } finally {
                socketChannel.close();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
