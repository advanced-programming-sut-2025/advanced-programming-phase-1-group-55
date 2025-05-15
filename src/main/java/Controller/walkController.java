package Controller;

import model.App;
import model.Map.Location;
import model.Map.Tile;
import model.Result;
import model.User;

import java.util.*;

import static model.App.currentGame;


public class walkController {
    private int countTurns(List<Tile> path) {
        if (path == null || path.size() < 3) return 0;

        int turns = 0;
        int prevDx = path.get(1).getLocation().getX() - path.get(0).getLocation().getX();
        int prevDy = path.get(1).getLocation().getY() - path.get(0).getLocation().getY();

        for (int i = 2; i < path.size(); i++) {
            int currDx = path.get(i).getLocation().getX() - path.get(i - 1).getLocation().getX();
            int currDy = path.get(i).getLocation().getY() - path.get(i - 1).getLocation().getY();

            if (currDx != prevDx || currDy != prevDy) {
                turns++;
            }

            prevDx = currDx;
            prevDy = currDy;
        }

        return turns;
    }

    private List<Tile> dfs(int startX, int startY, int endX, int endY, Tile[][] map) {
        int n = map.length;
        int m = map[0].length;
        boolean[][] visited = new boolean[n][m];
        List<Tile> path = new ArrayList<>();
        List<Tile> result = new ArrayList<>();

        dfsHelper(startX, startY, endX, endY, map, visited, path, result);

        return result.isEmpty() ? null : result;
    }

    private boolean dfsHelper(int x, int y, int endX, int endY, Tile[][] map, boolean[][] visited, List<Tile> path, List<Tile> result) {
        int n = map.length;
        int m = map[0].length;

        if (x < 0 || y < 0 || x >= n || y >= m || visited[x][y] || !map[x][y].isWalkable()) {
            return false;
        }

        visited[x][y] = true;
        path.add(map[x][y]);

        if (x == endX && y == endY) {
            result.addAll(new ArrayList<>(path));
            return true;
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        for (int[] dir : directions) {
            if (dfsHelper(x + dir[0], y + dir[1], endX, endY, map, visited, path, result)) {
                return true;
            }
        }

        path.remove(path.size() - 1);
        return false;
    }


    public Result walk(String x, String y, Tile[][] map) {
        int targetX;
        int targetY;
        try {
            targetX = Integer.parseInt(x);
            targetY = Integer.parseInt(y);
        } catch (Exception e) {
            return new Result(false, "Invalid coordinates");
        }
        int startX = currentGame.currentUser.getLocation().getX();
        int startY = currentGame.currentUser.getLocation().getY();

        List<Tile> path = bfs(startX, startY, targetX, targetY, map);

        if (path == null || path.isEmpty()) {
            return new Result(false, "there is no path");
        }

        int distance = path.size() - 1;
        System.out.println("turns :" + countTurns(path));
        int energyNeeded = (int) Math.ceil((distance + 10 * countTurns(path)) / 20.0);

        System.out.println("path found :)   distance : " + distance + " needed energy :  " + energyNeeded);
        System.out.println("are you sure you want to move (yes/no)");
        Scanner scanner = new Scanner(System.in);
        String confirm = scanner.nextLine().trim().toLowerCase();

        if (confirm.equals("yes")) {
            if (currentGame.currentUser.getEnergy() >= energyNeeded) {
                currentGame.currentUser.decreaseEnergy(energyNeeded);
                Location playerTommorowLocation = new Location(targetY, targetX);
                currentGame.currentUser.setPlayerTommorowLocation(playerTommorowLocation);
                return new Result(true, "you are now moving to " + playerTommorowLocation + " remained energy : " + currentGame.currentUser.getEnergy());
            } else {
                currentGame.currentUser.setFainted(true);
                //todo shayd nyaz beshe energysh ro sefr konam
                return new Result(false, "you dont have enough energy (Fainted !)");

            }
        } else {
            return new Result(false, "move failed");
        }

    }

    private List<Tile> bfs(int startX, int startY, int endX, int endY, Tile[][] map) {
        int n = map.length;
        int m = map[0].length;

        boolean[][] visited = new boolean[n][m];
        Tile[][] parent = new Tile[n][m];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            if (x == endX && y == endY) {
                List<Tile> path = new ArrayList<>();
                Tile step = map[x][y];
                while (step != null) {
                    path.add(0, step);
                    int px = step.getLocation().getX();
                    int py = step.getLocation().getY();
                    step = parent[px][py];
                }
                return path;
            }

            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && map[nx][ny].isWalkable()) {
                    visited[nx][ny] = true;
                    parent[nx][ny] = map[x][y];
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return null;
    }
}
