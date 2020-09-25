package com.suek.ex27activity3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv= findViewById(R.id.tv);
    }



    public void clickBtn(View view) {
        // 클릭했을때 SecondActivity 를 실행하되 '결과를 받기위해서'...
        Intent intent= new Intent(this, SecondActivity.class);   //명시적 Intent
        //startActivity(intent);    //이렇게만 하면 택배기사 안돌아옴
        startActivityForResult(intent,10);    //택배기사 돌아오게 하기 (10 은 그냥 '식별번호(requestCode)'임. 저 10은 아무의미없는 숫자)

    }





    //마지막으로..
    //startActivityForResult()로 실행된 Activity 가 종료되어
    //현재 이 MainActivity 가 다시 화면에 보여질 때 자동으로 실행되는 메소드
    //즉, SecondActivity 에 갔던 Intent(택배기사) 가 돌아오면 자동으로 실행되는 메소드
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //내가 보낸 택배기사가 맞는지 requestCode(식별자) 를 통해 확인
        switch (requestCode){
            case 10:
                //SecondActivity 의 OK 결과냐?
                if(resultCode == RESULT_OK){
                    //돌아온 Intent 객체(3번째 파라미터: data)에게 'Extra 데이터'를 얻어오기  ==Intent data= 돌아온 택배기사
                    String name= data.getStringExtra("Name");
                    int age= data.getIntExtra("Age",0);

                    tv.setText(name+"\n"+age);
                }
                break;
        }
    }
}
