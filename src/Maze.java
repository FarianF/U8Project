import java.util.ArrayList;
public class Maze {
    private String[][] maze;
    private int point1;
    private int point2;

    private String pointForList;
    private ArrayList<String> pointList;


    public Maze(String[][] maze){
        this.maze = maze;
        this.point1 = 0;
        this.point2 = 0;
    }

    public String[][] getMaze(){
        return maze;
    }

    public int getPoint1(){
        return point1;
    }

    public int getPoint2(){
        return point2;
    }

    public void makePoint(int point1, int point2){
        pointForList = point1 + "," + point2;
    }

    public void addPointToList(){
        pointList.add(pointForList);
    }

    public boolean canGoNorth(){
        try {
            String north = maze[point1-1][point2];
            if(north.equals("#")){
                return false;
            }
        }
        catch (IndexOutOfBoundsException e){
            return false;
        }
        point1 = point1-1;
        makePoint(point1, point2);
        addPointToList();
        return true;
    }

    public boolean canGoEast(){
        try {
            String east = maze[point1][point2+1];
            if(east.equals("#")){
                return false;
            }
        } catch (IndexOutOfBoundsException e){
            return false;
        }
        point2 = point2+1;
        makePoint(point1, point2);
        addPointToList();
        return true;
    }

    public boolean canGoSouth(){
        try {
            String south = maze[point1+1][point2];
            if(south.equals("#")){
                return false;
            }
        } catch (IndexOutOfBoundsException e){
            return false;
        }
        point1 = point1+1;
        makePoint(point1, point2);
        addPointToList();
        return true;
    }

    public boolean canGoWest(){
        try{
            String west = maze[point1][point2-1];
            if(west.equals("#")){
                return false;
            }
        } catch (IndexOutOfBoundsException e){
            return false;
        }
        point2 = point2-1;
        makePoint(point1, point2);
        return true;
    }

    public void checkList(){
        if(pointList.contains(pointForList)){

        } else {
            addPointToList();
        }
    }


}

