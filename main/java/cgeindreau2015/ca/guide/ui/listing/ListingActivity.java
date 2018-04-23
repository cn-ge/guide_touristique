package cgeindreau2015.ca.guide.ui.listing;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cgeindreau2015.ca.guide.ui.AppActivity;
import cgeindreau2015.ca.guide.util.Constant;
import cgeindreau2015.ca.guide.models.Etablissement;
import cgeindreau2015.ca.guide.models.Hotel;
import cgeindreau2015.ca.guide.R;
import cgeindreau2015.ca.guide.models.Restaurant;
import cgeindreau2015.ca.guide.ui.detail.DetailActivity;

public class ListingActivity extends AppActivity {

    private TextView textViewTitle;
    //private ListView listViewData;
    private GridView gridViewData;

    private List<Etablissement> etablissementList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing);

        textViewTitle = (TextView) findViewById(R.id.textv_Title);
        //listViewData = (ListView) findViewById(R.id.listv_Data);
        gridViewData = (GridView) findViewById(R.id.gridv_Data);

        if(getIntent().getExtras() != null) {

            boolean is_restaurant = (Boolean) getIntent().getBooleanExtra(Constant.INTENT_IS_RESTAURANT,false);
            if (is_restaurant) {
                etablissementList.clear();
                textViewTitle.setText(R.string.Listing_title_restaurant);
                GenererListResto();


            } else {
                etablissementList.clear();
                textViewTitle.setText(R.string.Listing_title_hotel);
                GenererListHotel();
            }

            gridViewData.setAdapter(
                    new EtablissementAdapter(ListingActivity.this,
                            R.layout.activity_listing_item,
                            etablissementList)
            );

            gridViewData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent i = new Intent(ListingActivity.this, DetailActivity.class);
                    Bundle b = new Bundle();
                    b.putSerializable(Constant.INTENT_OBJECT, etablissementList.get(position));
                    i.putExtras(b);
                    startActivity(i);
                }
            });
        }
    }

    private void GenererListHotel() {
        etablissementList.add(new Hotel("IBIS", "Travail", "ibis@ibis.fr","0101010101","http://www.ibis.com/fr/france/index.shtml","http://blog.blanee.com/wp-content/uploads/2010/12/hotel-ibis-tanger.jpg"));
        etablissementList.add(new Hotel("FOUR SEASONS", "Visite", "four@seasons.fr", "0240032575", "www.fourseasons.com/","https://www.google.fr/imgres?imgurl=https%3A%2F%2Fu.tfstatic.com%2Frestaurant_photos%2F961%2F73961%2F169%2F612%2Fle-george-hotel-george-v-vue-de-la-notre-terrasse-9e995.jpg&imgrefurl=https%3A%2F%2Ffr.mappy.com%2Fpoi%2F560afe539191b05b0fe3461c&docid=vVrgHcWAqVUwkM&tbnid=VSRaR-smPwPaRM%3A&vet=10ahUKEwj9xZiopsLTAhUF2xoKHTHZCBMQMwhGKBwwHA..i&w=612&h=344&bih=918&biw=1280&q=four%20seasons%20hotel%20nantes&ved=0ahUKEwj9xZiopsLTAhUF2xoKHTHZCBMQMwhGKBwwHA&iact=mrc&uact=8"));
    }

    private void GenererListResto() {
        etablissementList.add(new Restaurant("Mac Do", "Fast Food", "macdo@macdo.fr", "0130486000", "https://www.mcdonalds.fr/","https://goo.gl/sdjfC4"));
        etablissementList.add(new Restaurant("Burger King", "Fast Food", "burger@king.fr", "0102030405", "https://www.burgerking.fr/","https://img.argentdubeurre.com/content/5384/burger-king-vous-ecoute-1-burger-offert.jpg"));
        etablissementList.add(new Restaurant("KFC", "Fast Food", "kfc@kfc.fr", "0184110000", "https://www.kfc.fr/","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTzlCg1CnnwzlOZAs__OPqwynJpqCF6YiXGT78iF9uNZUwEu1K-Xw"));
        etablissementList.add(new Restaurant("Quick", "Fast Food", "accueil2@quick.fr", "0149516464", "https://www.quick.fr/fr","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTSZ84T_lX1MJyJrCrGV_s3f1o6z3vvz1erWcVhndl4fM_llowNLA"));
    }
}
