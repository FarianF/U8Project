import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[][] maze = getMaze("src/maze1");
        Maze maze1 = new Maze(maze);
        for(int row = 0; row < maze1.getMaze().length; row++){
            for(int col = 0; col < maze1.getMaze()[0].length; col++){
                if(maze1.canGoEast()){
                    System.out.println(maze1.getPoint1() + "," + maze1.getPoint2());
                } else if (maze1.canGoWest()) {
                    System.out.println(maze1.getPoint1() + "," + maze1.getPoint2());
                } else if (maze1.canGoSouth()) {
                    System.out.println(maze1.getPoint1() + "," + maze1.getPoint2());
                } else if (maze1.canGoNorth()) {
                    System.out.println(maze1.getPoint1() + "," + maze1.getPoint2());
                }
            }
        }


    }

    public static String[][] getMaze(String fileName) {
        File f = new File(fileName);
        Scanner s = null;
        try {
            s = new Scanner(f);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(1);
        }

        ArrayList<String> fileData = new ArrayList<String>();
        while (s.hasNextLine())
            fileData.add(s.nextLine());

        int rows = fileData.size();
        int cols = fileData.get(0).length();

        String[][] maze = new String[rows][cols];

        for (int i = 0; i < fileData.size(); i++) {
            String d = fileData.get(i);
            for (int j = 0; j < d.length(); j++) {
                maze[i][j] = String.valueOf(d.charAt(j));
            }
        }
        return maze;

    }

}