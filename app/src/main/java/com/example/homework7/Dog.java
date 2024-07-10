package com.example.homework7;

import android.widget.ImageView;

// Animal 붕어빵 들의 변수상자나 함수상자를 그대로 물려받아서 쓸게요.
public class Dog extends Animal{

    Dog(String name, int age, String phone) {
        super(name, age, phone);
    }

    // Animal 부모 안에 만들어져 있는 함수상자를 재정의
    void run(ImageView outputImage) {
        // 화면에 있는 이미지뷰의 이미지를 강아지가 뛰어가는 이미로 바꿀께요
        outputImage.setImageResource(R.drawable.dog_run);
    }

    @Override
    void sitdown(ImageView outputImage) {
        outputImage.setImageResource(R.drawable.dog_sit);
    }


    @Override
    void standup(ImageView outputImage) {
        outputImage.setImageResource(R.drawable.dog_stand);
    }
}
