package com.example.pokemon125;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {
    private Pokemon eevee;
    private Pokemon garchomp;
    private Pokemon greninja;
    private Pokemon voltorb;
    private Pokemon riolu;
    private Pokemon six; //TO BE DETERMINED
    private List<Pokemon> userLineup;
    private Pokemon userCurrent;

    private Pokemon ekans;
    private Pokemon porygon;
    private Pokemon entei;
    private Pokemon mrMime;
    private Pokemon dialga;
    private Pokemon mewTwo;
    private List<Pokemon> geoffLineup;
    private int geoffPokeCount;
    private Pokemon geoffCurrent;

    private PokeApi pokeApi = new PokeApiClient();

    private TextView message;
    private Button move1;
    private Button move2;
    private Button move3;
    private Button move4;
    private Button fightOption;

    private String userDamageName;
    private int userDamage;

    private String geoffMove1Name;
    private int geoffMove1Dmg;
    private String geoffMove2Name;
    private int geoffMove2Dmg;
    private String geoffMove3Name;
    private int geoffMove3Dmg;
    private String geoffMove4Name;
    private int geoffMove4Dmg;
    private String geoffDamageName;
    private int geoffDamage;

    private TextView geoffFirstRow;
    private TextView geoffSecondRow;
    private TextView playerFirstRow;
    private TextView playerSecondRow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        eevee = new Pokemon("FLUFFY", 314, 229, 218, 207, 251, 229);
        garchomp = new Pokemon("GARCHOMP", 420, 482, 361, 372, 317, 311);
        greninja = new Pokemon("NARUTO", 348, 317, 256, 335, 265, 377);
        voltorb = new Pokemon("VOLTORB", 284, 174, 218, 229, 229, 328);
        riolu = new Pokemon("RAMICU", 284, 262, 196, 185, 196, 240);
        six = new Pokemon("POKEMON 6", 420, 229, 218, 207, 251, 229); // NEED TO EDIT
        userLineup = Arrays.asList(eevee, garchomp, greninja, voltorb, riolu, six);

        ekans = new Pokemon("Machine Project 0", 274, 240, 205, 196, 227, 229);
        porygon = new Pokemon("Machine Project 1", 334, 240, 262, 295, 273, 196);
        entei = new Pokemon("Machine Project 2", 434, 361, 295, 306, 273, 328);
        mrMime = new Pokemon("Machine Project 3", 284, 207, 251, 328, 372, 306);
        dialga = new Pokemon("Machine Project 4", 404, 372, 372, 438, 328, 306);
        mewTwo = new Pokemon("Final Project", 416, 350, 306, 447, 306, 394);

        geoffLineup = Arrays.asList(ekans, porygon, entei, mrMime, dialga, mewTwo);
        geoffPokeCount = 0;
        geoffCurrent = geoffLineup.get(geoffPokeCount);

        setContentView(R.layout.fight_screen);
        move1 = findViewById(R.id.moveTL);
        move2 = findViewById(R.id.moveTR);
        move3 = findViewById(R.id.moveBL);
        move4 = findViewById(R.id.moveBR);
        geoffFirstRow = findViewById(R.id.geoffFirstRow);
        geoffSecondRow = findViewById(R.id.geoffSecondRow);
        playerFirstRow = findViewById(R.id.playerFirstRow);
        playerSecondRow = findViewById(R.id.playerSecondRow);

        Intent intent = getIntent();
        String currentSelection = intent.getStringExtra("selectedPokemon");
        message = findViewById(R.id.messageBox);
        message.setText("What will \n" + currentSelection + " do?");

        //where you would rename the moves:
        move1.setText("50 dmg");
        move2.setText("100 dmg");
        move3.setText("150 dmg");
        move4.setText("200 dmg");
        fightOption = findViewById(R.id.fight);

        if (currentSelection.equals("FLUFFY")) {
            userCurrent = eevee;
        }
        if (currentSelection.equals("GARCHOMP")) {
            userCurrent = garchomp;
        }
        if (currentSelection.equals("NARUTO")) {
            userCurrent = greninja;
        }
        if (currentSelection.equals("VOLTORB")) {
            userCurrent = voltorb;
        }
        if (currentSelection.equals("RAMICU")) {
            userCurrent = riolu;
        }
        if (currentSelection.equals("Pokemon 6")) { //TO BE DETERMINED
            userCurrent = eevee;
        }
        setPokeStats(geoffFirstRow, geoffSecondRow, geoffCurrent);
        setPokeStats(playerFirstRow, playerSecondRow, userCurrent);

        fightOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMoves();
                move1.setOnClickListener(this);
                move2.setOnClickListener(this);
                move3.setOnClickListener(this);
                move4.setOnClickListener(this);
                //showMessage();
            }
        });
    }


    /*
    fightOption.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                fightAction();
                int geoffRandomAtk = (int) (Math.random() * 4) + 1;
                if (geoffRandomAtk == 1) {
                    geoffDamageName = geoffMove1Name;
                    geoffDamage = geoffMove1Dmg;
                } else if (geoffRandomAtk == 2) {
                    geoffDamageName = geoffMove2Name;
                    geoffDamage = geoffMove2Dmg;
                } else if (geoffRandomAtk == 3) {
                    geoffDamageName = geoffMove3Name;
                    geoffDamage = geoffMove3Dmg;
                } else if (geoffRandomAtk == 4) {
                    geoffDamageName = geoffMove4Name;
                    geoffDamage = geoffMove4Dmg;
                }
                message.setText(userCurrent.getName() + " used " + userDamageName + "!");
            }
        });
     */

    /*
    if (userCurrent.getSpeed() >= geoffCurrent.getSpeed()) {
                    message.setText(userCurrent.getName() + " used " + userDamageName + "!");
                    geoffCurrent.setCurrentHealth(geoffCurrent.getCurrentHealth() - userDamage);
                    setPokeStats(geoffFirstRow, geoffSecondRow, geoffCurrent);
                    LinearLayout wholeScreen = findViewById(R.id.fight_Screen);
                    wholeScreen.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            message.setText("What will \n" + userCurrent.getName() + " do?");
                            return;
                        }
                    });
                } else {
                    userCurrent.setCurrentHealth(userCurrent.getCurrentHealth() - geoffDamage);
                    setPokeStats(playerFirstRow, playerSecondRow, userCurrent);
                }
     */

    private void fightAction() {
        showMoves();
        move1.setOnClickListener(this);
        move2.setOnClickListener(this);
        move3.setOnClickListener(this);
        move4.setOnClickListener(this);

    }

    private void showMessage() {
        message.setVisibility(View.VISIBLE);
        move1.setVisibility(View.INVISIBLE);
        move2.setVisibility(View.INVISIBLE);
        move3.setVisibility(View.INVISIBLE);
        move4.setVisibility(View.INVISIBLE);
    }

    private void showMoves() {
        message.setVisibility(View.INVISIBLE);
        move1.setVisibility(View.VISIBLE);
        move2.setVisibility(View.VISIBLE);
        move3.setVisibility(View.VISIBLE);
        move4.setVisibility(View.VISIBLE);
    }

    private void setPokeStats(TextView text1, TextView text2, Pokemon poke) {
        text1.setText(poke.getName() + " :L100");
        text2.setText("HP: " + poke.getCurrentHealth() + "/" + poke.getTotalHealth());
    }

    /*
        user chooses move
        if user is first based on speed:
            user attacks
            geoff takes dmg
            >check for geoff faint
                if yes, check if all pokemon are fainted
                    if yes, game over
                else switch to next pokemon

            geoff attacks
            user takes dmg
            >check for user faint
                if yes, check if all pokemon are fainted
                    if yes, game over
                else switch to pokemon selection menu

        if geoff is first based on speed:
            geoff attacks
            user takes dmg (^^)
            user attacks
            geoff takes dmg (^^)

        message board back up, repeat

        pokemon selection menu method:
        update hp of pokemon with current hp
        upon selection, check hp:
            if 0:
                toast message
            else:
                set current pokemon to selected pokemon, copy from onCreate
         */

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.moveTL: {
                //Move 1 selected
                userDamageName = "50 dmg";
                userDamage = 50;
                dealDamage();
                break;
            }
            case R.id.moveTR:
                userDamageName = "100 dmg";
                userDamage = 100;
                dealDamage();
                break;
            case R.id.moveBL:
                userDamageName = "150 dmg";
                userDamage = 150;
                dealDamage();
                break;
            case R.id.moveBR:
                userDamageName = "200 dmg";
                userDamage = 200;
                dealDamage();
                break;
        }
    }

    private void dealDamage() {
        message.setText(userDamage);
        showMessage();
        geoffCurrent.setCurrentHealth(userDamage);
        setPokeStats(geoffFirstRow, geoffSecondRow, geoffCurrent);
    }

    /**
     * Use this method every time Geoff plays a new Pokemon.
     * Will eventually use the geoff.current Pokemon
     */
    private void setGeoffMoves() {
        geoffMove1Name = "50 dmg";
        geoffMove2Name = "100 dmg";
        geoffMove3Name = "150 dmg";
        geoffMove4Name = "200 dmg";
        geoffMove1Dmg = 50;
        geoffMove2Dmg = 100;
        geoffMove3Dmg = 150;
        geoffMove4Dmg = 200;
    }

    /**
     * Set the name of the moves based on the current Pokemon selected.
     */
    public void initialSetup() {
        TextView move1 = findViewById(R.id.moveTL);
        move1.setText(userCurrent.getMove1());
        TextView move2 = findViewById(R.id.moveTR);
        move2.setText(userCurrent.getMove2());
        TextView move3 = findViewById(R.id.moveBL);
        move3.setText(userCurrent.getMove3());
        TextView move4 = findViewById(R.id.moveBR);
        move4.setText(userCurrent.getMove4());
        /*
        ConstraintLayout parent = findViewById(R.id.playerOptions);
        //parent.removeAllViews();
        View messageChunk = getLayoutInflater().inflate(R.layout.chunk_player_options, parent, false);
        TextView move1 = messageChunk.findViewById(R.id.moveTL);
        move1.setText(userCurrent.getMove1());
        TextView move2 = messageChunk.findViewById(R.id.moveTR);
        move2.setText(userCurrent.getMove2());
        TextView move3 = messageChunk.findViewById(R.id.moveBL);
        move3.setText(userCurrent.getMove3());
        TextView move4 = messageChunk.findViewById(R.id.moveBR);
        move4.setText(userCurrent.getMove4());
        parent.addView(messageChunk);
         */
    }
}