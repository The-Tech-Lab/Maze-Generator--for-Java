package Mazes;

import Mazes.Cell.Cell;

import java.awt.*;

public class HuntKill extends Maze {
    public HuntKill(int width, int height, int size, int offsetx, int offsety, boolean watch) {
        super(width, height, size, offsetx, offsety,watch);

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                cells[i][j] = new Cell(i * size + offsetx, j * size + offsety, size,true);
            }
        }
    }

    @Override
    public void work() {

        x = r.nextInt(cells.length);
        y = r.nextInt(cells[x].length);
        cells[x][y].start=true;
        cells[x][y].visit();

        Point last =new Point(x,y);

        while (true) {

            while (true) {

                open = openings();
                if (!isOpen(open))
                    break;

                while (true) {

                    //try {

                    //Thread.sleep(1);
                    //} catch (InterruptedException e) {
                    //	e.printStackTrace();
                    //}

                    int num = r.nextInt(4);
                    if (!open.get(num)) {
                        // next
                        if(watch){
                            try {
                                Wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                    } else if (num == 0) {
                        Down();
                        break;
                    } else if (num == 1) {
                        Left();
                        break;
                    } else if (num == 2) {
                        Up();
                        break;
                    } else if (num == 3) {
                        Right();
                        break;
                    }

                }
                visited++;



            }

            last=new Point(x,y);
            if (visited >= total)
                break;

            while (true) {
                // find new path
                x = r.nextInt(cells.length);
                y = r.nextInt(cells[x].length);
                if (cells[x][y].visited) {
                    open = openings();
                    if (isOpen(open))
                        break;


                }
            }

        }

        cells[last.x][last.y].end=true;

        Done=true;
    }
}

