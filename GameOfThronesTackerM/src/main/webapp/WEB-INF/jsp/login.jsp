<%-- 
    Document   : login
    Created on : Apr 18, 2017, 9:45:23 PM
    Author     : crisp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link rel="stylesheet" type="text/css"href="login.css">
    <div class="video-background">
        <div class="video-foreground">
            <iframe src="https://www.youtube.com/embed/s7L2PVdrb_8?controls=0&showinfo=0&rel=0&autoplay=1&loop=1&playlist=W0LHTWG-UmQ" frameborder="0" allowfullscreen></iframe>
        </div>
    </div>

    <div id="vidtop-content">
        <div class="vid-info">
            <h1></h1>
            <p>
                <label>Username</label>
                <input type = "text"
                       id = "myText"
                       value = "" />
            </p>
            <p>
                <label>Password</label>
                <input type = "password"
                       value = "" />
            </p>
            <p id = "correctLogin" class = "hidden">
                Incorrect Username or Password
            </p>
            <!--
              document.getElementById("correctLogin").className = 'hidden'; // to hide
              and
          
              document.getElementById("correctLogin").className = ''; // to show
              */ --->

            <button type="button" id = "loginButton" onclick="incorrectLogin()">Login</button>
            <script>
                function incorrectLogin() {
                    document.getElementById("correctLogin").className = 'notHidden';
                }

            </script>
        </div>
    </div>

</html>
