package com.reubenjohn.chess;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Home extends Activity {

	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		
		Button play=(Button)findViewById(R.id.play_button);
		play.setOnClickListener(new Button.OnClickListener()
		{

			@Override
			public void onClick(View arg0) {
				Toast.makeText(Home.this, R.string.play_button_response, Toast.LENGTH_SHORT).show();
				
			}
			
		});
	}
	
}
