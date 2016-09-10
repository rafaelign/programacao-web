package ine5646.primo.controle;

import ine5646.primo.modelo.VerificadorDePrimo;
import ine5646.primo.visao.PaginaResposta;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author leandro
 */
public class ProcessadorDeRequisicao {

    protected String processe(HttpServletRequest request) {
        String[] numero_MsgErro = valideNumero(request.getParameter("numero"));
        PaginaResposta pr = new PaginaResposta();
        String html;

        if (numero_MsgErro[1] != null) {
            html = pr.gereComErro(numero_MsgErro[0], numero_MsgErro[1]);
        } else {
            VerificadorDePrimo v = new VerificadorDePrimo();
            long numero = Long.parseLong(numero_MsgErro[0]);
            boolean ehPrimo = v.ehPrimo(numero);
            html = pr.gereSemErro(numero, ehPrimo);
        }
        return html;
    }

    private String[] valideNumero(String numero) {
        String[] resp = new String[]{numero, null};

        if (numero.length() == 0) {
            resp = new String[]{numero, "Número não definido"};
        } else {
            try {
                long num = Long.parseLong(numero);
                if (num < 1) {
                    resp = new String[]{numero, "O número tem que ser maior que zero."};
                }

            } catch (NumberFormatException ex) {
                resp = new String[]{numero, "Valor digitado não é número"};
            }
        }
        return resp;
    }

}
