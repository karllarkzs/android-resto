package com.example.resto;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ViewHolder extends RecyclerView.ViewHolder  {

    View mView;
    public ViewHolder ( @NonNull View itemView ) {
        super ( itemView );

        mView = itemView;
        itemView.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick ( View v ) {
                mClickListener.onItemClick (v,getAdapterPosition ());
            }
        } );
        itemView.setOnLongClickListener ( new View.OnLongClickListener (){
            @Override
            public boolean onLongClick (View v){
                mClickListener.onItemlongClick ( v,getAdapterPosition () );
                return true;
            }

        } );


    }
    //set details to recycler view
    public void setDetails ( Context applicationContext , String Name , String Price ){
        TextView mTitleTv = mView.findViewById ( R.id.rTitleTv );
        TextView mDetailTv = mView.findViewById ( R.id.rDescriptionTv );
        //ImageView mImageTv = mView.findViewById ( R.id.rImageView );

        //setdata to cardview
        mTitleTv.setText(Name);
        mDetailTv.setText(Price );
        //Picasso.get ().load (image).into( mImageTv );

    }

    private ViewHolder.ClickListener mClickListener;

    //interfave to send callbacks
    public interface ClickListener {
        void onItemClick ( View view , int position );
        void  onItemlongClick(View view, int position);

    }
    public  void  setOnClickListener(ViewHolder.ClickListener clickListener){
        mClickListener = clickListener;
    }
}
