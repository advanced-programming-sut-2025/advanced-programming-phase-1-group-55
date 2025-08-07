package com.StardewValley.Server.Controller;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class GameServer {

    private ServerSocket serverSocket;
    private final int port = 12345;

    private final Map<Integer, ObjectOutputStream> clientOutputs = new ConcurrentHashMap<>();
    private final Map<Integer, PlayerInput> playerInputs = new ConcurrentHashMap<>();

    private final Map<Integer, PlayerState> gameState = new ConcurrentHashMap<>();

    private volatile boolean running = true;

    public void start() throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Server started on port " + port);

        new Thread(() -> {
            int clientId = 1;
            while (running) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("Client connected: " + clientSocket.getInetAddress());

                    int assignedId = clientId++;
                    ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
                    ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());

                    clientOutputs.put(assignedId, out);
                    playerInputs.put(assignedId, new PlayerInput());

                    out.writeInt(assignedId);
                    out.flush();

                    gameState.put(assignedId, new PlayerState(0, 0));

                    new Thread(() -> handleClient(assignedId, in)).start();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            while (running) {
                updateGameState();
                broadcastGameState();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void handleClient(int clientId, ObjectInputStream in) {
        try {
            while (running) {
                PlayerInput input = (PlayerInput) in.readObject();
                playerInputs.put(clientId, input);
            }
        } catch (Exception e) {
            System.out.println("Client " + clientId + " disconnected.");
            clientOutputs.remove(clientId);
            playerInputs.remove(clientId);
            gameState.remove(clientId);
        }
    }

    private void updateGameState() {
        for (Map.Entry<Integer, PlayerInput> entry : playerInputs.entrySet()) {
            int id = entry.getKey();
            PlayerInput input = entry.getValue();
            PlayerState state = gameState.get(id);

            if (state != null && input != null) {
                int x = state.getX() + input.getDx();
                int y = state.getY() + input.getDy();
                gameState.put(id, new PlayerState(x, y));
            }
        }
    }

    private void broadcastGameState() {
        for (Map.Entry<Integer, ObjectOutputStream> entry : clientOutputs.entrySet()) {
            try {
                ObjectOutputStream out = entry.getValue();
                out.reset();
                out.writeObject(gameState);
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() throws IOException {
        running = false;
        if (serverSocket != null) {
            serverSocket.close();
        }
    }

    public static class PlayerInput implements Serializable {
        private int dx;
        private int dy;

        public PlayerInput() {
            this.dx = 0;
            this.dy = 0;
        }

        public PlayerInput(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }

        public int getDx() {
            return dx;
        }

        public int getDy() {
            return dy;
        }
    }

    public static class PlayerState implements Serializable {
        private int x;
        private int y;

        public PlayerState(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public static void main(String[] args) {
        try {
            new GameServer().start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
