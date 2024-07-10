package com.example.homework7;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // 화면이 보이는 동안에는 계속 붕어빵이 유지됨

    EditText editTextName;
    EditText editTextAge;
    EditText editTextPhone;

    ImageView outputImage;
    TextView outputText;

    // 강아지나 고양이를 담아줄 변수상자를 만든다.
    Animal animal;
    LinearLayout container;

    // 화면이 보이기 전에 한 번 실행
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // activity_main.xml파일의 화면 모양과 이피일의 소스코드가 하나의 화면이 된다는 것을 알려줌

        init();

    }

    // 초기화
    void init() {
        // 화면에 보이는 것들 중에서 필요한 것들을 찾아서 변수상장에 넣어두기
        editTextName = findViewById(R.id.editTextName);
        editTextAge = findViewById(R.id.editTextAge);
        editTextPhone = findViewById(R.id.editTextPhone);

        outputImage = findViewById(R.id.outputImage);
        outputText = findViewById(R.id.outputText);

        container = findViewById(R.id.container);

        //버튼을 눌렀을 때 동작시키기
        Button createDogBtn = findViewById(R.id.createDogBtn);
        Button createCatBtn = findViewById(R.id.createCatBtn);
        Button runBtn = findViewById(R.id.runBtn);
        Button sitDownBtn = findViewById(R.id.sitDownBtn);
        Button standUpBtn = findViewById(R.id.standUpBtn);


        // 강아지 만들기
        createDogBtn.setOnClickListener(v -> {
            createDog();
        });

        createCatBtn.setOnClickListener(v -> {
            createCat();
        });

        // 뛰어 버튼
        runBtn.setOnClickListener(v -> {
            if (animal != null) {
                animal.run(outputImage);
                outputText.setText("동물이 뛰어갑니다.");
            } else {
                //Log.d("Main", "animal 변수상자가 널입니다.");
                outputText.setText("동물을 먼저 만드세요.");
            }
        });

        Button addBtn = findViewById(R.id.addBtn);
        addBtn.setOnClickListener(v -> {

            ImageView imageView1 = new ImageView(getApplicationContext());
            imageView1.setImageResource(R.drawable.dog_stand);
            container.addView(imageView1);

        });

        //앉아 버튼
        sitDownBtn.setOnClickListener(v -> {
            if (animal != null && animal instanceof Dog) {
                animal.sitdown(outputImage);
                outputText.setText("강아지가 앉습니다.");
            } else if (animal != null && animal instanceof Cat) {
                outputText.setText("고양이가 앉습니다.");
            }
            else {
                outputText.setText("동물을 먼저 만드세요.");
            }
        });

        standUpBtn.setOnClickListener(v -> {
            if(animal != null) {
                animal.standup(outputImage);
                outputText.setText("동물이 일어납니다.");
            } else {
                outputText.setText("동물을 먼저 만드세요.");
            }
        });
    }

    void createDog() {
        String name = editTextName.getText().toString();
        String ageStr = editTextAge.getText().toString();
        String phone = editTextPhone.getText().toString();
        int age = Integer.parseInt(ageStr);
        animal = new Dog(name, age, phone);

        outputText.setText("강아지가 만들어졌어요");
    }
    
    void createCat() {
        String name = editTextName.getText().toString();
        String ageStr = editTextAge.getText().toString();
        String mobile = editTextPhone.getText().toString();
        
        int age = Integer.parseInt(ageStr);
        
        animal = new Cat(name, age, mobile);
        
        outputText.setText("고양이가 만들어 졌어요");
        
    }
}