package com.teamtreehouse.whichanimalareyou.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.teamtreehouse.whichanimalareyou.R;
import com.teamtreehouse.whichanimalareyou.model.Result;

public class ResultActivity extends AppCompatActivity {
    private ImageView mResultImageView;
    private String[] mAnswers;
    private Result mResult = new Result();
    private String mImageTag;
    Button mReturnButton;
    private TextView mCaptionTextView;
    private String mCaption;
    private int mPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        mResultImageView = (ImageView) findViewById(R.id.resultImageView);
        mReturnButton = (Button) findViewById(R.id.returnButton);
        mCaptionTextView = (TextView) findViewById(R.id.captionTextView);

        Intent intent = getIntent();
        mAnswers = intent.getStringArrayExtra("answers");
        mCaption = intent.getStringExtra("caption");

        getResults();

        setResults();

        Toast.makeText(this, "You're a " + mImageTag + "!", Toast.LENGTH_SHORT).show();

        mReturnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void getResults() {
        for (String answer : mAnswers) {
            mPoints = 0;
            switch (answer) {
                case "Totally Agree":
                    mPoints++;
                case "Agree":
                    mPoints += 2;
                case "Indifferent":
                    mPoints += 3;
                case "Disagree":
                    mPoints += 4;
                case "Totally Disagree":
                    mPoints += 5;
            }
            if (mPoints > 4 && mPoints < 9) {
                mResult.setImageId(R.drawable.tiger);
                mResultImageView.setTag("tiger");
            }
            if (mPoints > 8 && mPoints < 13) {
                mResult.setImageId(R.drawable.redpanda);
                mResultImageView.setTag("red panda");
            }
            if (mPoints > 12 && mPoints < 17) {
                mResult.setImageId(R.drawable.monkey);
                mResultImageView.setTag("monkey");
            }
            if (mPoints > 16 && mPoints < 21) {
                mResult.setImageId(R.drawable.elephant);
                mResultImageView.setTag("elephant");
            }
            if (mPoints > 20 && mPoints < 26) {
                mResult.setImageId(R.drawable.dolphin);
                mResultImageView.setTag("dolphin");
            }
        }
        mResult.setCaption(mCaption);
    }

    public void setResults() {
        Drawable drawable = getResources().getDrawable(mResult.getImageId());
        mResultImageView.setImageDrawable(drawable);
        mCaptionTextView.setText(mResult.getCaption());

        mImageTag = mResultImageView.getTag().toString();
    }
}
