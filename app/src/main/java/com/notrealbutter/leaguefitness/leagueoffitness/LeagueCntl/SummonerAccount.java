package com.notrealbutter.leaguefitness.leagueoffitness.LeagueCntl;

import com.robrua.orianna.type.dto.matchlist.MatchList;

public class SummonerAccount {
    private String nameCollected;
    private int summonerIDCollected;
    private int summonerLevelCollected;
    public MatchList recentGamesCollected = null;

    public SummonerAccount()
    {
        nameCollected = "none";
        summonerIDCollected = 0;
        summonerLevelCollected = 0;
        recentGamesCollected = new MatchList();
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

    public MatchList getRecentGamesCollected() {
        return recentGamesCollected;
    }

    public void setRecentGamesCollected(MatchList recentGamesCollected) {
        this.recentGamesCollected = recentGamesCollected;
    }

    public int getSummonerLevelCollected() {
        return summonerLevelCollected;
    }

    public void setSummonerLevelCollected(int summonerLevelCollected) {
        this.summonerLevelCollected = summonerLevelCollected;
    }


}



