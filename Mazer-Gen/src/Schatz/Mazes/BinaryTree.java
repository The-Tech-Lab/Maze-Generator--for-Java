package Mazes;

import Mazes.Cell.Cell;

public class BinaryTree extends Maze {
    public BinaryTree(int width, int height, int size, int offsetx, int offsety, boolean watch) {
        super(width, height, size, offsetx, offsety,watch);

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                cells[i][j] = new Cell(i * size + offsetx, j * size + offsety, size,true);
            }
        }
    }

    @Override
    public void work() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                if (j == width - 1 && i == 0) {
                    delDown(j, i);
                    delLeft(j, i);
                } else if (i == 0) {
                    delRight(j, i);
                } else if (j == width - 1) {
                    delUp(j, i);
                } else if (r.nextBoolean()) {
                    delUp(j, i);
                } else {
                    delRight(j, i);
                }
                if(watch){
                    try {
                        Wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }

        }
        // entrance&exit
        delDown(0, height - 1);
        cells[0][height-1].start=true;
        delDown(width - 1, 0);
        cells[width-1][0].end=true;

        Done =true;
    }
}

