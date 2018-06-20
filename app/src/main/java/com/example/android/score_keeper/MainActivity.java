package com.example.android.score_keeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String KEY_TEXT_VALUE1 = "textValue1";
    private static final String KEY_TEXT_VALUE2 = "textValue2";
    int scoreTeamA = 0;
    int scoreTeamB = 0;
    private TextView mTextView;
    private TextView nTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.team_a_score);
        nTextView = findViewById(R.id.team_b_score);
        if (savedInstanceState != null) {
            CharSequence savedText1 = savedInstanceState.getCharSequence(KEY_TEXT_VALUE1);
            mTextView.setText(savedText1);
            CharSequence savedText2 = savedInstanceState.getCharSequence(KEY_TEXT_VALUE2);
            nTextView.setText(savedText2);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putCharSequence(KEY_TEXT_VALUE1, mTextView.getText());
        outState.putCharSequence(KEY_TEXT_VALUE2, nTextView.getText());
    }


    /**
     * @param view Adds 2 to the score
     */
    public void FoulA(View view) {
        scoreTeamA -= 1;
        displayForTeamA(scoreTeamA);
    }

    /**
     * @param view
     */
    public void GoalA(View view) {
        scoreTeamA += 3;
        displayForTeamA(scoreTeamA);
    }
    /**
     * @param view resets the score of both the teams
     */
    public void FoulB(View view) {
        scoreTeamB -= 1;
        displayForTeamB(scoreTeamB);
    }
    public void GoalB(View view) {
        scoreTeamB += 3;
        displayForTeamB(scoreTeamB);
    }
    public void resetScore(View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }

    /**
     * Displays the given score for Team A.
     */

    public void displayForTeamA(int score) {
        TextView scoreViewA = (TextView) findViewById(R.id.team_a_score);
        scoreViewA.setText(String.valueOf(score));
    }

    public void displayForTeamB(int score) {
        TextView scoreViewB = (TextView) findViewById(R.id.team_b_score);
        scoreViewB.setText(String.valueOf(score));
    }
}

