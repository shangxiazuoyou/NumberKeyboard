package com.clownjee.numberkeyboard;

import android.app.Activity;
import android.content.Context;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Clownjee on 2017/3/7.
 */
public class NumberKeyboard extends AbstractKeyboard {

    private final KeyboardView mKeyboardView;

    private Keyboard mKeyboard;

    public NumberKeyboard(final Context context, OnKeyActionListener keyActionListener) {
        super(context, keyActionListener);

        final View contentView = setContentView(R.layout.keyboard_plate);

        mKeyboard = new Keyboard(context, R.xml.keyboardnumber);

        mKeyboardView = (KeyboardView) contentView.findViewById(R.id.keyboard_view);
        mKeyboardView.setOnKeyboardActionListener(new OnKeyboardActionHandler() {
            @Override
            public void onKey(int charCode, int[] keyCodes) {
                if (charCode == Keyboard.KEYCODE_DONE) {
                    dismiss();
                    return;
                }
                mOnKeyActionListener.onProcess(charCode);
            }
        });
        mKeyboardView.setPreviewEnabled(false);// !!! Must be false
        mKeyboardView.setKeyboard(mKeyboard);
    }

    @Override
    public void show(View anchorView) {
        super.show(anchorView);
    }

    @Override
    protected void onShow() {
    }

    @Override
    protected String getInput(TextView[] inputs) {
        return super.getInput(inputs);
    }

    public static void show(Activity activity, OnKeyActionListener listener) {
        new NumberKeyboard(activity, listener).show(activity.getWindow().getDecorView().getRootView());
    }

    public static NumberKeyboard create(Context context, OnKeyActionListener listener) {
        return new NumberKeyboard(context, listener);
    }

}
