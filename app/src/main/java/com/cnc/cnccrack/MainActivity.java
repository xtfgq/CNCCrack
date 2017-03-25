package com.cnc.cnccrack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText edUser;
    private EditText edPass;
    private Button btnjisuan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView(){
        edUser=(EditText)findViewById(R.id.ed_user);
        edPass=(EditText)findViewById(R.id.ed_pass);
        btnjisuan=(Button)findViewById(R.id.btn_jisuan);
        btnjisuan.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_jisuan:
                if(TextUtils.isEmpty(edUser.getText().toString())){
                    Toast.makeText(MainActivity.this, "请输入用户名",
                            Toast.LENGTH_LONG).show();
                    return;
                }
                edPass.setText(CncUtils.DeCode(edUser.getText().toString().toCharArray()));
                break;
        }

    }
}
