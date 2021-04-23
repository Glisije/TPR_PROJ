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

    public static ArrayList<Camera> makeArrayEl(ArrayList<Camera> oldMas) {
        ArrayList<Camera> mas = oldMas;
        ArrayList<Camera> mas1 = oldMas;
        for (int i = 0; i < mas.size(); i++) {

                if (mas.get(i).weight > 650) {
                    mas1.get(i).weight = 15;
                } else if (mas.get(i).weight >= 520 && mas.get(i).weight <= 650) {
                    mas1.get(i).weight = 10;
                } else if (mas.get(i).weight < 520){
                    mas1.get(i).weight = 5;
                }

                if (mas.get(i).crop == 1.9 ) {
                    mas1.get(i).crop = 15;
                } else if (mas.get(i).crop == 1.5 ) {
                    mas1.get(i).crop = 10;
                } else if (mas.get(i).crop == 1){
                    mas1.get(i).crop = 5;
                }

                if (mas.get(i).resolution == 6) {
                    mas1.get(i).resolution = 15;
                } else if (mas.get(i).resolution == 4) {
                    mas1.get(i).resolution = 10;
                } else if (mas.get(i).resolution == 1) {
                    mas1.get(i).resolution = 5;
                }

                if (mas.get(i).fps >= 100) {
                    mas1.get(i).fPar = 15;
                } else if (mas.get(i).fps > 50 && mas.get(i).fps < 100) {
                    mas1.get(i).fPar = 10;
                } else if (mas.get(i).fps <=50){
                    mas1.get(i).fPar = 5;
                }

                if (mas.get(i).iso >= 700) {
                    mas1.get(i).iso += 1;
                } else if (mas.get(i).iso > 500 && mas.get(i).iso < 700) {
                    mas1.get(i).iso += 1;
                } else if (mas.get(i).iso <= 500) {
                    mas1.get(i).iso += 1;
                }

                if (mas.get(i).deep == 12422) {
                    mas1.get(i).deep = 20;
                } else if (mas.get(i).deep == 10422 ) {
                    mas1.get(i).deep = 15;
                } else if (mas.get(i).deep == 10420) {
                    mas1.get(i).deep = 10;
                } else if (mas.get(i).deep == 8420) {
                    mas1.get(i).deep = 5;
                }

                if (mas.get(i).speed >= 399) {
                    mas1.get(i).speed = 15;
                } else if (mas.get(i).speed > 200 && mas.get(i).speed < 399) {
                    mas1.get(i).speed = 10;
                } else if (mas.get(i).speed <= 200){
                    mas1.get(i).speed = 5;
                }

                if (mas.get(i).stab) {
                    mas1.get(i).stabil = 15;
                } else if (!mas.get(i).stab ) {
                    mas1.get(i).stabil = 5;
                }
        }

        return mas1;
    }


    public static void main(String[] args) {
        ArrayList<Camera> parMas = makeArrayPar();
        new Pareto(parMas);
        ArrayList<Camera> elMas = makeArrayEl(parMas);
        new Electra(elMas);


    }
}
