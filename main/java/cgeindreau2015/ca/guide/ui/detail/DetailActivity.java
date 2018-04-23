package cgeindreau2015.ca.guide.ui.detail;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import cgeindreau2015.ca.guide.ui.AppActivity;
import cgeindreau2015.ca.guide.util.Constant;
import cgeindreau2015.ca.guide.models.Etablissement;
import cgeindreau2015.ca.guide.R;

public class DetailActivity extends AppActivity {

    private ImageView imgv_Image;
    private TextView textv_Name;
    private TextView textv_Category;
    private Button btn_Mail;
    private Button btn_Phone;
    private Button btn_Site;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imgv_Image = (ImageView) findViewById(R.id.imgv_image);
        textv_Name = (TextView) findViewById(R.id.textv_name);
        textv_Category = (TextView) findViewById(R.id.textv_category);
        btn_Mail = (Button) findViewById(R.id.btn_mail);
        btn_Phone = (Button) findViewById(R.id.btn_phone);
        btn_Site = (Button) findViewById(R.id.btn_site);

        if (getIntent().hasExtra(Constant.INTENT_OBJECT)) {
            Etablissement e = (Etablissement) getIntent().getSerializableExtra(Constant.INTENT_OBJECT);
            textv_Name.setText(e.getName());
            textv_Category.setText(e.getCategory());
            btn_Mail.setText(e.getEmail());
            btn_Site.setText(e.getUrl());
            btn_Phone.setText(e.getPhone());
            Picasso.with(DetailActivity.this).load(e.getImage()).into(imgv_Image);

        }

    }


    public void Click(View view) {
        String action = view.getTag().toString();
        switch (action) {
            case "mail" :
                SendMail(view);
                break;
            case "site" :
                OpenUrl(view);
                break;
            case "phone" :
                Call(view);
                break;
        }
    }

    // accès internet
    public void OpenUrl(View view) {
        if (URLUtil.isValidUrl(btn_Site.getText().toString())) {
            Uri url = Uri.parse(btn_Site.getText().toString());
            Intent i = new Intent(Intent.ACTION_VIEW, url);
            startActivity(i);
        } else {
            Toast.makeText(DetailActivity.this, "URL invalide", Toast.LENGTH_SHORT).show();
        }
    }

    // téléphoner
    public void Call(View view) {
        Intent i = new Intent(Intent.ACTION_CALL);
        i.setData(Uri.parse("tel:" + btn_Phone.getText().toString()));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[] {Manifest.permission.CALL_PHONE},10);
            }

            return;
        }
        startActivity(i);
    }

    // envoyer un mail
    public void SendMail(View view) {

        Intent i = new Intent(Intent.ACTION_SEND);

        String[] TO = {String.valueOf(btn_Mail.getText())};
        String[] CC = {"xyz@gmail.com"};
        String[] BCC = {"cci@gmail.com"};

        i.setType("message/rfc822");

        i.putExtra(Intent.EXTRA_EMAIL, TO);
        i.putExtra(Intent.EXTRA_CC, CC);
        i.putExtra(Intent.EXTRA_BCC, BCC);
        i.putExtra(Intent.EXTRA_SUBJECT, textv_Name.getText());
        i.putExtra(Intent.EXTRA_TEXT, "Je voudrais réserver");

        startActivity(i);

    }

    // envoyer un sms
    //Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:123"));
    //startActivity(i);


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == 10){
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) { // Acceptation user
                Call(btn_Phone);
            } else { // Refus user
                Toast.makeText(DetailActivity.this, "Permission refusée", Toast.LENGTH_SHORT).show();
            }

        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
