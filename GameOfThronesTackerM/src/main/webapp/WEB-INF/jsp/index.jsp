<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
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
        <!-- BANNER -->
        <div class="ui inverted vertical masthead center algined segment">
            <div class="ui contianer">
                <div class="ui large secondary inverted pointing menu">
                    <a class="active item">
                        <i class="home icon"></i> Home
                    </a>
                    <a class="item" href="file:///home/pterzic/Documents/CSE 412/GoT/writer.html">
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
                <a class="ui huge primary button" href="#theories">Check your predictions<i class="right arrow icon"></i></a>
            </div>
        </div>

        <!-- SITE CONTENT UNDER BANNER -->
        <!-- THEORIES -->
        <div class="ui vertical stripe segment" id="theories">
            <div class="ui middle aligned stackable grid container">
                <div class="row">
                    <div class="eight wide column">
                        <!--form class="ui form" name="theoryForm"-->
                        <h3 class="ui header">Current Theories &amp; Predictions</h3>
                        <div class="ui piled very padded segments">
                            <div class="ui segment">
                                <p>Description 1</p>
                                <label>Theory 1</label>
                                <br><br>
                                <button class="ui positive button correctTheory">Correct &nbsp;&nbsp;</button>
                                <button class="ui negative button wrongTheory">Incorrect</button>
                            </div>
                            <div class="ui segment">
                                <p>Description 1</p>
                                <label>Theory 1</label>
                                <br><br>
                                <button class="ui positive button correctTheory">Correct &nbsp;&nbsp;</button>
                                <button class="ui negative button wrongTheory">Incorrect</button>
                            </div>
                            <div class="ui disabled segment">
                                <p id="t3">Theory that was wrong</p>
                                <label>Theory 3</label>
                                <br><br>
                                <button class="ui positive button correctTheory">Correct &nbsp;&nbsp;</button>
                                <button class="ui negative button wrongTheory">Incorrect</button>
                            </div>
                        </div>
                        <!--/form-->
                    </div>
                    <div class="three wide column">
                        <div class="ui statistic">
                            <div class="label">
                                Accuracy
                            </div>
                            <div class="value" id="theoryStat">
                                39%
                            </div>
                        </div>
                    </div>
                    <div class="four wide right floated column">
                        <h4 class="ui header">Top Theorists</h4>
                        <div class="ui segments" id="topTheorists">
                            <div class="ui segment">
                                User1
                            </div>
                            <div class="ui segment">
                                User2
                            </div>
                            <div class="ui segment">
                                User3
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- QUERY TABS -->
        <div class="ui vertical stripe segment">
            <div class="row">
                <div class="ui text container">
                    <h3 class="ui header">Getting lost?</h3>
                    <p>If the episodes and chapters have got you lost, try searching topics you've lost track of. Choose between
                        characters, houses, and factions to learn more and start refining your predictions!</p>
                    <h4 class="ui horizontal header divider">
                        <a href="#">Select an entity to query on</a>
                    </h4>
                </div>
            </div>

            <div class="row">
                <!-- TODO the tab section doesnt want to follow the grid format I set for it, so it spans the entire page. Ideally it would be shrinked -->
                <div class="center aligned eight wide column">
                    <div class="ui top attached tabular menu">
                        <a class="item active" data-tab="characters">Characters</a>
                        <a class="item" data-tab="houses">Houses</a>
                        <a class="item" data-tab="factions">Factions</a>
                    </div>
                    <div class="ui bottom attached tab segment active" data-tab="characters">
                        <form class="ui form" id="charForm">
                            <h4 for="charName">Character name</h4>
                            <input type="text" name="charName" placeholder="ex. Jon Snow" required>
                            <button class="ui button" type="submit" onclick="submitChar();">Get Character Info</button>
                        </form>
                        <h4 class="ui header charInfo">Character Info</h4>
                        <div class="ui middle aligned huge divided list">
                            <div class="item">
                                <em>Name:</em>
                                <div class="content centered">
                                    Cersei Lannister
                                </div>
                            </div>
                            <div class="item">
                                <em>Title:</em>
                                <div class="content centered">
                                    Queen Regent
                                </div>
                            </div>
                            <div class="item">
                                <em>
                                Religion:</em>
                                <div class="content centered">
                                    Faith of the Seven
                                </div>
                            </div>
                            <div class="item">
                                <em>House:</em>
                                <div class="content centered">
                                    House Lannister
                                </div>
                            </div>
                        </div>

                        <h4>Character Relationships</h4>
                        <table class="ui celled table">
                            <thead>
                                <tr>
                                    <th>Name</th>
                                    <th>Status</th>
                                    <th>Neutrality</th>
                                    <th>Relationship Description</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>Hodor</td>
                                    <td>Current</td>
                                    <td>Neutral</td>
                                    <td>Never met</td>
                                </tr>
                                <tr class="positive">
                                    <td>Jaime Lannister</td>
                                    <td>Current</td>
                                    <td><i class="icon checkmark"></i> Positive</td>
                                    <td>Brother, lover</td>
                                </tr>
                                <tr class="negative">
                                    <td>Sansa Stark</td>
                                    <td>Current</td>
                                    <td><i class="icon close"></i>Negative</td>
                                    <td>Killed Sansa's wolf and father, kept Sansa hostage in the Red Keep</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="ui bottom attached tab segment" data-tab="houses">
                        <form class="ui form" id="houseForm">
                            <h4 for="houseName">House Name</h4>
                            <input type="text" name="houseName" placeholder="ex. Stark" required>
                            <br>
                            <button class="ui button" type="submit" onclick="submitHouse();">Get House Info</button>
                        </form>
                        <h4 class="ui header charInfo">House Info</h4>
                        <div class="ui middle aligned huge divided list">
                            <div class="item">
                                <em>Name:</em>
                                <div class="content centered">
                                    House Stark
                                </div>
                            </div>
                            <div class="item">
                                <em>Words:</em>
                                <div class="content centered">
                                    Winter is coming
                                </div>
                            </div>
                            <div class="item">
                                <em>Banner:</em>
                                <div class="content centered">
                                    A gray direwolf on a white field
                                </div>
                            </div>
                            <div class="item">
                                <em>Status:</em>
                                <div class="content centered">
                                    Current
                                </div>
                            </div>
                        </div>
                        <h4>Members of House</h4>
                        <table class="ui celled table">
                            <thead>
                                <tr>
                                    <th>Name</th>
                                    <th>Title</th>
                                    <th>Status</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>Brandon Stark</td>
                                    <td>The Builder</td>
                                    <td>Current</td>
                                </tr>
                                <tr>
                                    <td>Ned Stark</td>
                                    <td>Lord Warden of the North</td>
                                    <td>Former</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="ui bottom attached tab segment" data-tab="factions">
                        <form class="ui form" id="factionForm">
                            <h4 for="houseName">Faction Leader Name</h4>
                            <input type="text" name="factionName" placeholder="ex. Tywin Lannister" required>
                            <br>
                            <button class="ui button" type="submit" onclick="submitFaction();">Get Faction Info</button>
                        </form>
                        <h4 class="ui header charInfo">Faction Info</h4>
                        <div class="ui middle aligned huge divided list">
                            <div class="item">
                                <em>Leader Name:</em>
                                <div class="content centered">
                                    Tywin Lannister
                                </div>
                            </div>
                        </div>
                        <h4>Faction Members</h4>
                        <table class="ui celled table">
                            <thead>
                                <tr>
                                    <th>House</th>
                                    <th>Faction Name</th>
                                    <th>Faction Status</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>Tyrell</td>
                                    <td>Iron Throne</td>
                                    <td>Active</td>
                                </tr>
                                <tr>
                                    <td>Lannister</td>
                                    <td>House Lannister</td>
                                    <td>Inactive</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
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