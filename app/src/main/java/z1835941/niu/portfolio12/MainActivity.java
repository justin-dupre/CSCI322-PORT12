package z1835941.niu.portfolio12;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView countTV;
    private Integer counter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countTV = findViewById(R.id.countText);
        counter = 0;

        //create new thread
        Thread thread = new Thread(countNumbers);
        //start exec of the thread
        thread.start();

    } //end on create

    @Override
    protected void onStart() {
        super.onStart();
        //reset counter to 0
        counter = 0;
    }

    private Runnable countNumbers = new Runnable() {
        private static final int DELAY = 1000;
        @Override
        public void run() {
            while(true){
                //inc counter
                counter++;
                try {
                    Thread.sleep(DELAY);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                //update UI thread by sending empty message.
                threadHandler.sendEmptyMessage(0);
            }//end while
        }
    };//end of counterNumbers runnable


    public Handler threadHandler = new Handler(){
      //code the handleMessage so UI thread knows what to do
      public void handleMessage(Message m){
          countTV.setText(counter.toString());
      }
    };






} //end class
