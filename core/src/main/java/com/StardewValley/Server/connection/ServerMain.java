package com.StardewValley.Server.connection;

import com.StardewValley.Common.ConnectionMessage;
import com.StardewValley.Common.DataBase;
import com.StardewValley.Common.GameDetails;
import com.StardewValley.Common.Lobby;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static com.StardewValley.Common.Connection.TIMEOUT;

public class ServerMain {
    private static String ip;
    private static int port;
    private static ServerSocket serverSocket;
    private static boolean exitFlag = false;
    private static ArrayList<ClientConnection> connections = new ArrayList<>();

    private static ArrayList<Lobby> lobbies = new ArrayList<>();
    private static ArrayList<GameDetails> games = new ArrayList<>();

    public static void main(String[] args) {
        try {
            ip = "localhost";
            port = 8080;
            serverSocket = new ServerSocket(port);
            System.out.println("Listening on port " + port);
        } catch (Exception e) {
            System.err.println("Could not start the server");
            e.printStackTrace();
        }

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
        Runnable refreshStatus = () -> {
            ArrayList<String> onlineUsers = new ArrayList<>();
            ArrayList<ClientConnection> onlineConnections = new ArrayList<>();
            Iterator<ClientConnection> it = connections.iterator();
            while (it.hasNext()) {
                ClientConnection connection = it.next();
                if (connection.refreshStatus()) {
                    System.out.println(connection.getUsername() + " has refreshed");
                    connection.setLastRefresh(System.currentTimeMillis());
                } else if (System.currentTimeMillis() - connection.getLastRefresh() > 30 * 1000 || !connection.isAlive()) {
                    System.out.println("connection ended: " + connection.getUsername());
                    connection.end();
                    continue;
                }
                if (!connection.getUsername().isEmpty()) {
                    System.out.println(connection.getUsername() + ":::::");
                }
                if (!connection.getUsername().isEmpty() && !connection.isInGame()) {
                    String info = connection.getUsername();
                    if (!connection.getLobbyCode().isEmpty()) {
                        Lobby lobby = getLobbyByCode(connection.getLobbyCode());
                        if (lobby == null) {
                            continue;
                        }
                        info += " : " + lobby.getName() + "(" + lobby.getCode() + ")";
                    }
                    onlineUsers.add(info);
                    onlineConnections.add(connection);
                }
            }
            ConnectionMessage message = new ConnectionMessage(new HashMap<>() {{
                put("information", "online_users");
                put("online_users", onlineUsers);
            }}, ConnectionMessage.Type.inform);

            for (ClientConnection connection : onlineConnections) {
                System.out.println(connection.getUsername());
                connection.sendMessage(message);
            }
        };
        Runnable checkLobbies = () -> {
            Long time = System.currentTimeMillis();
            Iterator<Lobby> it = lobbies.iterator();
            while (it.hasNext()) {
                Lobby lobby = it.next();
                if (time - lobby.getLastJoin() > (3 * 60 * 1000)) {
                    lobby.terminate();
                }
            }
        };

        scheduler.scheduleAtFixedRate(refreshStatus, 10, 3, TimeUnit.SECONDS);
        scheduler.scheduleAtFixedRate(checkLobbies, 10, 3, TimeUnit.SECONDS);


        try {
            serverSocket.setSoTimeout(TIMEOUT);
            while (!exitFlag) {
                try {
                    Socket socket = serverSocket.accept();
                    handleConnection(socket);
                } catch (SocketTimeoutException e) {
                    continue;
                } catch (Exception e) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            serverSocket.close();
        } catch (Exception ignored) {
        }
    }

    public static void handleConnection(Socket socket) {
        if (socket == null) {
            return;
        }
        try {
            new ClientConnection(socket, ip, port).start();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                socket.close();
            } catch (Exception ignored) {
            }
        }

    }

    public static ClientConnection getConnectionByUsername(String username) {
        for (ClientConnection connection : connections) {
            if (connection.getUsername().equals(username)) {
                return connection;
            }
        }
        return null;
    }

    public static boolean isEnded() {
        return exitFlag;
    }

    public static List<ClientConnection> getConnections() {
        return List.copyOf(connections);
    }

    public static void addConnection(ClientConnection connection) {
        if (connection != null && !connections.contains(connection)) {
            connections.add(connection);
        }
    }

    public static void removeConnection(ClientConnection connection) {
        if (connection != null) {
            connections.remove(connection);
        }
    }

    public static void addLobby(Lobby lobby) {
        lobbies.add(lobby);
    }

    public static void removeLobby(Lobby lobby) {
        lobbies.remove(lobby);
    }

    public static ArrayList<Lobby> getLobbies() {
        return lobbies;
    }

    public static Lobby getLobbyByCode(String code) {
        for (Lobby lobby : lobbies) {
            if (lobby.getCode().equals(code)) {
                return lobby;
            }
        }
        return null;
    }

    public static void addGame(GameDetails game) {
        games.add(game);
    }

    public static void removeGame(GameDetails game) {
        games.remove(game);
    }

    public static ArrayList<GameDetails> getGames() {
        return games;
    }

    public static GameDetails getGameById(int id) {
        for (GameDetails game : games) {
            if (game.getGameId() == id) {
                return game;
            }
        }
        return null;
    }

    public static String getIp() {
        return ip;
    }

    public static void setIp(String ip) {
        ServerMain.ip = ip;
    }

    public static int getPort() {
        return port;
    }

    public static void setPort(int port) {
        ServerMain.port = port;
    }

    public static ServerSocket getServerSocket() {
        return serverSocket;
    }

    public static void setServerSocket(ServerSocket serverSocket) {
        ServerMain.serverSocket = serverSocket;
    }

    public static boolean isExitFlag() {
        return exitFlag;
    }

    public static void setExitFlag(boolean exitFlag) {
        ServerMain.exitFlag = exitFlag;
    }

    public static void setConnections(ArrayList<ClientConnection> connections) {
        ServerMain.connections = connections;
    }

    public static void setLobbies(ArrayList<Lobby> lobbies) {
        ServerMain.lobbies = lobbies;
    }

    public static void setGames(ArrayList<GameDetails> games) {
        ServerMain.games = games;
    }

}
