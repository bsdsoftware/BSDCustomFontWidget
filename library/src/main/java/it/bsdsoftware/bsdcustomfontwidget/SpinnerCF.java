package it.bsdsoftware.bsdcustomfontwidget;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.widget.Spinner;

import java.util.List;

/**
 * Created by Simone on 19/04/16.
 */
public class SpinnerCF extends Spinner {

    private SpinnerAdapterCF adapterCF;

    public SpinnerCF(Context context) {
        super(context);
        init(null);
    }

    public SpinnerCF(Context context, int mode) {
        super(context, mode);
        init(null);
    }

    public SpinnerCF(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public SpinnerCF(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public SpinnerCF(Context context, AttributeSet attrs, int defStyleAttr, int mode) {
        super(context, attrs, defStyleAttr, mode);
        init(attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SpinnerCF(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes, int mode) {
        super(context, attrs, defStyleAttr, defStyleRes, mode);
        init(attrs);
    }

    @TargetApi(Build.VERSION_CODES.M)
    public SpinnerCF(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes, int mode, Resources.Theme popupTheme) {
        super(context, attrs, defStyleAttr, defStyleRes, mode, popupTheme);
        init(attrs);
    }

    private void init(AttributeSet attrs){
        if(!isInEditMode()) {
            int dropdownLayout = android.R.layout.simple_spinner_dropdown_item;
            int itemLayout = android.R.layout.simple_spinner_item;
            if (attrs != null) {
                TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.SpinnerCF);
                if (a.hasValue(R.styleable.SpinnerCF_spinner_item_resource)) {
                    itemLayout = a.getResourceId(R.styleable.SpinnerCF_spinner_item_resource, itemLayout);
                }
                if (a.hasValue(R.styleable.SpinnerCF_spinner_dropdown_item_resource)) {
                    itemLayout = a.getResourceId(R.styleable.SpinnerCF_spinner_dropdown_item_resource, dropdownLayout);
                }
                a.recycle();
            }
            Activity activity;
            if(getContext() instanceof Activity) {
                activity = (Activity) getContext();
            }else{
                ContextThemeWrapper ctw = (ContextThemeWrapper) getContext();
                activity = (Activity) ctw.getBaseContext();
            }
            adapterCF = new SpinnerAdapterCF(activity, itemLayout, dropdownLayout);
        }
    }

    public void setItems(List<SpinnerItem> items){
        adapterCF.addAll(items);
    }

}
