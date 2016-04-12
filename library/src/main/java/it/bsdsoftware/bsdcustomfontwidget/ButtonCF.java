package it.bsdsoftware.bsdcustomfontwidget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Created by Simone on 11/04/16.
 */
public class ButtonCF  extends Button implements BSDCustomFontInterface {

    public ButtonCF(Context context) {
        super(context);
    }

    public ButtonCF(Context context, AttributeSet attrs) {
        super(context, attrs);
        checkFont(attrs);
    }

    public ButtonCF(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        checkFont(attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ButtonCF(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        checkFont(attrs);
    }

    private void checkFont(AttributeSet attrs){
        if(!isInEditMode()) {
            int style = 0;
            if (attrs != null) {
                TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.ButtonCF);
                if (a.hasValue(R.styleable.ButtonCF_custom_font_style_button)) {
                    style = a.getInt(R.styleable.ButtonCF_custom_font_style_button, 0);
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
