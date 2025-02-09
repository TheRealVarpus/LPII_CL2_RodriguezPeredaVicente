<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <title>Registro de Proveedores</title>
    <style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

.container {
	background: #fff;
	padding: 20px;
	border-radius: 10px;
	box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
	width: 400px;
}

h2 {
	text-align: center;
	color: #333;
}

table {
	width: 100%;
}

td {
	padding: 10px;
}

input[type="text"], input[type="email"], input[type="date"] {
	width: 100%;
	padding: 8px;
	border: 1px solid #ccc;
	border-radius: 5px;
}

.btn {
	background-color: #28a745;
	color: white;
	padding: 10px;
	border: none;
	width: 100%;
	border-radius: 5px;
	cursor: pointer;
	font-size: 16px;
}

.btn:hover {
	background-color: #218838;
}
</style>
</head>
<body>

    <div class="container">
        <h2>Registro de Proveedores</h2>
        <form action="RegistrarProveedorServlet" method="post">
            <table>
                <tr>
                    <td>Nombre:</td>
                    <td><input type="text" name="nombre" required></td>
                </tr>
                <tr>
                    <td>Razón Social:</td>
                    <td><input type="text" name="razonSocial"
						required></td>
                </tr>
                <tr>
                    <td>RUC:</td>
                    <td><input type="text" name="ruc" required></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input type="email" name="email" required></td>
                </tr>
                <tr>
                    <td>Fecha de Ingreso:</td>
                    <td><input type="date" name="fechaIngreso"
						required></td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: center;">
                        <button type="submit" class="btn">Registrar Proveedor</button>
                    </td>
                </tr>
            </table>
        </form>
    </div>

</body>
</html>

</html>