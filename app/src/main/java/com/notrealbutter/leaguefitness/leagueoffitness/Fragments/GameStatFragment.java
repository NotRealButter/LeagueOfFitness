package com.notrealbutter.leaguefitness.leagueoffitness.Fragments;

import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.notrealbutter.leaguefitness.leagueoffitness.LeagueCntl.SummonerAccount;
import com.notrealbutter.leaguefitness.leagueoffitness.R;

public class GameStatFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


    // TODO: Rename and change types of parameters

    private OnFragmentInteractionListener mListener;

    public TextView summonerNameGS;
    public TextView summonerLevelGS;
    public TextView summonerIDGS;
    public SummonerAccount summonerAccount;

    public static GameStatFragment newInstance(String param1, String param2) {
        GameStatFragment fragment = new GameStatFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public GameStatFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_game_stat, container, false);

         summonerNameGS = (TextView) view.findViewById(R.id.summonerNameBoxGS);
         summonerLevelGS = (TextView) view.findViewById(R.id.summonerLevelBoxGS);
         summonerIDGS = (TextView) view.findViewById(R.id.summonerIDBoxGS);

        updateView();
        return view;
    }

    public void changeText(String inputWords){
        summonerNameGS.setText(inputWords);
    }

    // TODO: Rename method, update argument and hook method into UI event
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
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

    public void setSummonerAccount(SummonerAccount acct){
        summonerAccount = acct;
    }

    public void updateView(){
        summonerNameGS.setText("Summoner Name: " +summonerAccount.getNameCollected());
        summonerLevelGS.setText("Level: " +summonerAccount.getSummonerLevelCollected());
        summonerIDGS.setText("ID: " + summonerAccount.getSummonerIDCollected());

    }


}
