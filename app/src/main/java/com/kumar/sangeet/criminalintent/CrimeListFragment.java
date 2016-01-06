package com.kumar.sangeet.criminalintent;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by sangeet kumar on 12/31/2015.
 */
public class CrimeListFragment extends ListFragment {
    private final static String TAG = "CrimeListActivity";
    private ArrayList<Crime> mCrimes;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.crimes_title);
        mCrimes = CrimeLab.get(getActivity()).getCrimes();

        ArrayAdapter<Crime> adapter = new ArrayAdapter<Crime>(getActivity(),android.R.layout.simple_list_item_1,mCrimes);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l,View v,int position,long id){
            Crime c = ((CrimeAdapter)getListAdapter()).getItem(position);
            Log.d(TAG, c.getTitle() + " was clicked");
    }

    private class CrimeAdapter extends ArrayAdapter{

        public CrimeAdapter(ArrayList<Crime> crimes){
            super(getActivity(),0,crimes);
        }
    }

    @Override
    public View getView(int position,View convertView,ViewGroup parent){
        if(convertView == null){
            convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_crime,null);
        }

        CheckBox solvedCheckBox =(CheckBox)convertView.findViewById(R.id.crime_list_item_solvedCheckBox);
        return convertView;
    }
}
