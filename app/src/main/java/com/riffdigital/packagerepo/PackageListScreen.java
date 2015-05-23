package com.riffdigital.packagerepo;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class PackageListScreen extends ActionBarActivity
{
    String[] pkgTitles;
    String[] pkgDescriptions;
    String[] pkgDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.package_list);

        pkgTitles = getApplicationContext().getResources().getStringArray(R.array.package_titles);
        pkgDescriptions = getApplicationContext().getResources().getStringArray(R.array.package_descriptions);
        pkgDetails = getApplicationContext().getResources().getStringArray(R.array.package_detail);

        final ListView listview = (ListView)findViewById(R.id.titleList);
        final ArrayList<String> titleList = new ArrayList<String>();

        //put all the package titles into the list of titles
        //i did a for each for this, is that messy?
        for(String title : pkgTitles) titleList.add(title);

        //set up the adapter
        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, titleList);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int i, long id)
            {

                String title = pkgTitles[i];
                String description = pkgDescriptions[i];
                String detail = pkgDetails[i];



                Intent newActivity = new Intent(PackageListScreen.this, DetailsScreen.class);
                newActivity.putExtra("title_key", title);
                newActivity.putExtra("description_key", description);
                newActivity.putExtra("detail_key", detail);
                startActivity(newActivity);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_package_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}