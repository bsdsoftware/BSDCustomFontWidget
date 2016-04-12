package it.bsdsoftware.bsdcustomfontwidget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by Simone on 11/04/16.
 */
public class EditTextCF extends EditText implements BSDCustomFontInterface{

    private CustomFontStyle fontStyle;

    public EditTextCF(Context context) {
        super(context);
    }

    public EditTextCF(Context context, AttributeSet attrs) {
        super(context, attrs);
        checkFont(attrs);
    }

    public EditTextCF(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        checkFont(attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public EditTextCF(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        checkFont(attrs);
    }

    private void checkFont(AttributeSet attrs){
        if(!isInEditMode()) {
            int style = 0;
            if (attrs != null) {
                TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.EditTextCF);
                if (a.hasValue(R.styleable.EditTextCF_custom_font_style_edittext)) {
                    style = a.getInt(R.styleable.EditTextCF_custom_font_style_edittext, 0);
                }
                a.recycle();
            }
            BSDFont.getInstance().setFont(style, this);
        }
    }

    @Override
    public void setFont(Typeface typeface) {
        this.setTypeface(typeface);
    }
}
