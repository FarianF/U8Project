import java.util.ArrayList;

public class Maze {
    private String[][] maze;
    private ArrayList<String> path;

    public Maze(String[][] maze) {
        this.maze = maze;
        this.path = new ArrayList<>();
    }

    public ArrayList<String> solveMaze() {
        explore(0, 0);
        // Reverse the path to print it in the correct order
        ArrayList<String> reversedPath = new ArrayList<>();
        for (int i = path.size() - 1; i >= 0; i--) {
            reversedPath.add(path.get(i));
        }
        return reversedPath;
    }

    private boolean explore(int x, int y) {
        // Base case: If we reach the end of the maze
        if (x == maze.length - 1 && y == maze[0].length - 1) {
            path.add("(" + x + ", " + y + ")");
            return true;
        }

        // Check if current position is valid and not already visited
        if (isValid(x, y)) {
            // Mark current position as visited
            maze[x][y] = "#";

            // Explore all possible directions
            if (explore(x + 1, y) || explore(x, y + 1) || explore(x - 1, y) || explore(x, y - 1)) {
                path.add("(" + x + ", " + y + ")");
                return true;
            }

            // If no path found from this position, backtrack
            maze[x][y] = ".";
        }

        return false;
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y].equals(".");
    }
}
