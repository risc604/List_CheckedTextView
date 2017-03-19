package com.test.tomcat.list_checkedtextview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private static final String TAG = "MainActivity";
    List<String>    list;
    ListView        listView;
    List<Boolean>   listShow;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listview01);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                CheckedTextView chkItem = (CheckedTextView) view.findViewById(R.id.check1);
                chkItem.setChecked(!chkItem.isChecked());
                Toast.makeText(MainActivity.this, "You're selected " + (position+1) + " item.",
                                Toast.LENGTH_SHORT).show();
                listShow.set(position, chkItem.isChecked());

            }
        });

        listShow = new ArrayList<Boolean>();
        list = new ArrayList<String>();
        for (int x=1; x<11; x++)
        {
            list.add("item " + x);
            listShow.add(true);
        }
        ListAdapter adapterItem = new ListAdapter(this, list);
        listView.setAdapter(adapterItem);
    }

    @Override
    public void onBackPressed()
    {
        for (int x=0; x<listShow.size(); x++)
        {
            Log.d(TAG, "listShow(" + x + ") is " + listShow.get(x));
            if (listShow.get(x) == true)
            {
                // user process.
            }
        }
        super.onBackPressed();
    }
}

