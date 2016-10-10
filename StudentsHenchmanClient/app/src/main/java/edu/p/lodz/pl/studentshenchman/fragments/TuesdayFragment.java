package edu.p.lodz.pl.studentshenchman.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.p.lodz.pl.studentshenchman.R;

public class TuesdayFragment extends Fragment {

    private static final String FRAGMENT_NUMBER = "numer_fragmentu";

    public TuesdayFragment() {}

    public static TuesdayFragment getInstance(int fragmentNumber) {
        TuesdayFragment fragment = new TuesdayFragment();

        Bundle args = new Bundle();
        args.putInt(FRAGMENT_NUMBER, fragmentNumber);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_tuesday, container, false);
        return view;
    }

    @Override
    public void onStop()
    {
        super.onStop();
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
    }

    @Override
    public void onDetach()
    {
        super.onDetach();
    }
}