import java.util.ArrayList;

public class Maze {
    private String[][] maze;
    private int point1;
    private int point2;
    private ArrayList<String> pointList;

    public Maze(String[][] maze) {
        this.maze = maze;
        this.point1 = 0;
        this.point2 = 0;
        this.pointList = new ArrayList<>();
    }

    public ArrayList<String> solveMaze() {
        ArrayList<String> path = new ArrayList<>();
        while (point1 != maze.length - 1 || point2 != maze[0].length - 1) {
            if (canGoSouth()) {
                continue;
            }
            if (canGoEast()) {
                continue;
            }
            if (canGoNorth()) {
                continue;
            }
            if (canGoWest()) {
                continue;
            }
            // If there's no way to move, backtrack
            if (!pointList.isEmpty()) {
                String lastPoint = pointList.remove(pointList.size() - 1);
                String[] coordinates = lastPoint.split(",");
                point1 = Integer.parseInt(coordinates[0]);
                point2 = Integer.parseInt(coordinates[1]);
            } else {
                // If pointList is empty, maze is unsolvable
                System.out.println("Maze is unsolvable!");
                return path;
            }
        }
        // Add starting point to the path
        path.add("(" + 0 + ", " + 0 + ")");

        // Add all points from pointList to the path, excluding duplicates
        for (String point : pointList) {
            path.add("(" + point + ")");
        }

        return path;
    }

    public boolean canGoNorth() {
        try {
            String north = maze[point1 - 1][point2];
            if (north.equals("#")) {
                return false;
            }
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
        point1 = point1 - 1;
        String pointForList = point1 + "," + point2;
        checkList(pointForList);
        return true;
    }

    public boolean canGoEast() {
        try {
            String east = maze[point1][point2 + 1];
            if (east.equals("#")) {
                return false;
            }
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
        point2 = point2 + 1;
        String pointForList = point1 + "," + point2;
        checkList(pointForList);
        return true;
    }

    public boolean canGoSouth() {
        try {
            String south = maze[point1 + 1][point2];
            if (south.equals("#")) {
                return false;
            }
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
        point1 = point1 + 1;
        String pointForList = point1 + "," + point2;
        checkList(pointForList);
        return true;
    }

    public boolean canGoWest() {
        try {
            String west = maze[point1][point2 - 1];
            if (west.equals("#")) {
                return false;
            }
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
        point2 = point2 - 1;
        String pointForList = point1 + "," + point2;
        checkList(pointForList);
        return true;
    }

    public void checkList(String pointForList) {
        if (!pointList.contains(pointForList)) {
            pointList.add(pointForList);
        }
    }
}
