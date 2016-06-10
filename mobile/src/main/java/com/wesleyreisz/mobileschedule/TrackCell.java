package com.wesleyreisz.mobileschedule;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.reflect.Field;

/**
 * Created by wesleyreisz on 6/10/16.
 */
public class TrackCell extends LinearLayout {
    private final Context context;
    private final AttributeSet attrs;

    public TrackCell(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        this.attrs = attrs;

        setOrientation(HORIZONTAL);
        setGravity(Gravity.CENTER_VERTICAL);

        LayoutInflater.from(context).inflate(R.layout.track_cell, this, true);

        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.TrackLine, 0, 0);

        int trackImage = array.getResourceId(R.styleable.TrackLine_trackImage,0);
        if (trackImage == 0) ((ImageView) findViewById(R.id.trackImage)).setImageResource(R.drawable.ic_cast_dark);
        ((ImageView) findViewById(R.id.trackImage)).setImageResource(trackImage);

        String trackTitle = array.getString(R.styleable.TrackLine_text);
        if (trackTitle == null) trackTitle = "No Track Title Set";
        ((TextView) findViewById(R.id.text)).setText(trackTitle);

        array.recycle();
    }
}

