package com.reubenjohn.chess;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class TestDialog extends DialogFragment {

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState)
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setView(getActivity().getLayoutInflater().inflate(R.layout.test_dialog,null));
		return builder.create();
	}
	
}
