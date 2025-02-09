<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*" %>
<%@page import="model.TblProveedorcl2" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Lista de Proveedores</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
            text-align: center;
        }

        .container {
            background: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            width: 80%;
            margin: auto;
        }

        h2 {
            color: #333;
        }

        .btn {
            background-color: #007bff;
            color: white;
            padding: 10px 15px;
            text-decoration: none;
            border-radius: 5px;
            font-size: 16px;
            display: inline-block;
            margin-bottom: 15px;
        }

        .btn:hover {
            background-color: #0056b3;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 10px;
        }

        th, td {
            padding: 10px;
            border: 1px solid #ccc;
            text-align: left;
        }

        th {
            background-color: #007bff;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

    </style>
</head>
<body>

    <div class="container">
        <h2>Lista de Proveedores</h2>

        <!-- Bot�n para registrar un nuevo proveedor -->
        <a href="registrarProveedor.jsp" class="btn">Nuevo Proveedor</a>

        <!-- Tabla con la lista de proveedores -->
        <table>
            <thead>
                <tr>
                    <th>C�digo</th>
                    <th>Nombre</th>
                    <th>Raz�n Social</th>
                    <th>RUC</th>
                    <th>Email</th>
                    <th>Fecha de Ingreso</th>
                </tr>
            </thead>
            <tbody>
                <%
				List<TblProveedorcl2> lista=(List<TblProveedorcl2>)request.getAttribute("listado");
				//aplicamos una condicion...
				if(lista!=null){
					//aplicamos un bucle for..
					for(TblProveedorcl2 prov:lista){
					%>
                    <tr>
                        <td><%=prov.getIdprooveedorcl2()%></td>
                        <td><%=prov.getNomproveecl2()%></td>
                        <td><%=prov.getRsocialproveecl2()%></td>
                        <td><%=prov.getRucproveecl2()%></td>
                        <td><%=prov.getEmailproveecl2()%></td>
                        <td><%=prov.getFeingproveecl2()%></td>
                    </tr>
                	<%}
				}else{%>
				<tr>
					<td colspan="6"> La lista est� vac�a</td>
				</tr>
				<%}%>
            </tbody>
        </table>
    </div>

</body>
</html>
