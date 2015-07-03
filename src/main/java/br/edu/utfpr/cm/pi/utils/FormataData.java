package br.edu.utfpr.cm.pi.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FormataData {
    Calendar c;

    public FormataData(Calendar data) {
        c = data;
    }

    public String dataFormatada() {

        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
        Date date = c.getTime();

        return sd.format(date);
    }
}
