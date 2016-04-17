package su.dreamteam.lonja.trainingdiarymvp.addeditmeasurement;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.GregorianCalendar;

import su.dreamteam.lonja.trainingdiarymvp.BR;
import su.dreamteam.lonja.trainingdiarymvp.R;
import su.dreamteam.lonja.trainingdiarymvp.data.Measurement;
import su.dreamteam.lonja.trainingdiarymvp.databinding.FragmentAddEditMeasurementBinding;

import static com.google.common.base.Preconditions.checkNotNull;

public class AddEditMeasurementFragment
        extends Fragment
        implements AddEditMeasurementContract.View {

    int mYear, mMonth, mDay, mHour, mMinute;

    public static final String ARGUMENT_EDIT_MEASUREMENT_ID = "EDIT_MEASUREMENT_ID";

    private AddEditMeasurementContract.Presenter mPresenter;

    private FragmentAddEditMeasurementBinding mAddEditMeasurementBinding;

    private MeasurementViewModel mMeasurementViewModel;

    private Calendar calendar;

    public AddEditMeasurementFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        calendar = new GregorianCalendar();
        mAddEditMeasurementBinding = FragmentAddEditMeasurementBinding
                .inflate(inflater, container, false);
        mAddEditMeasurementBinding.setActionHandler(mPresenter);
        mAddEditMeasurementBinding.setMeasurement(mMeasurementViewModel);
        setHasOptionsMenu(true);
        setRetainInstance(true);
        return mAddEditMeasurementBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab_edit_measurement_done);
        fab.setImageResource(R.drawable.check);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNewMeasurement()) {
                    mPresenter.createMeasurement(mAddEditMeasurementBinding.getMeasurement().getMeasurement());
                } else {
                    mPresenter.updateMeasurement(mAddEditMeasurementBinding.getMeasurement().getMeasurement());
                }
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    public static AddEditMeasurementFragment newInstance() {
        return new AddEditMeasurementFragment();
    }

    @Override
    public void showEmptyMeasurementError() {

    }

    @Override
    public void showMeasurementsList() {
        getActivity().setResult(Activity.RESULT_OK);
        getActivity().finish();
    }

    @Override
    public void showSetDateTimeDialog() {
        DatePickerDialog dialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                mYear = year;
                mMonth = monthOfYear;
                mDay = dayOfMonth;
                final Calendar date = new GregorianCalendar(mYear, mMonth, mDay, mHour, mMinute);
                setTime(date);
            }
        }, mYear, mMonth, mDay);
        dialog.show();
    }

    private void setTime(final Calendar calendar) {
        TimePickerDialog dialog = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                mHour = hourOfDay;
                mMinute = minute;
                calendar.set(Calendar.HOUR_OF_DAY, mHour);
                calendar.set(Calendar.MINUTE, minute);
                mMeasurementViewModel.setDate(calendar);
            }
        }, mHour, mMinute, true);
        dialog.show();
    }

    @Override
    public void showSetCommentDialog() {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_comment, null);
        final EditText commentEditText = (EditText) dialogView.findViewById(R.id.dialog_comment_edit);

        if (!mMeasurementViewModel.getComment().equals("Enter comment")) {
            commentEditText.setText(mMeasurementViewModel.getComment());
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(R.string.comment)
                .setView(dialogView)
                .setCancelable(true)
                .setPositiveButton(R.string.add, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mMeasurementViewModel.setComment(commentEditText.getText().toString());
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }

    @Override
    public void setMeasurement(Measurement measurement) {
        mMeasurementViewModel.setMeasurement(measurement);
//        mMeasurementViewModel.setValues();
        calendar.setTime(mMeasurementViewModel.getMeasurement().getDate());
        mYear = calendar.get(Calendar.YEAR);
        mMonth = calendar.get(Calendar.MONTH);
        mDay = calendar.get(Calendar.DAY_OF_MONTH);
        mHour = calendar.get(Calendar.HOUR_OF_DAY);
        mMinute = calendar.get(Calendar.MINUTE);
    }

    public void setViewModel(MeasurementViewModel viewModel) {
        mMeasurementViewModel = viewModel;
    }

    @Override
    public void setPresenter(AddEditMeasurementContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    private boolean isNewMeasurement() {
        return getArguments() == null || !getArguments().containsKey(ARGUMENT_EDIT_MEASUREMENT_ID);
    }
}