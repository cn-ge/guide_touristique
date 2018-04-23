package cgeindreau2015.ca.guide.ui.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

import cgeindreau2015.ca.guide.R;
import cgeindreau2015.ca.guide.ui.home.HomeActivity;

public class MainActivity extends AppCompatActivity {

    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // TODO lancer l'activité Home
                Intent i = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(i);
                // finish(); --> voir le manifest
            }
        }, 1000);
    }
}
