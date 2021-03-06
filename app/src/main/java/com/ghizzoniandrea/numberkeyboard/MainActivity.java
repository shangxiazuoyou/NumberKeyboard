package com.ghizzoniandrea.numberkeyboard;

import android.inputmethodservice.Keyboard;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

/**
 * Created by ghizzoniandrea on 2017/3/7.
 */
public class MainActivity extends AppCompatActivity {

    private NumberKeyboard mKeyboard;
    private EditText edtTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtTest = (EditText) findViewById(R.id.edt_test);
    }

    public void show(View view) {
        mKeyboard = new NumberKeyboard(MainActivity.this, new OnKeyActionListener() {
            @Override
            public void onFinish(int input) {
                edtTest.setText(Character.toString((char) input));
            }

            @Override
            public void onProcess(int input) {
                Editable editable = edtTest.getText();
                int start = edtTest.getSelectionStart();
                if (input == Keyboard.KEYCODE_DELETE) {// 回退
                    if (editable != null && editable.length() > 0) {
                        if (start > 0) {
                            editable.delete(start - 1, start);
                        }
                    }
                } else if (input == 0) {// 无操作

                } else {
                    editable.insert(start, Character.toString((char) input));
                }
            }
        });
        mKeyboard.show(MainActivity.this.getWindow().getDecorView().getRootView());
    }

    public void dismiss(View view) {
        if (null != mKeyboard) {
            mKeyboard.dismiss();
        }
    }
}
