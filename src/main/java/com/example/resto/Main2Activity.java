package com.example.resto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class Main2Activity extends AppCompatActivity {

    TextView mTitleTv, mDetailTv;


    String st,st1;

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main2);


        mTitleTv = findViewById ( R.id.textView);
        mDetailTv = findViewById ( R.id.textView2);

        st = getIntent ().getExtras ().getString ( "Title" );
        st1 = getIntent ().getExtras ().getString ( "description" );

        mTitleTv.setText (st);
        mDetailTv.setText (st1);



    }
}
