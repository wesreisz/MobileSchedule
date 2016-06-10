package com.wesleyreisz.mobileschedule;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by wesleyreisz on 6/10/16.
 */
public class TalkCell extends LinearLayout {
    private final Context context;
    private final AttributeSet attrs;

    public TalkCell(Context context, AttributeSet attrs) {
            super(context, attrs);
            this.context = context;
            this.attrs = attrs;

            setOrientation(VERTICAL);
            setGravity(Gravity.CENTER);

            LayoutInflater.from(context).inflate(R.layout.talk_cell, this, true);

            TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.TalkCell, 0, 0);

            String textTalkTitle = array.getString(R.styleable.TalkCell_talkTitle);
            if (textTalkTitle == null) textTalkTitle = "No Title Set";
            ((TextView) findViewById(R.id.textTalkTitle)).setText(textTalkTitle);

            String textSpeakerName = array.getString(R.styleable.TalkCell_speakerName);
            if (textSpeakerName == null) textSpeakerName = "";
            ((TextView) findViewById(R.id.textSpeakerName)).setText(textSpeakerName);

            array.recycle();
        }
    }

