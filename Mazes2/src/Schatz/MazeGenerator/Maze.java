package MazeGenerator;

import MazeGenerator.Cell.Cell;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public abstract class Maze {
    protected static int visited;
    protected static int total;
    protected int width;
    protected int height;
    public int offsetx;
    public int offsety;
    protected Cell[][] cells;
    public int Maze, size;
    public Boolean Done = false;
    protected Random r = new Random();
    protected int x;
    protected int y;
    protected boolean watch;
    protected static ArrayList<Boolean> open;
    
    
    public Maze(int width, int height, int size, int offsetx, int offsety,boolean watch) {
        this.width = width;
        this.height = height;
        cells = new Cell[width][height];
        this.Maze = Maze;
        this.size = size;
        this.offsetx = offsetx;
        this.offsety = offsety;
        Done=watch;
        this.watch=watch;

        visited = 1;
        total = width * height;

    }

    public void Draw(Graphics g, Color color0, Color color1){
        g.setColor(color1);
        g.fillRect(0, 0, width * size + offsetx * 2, height * size + offsety * 2);

        g.setColor(color0);

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                cells[i][j].draw(g,color0,color1);

            }
        }

    }


    public abstract void work();



    // Move

    protected boolean isOpen(ArrayList<Boolean> open) {
        for (int i = 0; i < open.size(); i++) {
            if (open.get(i))
                return true;
        }
        return false;
    }


    // 0-down,1-left,2-up,3-right
    protected ArrayList<Boolean> openings() {
        ArrayList<Boolean> open = new ArrayList<Boolean>(4);

        if (y + 2 > height || cells[x][y + 1].visited) {
            open.add(false);
        } else
            open.add(true);

        if (x - 1 < 0 || cells[x - 1][y].visited) {
            open.add(false);
        } else
            open.add(true);

        if (y - 1 < 0 || cells[x][y - 1].visited) {
            open.add(false);
        } else
            open.add(true);

        if (x + 2 > width || cells[x + 1][y].visited) {
            open.add(false);
        } else
            open.add(true);

        return open;

    }

    protected void Left() {
        x--;
        cells[x][y].visit();
        delRight(x, y);
    }

    protected void Right() {
        x++;
        cells[x][y].visit();
        delLeft(x, y);
    }

    protected void Up() {
        y--;
        cells[x][y].visit();
        delDown(x, y);
    }

    protected void Down() {
        y++;
        cells[x][y].visit();
        delUp(x, y);
    }

    // 0-down,1-left,2-up,3-right
    protected void delUp(int x, int y) {
        cells[x][y].eraseUp();
        if (y - 1 >= 0)
            cells[x][y - 1].eraseDown();

    }

    protected void delDown(int x, int y) {
        cells[x][y].eraseDown();
        if (y + 1 < height)
            cells[x][y + 1].eraseUp();
    }

    protected void delRight(int x, int y) {
        cells[x][y].eraseRight();
        if (x + 1 < width)
            cells[x + 1][y].eraseLeft();
    }

    protected void delLeft(int x, int y) {
        cells[x][y].eraseLeft();
        if (x - 1 >= 0)
            cells[x - 1][y].eraseRight();
        
    }

    protected void Wait() throws InterruptedException {
            Thread.sleep(5);

    }


}
