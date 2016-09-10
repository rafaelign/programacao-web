/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ine5646.primo.visao;

/**
 *
 * @author leandro
 */
public class PaginaResposta {

    final String COR_PRIMO = "green";
    final String COR_NAO_PRIMO = "orange";
    final String COR_ERRO = "red";

    public String gereComErro(String numero, String msgErro) {
        return gereHTML(numero, msgErro, false);
    }

    public String gereSemErro(long numero, boolean ehPrimo) {
        return gereHTML(String.valueOf(numero), null, ehPrimo);
    }

    private String gereHTML(String numero, String msgErro, boolean ehPrimo) {
        StringBuilder sb = new StringBuilder();

        sb.append("<!DOCTYPE html>");
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title>INE5646 - primo</title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("<h1>INE5646 - primo</h1>");
        sb.append(processeResultado(numero, msgErro, ehPrimo));
        sb.append("</body>");
        sb.append("</html>");

        return sb.toString();
    }

    private String processeResultado(String numero, String msgErro, boolean ehPrimo) {
        StringBuilder sb = new StringBuilder("");
        String cor;
        String msg;
        if (msgErro != null) {
            cor = COR_ERRO;
            msg = msgErro;
        } else {
            if (ehPrimo) {
                cor = COR_PRIMO;
                msg = "é primo!";
            } else {
                cor = COR_NAO_PRIMO;
                msg = "não é primo...";
            }
        }

        return sb.append("<h2 style='color : ").append(cor).append("'>").append(numero).append(" : ").append(msg).append("</h2>").toString();
    }

}
