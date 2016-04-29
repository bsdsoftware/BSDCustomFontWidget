package it.bsdsoftware.bsdcustomfontwidget;

import android.graphics.Typeface;

/**
 * Created by Simone on 11/04/16.
 */
public class BSDFont {

    protected Typeface normalFont = Typeface.DEFAULT, boldFont, italicFont, italicBoldFont;

    private static BSDFont instance;

    public static BSDFont getInstance(){
        if(instance==null){
            throw new RuntimeException("BSD Font non inizializzata! Assicurati di chiamare il metodo 'init' all'avvio dell'applicazione");
        }
        return instance;
    }

    protected BSDFont(BSDFontBuilder builder){
        this.normalFont = builder.normalFont != null ? builder.normalFont : Typeface.DEFAULT;
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
            case ITALIC_BOLD:
                fontInterface.setFont(italicBoldFont);
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
            case 3:
                return CustomFontStyle.ITALIC_BOLD;
            default:
                return CustomFontStyle.NORMAL;
        }
    }

    protected Typeface getTypeface(Typeface typeface){
        Typeface newTypeface = BSDFont.getInstance().normalFont;
        if(typeface!=null) {
            if (typeface.isBold() && typeface.isItalic()) {
                newTypeface = BSDFont.getInstance().italicBoldFont;
            } else if (typeface.isBold()) {
                newTypeface = BSDFont.getInstance().boldFont;
            } else if (typeface.isItalic()) {
                newTypeface = BSDFont.getInstance().italicFont;
            }
        }
        if(newTypeface == null){
            newTypeface = BSDFont.getInstance().normalFont;
        }
        return newTypeface;
    }
}
