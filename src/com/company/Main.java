package com.company;

import java.util.ArrayList;

public class Main {

    public static ArrayList<Camera> makeArrayPar() {
        Camera XT4 = new Camera("X-T4", "  X-T4 ", 501, 1.5D, 4, 60, 640, 10422, 400, true);
        Camera XT3 = new Camera("X-T3", "  X-T3 ", 539, 1.5D, 4, 60, 640, 10422, 400, false);
        Camera XT30 = new Camera("X-T30", "  X-T30", 680, 1.5D, 4, 30, 640, 10420, 200, false);
        Camera BMPCC6K = new Camera("BMPCC6K", "BMPCC6K", 499, 1.0D, 6, 60, 3200, 12422, 483, false);
        Camera BMPCC4K = new Camera("BMPCC4K", "BMPCC4K", 680, 1.9D, 4, 60, 3200, 12422, 203, false);
        Camera BMMCC = new Camera("BMMCC", " BMMCC ", 700, 1.9D, 1, 0, 600, 10422, 65, false);
        Camera A7sIII = new Camera("A7sIII", " A7sIII", 500, 1.0D, 4, 120, 800, 10422, 300, true);
        Camera A7sII = new Camera("A7sII", " A7sII ", 627, 1.0D, 4, 30, 100, 8420, 100, true);
        Camera A7sI = new Camera("A7sI", "  A7sI ", 699, 1.0D, 4, 30, 100, 8420, 28, false);
        Camera a6600 = new Camera("a6600", " a6600 ", 503, 1.5D, 4, 30, 100, 8420, 200, true);
        ArrayList<Camera> mainMas = new ArrayList();
        mainMas.add(XT4);
        mainMas.add(XT3);
        mainMas.add(XT30);
        mainMas.add(BMPCC6K);
        mainMas.add(BMPCC4K);
        mainMas.add(BMMCC);
        mainMas.add(A7sIII);
        mainMas.add(A7sII);
        mainMas.add(A7sI);
        mainMas.add(a6600);
        return mainMas;
    }

    public static ArrayList<Camera> makeArrayEl() {
        Camera XT4 = new Camera("X-T4", "  X-T4 ", 5, 10, 10, 10, 10, 15, 15, 15);
        Camera XT3 = new Camera("X-T3", "  X-T3 ", 10, 10, 10, 10, 10, 15, 15, 5);
        Camera XT30 = new Camera("X-T30", "  X-T30", 15, 10, 10, 5, 10, 10, 10, 5);
        Camera BMPCC6K = new Camera("BMPCC6K", "BMPCC6K", 5, 5, 15, 10, 15, 20, 15, 5);
        Camera BMPCC4K = new Camera("BMPCC4K", "BMPCC4K", 15, 15, 10, 10, 15, 20, 10, 5);
        Camera BMMCC = new Camera("BMMCC", " BMMCC ", 15, 15, 5, 5, 10, 15, 5, 5);
        Camera A7sIII = new Camera("A7sIII", " A7sIII", 5, 5, 10, 15, 15, 15, 10, 15);
        Camera A7sII = new Camera("A7sII", " A7sII ", 10, 5, 10, 5, 5, 5, 5, 15);
        Camera A7sI = new Camera("A7sI", "  A7sI ", 15, 5, 10, 5, 5, 5, 5, 5);
        Camera a6600 = new Camera("a6600", " a6600 ", 5, 10, 10, 5, 5, 5, 10, 15);
        ArrayList<Camera> mainMas = new ArrayList();
        mainMas.add(XT4);
        mainMas.add(XT3);
        mainMas.add(XT30);
        mainMas.add(BMPCC6K);
        mainMas.add(BMPCC4K);
        mainMas.add(BMMCC);
        mainMas.add(A7sIII);
        mainMas.add(A7sII);
        mainMas.add(A7sI);
        mainMas.add(a6600);
        return mainMas;
    }


    public static void main(String[] args) {
        ArrayList<Camera> parMas = makeArrayPar();
        new Pareto(parMas);
        ArrayList<Camera> elMas = makeArrayEl();
        new Electra(elMas);


    }
}
