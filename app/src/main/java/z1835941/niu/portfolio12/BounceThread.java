package z1835941.niu.portfolio12;

import android.graphics.Canvas;
import android.view.Surface;
import android.view.SurfaceHolder;

public class BounceThread extends Thread {

    private SurfaceHolder surfaceHolder;
    private AnimationArena animationArena;
    private boolean isRunning;

    public BounceThread(SurfaceHolder sh){
        surfaceHolder = sh;
        isRunning = true;

        //create animation arena
        animationArena = new AnimationArena();
    }//end constructor

    public void run(){
        try {
            while(isRunning){
                Canvas canvas = surfaceHolder.lockCanvas();
                //update ball location
                animationArena.update(canvas.getWidth(), canvas.getHeight());
                animationArena.draw(canvas);

                surfaceHolder.unlockCanvasAndPost(canvas);
            }
        }catch (NullPointerException npe){
            npe.printStackTrace();
        }
    }

    public void endBounce(){
        isRunning = false;
    }
}
