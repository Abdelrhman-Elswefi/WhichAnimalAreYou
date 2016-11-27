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
        if (mAnswers[0].equals("Totally Agree") && !mAnswers[2].equals("Totally Agree")) {
            mResult.setImageId(R.drawable.dolphin);
            mResultImageView.setTag("dolphin");
        }
        if (mAnswers[1].equals("Totally Agree")) {
            mResult.setImageId(R.drawable.elephant);
            mResultImageView.setTag("elephant");
        }
        if (mAnswers[2].equals("Totally Agree") && !mAnswers[0].equals("Totally Agree")) {
            mResult.setImageId(R.drawable.monkey);
            mResultImageView.setTag("monkey");
        }
        if (mAnswers[3].equals("Totally Agree")) {
            mResult.setImageId(R.drawable.redpanda);
            mResultImageView.setTag("red panda");
        }
        if (mAnswers[4].equals("Totally Agree")) {
            mResult.setImageId(R.drawable.tiger);
            mResultImageView.setTag("tiger");
        }
        if (!mAnswers[0].equals("Totally Agree") &&
                !mAnswers[1].equals("Totally Agree") &&
                !mAnswers[2].equals("Totally Agree") &&
                !mAnswers[3].equals("Totally Agree") &&
                !mAnswers[4].equals("Totally Agree")) {
            if (mAnswers[0].equals("Agree")) {
                mResult.setImageId(R.drawable.dolphin);
                mResultImageView.setTag("dolphin");
            }
            if (mAnswers[1].equals("Agree")) {
                mResult.setImageId(R.drawable.elephant);
                mResultImageView.setTag("elephant");
            }
            if (mAnswers[2].equals("Agree")) {
                mResult.setImageId(R.drawable.monkey);
                mResultImageView.setTag("monkey");
            }
            if (mAnswers[3].equals("Agree")) {
                mResult.setImageId(R.drawable.redpanda);
                mResultImageView.setTag("red panda");
            }
            if (mAnswers[4].equals("Agree")) {
                mResult.setImageId(R.drawable.tiger);
                mResultImageView.setTag("tiger");
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
