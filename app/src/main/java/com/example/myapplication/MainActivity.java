package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


     EditText editTextName ;
     EditText editTextMSSV;
     EditText editTextAge ;
    RadioButton radNam ;
    RadioButton radNu;
     CheckBox checkBoxFootball;
     CheckBox checkBoxGaming ;
    Button btnSubmit;
     TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextMSSV = findViewById(R.id.editTextMSSV);
        editTextAge = findViewById(R.id.editTextAge);
        radNam = findViewById(R.id.radioNam);
        radNu = findViewById(R.id.radioNu);
        checkBoxFootball = findViewById(R.id.checkBoxFootball);
        checkBoxGaming = findViewById(R.id.checkBoxGaming);
        btnSubmit = findViewById(R.id.btnSubmit);
        textViewResult = findViewById(R.id.textViewResult);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String mssv = editTextMSSV.getText().toString();
                String age = editTextAge.getText().toString();
                String gender = getSelectedGender();
                String sothich = "";
                boolean likesFootball = checkBoxFootball.isChecked();
                boolean likesGaming = checkBoxGaming.isChecked();
                if (likesFootball && likesGaming) {
                    sothich = "Bóng Đá, Chơi Game";
                }
                else if (likesGaming) {
                    sothich = "Chơi Game";
                } else if (likesFootball) {
                    sothich = "Bóng Đá";
                } else {
                    sothich = "Không có";
                }
                String result = "Tên: " + name + "\nMSSV: " + mssv + "\nTuổi: " + age +"\nGiới Tính: " + gender + "\nSở Thích: " + sothich ;
                textViewResult.setText(result);
            }
        });
    }

    private String getSelectedGender() {

        if (radNam.isChecked()) {
            return "Nam";
        } else if (radNu.isChecked()) {
            return "Nữ";
        } else {
            return "Không rõ";
        }
    }
    public void onRadioButtonClicked(View view) {
        // Uncheck the other RadioButton when one is clicked
        if (view.getId() == R.id.radioNam) {
            radNu.setChecked(false);
        } else if (view.getId() == R.id.radioNu) {
            radNam.setChecked(false);
        }
    }
}

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        edtA =  findViewById(R.id.edtA);
//        edtB =  findViewById(R.id.edtB);
//        edtKQ =  findViewById(R.id.edtKQ);
//        btnTong =  findViewById(R.id.btnTong);
//        btnTong.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int a = Integer.parseInt(edtA.getText().toString());
//                int b = Integer.parseInt(edtB.getText().toString());
//                int kq = a+b;
//                edtKQ.setText(kq+"");
//            }
//        });
//    }

