package com.example.engelssoto.match2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;

public class MediumActivity extends AppCompatActivity {

    ImageView card_11, card_12, card_13, card_21, card_22, card_23;
    Integer[] cardsArray = {101, 102, 103, 201, 202, 203};
    int picture101, picture102, picture103, picture201, picture202, picture203;
    int firstCard, secondCard;
    int selectedFirst, selectedSecond;
    int cardNumber = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medium);

        card_11 = findViewById(R.id.card_11);
        card_12 = findViewById(R.id.card_12);
        card_13 = findViewById(R.id.card_13);
        card_21 = findViewById(R.id.card_21);
        card_22 = findViewById(R.id.card_22);
        card_23 = findViewById(R.id.card_23);

        card_11.setTag("0");
        card_12.setTag("1");
        card_13.setTag("2");
        card_21.setTag("3");
        card_22.setTag("4");
        card_23.setTag("5");

        //Load the actual pictures
        frontOfCardsPictures();

        //Shuffle the cards
        Collections.shuffle(Arrays.asList(cardsArray));

        card_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int parsedTag = Integer.parseInt((String) v.getTag());
                managePicture(card_11, parsedTag);
            }
        });

        card_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int parsedTag = Integer.parseInt((String) v.getTag());
                managePicture(card_12, parsedTag);
            }
        });

        card_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int parsedTag = Integer.parseInt((String) v.getTag());
                managePicture(card_13, parsedTag);
            }
        });

        card_21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int parsedTag = Integer.parseInt((String) v.getTag());
                managePicture(card_21, parsedTag);
            }
        });

        card_22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int parsedTag = Integer.parseInt((String) v.getTag());
                managePicture(card_22, parsedTag);
            }
        });

        card_23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int parsedTag = Integer.parseInt((String) v.getTag());
                managePicture(card_23, parsedTag);
            }
        });
    }

    private void frontOfCardsPictures() {
        picture101 = R.drawable.drumkit;
        picture102 = R.drawable.piano;
        picture103 = R.drawable.violin;
        picture201 = R.drawable.drumkit;
        picture202 = R.drawable.piano;
        picture203 = R.drawable.violin;
    }

    private void managePicture(ImageView imageView, int intTag) {
        //Set the picture to the card(square)
        if (cardsArray[intTag] == 101) {
            imageView.setImageResource(picture101);
        } else if (cardsArray[intTag] == 102) {
            imageView.setImageResource(picture102);
        } else if (cardsArray[intTag] == 103) {
            imageView.setImageResource(picture103);
        } else if (cardsArray[intTag] == 201) {
            imageView.setImageResource(picture201);
        } else if (cardsArray[intTag] == 202) {
            imageView.setImageResource(picture202);
        } else if (cardsArray[intTag] == 203) {
            imageView.setImageResource(picture203);
        }

        //Place the selected picture into a variable
        if (cardNumber == 1) {
            firstCard = cardsArray[intTag];
            if (firstCard > 200) {
                firstCard = firstCard - 100;
            }
            cardNumber = 2;
            selectedFirst = intTag;

            imageView.setEnabled(false);

        } else if (cardNumber == 2) {
            secondCard = cardsArray[intTag];
            if (secondCard > 200) {
                secondCard = secondCard - 100;
            }
            cardNumber = 1;
            selectedSecond = intTag;

            card_11.setEnabled(false);
            card_12.setEnabled(false);
            card_13.setEnabled(false);
            card_21.setEnabled(false);
            card_22.setEnabled(false);
            card_23.setEnabled(false);

            //Waits a bit before going invisible
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    isMatch();
                }
            }, 1000);
        }
    }

    //Verify the selected pictures are the same
    private void isMatch(){
        if (firstCard == secondCard) {
            if (selectedFirst == 0) {
                card_11.setVisibility(View.INVISIBLE);
            } else if (selectedFirst == 1) {
                card_12.setVisibility(View.INVISIBLE);
            } else if (selectedFirst == 2) {
                card_13.setVisibility(View.INVISIBLE);
            } else if (selectedFirst == 3) {
                card_21.setVisibility(View.INVISIBLE);
            } else if (selectedFirst == 4) {
                card_22.setVisibility(View.INVISIBLE);
            } else if (selectedFirst == 5) {
                card_23.setVisibility(View.INVISIBLE);
            }

            if (selectedSecond == 0) {
                card_11.setVisibility(View.INVISIBLE);
            } else if (selectedSecond == 1) {
                card_12.setVisibility(View.INVISIBLE);
            } else if (selectedSecond == 2) {
                card_13.setVisibility(View.INVISIBLE);
            } else if (selectedSecond == 3) {
                card_21.setVisibility(View.INVISIBLE);
            } else if (selectedSecond == 4) {
                card_22.setVisibility(View.INVISIBLE);
            } else if (selectedSecond == 5) {
                card_23.setVisibility(View.INVISIBLE);
            }
        } else {
            card_11.setImageResource(R.drawable.questionmark);
            card_12.setImageResource(R.drawable.questionmark);
            card_13.setImageResource(R.drawable.questionmark);
            card_21.setImageResource(R.drawable.questionmark);
            card_22.setImageResource(R.drawable.questionmark);
            card_23.setImageResource(R.drawable.questionmark);
        }

        card_11.setEnabled(true);
        card_12.setEnabled(true);
        card_13.setEnabled(true);
        card_21.setEnabled(true);
        card_22.setEnabled(true);
        card_23.setEnabled(true);

        //Verify the game is over
        checkGameOver();
    }

    private void checkGameOver() {
        if (card_11.getVisibility() == View.INVISIBLE &&
                card_12.getVisibility() == View.INVISIBLE &&
                card_13.getVisibility() == View.INVISIBLE &&
                card_21.getVisibility() == View.INVISIBLE &&
                card_22.getVisibility() == View.INVISIBLE &&
                card_23.getVisibility() == View.INVISIBLE) {

            Toast.makeText(this, R.string.gratz, Toast.LENGTH_LONG).show();

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MediumActivity.this);
            alertDialogBuilder
                    .setMessage(R.string.again)
                    .setCancelable(false)
                    .setPositiveButton(R.string.accept, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(getApplicationContext(), MediumActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    })
                    .setNegativeButton(R.string.reject, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    }
}
