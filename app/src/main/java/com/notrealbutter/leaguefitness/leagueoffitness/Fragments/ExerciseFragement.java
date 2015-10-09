package com.notrealbutter.leaguefitness.leagueoffitness.Fragments;

import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.notrealbutter.leaguefitness.leagueoffitness.ExerciseCntl.ExerciseStat;
import com.notrealbutter.leaguefitness.leagueoffitness.LeagueCntl.SummonerAccount;
import com.notrealbutter.leaguefitness.leagueoffitness.R;

public class ExerciseFragement extends Fragment {
    SummonerAccount summonerAccount;
    ExerciseStat exerciseStat;

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public static ExerciseFragement newInstance(String param1, String param2) {
        ExerciseFragement fragment = new ExerciseFragement();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public ExerciseFragement() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_exercise_fragement, container, false);
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(Uri uri);
    }

    public void setSummonerAccount(SummonerAccount acct){
        summonerAccount = acct;
    }

    public void setExerciseStat(ExerciseStat stat){
        exerciseStat = stat;
    }

    public void updateView(){

    }
}