<%-- 
    Document   : writer
    Created on : Apr 18, 2017, 2:17:18 PM
    Author     : crisp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<html>

<head>
    <title>ASOIAF Tracker</title>
    <meta charset='utf-8' />
    <meta name='viewport' content='width=device-width, initial-scale=1.0' />
    <!--JQUERY-->
    <script type="text/javascript" src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
    <!--Semantic UI-->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/semantic-ui/2.2.10/semantic.min.css">
    <script src="https://cdn.jsdelivr.net/semantic-ui/2.2.10/semantic.min.js"></script>
    <!--Import Open Sans font-->
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=PT+Serif|Open+Sans:300,400,600,700,800">
    <link href="index.css" rel="stylesheet">
    <script src="index.js"></script>
</head>

<body>
    <div class="pusher">
        <!-- BANNER TOP -->
        <div class="ui inverted vertical masthead center algined segment">
            <div class="ui contianer">
                <div class="ui large secondary inverted pointing menu">
                    <a class="item" href="file:///home/pterzic/Documents/CSE 412/GoT/index.html">
                        <i class="home icon"></i> Home
                    </a>
                    <a class="item active">
                        <i class="lock icon"></i> Update
                    </a>
                    <div class="right menu">
                        <a class="ui inverted button">Log out</a>
                    </div>
                </div>
            </div>
            <div class="ui text container">
                <h1 class="ui inverted header">ASOIAF Tracking App</h1>
                <h2>Stay up to date with the latest twists, deaths, and characters!</h2>
                <a class="ui huge primary button" href="#createChars">Update characters<i class="right arrow icon"></i></a>
            </div>
        </div>

        <!-- SITE CONTENT UNDER BANNER -->
        <!-- ADD CHARACTER FORM -->
        <div class="ui vertical stripe segment" id="createChars">
            <div class="ui middle aligned stackable grid container">
                <div class="row">
                    <div class="eight wide column">
                        <h3 class="ui header">Add a character</h3>
                        <form class="ui form" id="createCharForm">
                            <h4 for="cName">Name</h4>
                            <input type="text" name="cName" placeholder="ex. Rickard Stark">
                            <h4 for="cTitle">Title</h4>
                            <input type="text" name="cTitle" placeholder="ex. King in the North">
                            <h4 for="cStatus">Status</h4>
                            <input type="text" name="cStatus" placeholder="ex. Alive">
                            <h4 for="cReligion">Religion</h4>
                            <input type="text" name="cReligion" placeholder="ex. Old Gods">
                            <br><br>
                            <button class="ui positive button" type="submit" onclick="submitCreateChar();">Create Character</button>
                        </form>
                    </div>
                </div>

                <!-- KILL CHARACTER TABLE -->
                <div class="row">
                    <h3>Characters</h3>
                    <table class="ui celled table">
                        <thead>
                            <tr>
                                <th>Name</th>
                                <th>Status</th>
                                <th>Title</th>
                                <th>Religion</th>
                                <th>Kill Character</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td class="cn">Cersei Lannister</td>
                                <td>Alive</td>
                                <td>Queen</td>
                                <td>Faith of the Seven</td>
                                <td>
                                     <button class="ui negative button killButton" type="submit" onclick="submitKill();">Kill Character</button>
                                </td>
                            </tr>
                            <tr>
                                <td class="cn">Jaime Lannister</td>
                                <td>Alive</td>
                                <td>Lannister</td>
                                <td>Faith of the Seven</td>
                                <td>
                                     <button class="ui negative button killButton" type="submit" onclick="submitKill();">Kill Character</button>
                                </td>
                            </tr>
                            <tr>
                                <td class="cn">Arya Stark</td>
                                <td>Alive</td>
                                <td>Stark</td>
                                <td>God of Many Faces</td>
                                <td>
                                     <button class="ui negative button killButton" type="submit" onclick="submitKill();">Kill Character</button>
                                </td>
                            </tr>
                            <tr>
                                <td class="cn">Melisandre</td>
                                <td>Alive</td>
                                <td>None</td>
                                <td>R'hllor</td>
                                <td>
                                     <button class="ui negative button killButton" type="submit" onclick="submitKill();">Kill Character</button>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <!-- FOOTER -->
        <div class="ui inverted vertical footer segment">
            <div class="ui contianer">
                <div class="ui stackable inverted divided equal height stackable grid">
                    <div class="three wide column"></div>
                    <div class="seven wide column">
                        <h4 class="ui inverted header">This project is for CSE 412 Spring '17 at ASU, by Group 3.</h4>
                        <div class="ui inverted list">
                            <li>Philip Terzic</li>
                            <li>Christina Wilmot</li>
                            <li>Sam Butler</li>
                            <li>Kendall Hickie</li>
                            <li>Carmine Lettieri</li>
                        </div>
                    </div>
                    <div class="three wide column">
                        <h4 class="ui inverted header">About</h4>
                        <p>This project was created using Microsoft SQL Server as our DBMS. The backend was built in Java Spring.
                            The UI was developed with help from the SemanticUI library.</p>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>

</html>