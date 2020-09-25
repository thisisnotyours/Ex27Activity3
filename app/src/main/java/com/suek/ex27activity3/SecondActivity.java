package com.suek.ex27activity3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        et= findViewById(R.id.et);
    }


    //메인 액티비티의 Button 의 clickBtn 과 다른 clickBtn 임(서로 누군지 인식못함)
    public void clickBtn(View view) {
        //MainActivity 에 돌려줄 데이터를 EditText 에서 얻어오기
        String s= et.getText().toString();

        // MainActivity 로 부터 온 Intent 객체(택배기사) 참조하기
        Intent intent= getIntent();

        // 되돌려줄 데이터를 Intent 객체(택배기사)에 추가하기- 돌려줄 값
        intent.putExtra("Name", s);
        intent.putExtra("Age", 25);

        // 이 값들을 넣은 인텐트 객체(택배기사)에게 이 결과가 OK 라는 설정을 해야함
        this.setResult(RESULT_OK, intent);   //RESULT_OK 를 intent 가 가져갈거라는 뜻   //this 생략가능

        // 이 액티비티를 종료
        finish();


    }
}
