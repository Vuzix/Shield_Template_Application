package com.vuzix.sample.shieldsampleapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity
{
    private MenuItem HelloMenuItem;
    private MenuItem VuzixMenuItem;
    private MenuItem ShieldMenuItem;
    private TextView mainText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu, menu);
        HelloMenuItem = menu.findItem(R.id.item1);
        VuzixMenuItem = menu.findItem(R.id.item2);
        ShieldMenuItem = menu.findItem(R.id.item3);
        mainText = findViewById(R.id.mainTextView);
        //updateMenuItems();
        return true;
    }

    @Override protected boolean alwaysShowOptionsMenu()
    {
        return false;
    }
    private void updateMenuItems()
    {
        if (HelloMenuItem == null)
        {
            return;
        }
        VuzixMenuItem.setEnabled(false);
        ShieldMenuItem.setEnabled(false);
    }

    //Action Menu Click events
    //This events where register via the XML for the menu definitions.
    public void showHello(MenuItem item)
    {
        showToast("Hello World!");
        mainText.setText("Hello World!");
        VuzixMenuItem.setEnabled(true);
        ShieldMenuItem.setEnabled(true);
    }
    public void showVuzix(MenuItem item)
    {
        showToast("Vuzix!");
        mainText.setText("Vuzix!");
    }
    public void showShield(MenuItem item)
    {
        showToast("Shield");
        mainText.setText("Shield");
    }
    private void showToast(final String text)
    {
        final Activity activity = this;
        activity.runOnUiThread(new Runnable()
        {
            @Override public void run()
            {
                Toast.makeText(activity, text, Toast.LENGTH_SHORT).show();
            }
        });
    }
}