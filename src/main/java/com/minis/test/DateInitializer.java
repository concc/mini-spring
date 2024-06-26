package com.minis.test;

import java.util.Date;

import com.minis.web.CustomDateEditor;
import com.minis.web.WebBindingInitializer;
import com.minis.web.WebDataBinder;

public class DateInitializer implements WebBindingInitializer{
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(Date.class,"yyyy-MM-dd", false));
    }
}
