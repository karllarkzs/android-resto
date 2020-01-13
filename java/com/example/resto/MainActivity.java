package com.example.resto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {


  private RecyclerView mRecyclerView;
   public FirebaseDatabase mFirebaseDatabase;
   public DatabaseReference mRef;

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
            setContentView ( R.layout.activity_main );

        ActionBar actionBar = getSupportActionBar ( );

        //set title
        actionBar.setTitle ( "Food Menu" );
      /*  actionBar.setDisplayHomeAsUpEnabled ( true );
        actionBar.setDisplayShowHomeEnabled ( true );
*/
        mRecyclerView = findViewById ( R.id.recyclerView );
        mRecyclerView.setHasFixedSize ( true );

        //set layout as linearlayout
        mRecyclerView.setLayoutManager ( new LinearLayoutManager ( this ) );

        // send query to firebase


        mFirebaseDatabase = FirebaseDatabase.getInstance ( );
        mRef = mFirebaseDatabase.getReference ( "Menu/Beers" );


    }

    @Override
    protected void onStart () {
        super.onStart ( );
        FirebaseRecyclerAdapter <Model, ViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter <Model, ViewHolder> ( Model.class , R.layout.row , ViewHolder.class , mRef ) {
            @Override
            protected void populateViewHolder ( ViewHolder viewHolder , Model model , int position ) {
                viewHolder.setDetails ( getApplicationContext ( ) , model.getName ( ) , model.getPrice ( )  );

            }

            @Override
            public ViewHolder onCreateViewHolder ( ViewGroup parent , int viewType ) {
                ViewHolder viewHolder = super.onCreateViewHolder ( parent,viewType );
                viewHolder.setOnClickListener ( new ViewHolder.ClickListener () {
                    @Override
                    public void onItemClick ( View view , int position ) {
                        TextView mTitleTv = view.findViewById (R.id.rTitleTv );
                        TextView mDescTv = view.findViewById ( R.id.rDescriptionTv );

                        String mTitle = mTitleTv.getText ().toString ();
                        String mDesc = mDescTv.getText ().toString ();

                        Intent intent = new Intent ( view.getContext (),tofirebase.class );
                        ByteArrayOutputStream stream = new ByteArrayOutputStream (  );
                        intent.putExtra ( "Title", mTitle );
                        intent.putExtra ( "description",mDesc );
                        startActivity ( intent );
                    }

                    @Override
                    public void onItemlongClick ( View view , int position ) {

                    }
                });


                return viewHolder;



            }
        };

        mRecyclerView.setAdapter ( firebaseRecyclerAdapter );

    }
    }


