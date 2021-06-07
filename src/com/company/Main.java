package com.company;

import java.util.ArrayList;
import java.util.Scanner;

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
            } else if (mas.get(i).weight < 520) {
                mas1.get(i).weight = 5;
            }

            if (mas.get(i).crop == 1.9) {
                mas1.get(i).crop = 15;
            } else if (mas.get(i).crop == 1.5) {
                mas1.get(i).crop = 10;
            } else if (mas.get(i).crop == 1) {
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
            } else if (mas.get(i).fps <= 50) {
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
            } else if (mas.get(i).deep == 10422) {
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
            } else if (mas.get(i).speed <= 200) {
                mas1.get(i).speed = 5;
            }

            if (mas.get(i).stab) {
                mas1.get(i).stabil = 15;
            } else if (!mas.get(i).stab) {
                mas1.get(i).stabil = 5;
            }
        }

        return mas1;
    }

    public static double[][] makeMAIs(double[][] arr) {
        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < 5; i++) {  //идём по строкам
                arr[j][5] *= arr[j][i];
            }
            arr[j][5] = Math.pow(arr[j][5], 0.2);
            //System.out.println(arr[j][5]);
        }
        return arr;
    }

    public static void printMAI(double[][] arr) {
        for (int i = 0; i < 5; i++) {  //идём по строкам
            System.out.print("K" + (i + 1));
            for (int j = 0; j < 9; j++) {//идём по столбцам
                System.out.print("   " + String.format("%.3f", arr[i][j]) + " "); //вывод элемента
            }
            System.out.println();//перенос строки ради визуального сохранения табличной формы
        }
        System.out.println();
    }

    public static void printMAI2(double[][] arr) {
        for (int i = 0; i < 5; i++) {  //идём по строкам
            System.out.print("A" + (i + 1));
            for (int j = 0; j < 9; j++) {//идём по столбцам
                System.out.print("   " + String.format("%.3f", arr[i][j]) + " "); //вывод элемента
            }
            System.out.println();//перенос строки ради визуального сохранения табличной формы
        }
        System.out.println();
    }

    public static double[][] makeSandP(double[][] arr) {
        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < 5; i++) {  //идём по строкам
                arr[j][7] += arr[i][j];
            }
        }
        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < 5; i++) {  //идём по строкам
                arr[j][8] = arr[j][7] * arr[j][6];
            }
        }
        return arr;
    }

    public static void makeMAI() {
        double[][] cel = {{1, 0.11, 0.16, 0.11, 0.14, 1, 1, 0, 0},
                {9, 1, 4, 1, 3, 1, 1, 0, 0},
                {6, 0.25, 1, 0.25, 0.5, 1, 1, 0, 0},
                {9, 1, 4, 1, 3, 1, 1, 0, 0},
                {7, 0.33, 2, 0.33, 1, 1, 1, 0, 0}};
        double[][] k1 = {{1, 5, 1, 1, 9, 1, 1, 0, 0},
                {0.2, 1, 0.5, 0.5, 5, 1, 1, 0, 0},
                {1, 5, 1, 1, 9, 1, 1, 0, 0},
                {1, 5, 1, 1, 9, 1, 1, 0, 0},
                {0.11, 0.2, 0.11, 0.11, 1, 1, 1, 0, 0}};
        double[][] k2 = {{1, 1, 0.2, 0.2, 1, 1, 1, 0, 0},
                {1, 1, 0.2, 0.2, 1, 1, 1, 0, 0},
                {5, 5, 1, 1, 1, 1, 1, 0, 0},
                {5, 5, 1, 1, 1, 1, 1, 0, 0},
                {5, 5, 1, 1, 1, 1, 1, 0, 0}};
        double[][] k3 = {{1, 1, 0.2, 1, 1, 1, 1, 0, 0},
                {1, 1, 0.2, 1, 1, 1, 1, 0, 0},
                {5, 5, 1, 5, 5, 1, 1, 0, 0},
                {1, 1, 0.2, 1, 1, 1, 1, 0, 0},
                {1, 1, 0.2, 1, 1, 1, 1, 0, 0}};
        double[][] k4 = {{1, 1, 0.2, 0.2, 5, 1, 1, 0, 0},
                {1, 1, 0.2, 0.2, 5, 1, 1, 0, 0},
                {5, 5, 1, 1, 9, 1, 1, 0, 0},
                {5, 5, 1, 1, 9, 1, 1, 0, 0},
                {0.2, 0.2, 0.11, 0.11, 1, 1, 1, 0, 0}};
        double[][] k5 = {{1, 9, 9, 1, 9, 1, 1, 0, 0},
                {0.11, 1, 1, 0.11, 1, 1, 1, 0, 0},
                {0.11, 1, 1, 0.11, 1, 1, 1, 0, 0},
                {1, 9, 9, 1, 9, 1, 1, 0, 0},
                {0.11, 1, 1, 0.11, 1, 1, 1, 0, 0}};

        double[] sumV = new double[]{0, 0, 0, 0, 0, 0};

        makeMAIs(cel);
        for (int j = 0; j < 5; j++) {
            sumV[0] += cel[j][5];
        }
        for (int j = 0; j < 5; j++) {
            cel[j][6] = cel[j][5] / sumV[0];
        }

        k1 = makeMAIs(k1);
        for (int j = 0; j < 5; j++) {
            sumV[1] += k1[j][5];
        }
        for (int j = 0; j < 5; j++) {
            k1[j][6] = k1[j][5] / sumV[1];
        }

        k2 = makeMAIs(k2);
        for (int j = 0; j < 5; j++) {
            sumV[2] += k2[j][5];
        }
        for (int j = 0; j < 5; j++) {
            k2[j][6] = k2[j][5] / sumV[2];
        }
        k3 = makeMAIs(k3);
        for (int j = 0; j < 5; j++) {
            sumV[3] += k3[j][5];
        }
        for (int j = 0; j < 5; j++) {
            k3[j][6] = k3[j][5] / sumV[3];
        }
        k4 = makeMAIs(k4);
        for (int j = 0; j < 5; j++) {
            sumV[4] += k4[j][5];
        }
        for (int j = 0; j < 5; j++) {
            k4[j][6] = k4[j][5] / sumV[4];
        }
        k5 = makeMAIs(k5);
        for (int j = 0; j < 5; j++) {
            sumV[5] += k5[j][5];
        }
        for (int j = 0; j < 5; j++) {
            k5[j][6] = k5[j][5] / sumV[5];
        }

        cel = makeSandP(cel);
        k1 = makeSandP(k1);
        k2 = makeSandP(k2);
        k3 = makeSandP(k3);
        k4 = makeSandP(k4);
        k5 = makeSandP(k5);

        double[] L = new double[]{0, 0, 0, 0, 0, 0};
        double[] IS = new double[]{0, 0, 0, 0, 0, 0};
        double[] OS = new double[]{0, 0, 0, 0, 0, 0};
        double CI = 1.12;

        for (int j = 0; j < 5; j++) {
            L[0] += k5[j][8];
            IS[0] = (L[0] - 5) / (5 - 1);
            OS[0] = IS[0] / CI;
        }
        for (int j = 0; j < 5; j++) {
            L[1] += k5[j][8];
            IS[1] = (L[1] - 5) / (5 - 1);
            OS[1] = IS[1] / CI;
        }
        for (int j = 0; j < 5; j++) {
            L[2] += k5[j][8];
            IS[2] = (L[2] - 5) / (5 - 1);
            OS[2] = IS[2] / CI;
        }
        for (int j = 0; j < 5; j++) {
            L[3] += k5[j][8];
            IS[3] = (L[3] - 5) / (5 - 1);
            OS[3] = IS[3] / CI;
        }
        for (int j = 0; j < 5; j++) {
            L[4] += k5[j][8];
            IS[4] = (L[4] - 5) / (5 - 1);
            OS[4] = IS[4] / CI;
        }
        for (int j = 0; j < 5; j++) {
            L[5] += k5[j][8];
            IS[5] = (L[5] - 5) / (5 - 1);
            OS[5] = IS[5] / CI;
        }

        double[] Wfinal = new double[]{0, 0, 0, 0, 0};


        Wfinal[0] = cel[0][6] * k1[0][6] + cel[1][6] * k2[0][6] + cel[2][6] * k3[0][6] + cel[3][6] * k4[0][6] + cel[4][6] * k5[0][6];
        Wfinal[1] = cel[0][6] * k1[1][6] + cel[1][6] * k2[1][6] + cel[2][6] * k3[1][6] + cel[3][6] * k4[1][6] + cel[4][6] * k5[1][6];
        Wfinal[2] = cel[0][6] * k1[2][6] + cel[1][6] * k2[2][6] + cel[2][6] * k3[2][6] + cel[3][6] * k4[2][6] + cel[4][6] * k5[2][6];
        Wfinal[3] = cel[0][6] * k1[3][6] + cel[1][6] * k2[3][6] + cel[2][6] * k3[3][6] + cel[3][6] * k4[3][6] + cel[4][6] * k5[3][6];
        Wfinal[4] = cel[0][6] * k1[4][6] + cel[1][6] * k2[4][6] + cel[2][6] * k3[4][6] + cel[3][6] * k4[4][6] + cel[4][6] * k5[4][6];


        System.out.println("Цель К1       К2       К3       К4       К5       Vi       W2i      S        P");
        printMAI(cel);
        System.out.println("Vi sum = " + String.format("%.3f", sumV[0]) + "  λ = " + String.format("%.3f", L[0]) + " ИС = " + String.format("%.3f", IS[0]) + " ОС = " + String.format("%.3f", OS[0]));
        System.out.println("----------------------------------------------------------------");
        System.out.println("К1   A1       A2       A3       A4       A5       Vi       W3k1y    S        P");
        printMAI2(k1);
        System.out.println("Vi sum = " + String.format("%.3f", sumV[1]) + "  λ = " + String.format("%.3f", L[1]) + " ИС = " + String.format("%.3f", IS[1]) + " ОС = " + String.format("%.3f", OS[1]));
        System.out.println("----------------------------------------------------------------");
        System.out.println("К2   A1       A2       A3       A4       A5       Vi       W3k2y    S        P");
        printMAI2(k2);
        System.out.println("Vi sum = " + String.format("%.3f", sumV[2]) + "  λ = " + String.format("%.3f", L[2]) + " ИС = " + String.format("%.3f", IS[2]) + " ОС = " + String.format("%.3f", OS[2]));
        System.out.println("----------------------------------------------------------------");
        System.out.println("К3   A1       A2       A3       A4       A5       Vi       W3k3y    S        P");
        printMAI2(k3);
        System.out.println("Vi sum = " + String.format("%.3f", sumV[3]) + "  λ = " + String.format("%.3f", L[3]) + " ИС = " + String.format("%.3f", IS[3]) + " ОС = " + String.format("%.3f", OS[3]));
        System.out.println("----------------------------------------------------------------");
        System.out.println("К4   A1       A2       A3       A4       A5       Vi       W3k4y    S        P");
        printMAI2(k4);
        System.out.println("Vi sum = " + String.format("%.3f", sumV[4]) + "  λ = " + String.format("%.3f", L[4]) + " ИС = " + String.format("%.3f", IS[4]) + " ОС = " + String.format("%.3f", OS[4]));
        System.out.println("----------------------------------------------------------------");
        System.out.println("К5   A1       A2       A3       A4       A5       Vi       W3k5y    S        P");
        printMAI2(k5);
        System.out.println("Vi sum = " + String.format("%.3f", sumV[5]) + "  λ = " + String.format("%.3f", L[5]) + " ИС = " + String.format("%.3f", IS[5]) + " ОС = " + String.format("%.3f", OS[5]));
        System.out.println("----------------------------------------------------------------");

        for (int i = 0; i < Wfinal.length; i++)
            System.out.println("W[" + i + "] = " + String.format("%.3f", Wfinal[i]));
    }

    public static void printSimpl(double[][] table, double[] fCI, double[] fCB){
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                if (i == 0 && j == 0) {
                    System.out.println("\t\t\t\t" + "x[" + fCI[0] + "]\t" + "x[" + fCI[1] + "]" + "\tA0");
                }
                if (j == 0 && i == 2) {
                    System.out.print("Δ1,  Δ2,  Q:\t");
                }
                if (j == 0 && i < 2) {
                    System.out.print(fCB[i] + "\t\tx[" + fCB[i] + "]\t");
                }
                System.out.print(" " + String.format("%.2f", table[i][j]) + " ");
                if (j == 2) {
                    System.out.println();
                }
            }
            System.out.println();
        }

    }

    public static void simpldimpl() {

        double[][] mainTable = {{0.15, 0.2, 60},
                {0.2, 0.1, 40},
                {0, 0, 0}};
        double[][] tempTable = {{0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}};
        double[] fCB = {0, 0};
        double[] fCI = {1.5, 1.2};
        double fd1 = 0, fd2 = 0, fQ = 0;
        for (int i = 0; i < fCB.length; i++) {
            fd1 += fCB[i] * mainTable[i][0];
            fd2 += fCB[i] * mainTable[i][1];
            fQ += fCB[i] * mainTable[i][2];
        }
        fd1 -= fCI[0];
        fd2 -= fCI[1];
        System.out.println(fQ + "  " + fd1 + "    " + fd2);
        mainTable[2][0] = fd1;
        mainTable[2][1] = fd2;
        mainTable[2][2] = fQ;

        while (mainTable[2][0] < 0 || mainTable[2][1]<0) {

            int raz=0;

            if (Math.abs(mainTable[2][0]) < 0) {
                raz = 0;
            } else if (mainTable[2][0] == 7.5) {
                raz = 1;
            }

            double temp = fCI[raz];
            double[] stemp = {0, 0};
            for (int i = 0; i < 2; i++) {
                stemp[i] = mainTable[i][2] / mainTable[i][raz];
            }
            int minIndexHor = 0;
            double min = stemp[0];
            for (int k = 0; k < stemp.length; k++) {
                for (int b = 0; b < stemp.length; b++) {
                    if (stemp[b] < min) {
                        min = stemp[b];
                        minIndexHor = b;
                    }
                }
                System.out.println(min + "  " + minIndexHor);
            }

            //Выше должно работать
            fCI[0] = fCB[minIndexHor];
            fCB[minIndexHor] = temp;
            //Рассчет строк и столбцов по разрешающему элементу

            for (int i = 0; i < 3; i++) {
                tempTable[i][raz] = -(mainTable[i][raz] / mainTable[minIndexHor][raz]);//Заебись
                tempTable[minIndexHor][i] = (mainTable[minIndexHor][i] / mainTable[minIndexHor][raz]);
            }
            Scanner in = new Scanner(System.in);
            System.out.println("Введите число обратное числу: " + mainTable[minIndexHor][raz]);
            tempTable[minIndexHor][raz] = in.nextDouble();


            if (raz == 0) {

                for (int i = 0; i < tempTable.length; i++) {
                    for (int j = 0; j < tempTable[0].length; j++) {
                        if (tempTable[i][j] == 0) {
                            if (i == 0 && j == 1) {
                                tempTable[i][j] = ((mainTable[i][j] * mainTable[minIndexHor][0]) - (mainTable[0][0] * mainTable[1][1])) / mainTable[minIndexHor][0];//true
                            } else if (i == 0 && j == 2) {
                                tempTable[i][j] = ((mainTable[i][j] * mainTable[minIndexHor][0]) - (mainTable[0][0] * mainTable[1][2])) / mainTable[minIndexHor][0];
                            } else if (i == 2 && j == 1) {
                                tempTable[i][j] = ((mainTable[i][j] * mainTable[minIndexHor][0]) - (mainTable[2][0] * mainTable[1][1])) / mainTable[minIndexHor][0];
                            } else if (i == 2 && j == 2) {
                                tempTable[i][j] = ((mainTable[i][j] * mainTable[minIndexHor][0]) - (mainTable[2][0] * mainTable[1][2])) / mainTable[minIndexHor][0];
                            }

                        }
                    }
                }

                System.out.println("//////////////");
                printSimpl(tempTable, fCI, fCB);


                mainTable = tempTable;
                tempTable = new double[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

            }
                else if (raz == 1){
                    for (int i = 0; i < tempTable.length; i++) {
                        for (int j = 0; j < tempTable[0].length; j++) {
                            if (tempTable[i][j] == 0) {
                                if (i == 1 && j == 0) {
                                    tempTable[i][j] = ((mainTable[i][j] * mainTable[minIndexHor][1]) - (mainTable[0][0] * mainTable[1][1])) / mainTable[minIndexHor][1];//true
                                } else if (i == 2 && j == 0) {
                                    tempTable[i][j] = ((mainTable[i][j] * mainTable[minIndexHor][1]) - (mainTable[0][0] * mainTable[2][1])) / mainTable[minIndexHor][1];
                                } else if (i == 1 && j == 2) {
                                    tempTable[i][j] = ((mainTable[i][j] * mainTable[minIndexHor][1]) - (mainTable[0][2] * mainTable[1][1])) / mainTable[minIndexHor][1];
                                } else if (i == 2 && j == 2) {
                                    tempTable[i][j] = ((mainTable[i][j] * mainTable[minIndexHor][1]) - (mainTable[0][2] * mainTable[2][1])) / mainTable[minIndexHor][1];
                                }

                            }
                        }
                    }
                    printSimpl(tempTable, fCI, fCB);

                    mainTable = tempTable;

//                    double temp2 = fCI[g + 1];
//                    fCI[g + 1] = fCB[minIndexHor1];
//                    fCB[minIndexHor1] = temp2;
//                    System.out.println(fCB[0] + "  " + fCB[1] + "  " + fCI[0] + "  " + fCI[1]);
//                    double Fmax = fCB[0] * tempTable[0][2] + fCB[1] * tempTable[1][2];
//                    System.out.println(Fmax);

                    //}
                }
            }
        System.out.println("x1 = " + String.format("%.3f", mainTable[0][2]));
        System.out.println("x2 = " + String.format("%.3f", mainTable[1][2]));
        System.out.println("Прибыль равна = " + (fCB[0] * mainTable[0][2] + fCB[1] * mainTable[1][2]));
        }


    class Simplex {
        Simplex() {
        }

        public double[] KoefC = {3, 5};
        public double[] KoefB = {0, 0, 0, 0};
        public int[] C = {1, 2};
        public int[] B = {3, 4, 5, 6};
        public double[] delta = {-1, -1};
        public double[][] mainTable = {{10, 70, 570}, {20, 50, 420}, {300, 400, 5000}, {200, 100, 3400}};
        public double[][] tmpMainTable = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

        public void start() {
            int r = 0, s = 0;
            while (true) {
                double scale = Math.pow(10, 2);
                double[] tmpFinalVector = new double[4];
                System.out.println("\t\t\t\t" + KoefC[0] + "\t\t" + KoefC[1]);
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (i == 0 && j == 0) {
                            System.out.println("\t\t\t\t" + "x[" + C[0] + "]\t" + "x[" + C[1] + "]" + "\tA0");
                        }
                        if (j == 0) {
                            System.out.print(KoefB[i] + "\t\tx[" + B[i] + "]\t");
                        }
                        System.out.print(Math.ceil(mainTable[i][j] * scale) / scale + "\t");
                        if (j == 2) {
                            System.out.println();
                        }
                    }
                }
                //подсчёт дельт
                delta[0] = (mainTable[0][0] * KoefB[0] + mainTable[1][0] * KoefB[1] + mainTable[2][0] * KoefB[2] + mainTable[3][0] * KoefB[3]) - KoefC[0];
                delta[1] = (mainTable[0][1] * KoefB[0] + mainTable[1][1] * KoefB[1] + mainTable[2][1] * KoefB[2] + mainTable[3][1] * KoefB[3]) - KoefC[1];
                System.out.println("\t\tf\t\t" + Math.ceil(delta[0] * scale) / scale + "\t" + Math.ceil(delta[1] * scale) / scale);
                if (delta[0] > 0 && delta[1] > 0) {
                    System.out.println("x1 = " + Math.ceil(mainTable[1][2] * scale) / scale);
                    System.out.println("x2 = " + Math.ceil(mainTable[0][2] * scale) / scale);
                    System.out.println("Прибыль равна = " + ((3 * mainTable[1][2]) + (5 * mainTable[0][2])));
                    break;
                }
                //Сравнение дельт
                if (delta[0] < 0 || delta[1] < 0) {
                    if (delta[0] < 0) {
                        s = 0;
                    }
                    if (delta[1] < 0) {

                        s = 1;

                    }
                    if (delta[0] < 0 && delta[1] < 0) {
                        double newDelta1 = -delta[0];
                        double newDelta2 = -delta[1];
                        if (newDelta1 > newDelta2) {
                            s = 0;
                        } else {
                            s = 1;
                        }
                    }
                }
                double tempMin = 100000;
                for (int i = 0; i < tmpFinalVector.length; i++) {
                    tmpFinalVector[i] = mainTable[i][2] / mainTable[i][s];
                    if (tempMin > tmpFinalVector[i] && tmpFinalVector[i] > 0) {
                        tempMin = tmpFinalVector[i];
                        r = i;
                    }
                }
                System.out.println("Разрешающая строка : " + r + "\nРазрешающий столбец : " + s + "\nРазрешающий элемент : " + Math.ceil(mainTable[r][s] * scale) / scale);
                //преобразование разрешающих стобцов и строк
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 3; j++) {
                        tmpMainTable[i][j] = mainTable[i][j];
                    }
                }
                double element = mainTable[r][s];//Выделение разрешающего элемента
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (i == r && j == s) {
                            mainTable[i][j] = 1 / mainTable[i][j];
                            continue;
                        }
                        if (i == r) {
                            mainTable[i][j] = mainTable[i][j] / element;
                        }
                        if (j == s) {
                            mainTable[i][j] = -mainTable[i][j] / element;
                        }
                    }
                }
                //замена коефициентов базисных и небазисных переменных
                double tempKoef;
                tempKoef = KoefC[s];
                KoefC[s] = KoefB[r];
                KoefB[r] = tempKoef;
                //замена базисных и небазисных переменных
                int tempC;
                tempC = C[s];
                C[s] = B[r];
                B[r] = tempC;
                //Правило прямоугольника внутри главной таблицы
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (i != r && j != s) {
                            mainTable[i][j] = ((tmpMainTable[i][j] * element) - (tmpMainTable[r][j] * tmpMainTable[i][s])) / element;
                        }
                    }
                }
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 2; j++) {
                        tmpMainTable[i][j] = mainTable[i][j];
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
//        ArrayList<Camera> parMas = makeArrayPar();
//        new Pareto(parMas);
//        ArrayList<Camera> elMas = makeArrayEl(parMas);
//        new Electra(elMas);
//        makeMAI();
        //makeSimpl();
        simpldimpl();

//        Simplex simplex=new Simplex();
//        simplex.start();
    }
}
