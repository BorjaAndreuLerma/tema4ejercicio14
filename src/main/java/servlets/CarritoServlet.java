/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entidades.objetosCarrito;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alumno
 */
@WebServlet(name = "CarritoServlet", urlPatterns = {"/CarritoServlet"})
public class CarritoServlet extends HttpServlet {

    List<entidades.objetosCarrito> productos = new ArrayList<>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        objetosCarrito producto1 = new objetosCarrito();
        producto1.setNombre("Producto1");
        producto1.setId(1);
        producto1.setPrecio(100);
        producto1.setCantidad(0);

        objetosCarrito producto2 = new objetosCarrito();
        producto2.setNombre("Producto2");
        producto2.setId(2);
        producto2.setPrecio(200);
        producto2.setCantidad(0);

        objetosCarrito producto3 = new objetosCarrito();
        producto3.setNombre("Producto3");
        producto3.setId(3);
        producto3.setPrecio(300);
        producto3.setCantidad(0);

        objetosCarrito producto4 = new objetosCarrito();
        producto4.setNombre("Producto4");
        producto4.setId(4);
        producto4.setPrecio(400);
        producto4.setCantidad(0);

        objetosCarrito producto5 = new objetosCarrito();
        producto5.setNombre("Producto5");
        producto5.setId(5);
        producto5.setPrecio(500);
        producto5.setCantidad(0);

        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
        productos.add(producto4);
        productos.add(producto5);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            for (objetosCarrito p : productos) {
                if (p.getNombre().equalsIgnoreCase(request.getParameter("lista"))) {
                    p.setCantidad(p.getCantidad() + 1);
                }
            }
            request.getSession().setAttribute("listaProductos", productos);
            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/Carrito.jsp");
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
