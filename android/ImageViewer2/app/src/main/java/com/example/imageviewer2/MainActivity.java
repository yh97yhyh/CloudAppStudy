package com.example.imageviewer2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textNum;
    TextView textName;
    ImageView imageView;
    int[] images = {R.drawable.bts1, R.drawable.bts2, R.drawable.bts3, R.drawable.bts4, R.drawable.bts5, R.drawable.bts6, R.drawable.bts7};
    String[] names = {"RM", "진", "슈가", "제이홉", "지민", "뷔", "정국"};
    int index = 0;
    Button button;
    Button button2;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textNum = findViewById(R.id.textNum);
        textName = findViewById(R.id.textName);
        imageView = findViewById(R.id.imageView);
        display();

        NextBtnOnClickListener nextBtnOnClickListener = new NextBtnOnClickListener();
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);

        button.setOnClickListener(nextBtnOnClickListener);
        button2.setOnClickListener(nextBtnOnClickListener);
        button.setEnabled(false);

        seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                button.setEnabled(true);
                button2.setEnabled(true);

                index = progress;
                if (index == 0) {
                    button.setEnabled(false);
                }
                if (index == 6) {
                    button2.setEnabled(false);
                }

                display();


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    private void display() {
        textNum.setText(String.format("%d / %d", index+1, names.length));
        textName.setText(names[index]);
        imageView.setImageResource(images[index]);
//        seekBar.setProgress(index);
    }

    class NextBtnOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            button.setEnabled(true);
            button2.setEnabled(true);

            if (v.getId() == R.id.button) {
                index --;
                if (index <= 0) {
                    button.setEnabled(false);
                }
            }
            else if (v.getId() == R.id.button2) {
                index ++;
                if (index >= images.length-1) {
                    button2.setEnabled(false);

                }
            }
            display();
        }

    }
}