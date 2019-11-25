package com.wx.springboot.component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;


public class MyLocalResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String str = httpServletRequest.getParameter("l");
        Locale locale = null;
        if(!StringUtils.isEmpty(str)){
            String[] split = str.split("_");
            locale = new Locale(split[0], split[1]);
        }else{
            locale = new Locale("zh","CN");
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
