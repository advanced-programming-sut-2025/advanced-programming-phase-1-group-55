package com.StardewValley.Client;

import com.StardewValley.Server.Controller.GameServer;

import java.io.*;
import java.net.*;
import java.util.Map;
import java.util.Scanner;

public class GameClient {

    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    private int playerId;
    private volatile boolean running = true;

    public void start(String host, int port) throws IOException, ClassNotFoundException {
        socket = new Socket(host, port);
        out = new ObjectOutputStream(socket.getOutputStream());
        in = new ObjectInputStream(socket.getInputStream());

        playerId = in.readInt();
        System.out.println("Connected to server. Player ID: " + playerId);

        new Thread(() -> {
            try {
                while (running) {
                    Map<Integer, GameServer.PlayerState> gameState = (Map<Integer, GameServer.PlayerState>) in.readObject();
                    printGameState(gameState);
                }
            } catch (Exception e) {
                System.out.println("Disconnected from server.");
                running = false;
            }
        }).start();

        Scanner scanner = new Scanner(System.in);
        while (running) {
            System.out.println("Enter movement (dx dy), e.g. '1 0' to move right:");
            int dx = scanner.nextInt();
            int dy = scanner.nextInt();

            GameServer.PlayerInput input = new GameServer.PlayerInput(dx, dy);
            sendPlayerInput(input);
        }

        scanner.close();
        stop();
    }

    private void sendPlayerInput(GameServer.PlayerInput input) {
        try {
            out.writeObject(input);
            out.flush();
        } catch (IOException e) {
            System.out.println("Failed to send input to server.");
            running = false;
        }
    }

    private void printGameState(Map<Integer, GameServer.PlayerState> gameState) {
        System.out.println("=== Game State ===");
        for (Map.Entry<Integer, GameServer.PlayerState> entry : gameState.entrySet()) {
            int id = entry.getKey();
            GameServer.PlayerState state = entry.getValue();
            String you = (id == playerId) ? " (You)" : "";
            System.out.printf("Player %d%s: x=%d, y=%d\n", id, you, state.getX(), state.getY());
        }
        System.out.println("==================");
    }

    public void stop() throws IOException {
        running = false;
        if (socket != null) socket.close();
        if (in != null) in.close();
        if (out != null) out.close();
    }

    public static void main(String[] args) {
        try {
            new GameClient().start("localhost", 12345);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
