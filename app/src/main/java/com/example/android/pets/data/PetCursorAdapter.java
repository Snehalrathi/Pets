package com.example.android.pets.data;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.android.pets.R;

/**
 * Created by Rachit on 09-08-2017.
 */

public class PetCursorAdapter extends CursorAdapter {

    public PetCursorAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }


    // The newView method is used to inflate a new view and return it,
    // you don't bind any data to the view at this point.
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }

    // The bindView method is used to bind all data to a given view
    // such as setting the text on a TextView.
    public void bindView(View view, Context context, Cursor cursor) {
        // Find fields to populate in inflated template
        TextView Petname = (TextView) view.findViewById(R.id.name);
        TextView PetSummary = (TextView) view.findViewById(R.id.summary);
        // Extract properties from cursor
        String Pname = cursor.getString(cursor.getColumnIndex(PetContract.PetEntry.COLUMN_PET_NAME));
        String Pbreed = cursor.getString(cursor.getColumnIndex(PetContract.PetEntry.COLUMN_PET_BREED));
        if (TextUtils.isEmpty(Pbreed))
        {
            Pbreed = "UNKNOWN BREED";
        }
        // Populate fields with extracted properties
        Petname.setText(Pname);
        PetSummary.setText(Pbreed);
    }
}
