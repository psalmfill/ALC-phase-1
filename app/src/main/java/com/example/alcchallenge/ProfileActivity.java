package com.example.alcchallenge;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    public void visitLink(View view){
        int id = view.getId();
        switch (id){
            case R.id.facebook:
                openUrl("https://web.facebook.com/SamfieldHawb");
                break;
            case R.id.twitter:
                openUrl("https://twitter.com/SamfieldHawb");
                break;
            case R.id.gmail:
                sendEmail();
                break;
            case R.id.github:
                openUrl("https://github.com/psalmfill");
                break;
            default:
                break;

        }
    }

    public void openUrl(String url){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    protected void sendEmail() {
        Log.i("Send email", "");
        String[] TO = {"samfield4sure@gmail.com","basseysamfield@gmail.com"};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "We will like to hire You");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Hello there \nwe will love to get in touch with you.");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finished sending email", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
}
