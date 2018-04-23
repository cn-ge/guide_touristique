package cgeindreau2015.ca.guide.ui.listing;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import cgeindreau2015.ca.guide.R;
import cgeindreau2015.ca.guide.models.Etablissement;


public class EtablissementAdapter extends ArrayAdapter<Etablissement> {

    private LayoutInflater inflater;
    private int resId;

    public EtablissementAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Etablissement> objects) {
        super(context, resource, objects);

        inflater = LayoutInflater.from(context);
        resId = resource; // = R.layout.activity_listing_item
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder viewHolder; // Classe ci-dessous

        if (convertView == null) { // Récupération du layout activity_listing_item
            //convertView = inflater.inflate(resId, parent, false);
            convertView = inflater.inflate(resId, null);

            viewHolder = new ViewHolder();
            viewHolder.textViewTitle = (TextView) convertView.findViewById(R.id.textv_Title);
            viewHolder.textViewCategory= (TextView) convertView.findViewById(R.id.textv_Category);

            convertView.setTag(viewHolder); // enregistre les views

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Etablissement item = getItem(position);
        viewHolder.textViewTitle.setText(item.getName());
        viewHolder.textViewCategory.setText(item.getCategory());

        return convertView;
    }
}


class ViewHolder {

    TextView textViewTitle;
    TextView textViewCategory;
}