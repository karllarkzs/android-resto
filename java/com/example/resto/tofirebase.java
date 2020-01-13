package com.example.resto;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class tofirebase extends AppCompatActivity {

    TextView mTitleTv, mDetailTv;

    Button btn;
    String st,st1;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_tofirebase );

        databaseReference = FirebaseDatabase.getInstance ().getReference ("Orders");

        ActionBar actionBar = getSupportActionBar ();

        actionBar.setTitle ( "Selected order" );

        actionBar.setDisplayHomeAsUpEnabled ( true );
        actionBar.setDisplayShowHomeEnabled (true);

        mTitleTv = findViewById ( R.id.rTitleTv );
        mDetailTv = findViewById (R.id.rDescriptionTv );
        btn = findViewById ( R.id.button );

        btn.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick ( View v ) {
                addFood ();
          /*    *//*  Intent intent = new Intent ( tofirebase.this,Main2Activity.class);
                st=mTitleTv.getText ().toString ();
                st1=mDetailTv.getText ().toString ();
                intent.putExtra ("Title",st  );
                intent.putExtra ( "description",st1 );
                startActivi*//*ty ( intent );
                finish ();*/
            }
        } );



        String title = getIntent ().getStringExtra ( "Title" );
        String desc = getIntent ().getStringExtra ( "description" );


        mTitleTv.setText ( title );
        mDetailTv.setText ( desc );
    }

   /* @Override
    public boolean onSupportNavigateUp(){
        onBackPressed ();
        return true;*/

    public void addFood(){
        String foodName = mTitleTv.getText ().toString ();
        String foodPrice = mDetailTv.getText ().toString ();

        if(!TextUtils.isEmpty ( foodName ) && !TextUtils.isEmpty ( foodPrice ) ){
            String id = databaseReference.push ().getKey ();

            Data data = new Data(foodName,foodPrice);

            databaseReference.child ( "Order" ).child("Ord").setValue ( data );
     /*       st=mTitleTv.getText ().toString ();
            st1=mDetailTv.getText ().toString ();*/
            Toast.makeText(tofirebase.this,"ORDER SUBMITTED", Toast.LENGTH_LONG).show ();


        }
        else{
            Toast.makeText(tofirebase.this,"Select menu propertly", Toast.LENGTH_LONG).show ();
        }
    }
}
