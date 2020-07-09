package com.convergencelabstfx.pianoviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.convergencelabstfx.pianoview.PianoTouchListener;
import com.convergencelabstfx.pianoview.PianoView;

import java.util.Random;

/*
 * TODO:
 *  - horizontal scroll piano
 *  - width slider
 *  - height slider
 *  - color pickers
 *  - corner radius slider
 *  - width radius
 *  - onTouch || onClick
 */

public class MainActivity extends AppCompatActivity {

    private PianoView mPianoView;
    private Button mKeysButton;
    private int lastKeyPressed;
    private int counter = 12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        mPianoView = new PianoView(this);
        mPianoView = findViewById(R.id.piano);
        mKeysButton = findViewById(R.id.testButton);
        mKeysButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rnd = new Random();
//                Log.d("testV", "num keys: " + newNum);
                final int newNum;
                if (counter > 24) {
                    counter = 2;
                }
                else {
                    counter += 1;
                }
                mPianoView.setNumberOfKeys(counter, false);
//                mPianoView.setBlackKeyWidthScale(Math.max(0.05f, rnd.nextFloat()));
//                mPianoView.setBlackKeyHeightScale(Math.max(0.05f, rnd.nextFloat()));
//                mPianoView.setWhiteKeyColor(Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
//                mPianoView.setBlackKeyColor(Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
//                mPianoView.setPressedKeyColor(Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
//                mPianoView.setKeyStrokeColor(Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
//                mPianoView.setKeyStrokeWidth(rnd.nextInt(15) + 2);
//                mPianoView.setKeyCornerRadius(rnd.nextInt(15) + 2);
//                ViewGroup.LayoutParams params = mPianoView.getLayoutParams();
//                params.height = mPianoView.getMeasuredHeight();
//                params.width = rnd.nextInt(600) + 360;
//                mPianoView.setLayoutParams(params);

            }
        });
        mPianoView.addPianoTouchListener(new PianoTouchListener() {
            @Override
            public void onPianoTouch(PianoView piano, int key) {
//                Log.d("testV", "" + key);
//                // Piano key change
//                if (key != lastKeyPressed) {
//                    if (lastKeyPressed != -1) {
//                        piano.showKeyNotPressed(lastKeyPressed);
//                    }
//                    if (key != -1) {
//                        piano.showKeyPressed(key);
//                    }
//                    lastKeyPressed = key;
//                }

            }

            @Override
            public void onPianoClick(PianoView piano, int key) {
                if (piano.keyIsPressed(key)) {
                    piano.showKeyNotPressed(key);
                }
                else {
                    piano.showKeyPressed(key);
                }
            }
        });
        Log.d("testV", "numKeys: " + mPianoView.getNumberOfKeys());

    }
}