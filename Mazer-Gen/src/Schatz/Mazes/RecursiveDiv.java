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
        divide(0, 0, width, height);
        divide(0, 0, width, height / 2);
        divide(0, 0 + height / 2, width, height / 2);

    }

    private void divide(int x1, int y1, int w, int h) {
       // if (r.nextBoolean()) {
       // horz(x1, y1, w, h);
       // } else {
        vert(x1, y1, w, h);
       // }

    }

    private void horz(int x1, int y1, int w, int h) {
        int s= 2 + r.nextInt(h +1)-1;//h/2;


        for (int i = x1; i < w; i++) {
            delDown(x1 + i, y1 + s);

        }
        if (!(s <= 1)) {
            divide(x1, y1, w, s);
        }
        if(!(h-s<=1)){
            divide(x1, y1 + s, w, (h-s));
        }
    }

    private void vert(int x1, int y1, int w, int h) {
        int s= 2 + r.nextInt(w +1)-1;//w/2;


        for (int i = y1; i < h; i++) {
            delLeft(x1 + s, y1+i);

        }
        if (!(s <= 1)) {
            divide(x1, y1, s, h);
        }
        if(!(w-s<=1)){
            divide(x1+s, y1, (w-s), h);
        }
    }
}