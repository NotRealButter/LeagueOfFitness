package com.notrealbutter.leaguefitness.leagueoffitness.Fragments;

import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.notrealbutter.leaguefitness.leagueoffitness.ExerciseCntl.ExerciseStat;
import com.notrealbutter.leaguefitness.leagueoffitness.LeagueCntl.SummonerAccount;
import com.notrealbutter.leaguefitness.leagueoffitness.R;

public class ExerciseFragement extends Fragment {
    SummonerAccount summonerAccount;
    ExerciseStat exerciseStat;

    TextView exerciseInitiation, crunchBox,pushUpBox,burpeeView,runDurationBox;

    private OnFragmentInteractionListener mListener;

    public static ExerciseFragement newInstance() {
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
        View view = inflater.inflate(R.layout.fragment_exercise_fragement, container, false);

        exerciseInitiation = (TextView) view.findViewById(R.id.exerciseInitiation);
        crunchBox = (TextView) view.findViewById(R.id.crunchBox);
        pushUpBox = (TextView) view.findViewById(R.id.pushUpBox);
        burpeeView = (TextView) view.findViewById(R.id.burpeeView);
        runDurationBox = (TextView) view.findViewById(R.id.runDurationBox);
updateView();        return view;
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
         void onFragmentInteraction(Uri uri);
    }

    public void setSummonerAccount(SummonerAccount acct){
        summonerAccount = acct;
    }

    public void setExerciseStat(ExerciseStat stat){
        exerciseStat = stat;
    }

    public void initView(){
        exerciseInitiation.setText(R.string.exerciseInitiator);
        crunchBox.setText("");
        pushUpBox.setText("");
        burpeeView.setText("");
        runDurationBox.setText("");
    }

    public void updateView(){
            exerciseInitiation.setText("");
            exerciseStat.setUpExercise();
            crunchBox.setText("Recommended Number of Crunches: " + exerciseStat.getCrunches());
            pushUpBox.setText("Recommended Number of Push Ups: " + exerciseStat.getPushUps());
            burpeeView.setText("Recommended Number of Burpees: " + exerciseStat.getBurpees());
            runDurationBox.setText("Recommended duration of Run: " + exerciseStat.getRunDuration() + "minutes");

    }
}