package com.clownjee.numberkeyboard;

/**
 * Created by Clownjee on 2017/3/7.
 */
public interface OnKeyActionListener {

    /**
     * 输入完成并提交
     *
     * @param input 输入内容
     */
    void onFinish(int input);

    /**
     * 输入过程中的数据
     *
     * @param input 当前已经输入的内容
     */
    void onProcess(int input);
}
