package it.bsdsoftware.bsdcustomfontwidget;

import android.graphics.Typeface;

/**
 * Created by Simone on 11/04/16.
 */
public class BSDFontBuilder {

    protected Typeface normalFont, boldFont, italicFont, italicBoldFont;

    public BSDFontBuilder(){}


    public BSDFontBuilder setNormalFont(Typeface normalFont){
        this.normalFont = normalFont;
        return this;
    }

    public BSDFontBuilder setBoldFont(Typeface boldFont){
        this.boldFont = boldFont;
        return this;
    }

    public BSDFontBuilder setItalicFont(Typeface italicFont){
        this.italicFont = italicFont;
        return this;
    }

    public BSDFontBuilder setItalicBoldFont(Typeface italicBoldFont){
        this.italicBoldFont = italicBoldFont;
        return this;
    }

    protected BSDFont build(){
        return new BSDFont(this);
    }




}
