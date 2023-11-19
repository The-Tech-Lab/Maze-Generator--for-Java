package Base;

import Mazes.*;


import javax.swing.*;
import java.util.Scanner;

public class GUILauncher {

    public static void main(String[] args) {
        GUI gui = new GUI();
        Maze maze;
        String Type;
        int width = 0, height = 0, size = 0, offsetX, offsetY;
        boolean watch;
        gui.main(args);

        while (!gui.Done) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Scanner read = new Scanner(gui.End);//.useDelimiter(".");
        Type = read.next();
        width = read.nextInt();
        height = read.nextInt();
        size = read.nextInt();
        watch = read.nextBoolean();
        read.close();
        offsetX = (int) (width * size * 0.05);
        offsetY = (int) (height * size * 0.05);

        gui.setSize((int) (width * size + offsetX * 2), (int) (height * size + offsetY * 2.2));
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        if (gui.getComboName(0).equals(Type)) {
            maze = new BinaryTree(width, height, size, offsetX, offsetY, watch);
        } else if (gui.getComboName(1).equals(Type)) {
            maze = new SideWinder(width, height, size, offsetX, offsetY, watch);
        } else if (gui.getComboName(2).equals(Type)) {
            maze = new HuntKill(width, height, size, offsetX, offsetY, watch);
        } else if (gui.getComboName(3).equals(Type)) {
            maze = new BackTrack(width, height, size, offsetX, offsetY, watch);
        } else if (gui.getComboName(4).equals(Type)) {
            maze = new RecursiveDiv(width, height, size, offsetX, offsetY, watch);
        } else {
            maze = new BinaryTree(width, height, size, offsetX, offsetY, watch);
        }


        Viewer view = new Viewer(maze, watch, true, width * size, height * size);
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                maze.work();
            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                view.init();
            }
        };

        gui.setContentPane(view);

        thread2.start();
        gui.setVisible(true);
        thread1.start();


    }


}
