package com.nazar.language;

import com.nazar.language.languages.AbstractLanguage;
import com.nazar.language.languages.EnglishLanguage;

public class LanguageManager {
    private AbstractLanguage currentLanguage;

    public LanguageManager(){
        currentLanguage = new EnglishLanguage();
    }

    public void setLanguage(AbstractLanguage language){
        currentLanguage = language;
    }

    public String get(String key){
        return currentLanguage.getString(key);
    }
}
