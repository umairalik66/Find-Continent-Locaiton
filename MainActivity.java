package com.example.hw00;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {


    Uri gmmIntentUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] stringArray = new String[]{"Asia","Africa","Antartica","Europe","South America","North America","Australia"};
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.continents,stringArray);

        final ListView list = (ListView) findViewById(R.id.continentList);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                if (id == 0) {
                    // Create a Uri from an intent string. Use the result to create an Intent.
                    //Asia
                    gmmIntentUri = Uri.parse("geo:34.0479,100.6197?z=5&q=Asia");
                }
                else if (id == 1) {
                    // Africa
                    gmmIntentUri = Uri.parse("geo:-8.7832,34.5085?z=5&q=Africa");
                }
                else if (id == 2) {
                    // Antartica
                    gmmIntentUri = Uri.parse("geo:-82.8628,135.0000?z=5&q=Antartica");
                }
                else if (id == 3) {
                    // Europe
                    gmmIntentUri = Uri.parse("geo:54.5260,15.2551?z=5&q=Europe");
                }
                else if (id == 4) {
                    // South America
                    gmmIntentUri = Uri.parse("geo:-8.7832,-55.4915?z=5&q=South America");
                }
                else if (id == 5) {
                    // North America
                    gmmIntentUri = Uri.parse("geo:-54.5260,-105.2551?z=5&q=North America");
                }
                else if (id == 6) {
                    // Australia
                    gmmIntentUri = Uri.parse("geo:-25.2744,133.7751?z=5&q=Australia");
                }


                    // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    // Make the Intent explicit by setting the Google Maps package
                    mapIntent.setPackage("com.google.android.apps.maps");
                    // Attempt to start an activity that can handle the Intent
                    startActivity(mapIntent);


            }
        });

    }
}
