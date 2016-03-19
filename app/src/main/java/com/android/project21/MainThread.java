package com.android.project21;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

/**
 * Created by andrewporter on 19/03/2016.
 */
public class MainThread extends Thread {
    private int FPS=30;
    private double averageFPS;
    private SurfaceHolder surfaceHolder;
    private GameScreen gameScreen;
    private boolean running;
    public static Canvas canvas;

    public MainThread(SurfaceHolder surfaceHolder, GameScreen gameScreen) {
        super();
        this.surfaceHolder = surfaceHolder;
        this.gameScreen = gameScreen;
    }

    //Game loop
    @Override
    public void run() {
        long startTime;
        long timeMilliSec;
        long waitTime;
        long totalTime=0;
        int frameCount = 0;
        long targetTime = 1000/FPS;

        while(running) {
            startTime = System.nanoTime();
            canvas = null;

            try {
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder) {
                    this.gameScreen.update();
                    this.gameScreen.draw(canvas);
                }
            } catch(Exception e) {
            } finally {
                if(canvas!=null) {
                    try{surfaceHolder.unlockCanvasAndPost(canvas);
                } catch(Exception e){
                    e.printStackTrace();
                    }
                }
            }

            timeMilliSec = (System.nanoTime() - startTime) / 1000000;
            waitTime = targetTime-timeMilliSec;

            try {
                this.sleep(waitTime);
            } catch(Exception e) {
            }

            totalTime += System.nanoTime()-startTime;
            frameCount++;

            if(frameCount == FPS) {
                averageFPS = 1000/((totalTime/frameCount) / 1000000);
                frameCount = 0;
                totalTime = 0;
                System.out.println(averageFPS);
            }
        }
    }

    public void setRunning(boolean b) {
        running = b;
    }
}
