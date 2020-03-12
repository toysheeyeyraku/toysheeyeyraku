<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Sans&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/css/style2.css">
    <title>Document</title>
</head>
<body>
    <head>
        <div class="container">
            <div class="header">
                <div class="l__header">
                    <img class="logo" src="/imgs/logo.png" alt="">
                    <h1 class="user__log">${user}</h1>
                </div>
                <div class="r__header">
                    <a class="user__out" href="http://localhost:8081/logout">Log out</a>
                </div>
            </div>
        </div>
    </head>

    <main>
        <div class="container">
            <div class="circles">
                <div class="circles__inner">
                    <div class="circle__item">
                        <h1 class="in__circle">1</h1>
                        <div class="block__1"></div>
                    </div>
                    <div class="circle__item">
                        <h1 class="in__circle">2</h1>
                        <div class="block__2"></div>
                    </div>
                    <div class="circle__item">
                        <h1 class="in__circle">3</h1>
                    </div>
                </div>
            </div>

            <div class="conditions">
                <div class="condition__item">
                    <p class="in__condition">Start chat with this bot in telegram : @VINTransportbot</p>
                    <div class="block__3"></div>
                </div>
                
                <div class="condition__item">
                    <p class="in__condition">Copy bind code</p>
                    <div class="block__4"></div>
                </div>
                
                <div class="condition__item">
                    <p class="in__condition">Write bind code to bot</p>
                    <div class="block__5"></div>
                </div>
                
            </div>

            <div class="accept">
                <div class="accept__inner">
                    <p >BIND CODE : ${message}</p>
                    
                    
                </div>
            </div>

        </div>
    </main>
</body>
</html>
                    