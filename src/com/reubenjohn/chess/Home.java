package com.reubenjohn.chess;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends Activity {

	TextView teamRadioStatus;
	OnClickListener teamRadioButtonListener;
	CheckBox frenchCheck;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);

		final Button play = (Button) findViewById(R.id.play_button);
		play.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (frenchCheck.isChecked())
					Toast.makeText(Home.this,
							R.string.french_play_button_response,
							Toast.LENGTH_SHORT).show();
				else
					Toast.makeText(Home.this, R.string.play_button_response,
							Toast.LENGTH_SHORT).show();

			}

		});

		teamRadioStatus = (TextView) findViewById(R.id.team_radio_status);
		teamRadioButtonListener = new OnClickListener() {
			@Override
			public void onClick(View v) {
				RadioButton myRadioButton = (RadioButton) v;
				switch (myRadioButton.getId()) {
				case R.id.team_radio_button_1:
					teamRadioStatus.setTextColor(getResources().getColor(
							R.color.team_1));
					break;
				case R.id.team_radio_button_2:
					teamRadioStatus.setTextColor(getResources().getColor(
							R.color.team_2));
					break;
				case R.id.team_radio_button_3:
					teamRadioStatus.setTextColor(getResources().getColor(
							R.color.team_3));
					break;
				}
			}
		};
		RadioButton TeamRadioButton1, TeamRadioButton2, TeamRadioButton3;
		TeamRadioButton1 = (RadioButton) findViewById(R.id.team_radio_button_1);
		TeamRadioButton2 = (RadioButton) findViewById(R.id.team_radio_button_2);
		TeamRadioButton3 = (RadioButton) findViewById(R.id.team_radio_button_3);

		TeamRadioButton1.setOnClickListener(teamRadioButtonListener);
		TeamRadioButton2.setOnClickListener(teamRadioButtonListener);
		TeamRadioButton3.setOnClickListener(teamRadioButtonListener);

		frenchCheck = (CheckBox) findViewById(R.id.french_check);
		frenchCheck.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				CheckBox frenchCheckBox = (CheckBox) findViewById(R.id.french_check);
				if (frenchCheckBox.isChecked()) {
					play.setText(R.string.french_play_button);
				} else
					play.setText(R.string.play_button);
			}
		});
	}

	public void selectOpponent(View view) {
		Intent intent = new Intent(this, OpponentSelector.class);
		startActivity(intent);
	}
}
