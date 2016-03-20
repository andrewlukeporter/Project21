package com.android.project21;

/**
 * Created by andrewporter on 20/03/2016.
 */
import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Background {
    private Bitmap image;
    private int x, y;

    public Background(Bitmap res) {
        image = res;
    }

    public void update() {
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(image, x, y, null);
    }


}
