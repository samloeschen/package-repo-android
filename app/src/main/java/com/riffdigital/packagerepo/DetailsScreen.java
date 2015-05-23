package com.riffdigital.packagerepo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class DetailsScreen extends ActionBarActivity {

    String title;
    String description;
    String detail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.package_description);

        if (savedInstanceState == null) //only do this if we haven't already
        {
            Bundle extras = getIntent().getExtras();
            if(extras != null) //check to see if the main activity sent this one any extras
            {

                title = extras.getString("title_key");
                description = extras.getString("description_key");
                detail = extras.getString("detail_key");

                if(title==null)
                {
                    title = "There is no title for this package.";
                }

                if(description == null)
                {
                    description  =  "There is no description for this package.";
                }

                if(detail == null)
                {
                    detail = "There are no details for this package.";
                }
            }
            else
            {
                description = "There is no information for this package. :(";
            }
        }
        else
        {
            //since we're already in the instance, just use the values we already found
            title = (String) savedInstanceState.getSerializable("title_key");
            description = (String) savedInstanceState.getSerializable("description_key");
            detail = (String) savedInstanceState.getSerializable("detail_key");

        }

        final TextView titleView = (TextView) findViewById(R.id.package_title);
        final TextView descriptionView = (TextView) findViewById(R.id.package_description);
        final TextView detailView = (TextView) findViewById(R.id.package_detail);

        titleView.setText(title);
        descriptionView.setText(description);
        detailView.setText(detail);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_details_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
