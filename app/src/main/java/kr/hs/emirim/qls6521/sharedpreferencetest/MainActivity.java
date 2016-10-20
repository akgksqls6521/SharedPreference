package kr.hs.emirim.qls6521.sharedpreferencetest;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editName,editAge;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editName=(EditText)findViewById(R.id.edit_name);
        editAge=(EditText)findViewById(R.id.edit_age);
        sp=getSharedPreferences("appInfo", Context.MODE_PRIVATE);//현재 앱에서만 쓸 수 있음
    }

    @Override
    protected void onResume() {//이전 버튼으로 갔다가 다시 오면 호출됨! 가려졌다가 실행될 경우를 의미함
        super.onResume();
        String name=sp.getString("name","");
        String age=sp.getString("age","");
        editName.setText(name);
        editAge.setText(age);
    }

    @Override
    protected void onStop() {//액티비티가 사라졌을 때 호출, 가려질 때 호출됨! 마지막으로 작동 걸 저장함
        SharedPreferences.Editor edit=sp.edit();
        edit.putString("name",editName.getText().toString());
        edit.putString("age",editAge.getText().toString());
        edit.commit();
        super.onStop();
    }
}
