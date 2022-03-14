package ru.netology.clientserver.homework.task2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class Server {
    protected static final int PORT = 8004;
    private static final String HOST = "localhost";


    protected void start() {
        try {
            final ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(HOST,PORT));

            while (true) {
                try (SocketChannel socketChannel = serverSocketChannel.accept()) {
                    final ByteBuffer input = ByteBuffer.allocate(2<<10);

                    while (socketChannel.isConnected()) {
                        int bytesCount = socketChannel.read(input);
                        if (bytesCount == -1) {
                            break;
                        }
                        final String inputLine = new String(input.array(), 0, bytesCount, StandardCharsets.UTF_8);
                        input.clear();
                        System.out.printf("The line has gotten: %s\n", inputLine);

                        String lineWithoutSpaces = inputLine.replaceAll("\\s", "");
                        socketChannel.write(ByteBuffer.wrap(lineWithoutSpaces.getBytes(StandardCharsets.UTF_8)));
                    }
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
