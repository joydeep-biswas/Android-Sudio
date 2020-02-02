package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String winner;
    boolean gameActive = true;
    boolean winnerX = false, winnerO = false;

    int activePlayer = 0;
    int[] boardState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                            {0, 4, 8}, {2, 4, 6}};
    public void playerTap (View view) {
        TextView text = findViewById(R.id.status);
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        if (boardState[tappedImage] == 2 && gameActive) {
            boardState[tappedImage] = activePlayer;
            if (activePlayer == 0) {
                img.setImageResource(R.drawable.x);
                activePlayer = 1;
                text.setText("O's Turn");
            } else {
                img.setImageResource(R.drawable.o);
                activePlayer = 0;
                text.setText("X's Turn");
            }
        }
        for (int[] winPosition: winPositions) {
            if (boardState[winPosition[0]] == boardState[winPosition[1]] && boardState[winPosition[1]] == boardState[winPosition[2]] && boardState[winPosition[0]] != 2) {
                if (boardState[winPosition[0]] == 0) {
                    winner = "X Has Won! Tap To Reset";
                    gameActive = false;
                    winnerX = true;
                } else {
                    winner = "O Has Won! Tap To Reset";
                    gameActive = false;
                    winnerO = true;
                }
                text.setText(winner);
            }
        }
        int c = 0;
        for(int i = 0; i < boardState.length; i++) {
            if(boardState[i] == 2) {
                c = 1;
            }
        }
        if (c != 1 && gameActive) {
            text.setText("Game Draw! Tap To Reset");
            gameActive = false;
        }
    }
    public void textClick (View view) {
        if(!gameActive) {
            gameActive = true;
            activePlayer = 0;
            for(int i = 0; i < boardState.length; i++){
                boardState[i] = 2;
            }

            ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);

            TextView status = findViewById(R.id.status);
            status.setText("X's Turn, Tap To Play");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}