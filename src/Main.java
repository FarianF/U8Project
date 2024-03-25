import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[][] maze = getMaze("src/maze1");
        Maze maze1 = new Maze(maze);
        System.out.println("Solution path:");
        for (String point : maze1.solveMaze()) {
            System.out.println(point);
        }
    }

    public static String[][] getMaze(String fileName) {
        File f = new File(fileName);
        Scanner s = null;
        try {
            s = new Scanner(f);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(1);
        }

        int rows = 0;
        int cols = 0;
        while (s.hasNextLine()) {
            rows++;
            String line = s.nextLine();
            cols = Math.max(cols, line.length());
        }

        String[][] maze = new String[rows][cols];

        try (Scanner scanner = new Scanner(f)) {
            int row = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                for (int col = 0; col < line.length(); col++) {
                    maze[row][col] = String.valueOf(line.charAt(col));
                }
                row++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(1);
        }

        return maze;
    }
}
