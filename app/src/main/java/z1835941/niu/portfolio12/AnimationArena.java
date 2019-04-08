package z1835941.niu.portfolio12;

import android.graphics.Canvas;

public class AnimationArena {
    private Ball myBall;

    public AnimationArena(){
        myBall = new Ball();
    }

    public void update(int w, int h){
        myBall.move(0, 0, w, h);
    }

    public void draw(Canvas canvas){
        // set bg color for canvas
        canvas.drawRGB(156, 174, 216);
        //draw ball
        myBall.draw(canvas);
    }
}

