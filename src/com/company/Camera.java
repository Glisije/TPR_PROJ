package com.company;

public class Camera {
    String name;
    String pName;
    int weight;
    double crop;
    int resolution;
    int fps;
    int iso;
    int deep;
    int speed;
    boolean stab;
    int fPar;
    int dfPar;
    int upDown;
    int sub;
    int stabil;
    int P;
    int N;
    double D;

    Camera(String name, String pName, int weight, double crop, int resolution, int fps, int iso, int deep, int speed, boolean stab) {
        this.name = name;
        this.pName = pName;
        this.weight = weight;
        this.crop = crop;
        this.resolution = resolution;
        this.fps = fps;
        this.iso = iso;
        this.deep = deep;
        this.speed = speed;
        this.stab = stab;
        this.dfPar = 0;
        this.upDown = 0;
        this.sub = 0;
        this.P = 0;
        this.N = 0;
        this.D = 0;
    }

    Camera(String name, String pName, int weight, double crop, int resolution, int fps, int iso, int deep, int speed, int stabil) {
        this.name = name;
        this.pName = pName;
        this.weight = weight;
        this.crop = crop;
        this.resolution = resolution;
        this.fps = fps;
        this.iso = iso;
        this.deep = deep;
        this.speed = speed;
        this.stabil = stabil;
        this.dfPar = 0;
        this.upDown = 0;
        this.sub = 0;
        this.P = 0;
        this.N = 0;
        this.D = 0;
    }
}