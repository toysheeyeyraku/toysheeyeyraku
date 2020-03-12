<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="/css/main.css">
<link
	href="https://fonts.googleapis.com/css?family=Josefin+Sans&display=swap"
	rel="stylesheet">
<script src="https://kit.fontawesome.com/e7ae4e2f8f.js"
	crossorigin="anonymous"></script>
</head>
<body>
<head>
<div class="container">
	<div class="header">
		<div class="l__header">
			<img class="logo" src="/imgs/logo.png" alt="">
			<h1 class="user__log">${login}</h1>
			<a href="http://localhost:8081/" class="link__telegram"><i
				class="fab fa-telegram-plane"></i>conect telegram</a>
		</div>
		<div class="r__header">
			<a class="user__out" href="http://localhost:8081/logout">Log out</a>
		</div>
	</div>
</div>
</head>
<main>
<div class="container">
	<div class="info">
		<div class="info__left">
			<div class="info__item">
				<c:forEach var="emp" items="${everyDayEvents}">
					<button class="accordion">${emp.time}</button>
				<div class="panel">
					<div class="panel__inner">
						<div class="p__left">
							<p>${emp.description}</p>
						</div>
						<div class="p__right">
							<time>${emp.time}</time>
							<img id="delete" src="/imgs/Vector.png" alt="">
						</div>
					</div>
					<div class="status__log">
						<div class="status__log__left">
							<h1 class="status__h">Sended:</h1>
							<p class="status__state">${emp.sended}</p>
						</div>
						<div class="status__log__right">
							<h1 class="mark">Mark</h1>
							<button class="btn"></button>
						</div>
					</div>
				</div>
				</c:forEach>
				




			</div>
		</div>

		<div class="intro__right">
			<div class="intro__right__inner">
				<form class="create" action="createEveryDayEvent" method='post'>
					<h1 class="create__ev">Create event</h1>
					<input type="text" name="time" placeholder="HH:MM:SS"> <input
						type="about" name="text" placeholder="About"> <input
						type="submit" name="" value="Create">
				</form>
			</div>
		</div>

	</div>
</div>

</main>

<script src="js/js.js"></script>
<script src=""></script>
</body>
</html>