package com.teamtreehouse.whichanimalareyou.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.teamtreehouse.whichanimalareyou.R;
import com.teamtreehouse.whichanimalareyou.model.Result;

public class ResultActivity extends AppCompatActivity {
    private ImageView mResultImageView;
    private String[] mAnswers;
    private Result mResult = new Result();
    private String mImageTag;
    private Button mReturnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        mResultImageView = (ImageView) findViewById(R.id.resultImageView);
        mReturnButton = (Button) findViewById(R.id.returnButton);

        Intent intent = getIntent();
        mAnswers = intent.getStringArrayExtra("answers");

        getResult();

        Drawable drawable = getResources().getDrawable(mResult.getImageId());
        mResultImageView.setImageDrawable(drawable);

        String animal = drawable.toString();
        mImageTag = mResultImageView.getTag().toString();

        Toast.makeText(this, "You're a " + mImageTag + "!", Toast.LENGTH_SHORT).show();

        mReturnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void getResult() {
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
    }
}
