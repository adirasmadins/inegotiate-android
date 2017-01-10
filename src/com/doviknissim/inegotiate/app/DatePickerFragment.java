package com.doviknissim.inegotiate.app;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DatePickerFragment extends DialogFragment implements OnDateSetListener {
    TextView textView;

    public TextView getTextView() {
        return this.textView;
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }

    public DatePickerFragment(TextView view) {
        this.textView = null;
        this.textView = view;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar c = Calendar.getInstance();
        c.add(2, 1);
        return new DatePickerDialog(getActivity(), this, c.get(1), c.get(2), c.get(5));
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        Calendar c = Calendar.getInstance();
        c.set(1, year);
        c.set(2, month);
        c.set(5, day);
        this.textView.setText(new SimpleDateFormat("MMM-dd-yyyy").format(c.getTime()));
    }
}
