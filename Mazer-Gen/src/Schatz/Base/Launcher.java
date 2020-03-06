package Base;

import Mazes.*;


import javax.swing.JFrame;
import java.util.Scanner;



class launcher {
    private static Maze maze;
    static Thread thread;
    private static Viewer view;
    public static int offsetx;
    public static int offsety;
    private static Scanner scan;
    private static int size;
    private static int height,width;
    private static boolean watch;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        scan = new Scanner(System.in);
        System.out.print("width: ");
        width = scan.nextInt();//1000;
        System.out.print("height: ");
        height = scan.nextInt();
        System.out.print("cell size: ");
        size = scan.nextInt();
        watch= false;


        offsetx = (int) (width*size * 0.05);
        offsety = (int) (height*size * 0.05);
        pick();
        scan.close();

        JFrame f = new JFrame("Maze");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize((int) (width*size + offsetx * 2), (int) (height*size + offsety * 2.2));
        f.setVisible(true);



        view = new Viewer(maze, width*size, height*size);
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

        f.add(view);
        thread1.start();
        thread2.start();

        System.out.println(1);
    }
    private static void pick(){

        System.out.print("mazeType(0: binarytree 1: sidewinder 2: HuntKill): ");
        int mType= scan.nextInt();

        switch (mType){
            case 0:
                maze= new BinaryTree(width,height,size,offsetx,offsety, watch);
                break;
            case 1:
                maze= new SideWinder(width,height,size,offsetx,offsety, watch);
                break;
            case 2:
                maze = new HuntKill(width, height, size, offsetx, offsety, watch);
                break;
            default:
                System.out.println("invalid");
                pick();
                break;

        }


    }


}

