package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

//    public static void sort(double[] array) {
//        for (int left = 0; left < array.length; left++) {
//            double value = array[left];
//            int i = left - 1;
//            for (; i >= 0; i--) {
//                if (value > array[i]) {
//                    array[i + 1] = array[i];
//                } else {
//                    break;
//                }
//            }
//            array[i + 1] = value;
//        }
//    }

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

    public static double[][] makeMAIs (double[][] arr) {
        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < 5; i++) {  //идём по строкам
                arr[j][5] *= arr[j][i];
            }
            arr[j][5] = Math.pow(arr[j][5], 0.2);
            //System.out.println(arr[j][5]);
        }
        return arr;
    }

    public static void printMAI (double[][] arr) {
        for (int i = 0; i < 5; i++) {  //идём по строкам
            System.out.print("K"+ (i+1));
            for (int j = 0; j < 9; j++) {//идём по столбцам
                System.out.print("   " + String.format("%.3f",arr[i][j]) + " "); //вывод элемента
            }
            System.out.println();//перенос строки ради визуального сохранения табличной формы
        }
        System.out.println();
    }

    public static void printMAI2 (double[][] arr) {
        for (int i = 0; i < 5; i++) {  //идём по строкам
            System.out.print("A"+ (i+1));
            for (int j = 0; j < 9; j++) {//идём по столбцам
                System.out.print("   " + String.format("%.3f",arr[i][j]) + " "); //вывод элемента
            }
            System.out.println();//перенос строки ради визуального сохранения табличной формы
        }
        System.out.println();
    }

    public static double[][] makeSandP (double[][] arr) {
        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < 5; i++) {  //идём по строкам
                arr[j][7] += arr[i][j];
            }
        }
        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < 5; i++) {  //идём по строкам
                arr[j][8] = arr[j][7]*arr[j][6];
            }
        }
        return arr;
    }

    public static void makeMAI (){
        double[][] cel = {{1,0.11,0.16,0.11,0.14,1,1,0,0},
                {9,1,4,1,3,1,1,0,0},
                {6,0.25,1,0.25,0.5,1,1,0,0},
                {9,1,4,1,3,1,1,0,0},
                {7,0.33,2,0.33,1,1,1,0,0}};
        double[][] k1 = {{1,5,1,1,9,1,1,0,0},
                {0.2,1,0.5,0.5,5,1,1,0,0},
                {1,5,1,1,9,1,1,0,0},
                {1,5,1,1,9,1,1,0,0},
                {0.11,0.2,0.11,0.11,1,1,1,0,0}};
        double[][] k2 = {{1,1,0.2,0.2,1,1,1,0,0},
                {1,1,0.2,0.2,1,1,1,0,0},
                {5,5,1,1,1,1,1,0,0},
                {5,5,1,1,1,1,1,0,0},
                {5,5,1,1,1,1,1,0,0}};
        double[][] k3 = {{1,1,0.2,1,1,1,1,0,0},
                {1,1,0.2,1,1,1,1,0,0},
                {5,5,1,5,5,1,1,0,0},
                {1,1,0.2,1,1,1,1,0,0},
                {1,1,0.2,1,1,1,1,0,0}};
        double[][] k4 = {{1,1,0.2,0.2,5,1,1,0,0},
                {1,1,0.2,0.2,5,1,1,0,0},
                {5,5,1,1,9,1,1,0,0},
                {5,5,1,1,9,1,1,0,0},
                {0.2,0.2,0.11,0.11,1,1,1,0,0}};
        double[][] k5 = {{1,9,9,1,9,1,1,0,0},
                {0.11,1,1,0.11,1,1,1,0,0},
                {0.11,1,1,0.11,1,1,1,0,0},
                {1,9,9,1,9,1,1,0,0},
                {0.11,1,1,0.11,1,1,1,0,0}};

        double[] sumV = new double[]{0,0,0,0,0,0};

        makeMAIs(cel);
        for (int j = 0; j < 5; j++) {
            sumV[0]+=cel[j][5];
        }
        for (int j = 0; j < 5; j++) {
            cel[j][6] = cel[j][5]/sumV[0];
        }

        k1 = makeMAIs(k1);
        for (int j = 0; j < 5; j++) {
            sumV[1]+=k1[j][5];
        }
        for (int j = 0; j < 5; j++) {
            k1[j][6] = k1[j][5]/sumV[1];
        }

        k2 = makeMAIs(k2);
        for (int j = 0; j < 5; j++) {
            sumV[2]+=k2[j][5];
        }
        for (int j = 0; j < 5; j++) {
            k2[j][6] = k2[j][5]/sumV[2];
        }
        k3 = makeMAIs(k3);
        for (int j = 0; j < 5; j++) {
            sumV[3]+=k3[j][5];
        }
        for (int j = 0; j < 5; j++) {
            k3[j][6] = k3[j][5]/sumV[3];
        }
        k4 = makeMAIs(k4);
        for (int j = 0; j < 5; j++) {
            sumV[4]+=k4[j][5];
        }
        for (int j = 0; j < 5; j++) {
            k4[j][6] = k4[j][5]/sumV[4];
        }
        k5 = makeMAIs(k5);
        for (int j = 0; j < 5; j++) {
            sumV[5]+=k5[j][5];
        }
        for (int j = 0; j < 5; j++) {
            k5[j][6] = k5[j][5]/sumV[5];
        }

        cel = makeSandP(cel);
        k1 = makeSandP(k1);
        k2 = makeSandP(k2);
        k3 = makeSandP(k3);
        k4 = makeSandP(k4);
        k5 = makeSandP(k5);

        double[] L = new double[]{0,0,0,0,0,0};
        double[] IS = new double[]{0,0,0,0,0,0};
        double[] OS = new double[]{0,0,0,0,0,0};
        double CI = 1.12;

        for (int j = 0; j < 5; j++) {
            L[0] += k5[j][8];
            IS[0] = (L[0]-5)/(5-1);
            OS[0] = IS[0]/CI;
        }
        for (int j = 0; j < 5; j++) {
            L[1] += k5[j][8];
            IS[1] = (L[1]-5)/(5-1);
            OS[1] = IS[1]/CI;
        }
        for (int j = 0; j < 5; j++) {
            L[2] += k5[j][8];
            IS[2] = (L[2]-5)/(5-1);
            OS[2] = IS[2]/CI;
        }
        for (int j = 0; j < 5; j++) {
            L[3] += k5[j][8];
            IS[3] = (L[3]-5)/(5-1);
            OS[3] = IS[3]/CI;
        }
        for (int j = 0; j < 5; j++) {
            L[4] += k5[j][8];
            IS[4] = (L[4]-5)/(5-1);
            OS[4] = IS[4]/CI;
        }
        for (int j = 0; j < 5; j++) {
            L[5] += k5[j][8];
            IS[5] = (L[5]-5)/(5-1);
            OS[5] = IS[5]/CI;
        }

        double[] Wfinal = new double[]{0,0,0,0,0};


        Wfinal[0] = cel[0][6]*k1[0][6]+cel[1][6]*k2[0][6]+cel[2][6]*k3[0][6]+cel[3][6]*k4[0][6]+cel[4][6]*k5[0][6];
        Wfinal[1] = cel[0][6]*k1[1][6]+cel[1][6]*k2[1][6]+cel[2][6]*k3[1][6]+cel[3][6]*k4[1][6]+cel[4][6]*k5[1][6];
        Wfinal[2] = cel[0][6]*k1[2][6]+cel[1][6]*k2[2][6]+cel[2][6]*k3[2][6]+cel[3][6]*k4[2][6]+cel[4][6]*k5[2][6];
        Wfinal[3] = cel[0][6]*k1[3][6]+cel[1][6]*k2[3][6]+cel[2][6]*k3[3][6]+cel[3][6]*k4[3][6]+cel[4][6]*k5[3][6];
        Wfinal[4] = cel[0][6]*k1[4][6]+cel[1][6]*k2[4][6]+cel[2][6]*k3[4][6]+cel[3][6]*k4[4][6]+cel[4][6]*k5[4][6];


        System.out.println("Цель К1       К2       К3       К4       К5       Vi       W2i      S        P");
        printMAI(cel);
        System.out.println("Vi sum = " + String.format("%.3f",sumV[0]) + "  λ = " + String.format("%.3f",L[0]) + " ИС = " + String.format("%.3f",IS[0]) + " ОС = "+ String.format("%.3f",OS[0]));
        System.out.println("----------------------------------------------------------------");
        System.out.println("К1   A1       A2       A3       A4       A5       Vi       W3k1y    S        P");
        printMAI2(k1);
        System.out.println("Vi sum = " + String.format("%.3f",sumV[1]) + "  λ = " + String.format("%.3f",L[1]) + " ИС = " + String.format("%.3f",IS[1]) + " ОС = "+ String.format("%.3f",OS[1]));
        System.out.println("----------------------------------------------------------------");
        System.out.println("К2   A1       A2       A3       A4       A5       Vi       W3k2y    S        P");
        printMAI2(k2);
        System.out.println("Vi sum = " + String.format("%.3f",sumV[2]) + "  λ = " + String.format("%.3f",L[2]) + " ИС = " + String.format("%.3f",IS[2]) + " ОС = "+ String.format("%.3f",OS[2]));
        System.out.println("----------------------------------------------------------------");
        System.out.println("К3   A1       A2       A3       A4       A5       Vi       W3k3y    S        P");
        printMAI2(k3);
        System.out.println("Vi sum = " + String.format("%.3f",sumV[3]) + "  λ = " + String.format("%.3f",L[3]) + " ИС = " + String.format("%.3f",IS[3]) + " ОС = "+ String.format("%.3f",OS[3]));
        System.out.println("----------------------------------------------------------------");
        System.out.println("К4   A1       A2       A3       A4       A5       Vi       W3k4y    S        P");
        printMAI2(k4);
        System.out.println("Vi sum = " + String.format("%.3f",sumV[4]) + "  λ = " + String.format("%.3f",L[4]) + " ИС = " + String.format("%.3f",IS[4]) + " ОС = "+ String.format("%.3f",OS[4]));
        System.out.println("----------------------------------------------------------------");
        System.out.println("К5   A1       A2       A3       A4       A5       Vi       W3k5y    S        P");
        printMAI2(k5);
        System.out.println("Vi sum = " + String.format("%.3f",sumV[5]) + "  λ = " + String.format("%.3f",L[5]) + " ИС = " + String.format("%.3f",IS[5]) + " ОС = "+ String.format("%.3f",OS[5]));
        System.out.println("----------------------------------------------------------------");

        for (int i = 0; i < Wfinal.length; i++)
        System.out.println("W["+i+"] = "+String.format("%.3f",Wfinal[i]));
    }

    public static void main(String[] args) {
//        ArrayList<Camera> parMas = makeArrayPar();
//        new Pareto(parMas);
//        ArrayList<Camera> elMas = makeArrayEl(parMas);
//        new Electra(elMas);
        makeMAI();

    }
}
