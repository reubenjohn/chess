package com.reubenjohn.chess;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class OpponentSelector extends ListActivity {

	String firstNames[] = { "Juliet", "Monique", "Rachelle", "Tara", "Sophia",
			"Juliet", "Monique", "Rachelle", "Tara", "Sophia", "Juliet",
			"Monique", "Rachelle", "Tara", "Sophia", "Juliet", "Monique",
			"Rachelle", "Tara", "Sophia", "Juliet", "Monique", "Rachelle",
			"Tara", "Sophia" };
	ArrayAdapter<String> firstNamesAdapter;
	private String itemSelected;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		ArrayList<String> firstNameList = new ArrayList<String>(
				Arrays.asList(firstNames));

		firstNamesAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, firstNameList);
		setListAdapter(firstNamesAdapter);

		OnItemClickListener firstNameListener = new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View arg1,
					int position, long arg3) {
				Toast.makeText(
						OpponentSelector.this,
						getResources().getString(
								R.string.opponent_selection_prefix)
								+ parent.getItemAtPosition(position).toString(),
						Toast.LENGTH_SHORT).show();
			}

		};
		OnItemLongClickListener firstNameLongListener = new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View arg1,
					int arg2, long position) {
				itemSelected = parent.getItemAtPosition((int) position)
						.toString();
				
				AlertDialog.Builder builder = new AlertDialog.Builder(
						OpponentSelector.this);
				builder.setMessage(getResources().getString(
						R.string.opponent_removal_confirmation))
						.setCancelable(true)
						.setPositiveButton(R.string.opponent_removal_P,
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								firstNamesAdapter.remove(itemSelected);
								firstNamesAdapter.notifyDataSetChanged();
							}
						})
						.setNegativeButton(R.string.opponent_removal_N,
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								dialog.cancel();
							}
						})
						.setView(getLayoutInflater().inflate(R.layout.test_dialog, null))
						.setIcon(R.drawable.ic_launcher)
						.show();
						
				return false;

			}
		};

		getListView().setOnItemClickListener(firstNameListener);
		getListView().setOnItemLongClickListener(firstNameLongListener);
	}
}
