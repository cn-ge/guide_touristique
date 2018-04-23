package cgeindreau2015.ca.guide.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cgeindreau2015.ca.guide.ui.AppActivity;
import cgeindreau2015.ca.guide.util.Constant;
import cgeindreau2015.ca.guide.ui.listing.ListingActivity;
import cgeindreau2015.ca.guide.R;

public class HomeActivity extends AppActivity {

    private Button btnRestaurant, btnHotel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnRestaurant = (Button) findViewById(R.id.btn_restaurant);
        btnHotel = (Button) findViewById(R.id.btn_hotel);


    }

    public void ShowRestaurant(View view) {

        Intent i = new Intent(HomeActivity.this, ListingActivity.class);
        i.putExtra(Constant.INTENT_IS_RESTAURANT, true);
        startActivity(i);
    }

    public void ShowHotel(View view) {

        Intent i = new Intent(HomeActivity.this, ListingActivity.class);
        i.putExtra(Constant.INTENT_IS_RESTAURANT, false);
        startActivity(i);
    }
}
