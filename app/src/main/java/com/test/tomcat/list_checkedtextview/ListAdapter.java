package com.test.tomcat.list_checkedtextview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;

import java.util.List;

/**
 * Created by tomcat on 2017/3/19.
 */

public class ListAdapter extends BaseAdapter
{
    private Activity        activity;
    private List<String>    mList;

    private static LayoutInflater   inflater = null;

    public ListAdapter(Activity a, List<String> list)
    {
        activity = a;
        mList = list;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount()
    {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View vi = convertView;
        if (convertView == null)
        {
            vi =  inflater.inflate(R.layout.item, null);
        }

        CheckedTextView chkBshow = (CheckedTextView) vi.findViewById(R.id.check1);
        chkBshow.setText(mList.get(position).toString());
        return vi;
    }
}
