package cgeindreau2015.ca.guide.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import cgeindreau2015.ca.guide.ui.home.HomeActivity;

/**
 * Created by cgeindreau2015 on 26/04/2017.
 */

public class AppActivity extends AppCompatActivity {

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home: // flèche de retour
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // afficher la flèche de retour
        if(getSupportActionBar() != null) {
            if (!(this instanceof HomeActivity)) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }
        }
    }
}
