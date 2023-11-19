import Base.GUILauncher;
import Mazes.*;
import Mazes.Cell.Cell;

public class MazeGenerator {

    Maze maze;

    public static void main(String[] args) {
        GUILauncher.main(args);

    }

    public MazeGenerator(String Type, int width, int height) {


        switch (Type) {
            case "BinaryTree":
                maze = new BinaryTree(width, height, 1, 1, 1, false);
                break;
            case "SideWinder":
                maze = new SideWinder(width, height, 1, 1, 1, false);
                break;
            case "HuntKill":
                maze = new HuntKill(width, height, 1, 1, 1, false);
                break;
            case "BackTrack":
                maze = new BackTrack(width, height, 1, 1, 1, false);
                break;
            default:
                maze = new BackTrack(width, height, 1, 1, 1, false);
                break;
        }
        maze.work();
    }

    public Cell[][] getMaze() {
        return maze.getCells();
    }
}
