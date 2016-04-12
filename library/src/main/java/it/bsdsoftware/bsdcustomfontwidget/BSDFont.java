package it.bsdsoftware.bsdcustomfontwidget;

import android.graphics.Typeface;

/**
 * Created by Simone on 11/04/16.
 */
public class BSDFont {

    protected Typeface normalFont = Typeface.DEFAULT, boldFont, italicFont, italicBoldFont;

    private static BSDFont instance;

    protected static BSDFont getInstance(){
        if(instance==null){
            throw new RuntimeException("Nessuna instanza impostata!");
        }
        return instance;
    }

    protected BSDFont(BSDFontBuilder builder){
        this.normalFont = builder.normalFont;
        this.boldFont = builder.boldFont;
        this.italicFont = builder.boldFont;
        this.italicBoldFont = builder.italicBoldFont;

        if(this.boldFont == null){
            this.boldFont = this.normalFont;
        }
        if(this.italicFont == null){
            this.italicFont = this.normalFont;
        }
        if(this.italicBoldFont == null){
            this.italicBoldFont = this.normalFont;
        }
    }

    public static void init(BSDFontBuilder builder){
        instance = builder.build();
    }

    protected void setFont(int value, BSDCustomFontInterface fontInterface){
        switch (checkStyle(value)){
            case BOLD:
                fontInterface.setFont(boldFont);
                break;
            case ITALIC:
                fontInterface.setFont(italicFont);
                break;
            case NORMAL:
            default:
                fontInterface.setFont(normalFont);
                break;
        }
    }

    private CustomFontStyle checkStyle(int value){
        switch (value){
            case 0:
                return CustomFontStyle.NORMAL;
            case 1:
                return CustomFontStyle.BOLD;
            case 2:
                return CustomFontStyle.ITALIC;
            default:
                return CustomFontStyle.NORMAL;
        }
    }
}
