package com.nazar.language;

import com.nazar.language.languages.AbstractLanguage;
import com.nazar.language.languages.EnglishLanguage;
import com.nazar.language.languages.UkrainianLanguage;

public class LanguageFactoryMethodImpl implements LanguageFactoryMethod{
    private LanguageFactoryMethodImpl(){}

    private static class Holder {
        private static LanguageFactoryMethodImpl INSTANCE = new LanguageFactoryMethodImpl();
    }

    public static LanguageFactoryMethodImpl getInstance(){
        return Holder.INSTANCE;
    }

    @Override
    public AbstractLanguage getLanguage(String language){
        if("uk_UA".equals(language)){
            return new UkrainianLanguage();
        } else {
            //default language
            return new EnglishLanguage();
        }
    }
}
