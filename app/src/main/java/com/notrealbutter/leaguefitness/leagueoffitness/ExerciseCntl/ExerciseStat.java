package com.notrealbutter.leaguefitness.leagueoffitness.ExerciseCntl;

/**
 * Created by hites on 10/8/2015.
 */
public class ExerciseStat {
    private int killCount = 0;
    private int deathCount = 0;
    private int assistCount = 0;
    private int creepScore = 0;
    private int gameDuration = 0;

    private int pushUps;
    private int crunches;
    private int burpees;
    private int runDuration;

    public ExerciseStat(int kc,int dc, int ac, int cs, int gd){
        killCount = kc;
        deathCount = dc;
        assistCount = ac;
        creepScore = cs;
        gameDuration = gd;

        setUpExercise();
    }

    public void temporaryPresentationPrep()
    {
        setKillCount((int)(Math.random()*7));
        setDeathCount((int) (Math.random() * 9));
        setAssistCount((int) (Math.random() * 19));
        setCreepScore((int) (Math.random() * 275));
        setGameDuration((int) (30 + (Math.random() * 40)));
    }

    public void setUpExercise(){
        temporaryPresentationPrep();

        setPushUps(getKillCount() * 5 + getAssistCount());
        setBurpees(getDeathCount() * 5);
        setCrunches(getCreepScore() /10);
        setRunDuration(getGameDuration());

    }


    public int getKillCount() {
        return killCount;
    }

    public void setKillCount(int killCount) {
        this.killCount = killCount;
    }

    public int getDeathCount() {
        return deathCount;
    }

    public void setDeathCount(int deathCount) {
        this.deathCount = deathCount;
    }

    public int getAssistCount() {
        return assistCount;
    }

    public void setAssistCount(int assistCount) {
        this.assistCount = assistCount;
    }

    public int getCreepScore() {
        return creepScore;
    }

    public void setCreepScore(int creepScore) {
        this.creepScore = creepScore;
    }

    public int getGameDuration() {
        return gameDuration;
    }

    public void setGameDuration(int gameDuration) {
        this.gameDuration = gameDuration;
    }

    public int getPushUps() {
        return pushUps;
    }

    public void setPushUps(int pushUps) {
        this.pushUps = pushUps;
    }

    public int getCrunches() {
        return crunches;
    }

    public void setCrunches(int crunches) {
        this.crunches = crunches;
    }

    public int getBurpees() {
        return burpees;
    }

    public void setBurpees(int burpees) {
        this.burpees = burpees;
    }

    public int getRunDuration() {
        return runDuration;
    }

    public void setRunDuration(int runDuration) {
        this.runDuration = runDuration;
    }

}
