package com.teamtreehouse.whichanimalareyou.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.teamtreehouse.whichanimalareyou.R;

public class StatementActivity extends AppCompatActivity {
    private TextView mStatement1;
    private TextView mStatement2;
    private TextView mStatement3;
    private TextView mStatement4;
    private TextView mStatement5;
    private Spinner mSpinner1;
    private Spinner mSpinner2;
    private Spinner mSpinner3;
    private Spinner mSpinner4;
    private Spinner mSpinner5;
    Button mFinishButton;
    private EditText mCaptionEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statement);

        mStatement1 = (TextView) findViewById(R.id.statementTextView1);
        mStatement2 = (TextView) findViewById(R.id.statementTextView2);
        mStatement3 = (TextView) findViewById(R.id.statementTextView3);
        mStatement4 = (TextView) findViewById(R.id.statementTextView4);
        mStatement5 = (TextView) findViewById(R.id.statementTextView5);
        mSpinner1 = (Spinner) findViewById(R.id.spinner1);
        mSpinner2 = (Spinner) findViewById(R.id.spinner2);
        mSpinner3 = (Spinner) findViewById(R.id.spinner3);
        mSpinner4 = (Spinner) findViewById(R.id.spinner4);
        mSpinner5 = (Spinner) findViewById(R.id.spinner5);
        mFinishButton = (Button) findViewById(R.id.finishButton);
        mCaptionEditText = (EditText) findViewById(R.id.captionEditText);

        setStatements();

        setSpinners();

        mCaptionEditText.setHint(R.string.captionEditTextHint);

        mFinishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] answers = new String[5];
                answers[0] = mSpinner1.getSelectedItem().toString();
                answers[1] = mSpinner2.getSelectedItem().toString();
                answers[2] = mSpinner3.getSelectedItem().toString();
                answers[3] = mSpinner4.getSelectedItem().toString();
                answers[4] = mSpinner5.getSelectedItem().toString();
                String caption = mCaptionEditText.getText().toString();
                getResult(answers, caption);
            }
        });
    }

    public void getResult(String[] answers, String caption) {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("caption", caption);
        intent.putExtra("answers", answers);
        startActivity(intent);
    }

    public void setStatements() {
        mStatement1.setText(R.string.statement1);
        mStatement2.setText(R.string.statement2);
        mStatement3.setText(R.string.statement3);
        mStatement4.setText(R.string.statement4);
        mStatement5.setText(R.string.statement5);
    }

    public void setSpinners() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinnerChoices, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mSpinner1.setAdapter(adapter);
        mSpinner2.setAdapter(adapter);
        mSpinner3.setAdapter(adapter);
        mSpinner4.setAdapter(adapter);
        mSpinner5.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSpinner1.setSelection(0);
        mSpinner2.setSelection(0);
        mSpinner3.setSelection(0);
        mSpinner4.setSelection(0);
        mSpinner5.setSelection(0);
        mCaptionEditText.setText("");
    }
}
