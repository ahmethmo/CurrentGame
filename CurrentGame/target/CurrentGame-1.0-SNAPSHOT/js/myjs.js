function start() {
	var resim=Math.floor((Math.random() * 15) + 1);
	$(".header").css({
		"background-image": "url('img/"+resim+".jpg')",
		"background-repeat":"no-repeat",
		"background-position": "center center",
		"background-attachment": "scroll",
		"display": "table",
		"position": "relative",
		"width": "100%",
		"height": "100%",
		"-webkit-background-size": "cover",
		"-moz-background-size": "cover",
		"background-size": "cover",
		"-o-background-size": "cover"
	});
}