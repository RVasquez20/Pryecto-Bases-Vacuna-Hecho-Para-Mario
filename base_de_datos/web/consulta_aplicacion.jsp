<%-- 
    Document   : consulta_aplicacion
    Created on : 22/10/2021, 04:00:59 PM
    Author     : javie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>

        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

        
        <title>CONSULTAS APLICACION</title>
    </head>
    <body>
         <div class="container-fluid" style="background-color: #EAF2F8  ;">
            <div class="row">
                <div class="col-md-12">
                    <div class="row" style="background-color: #45B39D ;">
                        <div class="col-md-10" style="text-align: center;">
                            <h1>Comprometidos con el futuro de los guatemaltecos</h1>

                        </div>
                        <div class="col-md-2" align="center">
                            <img alt="Bootstrap Image Preview" src="fuentes/imagenes/logo.png" style="max-width: 100px; max-height: 100px;" />
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-8">
                        </div>
                        <div class="col-md-4">
                        </div>
                    </div>
                    <nav class="navbar navbar-expand-lg navbar-light">

                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                            <span class="navbar-toggler-icon"></span>
                        </button> <a class="navbar-brand" href="http://localhost:8081/base_de_datos/index.jsp">Inicio</a>
                        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                            <ul class="navbar-nav">
                                <li class="nav-item active">
                                    <a class="nav-link" href="http://localhost:8081/base_de_datos/Ciudadanos.jsp">registro ciudadano<span class="sr-only">(current)</span></a>
                                </li>
                                
                                <li class="nav-item">
                                    <a class="nav-link" href="http://localhost:8081/base_de_datos/registro.jsp">registro vacuna</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="http://localhost:8081/base_de_datos/dosis.jsp">dosis</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="http://localhost:8081/base_de_datos/consultas.jsp">consultas</a>
                                </li>
                            </ul>

                            <ul class="navbar-nav ml-md-auto">


                            </ul>
                        </div>
                    </nav>
                </div>
            </div>
            <div class="card" style="text-align: center; width:  auto; height: 540px; margin: 120px; border-color: #45B39D; background-color: #EAFAF1;">    
                <div class="row">
                    <div class="col-md-12" >
                        <div class="row">
                            <div class="col-md-2">
                            </div>
                            <div class="col-md-8">
                                <div class="row">

                                    <div class="col-md-12" style="text-align: center; margin: 20px; ">

                                        <h1>
                                            CONSULTAS APLICACIONES
                                        </h1>

                                        <p>

                                        </p>
                                        <div class="row" style="align-items: center;">

                                            <form action="servelet_CONSTANCIA_VACUNAS" method="POST" class="form" role="form">
                                                <br>
                                                <br><br><br>
                                                


                                                <label for="ldpi">DPI:</label><br>
                                                <input type="text" style="width: 600px;" id="dpi" name="dpi"><br>


                                                <br><br>
                                                <button  name="vConsultar" id="vConsultar"  value="vconsulta" class="btn btn-block btn-outline-info">
                                                    Consultar
                                                </button>


                                            </form>



                                        </div>
                                    </div>
                                </div>
                            </div>


                            <div class="col-md-2">
                            </div>
                        </div>
                    </div>
                </div>
            </div>       


            <div class="row">
                <div class="col-md-12" >

                    <p>

                        Todos los derechos reservados de esta pagina web, creadores Mario Javier Minches Muñoz, Jerson Soto.
                    </p>

                </div>
            </div>
        </div>
    </body>
</html>
