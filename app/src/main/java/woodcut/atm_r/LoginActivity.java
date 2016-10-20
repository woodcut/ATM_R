package woodcut.atm_r;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void login (View v){
        EditText edUserid = (EditText)findViewById(R.id.userid);
        EditText edPassswd = (EditText)findViewById(R.id.passwd);
        String uid = edUserid.getText().toString();
        String pwd = edPassswd.getText().toString();
        if (uid.equals("jack") && pwd.equals("1234")){//登入成功
            Toast.makeText(this, "登入成功", Toast.LENGTH_LONG).show();
            getIntent().putExtra("LOGIN_USERID", uid);
            getIntent().putExtra("LOGIN_USERID", pwd);
            setResult(RESULT_OK, getIntent());
            finish();
        }
        else { //登入失敗
        }
    }
    public void cancel (View v){

    }
}
