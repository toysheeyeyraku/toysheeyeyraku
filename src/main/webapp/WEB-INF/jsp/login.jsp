<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/css/style.css">
    
    <link href="https://fonts.googleapis.com/css?family=Josefin+Sans&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/e7ae4e2f8f.js" crossorigin="anonymous"></script>
</head>
<body>
    
   <form class="box" action="login" method='post'>
        <img src="/imgs/logo.jpg" class="form__logo" alt="">
        <input type="text" name="username" placeholder="Username">
        <input type="password" name="password" placeholder="Password">
        <div class="social">
           <a href="oauth2/authorize-client/facebook" class="social"><i class="fab fa-facebook-f"></i></a>
           <a href="oauth2/authorize-client/google" class="social"><i class="fab fa-google-plus-g"></i></a>
        </div>
        <input type="submit" name="" value="Login">
        <a href="http://localhost:8081/register/form" class="sign__up">Sign up</a>
    </form>
</body>
</html>