package com.wesleyreisz.mobileschedule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //todo: attach event to all buttons on the page, rather than getting them individually
        Button btnSF = (Button)findViewById(R.id.btnShowScheduleSF);
        btnSF.setOnClickListener(this);
        Button btnLondon = (Button)findViewById(R.id.btnShowScheduleLondon);
        btnLondon.setOnClickListener(this);
        Button btnNY = (Button)findViewById(R.id.btnShowScheduleNY);
        btnNY.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, MobileScheduleActivity.class);
        setCityAsExtra(v, intent);
        startActivity(intent);
    }

    private void setCityAsExtra(View v, Intent intent){
        if (R.id.btnShowScheduleSF==v.getId())
            intent.putExtra(MobileScheduleConstants.SELECTED_CITY_MESSAGE, MobileScheduleConstants.SAN_FRANCISCO);
        else if (R.id.btnShowScheduleLondon==v.getId())
            intent.putExtra(MobileScheduleConstants.SELECTED_CITY_MESSAGE, MobileScheduleConstants.LONDON);
        else if (R.id.btnShowScheduleNY==v.getId())
            intent.putExtra(MobileScheduleConstants.SELECTED_CITY_MESSAGE, MobileScheduleConstants.NEW_YORK);
    }
}
