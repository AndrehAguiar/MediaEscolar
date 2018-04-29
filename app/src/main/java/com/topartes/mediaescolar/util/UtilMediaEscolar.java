package com.topartes.mediaescolar.util;

import android.content.Context;
import android.widget.Toast;

import java.text.DecimalFormat;

public class UtilMediaEscolar {

    public static final String URL_WEB_SERVICE = "http://192.168.56.1:81/mediaescolar/";

    //TEMPO máximo para conectar ao apache
    public static final int CONECTION_TIMEOUT = 10000; //10seg
    // Tempo máximo para resposta do apache
    public static final int READ_TIME_OUT = 15000; //15 seg

    public static String formataValorDecimal(Double valor) {
        DecimalFormat df = new DecimalFormat("#,###,##0.00");
        return df.format(valor);
    }

    public static void showMensagem(Context context, String mensagem){
        Toast.makeText(context,mensagem,Toast.LENGTH_LONG).show();
    }

}
