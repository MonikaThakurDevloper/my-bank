package com.example.mybank;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class BankFormActivity extends AppCompatActivity {

    ImageView img_back,im_date;
    TextView tv_setdate;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bank_form);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        img_back=findViewById(R.id.img_back);
        im_date=findViewById(R.id.im_date);
        tv_setdate=findViewById(R.id.tv_setdate);
        setCurrentDate();
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BankFormActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        im_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }


        });
    }

    private void setCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);  // Note: month is zero-based
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        // Display the current date in TextView
        String currentDate = day + "/" + (month + 1) + "/" + year;  // Add 1 to month to display correctly
        tv_setdate.setText(currentDate);
    }

    private void showDatePickerDialog() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        // Create a DatePickerDialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                BankFormActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
                        // Format and display the selected date in the TextView
                        String selectedDate = selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear;
                        tv_setdate.setText(selectedDate);
                    }
                },
                year, month, day);

        // Show the DatePickerDialog
        datePickerDialog.show();
    }

}