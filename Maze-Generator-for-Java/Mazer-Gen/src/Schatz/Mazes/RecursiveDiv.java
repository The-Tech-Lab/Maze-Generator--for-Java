package Mazes;

import Mazes.Cell.Cell;

public class RecursiveDiv extends Maze {

    public RecursiveDiv(int width, int height, int size, int offsetx, int offsety, boolean watch) {
        super(width, height, size, offsetx, offsety, watch);

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                cells[i][j] = new Cell(i * size + offsetx, j * size + offsety, size, false);
            }
        }
    }

    @Override
    public void work() {
        //drawsquare
        for (int i = 0; i <= width - 1; i++) {
            delUp(i, 0);
        }
        for (int i = 0; i <= width - 1; i++) {
            delDown(i, height - 1);
        }
        for (int i = 0; i <= height - 1; i++) {
            delLeft(0, i);
        }
        for (int i = 0; i <= height - 1; i++) {
            delRight(width - 1, i);
        }


        //draw maze
        divide(0, 0, width, height);
        Done = true;

    }

    private void divide(int x1, int y1, int w, int h) {


        if (r.nextBoolean()) {
            horizontal(x1, y1, w, h);
            if (h <= 1)
                divide(x1, y1, w, h);
        } else {
            vertical(x1, y1, w, h);
            if (w <= 1)
                divide(x1, y1, w, h);
        }

    }

    private void vertical(int x1, int y1, int w, int h) {
        //check if too small

        // find vertical middle
        int m = r.nextInt(w - 1) + 1;

        //create line
        int opening = r.nextInt(h) - 1;
        for (int i = 0; i <= h - 1; i++) {
            if (i != opening)
                delLeft(x1 + m, y1 + i);

        }
        //split


        //left
        divide(x1, y1, m, h);
        //right
        divide(x1 + m, y1, w - m, h);
    }

    private void horizontal(int x1, int y1, int w, int h) {
        //check if too small
        if (h <= 1)
            return;
        // find horizontal middle
        int m = r.nextInt(h - 1) + 1;

        //create line
        int opening = r.nextInt(w) - 1;
        for (int i = 0; i <= w - 1; i++) {
            if (i != opening)
                delUp(x1 + i, y1 + m);

        }
        //split


        //up
        divide(x1, y1, w, m);
        //down
        divide(x1, y1 + m, w, h - m);
    }


}