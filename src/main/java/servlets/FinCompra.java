/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Borja
 */
@WebServlet(name = "FinCompra", urlPatterns = {"/FinCompra"})
public class FinCompra extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            int precioTotal = 0;
        List<entidades.objetosCarrito> listaProductos = (List) request.getSession().getAttribute("listaProductos");
        List<entidades.objetosCarrito> listaProductosComp = new ArrayList();
        for ( entidades.objetosCarrito p : listaProductos){
           if(p.getCantidad() != 0){
               listaProductosComp.add(p);
               precioTotal += p.getCantidad() * p.getPrecio();
           }          
        }
            

            request.getSession().setAttribute("precioTotal", precioTotal);
            request.getSession().setAttribute("listaProductosComp", listaProductosComp);

            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/Factura.jsp");
            rd.forward(request, response);        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
