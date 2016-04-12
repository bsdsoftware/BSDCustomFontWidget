package it.bsdsoftware.bsdcustomfontwidget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Simone on 11/04/16.
 */
public class TextViewCF extends TextView implements BSDCustomFontInterface {

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TextViewCF(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        checkFont(attrs);
    }

    public TextViewCF(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        checkFont(attrs);
    }

    public TextViewCF(Context context, AttributeSet attrs) {
        super(context, attrs);
        checkFont(attrs);
    }

    public TextViewCF(Context context) {
        super(context);
    }

    private void checkFont(AttributeSet attrs){
        if(!isInEditMode()){
            int style = 0;
            if(attrs!=null) {
                TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.TextViewCF);
                if(a.hasValue(R.styleable.TextViewCF_custom_style_font_textview)){
                    style = a.getInt(R.styleable.TextViewCF_custom_style_font_textview, 0);
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