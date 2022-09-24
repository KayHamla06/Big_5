package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    int i;
    private int player_turn = 1;
    private final List<int[]> CList = new ArrayList<>();
    private int [] Positions_Of_Boxes = {0,0,0,0,0,0,0,0,0};
    private int Total_Of_selected_boxes =1;
    private TextView player1Name,player2Name;
    private LinearLayout player1LayOut,player2LayOut;
    private ImageView image1, image2, image3, image4, image5, image6, image7, image8, image9;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);

       image1 = findViewById(R.id.Image1);
       image2 = findViewById(R.id.Image2);
       image3 = findViewById(R.id.Image3);
       image4 = findViewById(R.id.Image4);
       image5 = findViewById(R.id.Image5);
       image6 = findViewById(R.id.Image6);
       image7 = findViewById(R.id.Image7);
       image8 = findViewById(R.id.Image8);
       image9 = findViewById(R.id.Image9);

       player1Name = findViewById(R.id.player1Name);
       player2Name = findViewById(R.id.player2Name);

       player1LayOut= findViewById(R.id.player1Layout);
       player2LayOut = findViewById(R.id.player2Layout);


       CList.add(new int[]{0, 1, 2});
       CList.add(new int[]{3, 4, 5});
       CList.add(new int[]{6, 7, 8});
       CList.add(new int[]{0, 3, 6});
       CList.add(new int[]{1, 4, 7});
       CList.add(new int[]{2, 5, 8});
       CList.add(new int[]{2, 4, 6});
       CList.add(new int[]{0, 4, 8});

       final String getPlayer1Name = getIntent().getStringExtra("player1");
       final String getPlayer2Name = getIntent().getStringExtra("player2");

       player1Name.setText(getPlayer1Name);
       player2Name.setText(getPlayer2Name);

       image1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(Boxselection(0))
               {
                   actionPerformance((ImageView) view,0);
               }

           }
       });

       image2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(Boxselection(1))
               {
                   actionPerformance((ImageView)view,1);
              }

           }
       });

       image3.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(Boxselection(2))
               {
                   actionPerformance((ImageView)view,2);
               }

           }
       });

       image4.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(Boxselection(3))
               {
                   actionPerformance((ImageView)view,3);
               }

           }
       });

       image5.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(Boxselection(4))
               {
                   actionPerformance((ImageView)view,4);
               }

           }
       });

       image6.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(Boxselection(5))
               {
                   actionPerformance((ImageView)view,5);
               }

           }
       });

       image7.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(Boxselection(6))
               {
                   actionPerformance((ImageView)view,6);
               }

           }
       });

       image8.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(Boxselection(7))
               {
                   actionPerformance((ImageView)view,7);
               }

           }
       });

       image9.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(Boxselection(8))
               {
                    actionPerformance((ImageView)view,8);
               }

           }
       });
    }

    private void actionPerformance(ImageView imageView, int SelectBoxPosition)
    {
        Positions_Of_Boxes[SelectBoxPosition] = player_turn;
        if(player_turn==1)
        {
            imageView.setImageResource(R.drawable.o);

            if(cPlayerWin())
            {
                Winning winning= new Winning(MainActivity.this,player1Name.getText().toString() + " has Won" , MainActivity.this);
                winning.setCancelable(false);
                winning.show();
            }

            else if(Total_Of_selected_boxes == 9)
            {
                Winning winning= new Winning(MainActivity.this, "It's a Tie" , MainActivity.this);
                winning.setCancelable(false);
                winning.show();
            }

            else
            {
                changePlayers(2);   //changing player turn to 2
                Total_Of_selected_boxes++;
            }
        }

        else
        {
            imageView.setImageResource(R.drawable.x);

            if(cPlayerWin())
            {
                Winning winning= new Winning(MainActivity.this,player2Name.getText().toString() + " has Won" , MainActivity.this);
                winning.setCancelable(false);
                winning.show();
            }
            else if (SelectBoxPosition ==9)
            {
                Winning winning= new Winning(MainActivity.this, "It's a Tie" , MainActivity.this);
                winning.setCancelable(false);
                winning.show();
            }

            else
            {
                changePlayers(1);       //changing player turn to 1

                Total_Of_selected_boxes++;
            }
        }
    }

    private void changePlayers(int currentPlayer)
    {
        player_turn = currentPlayer;

        if(player_turn == 1)
        {
            player1LayOut.setBackgroundResource(R.drawable.r_b_b_b1k);  // change the colour for this
           player2LayOut.setBackgroundResource(R.drawable.r_d_b1k);     //change the colour for this

        }

        else
        {
            player2LayOut.setBackgroundResource(R.drawable.r_b_b_b1k);  // change the colour for this
            player1LayOut.setBackgroundResource(R.drawable.r_d_b1k);     //change the colour for this

        }
    }

    private boolean cPlayerWin()
    {
        boolean responding= false;

        for(i=0;i<CList.size();i++)
        {
            final int[] comb = CList.get(i);

            if(Positions_Of_Boxes[comb[0]]==player_turn && Positions_Of_Boxes[comb[1]] == player_turn && Positions_Of_Boxes[comb[2]] == player_turn)
            {
                responding = true;
            }
        }
        return responding;
    }

    private boolean Boxselection(int BoxPosition)
    {
        boolean responding = false;
        if(Positions_Of_Boxes[BoxPosition] ==0)
        {
            responding=true;
        }
        return responding;
    }

    public void Restart_The_Match()     // restarting the match
    {
        Positions_Of_Boxes = new int[]{ 0, 0, 0, 0, 0, 0, 0, 0, 0}; //re-arranging  the position of the box to their default positions
        player_turn = 1;        //since the Boxes have been re-arranged we let player 1 to start the match again.
        Total_Of_selected_boxes = 1;
        image1.setImageResource(R.drawable.invisible);  //reseting the background of the image to be transparent
        image2.setImageResource(R.drawable.invisible);  //reseting the background of the image to be transparent
        image3.setImageResource(R.drawable.invisible);  //reseting the background of the image to be transparent
        image4.setImageResource(R.drawable.invisible);  //reseting the background of the image to be transparent
        image5.setImageResource(R.drawable.invisible);  //reseting the background of the image to be transparent
        image6.setImageResource(R.drawable.invisible);  //reseting the background of the image to be transparent
        image7.setImageResource(R.drawable.invisible);  //reseting the background of the image to be transparent
        image8.setImageResource(R.drawable.invisible);  //reseting the background of the image to be transparent
        image9.setImageResource(R.drawable.invisible);  //reseting the background of the image to be transparent

    }
}