<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : Login
    Created on : 4/12/2022, 02:51:28 PM
    Author     : Elliot
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            .center_div{
                align-content: center;
                text-align: center;
            }

            .center_div h1{
                text-align: center;
            }
        </style>

        <script>
            function info(estado) {
            console.log(estado);        
                if(estado != ''){
                    alert(estado);
                }
               alert(estado);
            }
        </script>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="center_div">
            <h1>Iniciar Sesion</h1>
            <form action="inicio?action=acceso" method="post">
                <table border="1" align="center">
                    <tr>
                        <td>Username:</a></td>		
                        <td><input type="text" name="username" /></td>	
                    </tr>
                    <tr>
                        <td>Password:</a></td>		
                        <td><input type="password" name="password"/></td>	
                    </tr>

                </table>
                <br>

                <table border="0" align="center">
                    <tr >
                        <td><input type="submit" value="Send"  name="agregar" onclick="info('<%= request.getAttribute("error")%>') ></td>	
                    </tr>
                    

            </form>   
        </div>
    </body>
</html>
