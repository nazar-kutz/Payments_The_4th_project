package com.nazar.language;

import com.nazar.language.languages.AbstractLanguage;

public interface LanguageFactoryMethod {
    AbstractLanguage getLanguage(String language);
}
