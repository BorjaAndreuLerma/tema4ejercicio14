<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidades.objetosCarrito"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="productos" scope="session" class="entidades.objetosCarrito" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrito</title>
    </head>
    <body>
        <h1>Carrito de la compra</h1>
        <form action="CarritoServlet" method="POST">
            <select name="lista">
                <%
                    List<entidades.objetosCarrito> lista = (List) session.getAttribute("listaProductos");
                    for (entidades.objetosCarrito p : lista) {
                        String nombre = p.getNombre();
                %>
                <option><%=nombre%></option>
                <%
                    }%>

            </select>
            <input type="submit" value="Añadir producto" />


            <br>
            <select>
                <% 
                    for (entidades.objetosCarrito p : lista) {
                        String nombre = p.getNombre();
                        Integer cantidad = p.getCantidad();
                        if (p.getCantidad() != 0) {
                %>
                <option><%=nombre%> - <%=cantidad%></option>    
                <%
                        }

                    }
                %>
            </select>
            <a href="FinCompra">Fin compra</a>
        </form>  

    </body>
</html>
