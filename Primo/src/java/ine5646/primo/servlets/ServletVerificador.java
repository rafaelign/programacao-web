package ine5646.primo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author leandro
 */
@WebServlet(name = "ServletVerificador", urlPatterns = {"/verifique"})
public class ServletVerificador extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>INE5646 - primo</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>INE5646 - primo</h1>");
            out.println(processeNumero(request.getParameter("numero")));
            out.println("</body>");
            out.println("</html>");
        }

    }

    private String processeNumero(String numero) {
        final String COR_PRIMO = "green";
        final String COR_NAO_PRIMO = "orange";
        final String COR_ERRO = "red";
        StringBuilder sb = new StringBuilder("");
        String cor = COR_ERRO;
        String msg = "";
        
        try {
            Long num = Long.parseLong(numero);
            if (num < 0) {
                msg = ". O número deve ser maior do que 0.";
            } else {
                if (ehPrimo(num)) {
                    cor = COR_PRIMO;
                    msg = "é um número primo.";
                } else {
                    cor = COR_NAO_PRIMO;
                    msg = "não é um número primo.";
                }
            }
        } catch (NumberFormatException e) {
            cor = COR_ERRO;
            msg = (numero.length() > 0) ? "não é um Long válido." : "número não informado.";
        }

        return sb.append("<h2 style='color : ").append(cor).append("'>").append(numero).append(" : ").append(msg).append("</h2>").toString();
    }

    // retorna true se num for primo ou false caso contrário.
    private boolean ehPrimo(long num) {
        int count = 0;
        for (long i = (num - 1);i > 1;i--) {
            if ((num % i) == 0)
                count++;
        }
        
        return (count < 1 && num > 1);
    }
}
