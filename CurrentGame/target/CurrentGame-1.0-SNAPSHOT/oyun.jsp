<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Current Game</title>

    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/oyun.css" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">    <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">

</head>

<body onload="start()">
	<div class="container header">
		<div class="col-sm-1">
                    
		</div>
		<div class="col-sm-10" id="Orta">
			<div class="col-sm-12" id="OrtaUst">
				<table>
					<thead>
					  <tr >
						<th>Name</th> 
						<th>Spells</th>
						<th colspan="2">Champion</th>
						<th>KDA</th>
						<th>League</th>
						<th>Ranked Win</th>
						<th>Normal Win</th>
						<th>Masteries</th>
						<th>Runes</th>
					  </tr>
					</thead>
					<tbody>
					  <!--<tr>
						<td align="center">
                                                    <c:forEach items="${Sonuc}" var="snc">
                                                        ${snc.summonerName}</br>
                                                    </c:forEach>
						</td>
						<td align="center">
							<img src="img/spell/SummonerTeleport.png" width="20" height="20">
							<img src="img/spell/SummonerFlash.png" width="20" height="20">
						</td>
						<td align="center">
							<img src="img/champion/Jax.png" width="40px" height="40px">
						</td >
						<td align="center">
							<c:forEach items="${Sonuc}" var="snc">
                                                            <c:forEach items="${snc.runes}" var="asd">
                                                                ${asd}</br>
                                                            </c:forEach>
                                                        </c:forEach>
                                                        </br>
							(
							<font color="green">5</font>
							+
							<font color="red">4</font>
							)
							=
							<strong>9</strong>
						</td>
						<td align="center">
							<font color="green">5</font>
							/
							<font color="red">2.5</font>
							/
							<font color="orange">6</font>
						</td>
						<td align="center">
							<img src="img/leagues/Platinum.png" width="40px" height="40px">
							Platinum V (
							<strong>48 LP</strong>
							)
						</td>
						<td align="center">
							<font color="green">450</font>
							/
							<font color="red">375</font>
						</td>
						<td align="center">
							558
						</td>
						<td align="center">
							21/9/0
						</td>
						<td align="center">
							Runes
						</td>
					  </tr>-->
                                            <c:forEach items="${Sonuç1}" var="snc">
                                                <tr>
                                                    <td align="center">
                                                        ${snc.summonerName}
                                                    </td>
                                                    <td align="center">
                                                            <img src="img/spell/Summoner${snc.spell1}.png" width="20" height="20">
                                                            <img src="img/spell/Summoner${snc.spell2}.png" width="20" height="20">
                                                    </td>
                                                    <td align="center">
                                                            <img src="img/champion/${snc.hero}.png" width="40px" height="40px">
                                                    </td >
                                                    <td align="center">
                                                            ${snc.hero}</br>
                                                            (
                                                            <font color="green">${snc.heroStatistics.topGalibiyet}</font>
                                                            +
                                                            <font color="red">${snc.heroStatistics.topMalubiyet}</font>
                                                            )
                                                            =
                                                            <strong>${snc.heroStatistics.topOyun}</strong>
                                                    </td>
                                                    <td align="center">
                                                            <font color="green">${snc.heroStatistics.ortDead}</font>
                                                            /
                                                            <font color="red">${snc.heroStatistics.ortKill}</font>
                                                            /
                                                            <font color="orange">${snc.heroStatistics.ortAsist}</font>
                                                    </td>
                                                    <td align="left">
                                                              <img src="img/leagues/${snc.heroStatistics.ligi}.png"   width="40px" height="40px">
                                                              ${snc.heroStatistics.ligi} ${snc.heroStatistics.ligNumarası}
                                                              (
                                                              <strong>${snc.heroStatistics.ligPaunı} LP</strong>
                                                              )
                                                    </td>
                                                    <td align="center">
                                                            <font color="green">${snc.heroStatistics.rankedWin}</font>
                                                            /
                                                            <font color="red">${snc.heroStatistics.rankedLose}</font>
                                                    </td>
                                                    <td align="center">
                                                            ${snc.heroStatistics.unRankedWin}
                                                    </td>
                                                    <td align="center">
                                                          ${snc.masteries}
                                                    </td>
                                                    <td align="center">
                                                            Runes
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                        <tfoot>
                                            <tr>
                                                <td colspan="10" align="right" height="40px">
                                                    Banned list:
                                                    <c:forEach items="${Banlar1}" var="bnlr">
                                                        <img src="img/champion/${bnlr.hero}.png" width="30px" height="30px">
                                                    </c:forEach>
                                                </td>
                                            </tr>
                                        </tfoot>
				</table>
			</div>
			<div class="col-sm-12" id="OrtaAlt">
				<table>
					<thead>
					  <tr >
						<th>Name</th>
						<th>Spells</th>
						<th colspan="2">Champion</th>
						<th>KDA</th>
						<th>League</th>
						<th>Ranked Win</th>
						<th>Normal Win</th>
						<th>Masteries</th>
						<th>Runes</th>
					  </tr>
					</thead>
					<tbody >
                                            <c:forEach items="${Sonuç2}" var="snc">
                                                <tr>
                                                    <td align="center">
                                                        ${snc.summonerName}
                                                    </td>
                                                    <td align="center">
                                                            <img src="img/spell/Summoner${snc.spell1}.png" width="20" height="20">
                                                            <img src="img/spell/Summoner${snc.spell2}.png" width="20" height="20">
                                                    </td>
                                                    <td align="center">
                                                            <img src="img/champion/${snc.hero}.png" width="40px" height="40px">
                                                    </td >
                                                    <td align="center">
                                                            ${snc.hero}</br>
                                                            (
                                                            <font color="green">${snc.heroStatistics.topGalibiyet}</font>
                                                            +
                                                            <font color="red">${snc.heroStatistics.topMalubiyet}</font>
                                                            )
                                                            =
                                                            <strong>${snc.heroStatistics.topOyun}</strong>
                                                    </td>
                                                    <td align="center">
                                                            <font color="green">${snc.heroStatistics.ortDead}</font>
                                                            /
                                                            <font color="red">${snc.heroStatistics.ortKill}</font>
                                                            /
                                                            <font color="orange">${snc.heroStatistics.ortAsist}</font>
                                                    </td>
                                                    <td align="left">
                                                              <img src="img/leagues/${snc.heroStatistics.ligi}.png"   width="40px" height="40px">
                                                              ${snc.heroStatistics.ligi} ${snc.heroStatistics.ligNumarası}
                                                              (
                                                              <strong>${snc.heroStatistics.ligPaunı} LP</strong>
                                                              )
                                                    </td>
                                                    <td align="center">
                                                            <font color="green">${snc.heroStatistics.rankedWin}</font>
                                                            /
                                                            <font color="red">${snc.heroStatistics.rankedLose}</font>
                                                    </td>
                                                    <td align="center">
                                                            ${snc.heroStatistics.unRankedWin}
                                                    </td>
                                                    <td align="center">
                                                          ${snc.masteries}
                                                    </td>
                                                    <td align="center">
                                                            Runes
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                        <tfoot>
                                            <tr>
                                                <td colspan="10" align="right" height="40px">
                                                    Banned list:
                                                    <c:forEach items="${Banlar2}" var="bnlr">
                                                        <img src="img/champion/${bnlr.hero}.png" width="30px" height="30px">
                                                    </c:forEach>
                                                </td>
                                            </tr>
                                        </tfoot>
					
				</table>
			</div>
		</div>
		<div class="col-sm-1">
		</div>
	</div>
	<script src="js/myjs.js"></script>
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.js"></script>
</body>

</html>
