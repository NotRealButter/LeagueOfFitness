package com.notrealbutter.leaguefitness.leagueoffitness;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.notrealbutter.leaguefitness.leagueoffitness.ExerciseCntl.ExerciseStat;
import com.notrealbutter.leaguefitness.leagueoffitness.Fragments.AboutFragment;
import com.notrealbutter.leaguefitness.leagueoffitness.Fragments.ContactUsFragment;
import com.notrealbutter.leaguefitness.leagueoffitness.Fragments.ExerciseFragement;
import com.notrealbutter.leaguefitness.leagueoffitness.Fragments.GameStatFragment;
import com.notrealbutter.leaguefitness.leagueoffitness.Fragments.InitialFragment;
import com.notrealbutter.leaguefitness.leagueoffitness.LeagueCntl.RiotController;
import com.notrealbutter.leaguefitness.leagueoffitness.LeagueCntl.SummonerAccount;
import com.robrua.orianna.api.core.AsyncRiotAPI;
import com.robrua.orianna.api.dto.BaseRiotAPI;
import com.robrua.orianna.type.api.Action;
import com.robrua.orianna.type.core.common.Region;
import com.robrua.orianna.type.core.matchlist.MatchReference;
import com.robrua.orianna.type.core.summoner.Summoner;
import com.robrua.orianna.type.exception.APIException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,InitialFragment.OnFragmentInteractionListener {

    RiotController riotController;
    SummonerAccount summonerAccount;

    String enteredName;
    private ListView drawerList;
    private String[] navMenuTitles;

    public List<MatchReference> localMatchList;

    DrawerLayout drawerLayout;
    FragmentManager fm;

    InitialFragment initialFragment;
    AboutFragment aboutFragment;
    ContactUsFragment contactUsFragment;
    ExerciseFragement exerciseFragement;
    GameStatFragment gameStatFragment;
    FloatingActionButton button;
    ExerciseStat exerciseStat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initMenus(savedInstanceState);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void onButtonClick(View view) {
        EditText entrybox = (EditText) findViewById(R.id.summonerEntryField);
        String name = entrybox.getText().toString();
        System.out.println(name);
        enteredName = name;
        leagueInit(name);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) { }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        Fragment fragment = initialFragment;
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            fragment = initialFragment;
            Toast toast1 = Toast.makeText(getApplicationContext(),"this works1",Toast.LENGTH_LONG);
            toast1.show();
        } else if (id == R.id.nav_game_stat) {
            fragment = gameStatFragment;
            Toast toast2 = Toast.makeText(getApplicationContext(),"this works2",Toast.LENGTH_LONG);
            toast2.show();
        } else if (id == R.id.nav_exercise) {
            fragment = exerciseFragement;
            Toast toast3 = Toast.makeText(getApplicationContext(),"this works3",Toast.LENGTH_LONG);
            toast3.show();
        } else if (id == R.id.nav_about) {
            fragment = aboutFragment;
            Toast toast4 = Toast.makeText(getApplicationContext(),"this works4",Toast.LENGTH_LONG);
            toast4.show();
        } else if (id == R.id.nav_share) {
            Toast toast5= Toast.makeText(getApplicationContext(),"this works5",Toast.LENGTH_LONG);
            toast5.show();
        } else if (id == R.id.nav_send) {
            Toast toast6 = Toast.makeText(getApplicationContext(),"this works6",Toast.LENGTH_LONG);
            toast6.show();
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.container, fragment).commit();
        } else {
            // error in creating fragment
            Log.e("MainActivity", "Error in creating fragment");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void leagueInit(String name) {
        AsyncRiotAPI.getSummonerByName(new Action<Summoner>() {
            @Override
            public void perform(final Summoner summoner) {
                Date now = new Date(System.currentTimeMillis());
                summonerAccount.setNameCollected(summoner.getName());
                summonerAccount.setSummonerIDCollected((int) summoner.getID());
                summonerAccount.setSummonerLevelCollected((int) summoner.getLevel());

                System.out.println(summoner.getName() + " " + summoner.getID() + " " + summoner.getLevel());

//                Action action = new Action<List<MatchReference>>() {
//                    @Override
//
//                    public void perform(List<MatchReference> responseData) {
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                Toast toast = Toast.makeText(getApplicationContext(), "Matches Retrieved", Toast.LENGTH_LONG);
//                                toast.show();
//                            }
//                        });
//                    }
//
//                    @Override
//                    public void handle(APIException exception) {
//                        System.out.println("Couldn't Get Matchlist");
//                    }
//
//                };
//
//                summonerAccount.recentGamesCollected = BaseRiotAPI.getMatchList(summoner.getID());
//                Toast toast = Toast.makeText(getApplicationContext(), summonerAccount.recentGamesCollected.getMatches().size(), Toast.LENGTH_LONG);
//                                toast.show();


                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast toast = Toast.makeText(getApplicationContext(), "Summoner " + summonerAccount.getSummonerName() + " successfully loaded", Toast.LENGTH_LONG);
                        toast.show();
                    }
                });
            }

            public void handle(APIException e) {
                System.out.println("Couldn't get summoner");
            }
        }, name);

        temporaryPresentationPrep();
        gameStatFragment.setSummonerAccount(summonerAccount);
        exerciseFragement.setSummonerAccount(summonerAccount);
        exerciseFragement.setExerciseStat(exerciseStat);
        gameStatFragment.updateView();
        exerciseFragement.updateView();

        System.out.println("Number of Crunches:" + exerciseStat.getCrunches());
        button.hide();
    }

    public void initMenus(Bundle savedInstanceState)
    {
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        riotController = new RiotController();
        summonerAccount = new SummonerAccount();
        exerciseStat = new ExerciseStat(summonerAccount.getKillCount(),summonerAccount.getDeathCount(),summonerAccount.getAssistCount(),summonerAccount.getCreepScore(),summonerAccount.getGameDuration());

        initialFragment = InitialFragment.newInstance("param1","param2");
        aboutFragment = AboutFragment.newInstance("param1","param2");
        contactUsFragment = ContactUsFragment.newInstance("param1", "param2");
        exerciseFragement = ExerciseFragement.newInstance("param1", "param2");
        gameStatFragment = GameStatFragment.newInstance("param1","param2");

        gameStatFragment.setSummonerAccount(summonerAccount);

        fm = getFragmentManager();

        if (savedInstanceState == null) {
            fm.beginTransaction().replace(R.id.container, initialFragment, "title_section_1").commit();
        }

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
        navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);

        button = (FloatingActionButton) findViewById(R.id.fab);

        localMatchList = new ArrayList<>();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(this);

        AsyncRiotAPI.setMirror(Region.NA);
        AsyncRiotAPI.setRegion(Region.NA);
        AsyncRiotAPI.setAPIKey("f206b7e6-8f2c-4a64-a1bd-79e26953b808");
        BaseRiotAPI.setMirror(Region.NA);
        BaseRiotAPI.setRegion(Region.NA);
        BaseRiotAPI.setAPIKey("f206b7e6-8f2c-4a64-a1bd-79e26953b808");

        // add button listener
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                // get prompts.xml view
                LayoutInflater li = LayoutInflater.from(MainActivity.this);
                View promptsView = li.inflate(R.layout.prompts, null);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        MainActivity.this);

                // set prompts.xml to alertdialog builder
                alertDialogBuilder.setView(promptsView);

                final EditText userInput = (EditText) promptsView
                        .findViewById(R.id.editTextDialogUserInput);

                // set dialog message
                alertDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        // get user input and set it to result
                                        // edit text
                                        enteredName = userInput.getText().toString();
                                        leagueInit(enteredName);
                                    }
                                })
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        dialog.cancel();
                                    }
                                });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();
                // show it
                alertDialog.show();
            }
        });
    }
    public void temporaryPresentationPrep()
    {
        summonerAccount.setKillCount((int)(Math.random()*7));
        summonerAccount.setDeathCount((int) (Math.random() * 9));
        summonerAccount.setAssistCount((int) (Math.random() * 19));
        summonerAccount.setCreepScore((int) (Math.random() * 275));
        summonerAccount.setGameDuration((int)(Math.random()*40));
    }
}
