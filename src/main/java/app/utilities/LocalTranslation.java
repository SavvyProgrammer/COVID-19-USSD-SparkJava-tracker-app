package app.utilities;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translate.TranslateOption;
import com.google.cloud.translate.TranslateOptions;


public class LocalTranslation {

    static Translate translate = TranslateOptions.newBuilder()
            .setApiKey("AIzaSyA2Iy_RKiBWy_olSAjZkbtf0oKtgshjfyw")
            .build()
            .getService();


    public static String getTranslate(String sourceText, String isoLang) {

        return translate.translate(
                sourceText,
                TranslateOption.sourceLanguage("en"),
                TranslateOption.targetLanguage(isoLang))
                .getTranslatedText();

    }


}