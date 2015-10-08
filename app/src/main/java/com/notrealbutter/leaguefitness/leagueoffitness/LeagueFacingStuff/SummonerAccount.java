package com.notrealbutter.leaguefitness.leagueoffitness.LeagueFacingStuff;

import android.widget.Toast;

import com.robrua.orianna.api.core.AsyncRiotAPI;
import com.robrua.orianna.type.api.Action;
import com.robrua.orianna.type.core.matchlist.MatchReference;
import com.robrua.orianna.type.core.summoner.Summoner;
import com.robrua.orianna.type.exception.APIException;

import java.util.List;

/**
 * Created by hites on 9/28/2015.
 */
public class SummonerAccount {
    private String nameCollected;
    private int summonerIDCollected;
    private int summonerLevelCollected;
    private List<MatchReference> recentGamesCollected = null;

    public SummonerAccount() {
        nameCollected = "none";
        summonerIDCollected = 0;
        summonerLevelCollected = 0;
        List<MatchReference> recentGamesCollected = null;
    }

    public String getSummonerName() {
        return getNameCollected();
    }

    public int getSummonerIDCollected() {
        return summonerIDCollected;
    }

    public String getNameCollected() {
        return nameCollected;
    }

    public void setNameCollected(String nameCollected) {
        this.nameCollected = nameCollected;
    }

    public void setSummonerIDCollected(int summonerIDCollected) {
        this.summonerIDCollected = summonerIDCollected;
    }

    public List<MatchReference> getRecentGamesCollected() {
        return recentGamesCollected;
    }

    public void setRecentGamesCollected(List<MatchReference> recentGamesCollected) {
        this.recentGamesCollected = recentGamesCollected;
    }

    public int getSummonerLevelCollected() {
        return summonerLevelCollected;
    }

    public void setSummonerLevelCollected(int summonerLevelCollected) {
        this.summonerLevelCollected = summonerLevelCollected;
    }


}



