package com.teamtreehouse.whichanimalareyou.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
    private Button mFinishButton;

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

        mStatement1.setText(R.string.statement1);
        mStatement2.setText(R.string.statement2);
        mStatement3.setText(R.string.statement3);
        mStatement4.setText(R.string.statement4);
        mStatement5.setText(R.string.statement5);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinnerChoices, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mSpinner1.setAdapter(adapter);
        mSpinner2.setAdapter(adapter);
        mSpinner3.setAdapter(adapter);
        mSpinner4.setAdapter(adapter);
        mSpinner5.setAdapter(adapter);
    }
}
