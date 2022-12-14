package com.example.myapplication;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class Winning extends Dialog{

    private final String message;
    private final MainActivity mainActivity;

    public Winning(@NonNull Context context, String message,MainActivity mainActivity) {
        super(context);
        this.message = message;
        this.mainActivity = mainActivity;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.winning_layout);

        final TextView messageTxt = findViewById(R.id.messageTxt);
        final Button RestartBtn = findViewById(R.id.restartBtn);
        messageTxt.setText(message);
        RestartBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                mainActivity.Restart_The_Match();
                dismiss();
            }
        });
    }
}