<%-- 
    Document   : Factura
    Created on : 31-oct-2016, 14:03:10
    Author     : Borja
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Factura compra</title>
    </head>
    <body>
        <table style="border: 1px">
            <tr>
                <td>Nombre Producto</td>
                <td>Cantidad</td>
                <td>Precio unidad</td>
            </tr>
            <%
                String nombre;
                int precio, cantidad;
                ArrayList<entidades.objetosCarrito> lista = (ArrayList) session.getAttribute("listaProductosComp");
                for (entidades.objetosCarrito p : lista) {
                    nombre = p.getNombre();
                    precio = p.getPrecio();
                    cantidad = p.getCantidad();
            %>
            <tr>
                <td><%=nombre%></td>
                <td><%=cantidad%></td>
                <td><%=precio%></td>
            </tr>
            <%
                }
                int precioTotal = (Integer) session.getAttribute("precioTotal");
            %>
            <tr>
                <td colspan="3">PRECIO FINAL: <%=precioTotal%></td>
            </tr>
        </table>
    </body>
</html>
