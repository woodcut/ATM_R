package woodcut.atm_r;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean logon = false;
    public static final int FUNC_LOGIN = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!logon){/*如果未登入，則開啟登入 LoginActivity*/
            Intent intent = new Intent(this, LoginActivity.class);
            startActivityForResult(intent, FUNC_LOGIN);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == FUNC_LOGIN){
            if (resultCode == RESULT_OK){
                Toast.makeText(this, "登入成功", Toast.LENGTH_LONG).show();
                String uid = data.getStringExtra("LOGIN_USERID");
                String pwd = data.getStringExtra("LOGIN_PASSWD");
                Log.d("RESULT", uid + "/" + pwd);
            }else {
                finish();
            }
        }
    }
}
