package com.company;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Electra {

    public static void printElec(String[][] mat, ArrayList<Camera> mas){

        double C;
        String[][] mat1 = new String[10][10];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                switch (mat[i][j]) {
                    case " XXX " -> mat1[i][j] = "XXX";
                    case "Infinity" -> mat1[i][j] = " ∞ ";
                    case "null" -> mat1[i][j] = "---";
                    default -> mat1[i][j] = String.format("%.3s", mat[i][j]);
                }
            }
        }

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("\t\t|  XT4  |  XT3  | XT30  |BMPCC6K|BMPCC4K| BMPCC |A7sIII | A7sII | A7sI  | a6600 |");
        System.out.println("-----------------------------------------------------------------------------------------");
        for (int i = 0; i < mat1.length; i++) {
            System.out.print(mas.get(i).pName+"|");
            for (int j = 0; j < mat1[0].length; j++) {
                System.out.print("   " + mat1[i][j] + "  ");
            }
            System.out.println("|");
        }
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    public static String[][] electraMethod(ArrayList<Camera> mas, double C) {

        String[][] mat = new String[10][10];

        for (int i = 0; i < mas.size(); i++) {
            for (int j = 0; j < mas.size(); j++) {

                mas.get(i).P = 0;
                mas.get(i).N = 0;
                mas.get(j).P = 0;
                mas.get(j).N = 0;

                if (mas.get(i).weight > mas.get(j).weight) {
                    mas.get(i).N += 1;
                } else if (mas.get(i).weight < mas.get(j).weight) {
                    mas.get(i).P += 1;
                }

                if (mas.get(i).crop > mas.get(j).crop) {
                    mas.get(i).N += 5;
                } else if (mas.get(i).crop < mas.get(j).crop) {
                    mas.get(i).P += 5;
                }

                if (mas.get(i).resolution > mas.get(j).resolution) {
                    mas.get(i).P += 4;
                } else if (mas.get(j).resolution < mas.get(j).resolution) {
                    mas.get(i).N += 4;
                }

                if (mas.get(i).fps > mas.get(j).fps) {
                    mas.get(i).P += 2;
                } else if (mas.get(i).fps < mas.get(j).fps) {
                    mas.get(i).N += 2;
                }

                if (mas.get(i).iso > mas.get(j).iso) {
                    mas.get(i).P += 5;
                } else if (mas.get(i).iso < mas.get(j).iso) {
                    mas.get(i).N += 5;
                }

                if (mas.get(i).deep > mas.get(j).deep) {
                    mas.get(i).P += 2;
                } else if (mas.get(i).deep < mas.get(j).deep) {
                    mas.get(i).N += 2;
                }

                if (mas.get(i).speed > mas.get(j).speed) {
                    mas.get(i).P += 3;
                } else if (mas.get(i).speed < mas.get(j).speed) {
                    mas.get(i).N += 3;
                }

                if (mas.get(i).stabil > mas.get(j).stabil) {
                    mas.get(i).P += 4;
                } else if (mas.get(i).stabil < mas.get(j).stabil) {
                    mas.get(i).N += 4;
                }


                if (mas.get(i).name.equals(mas.get(j).name)){
                    mat[i][j] = "XXX";
                } else {
                    try {
                        mas.get(i).D = (double) mas.get(i).P / (double) mas.get(i).N;
                        if (mas.get(i).D >= C) {
                            mat[i][j] = ""+mas.get(i).D;
                        } else if (mas.get(i).D < C) {
                            mat[i][j] = "---";
                        }

                    } catch (ArithmeticException e){
                        mat[i][j] = "---";
                    }
                }
            }
        }
        return mat;
    }

    public Electra(ArrayList < Camera > mas) {

        ArrayList<Camera> mainMas = mas;
        String[][] mat = electraMethod(mainMas, 1);
        System.out.println("Метод Электра:");
        printElec(mat, mainMas);
        System.out.println("Метод Электра с ограничением ("+ 2.3 +"):");
        String[][] ogr = electraMethod(mainMas, 2.3);
        printElec(ogr, mainMas);
    }

}
