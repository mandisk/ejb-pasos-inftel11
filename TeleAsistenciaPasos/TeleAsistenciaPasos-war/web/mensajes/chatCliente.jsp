<%-- 
    Document   : chat
    Created on : Jan 26, 2012, 1:05:46 AM
    Author     : aljiru
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/jquery-1.7.1.min.js" type="text/javascript"></script>
        <title>Chat</title>
    </head>
    <body>
        <div id="chat" style="width: 500px; height: 300px; overflow-y: scroll;">

        </div>
        <form action="/ServletMensajeria" id="form" method="POST">
            <input type="hidden" name="user" value="0" />
            <input type="text" id="msgText" name="msg" />
            <input type="hidden" id="sesText" name="sesion" value="${ses}" />
            <input type="submit" value="Enviar" />
        </form>
        <script type="text/javascript">
            var ultimoC = -1;
            $("#form").submit(function(event) {
                $.ajax({
                    url: "ServletMensajeria",
                    data: $(this).serialize(),
                    success: function(data){
                        $("#chat").html($("#chat").html() + "<div>Usuario: " + $("#msgText").val() + "</div>");
                        ultimoC = data;
                        $("#msgText").val("");
                    }
                });
                return false;
            });
            
            $(document).ready(function() {
                setInterval(function() {
                    // Do something every 2 seconds
                    $.ajax({
                        url: "ServletCargarMensajes",
                        data: "ult=" + ultimoC + "&tel=1&ses=" + $("#sesText").val(),
                        success: function(data){
                            if (data.length > 5) {
                                $("#chat").html($("#chat").html() + data);
                                ultimoC = $(".maroto").html();
                                $(".maroto").removeClass("maroto");
                            }
                                
                        }
                    });
                }, 2000);
            });

        </script>
    </body>
</html>
