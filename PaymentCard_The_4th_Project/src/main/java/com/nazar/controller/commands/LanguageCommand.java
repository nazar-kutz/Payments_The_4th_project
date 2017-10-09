package com.nazar.controller.commands;

import com.nazar.controller.ControllerCommand;
import com.nazar.dto.User;
import com.nazar.dto.UserRole;
import com.nazar.language.LanguageFactoryMethod;
import com.nazar.language.LanguageFactoryMethodImpl;
import com.nazar.language.LanguageManager;
import com.nazar.util.PathManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.nazar.util.GlobalConst.LANGUAGE;
import static com.nazar.util.GlobalConst.USER;

public class LanguageCommand implements ControllerCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String language = request.getParameter(LANGUAGE);
        LanguageFactoryMethod languageFactory = LanguageFactoryMethodImpl.getInstance();
        LanguageManager languageManager = new LanguageManager();
        languageManager.setLanguage(languageFactory.getLanguage(language));
        request.getSession().setAttribute(LANGUAGE, languageManager);
        return nextPage(request);
    }

    protected String nextPage(HttpServletRequest request) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute(USER);
        if (UserRole.ADMIN.equals(user.getRole())){
            return PathManager.getInstance().getAdminCabinetUri();
        } else {
            return PathManager.getInstance().getUserCabinetUri();
        }
    }
}
