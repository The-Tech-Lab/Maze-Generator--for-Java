package Base;

import MazeGenerator.Maze;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;


public class Viewer extends JPanel {
    private Maze maze;
    private int width;
    private int height;
    private long startTime;

    public Viewer(Maze maze, int width, int height) {
        this.width = width;
        this.height = height;
        this.maze = maze;
        startTime = System.nanoTime();
    }

    public void init() {
        while (true) {
            repaint();

            if (maze.Done) {
                if((System.nanoTime() - startTime)>400000*1000000) {
                    //startTime=System.nanoTime();
                    //maze.work();
                }
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width * maze.size + maze.offsetx * 2, height * maze.size + maze.offsety * 2);
        g.setColor(Color.WHITE);
        g.drawString("time:  " + ((System.nanoTime() - startTime) / 1000000000), 20, 20);

        if (maze.Done) {
        maze.Draw(g,Color.red,Color.black);

        }

    }


}

