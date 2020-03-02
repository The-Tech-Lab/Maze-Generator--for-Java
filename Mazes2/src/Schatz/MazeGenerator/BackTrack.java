package MazeGenerator;

import MazeGenerator.Cell.Cell;

import java.awt.*;
import java.util.ArrayList;

public class BackTrack extends Maze {
    private static ArrayList<Point> path;
    private static int index;

    public BackTrack(int width, int height, int size, int offsetx, int offsety, boolean watch) {
        super(width, height, size, offsetx, offsety, watch);
        path = new ArrayList<Point>(total);
        index = 0;

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                cells[i][j] = new Cell(i * size + offsetx, j * size + offsety, size);
            }
        }
    }

    @Override
    public void work() {

        x = r.nextInt(cells.length);
        y = r.nextInt(cells[x].length);
        cells[x][y].start = true;
        cells[x][y].start=true;
        int last=1;
        path.add(new Point(x, y));


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
                path.add(index++, new Point(x, y));
                if (watch) {
                    try {
                        Wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


            }


            if (visited >= total) break;


            // find new path
            for (index = index; index >= 0; index--) {
                x = path.get(index).x;
                y = path.get(index).y;
                if (isOpen(openings())) {
                    last++;
                    break;

                }
            }


        }

        cells[path.get(path.size()-last).x][path.get(path.size()-last).y].end=true;
        Done = true;
    }
}
