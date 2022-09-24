package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Players extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players);


    final EditText player1 =findViewById(R.id.player1Name);
    final EditText player2 = findViewById(R.id.player2Name);
    final Button gameStartBTN= findViewById(R.id.gameStartBTN);


    gameStartBTN.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            final String getPlayer1Name = player1.getText().toString();
            final String getPlayer2Name = player2.getText().toString();

            if(getPlayer1Name.isEmpty() || getPlayer2Name.isEmpty()){
                Toast.makeText(Players.this, "Enter Player Name", Toast.LENGTH_SHORT).show();
            }
            else {
                Intent mxm = new Intent(Players.this, MainActivity.class);
                mxm.putExtra("player1",getPlayer1Name);
                mxm.putExtra("player2", getPlayer2Name);
                startActivity(mxm);
            }
        }
    });


    }
}