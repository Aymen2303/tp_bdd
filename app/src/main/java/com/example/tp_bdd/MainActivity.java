package com.example.tp_bdd;

import static com.example.tp_bdd.R.id.txtview1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText txtname, txtspecialite, txtdate_entre, txt_date_prom, txt_base_sal, txt_actual_sal;
    Button  btn;
    TextView  txt_view;

    CalendarView calendarView;
    Calendar calendar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**** Quick intialization ****/

        txtname = findViewById(R.id.Edit_name);
        txtspecialite = findViewById(R.id.Edit_specialite);
        txtdate_entre = findViewById(R.id.Edit_entree);
        txt_date_prom = findViewById(R.id.Edit_prom);
        txt_base_sal = findViewById(R.id.Edit_base_salary);
        txt_actual_sal = findViewById(R.id.Edit_actual_salary);
       txt_view = findViewById(R.id.txtview1);

        btn = findViewById(R.id.btn_send_infos);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ///SendUser();
                RefreshEdits();
            }
        });

        txt_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Main_Menu.class));
                finish();
            }
        });


        /******* Setting the date picker dialog  *******/
        txtdate_entre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog(txtdate_entre);
            }
        });

        txt_date_prom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog(txt_date_prom);
            }
        });
    }

    /**Outside OnCreate**/

    void RefreshEdits(){
        txtname.setText("");
        txtspecialite.setText("");
        txtdate_entre.setText("");
        txt_date_prom.setText("");
        txt_base_sal.setText("");
        txt_actual_sal.setText("");
    }


    private  void showDatePickerDialog(EditText edt1){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int selectedYear, int selectedMonth, int selectedDay) {
                // The user has selected a date
                String selectedDate = selectedYear + "-" + (selectedMonth + 1) + "-" + selectedDay;
                // Set the selected date in the EditText
                edt1.setText(selectedDate);
            }
        }, year, month, dayOfMonth);

        datePickerDialog.show();
    }




}




