<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@splidejs/splide@2.4.21/dist/css/themes/splide-sea-green.min.css">
    <link rel="stylesheet" href="./css/style_login.css">
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Noto+Sans+TC&display=swap');
        *{
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            list-style: none;
            text-decoration: none;
        }
        /*教練推薦*/

        .hot_trainer{
            text-align: center; 
            display:block;
            margin: 20px 0px -10px;
        }
        .hot_trainer h3{
            font-size: 18px;
            text-align: center;
            color: #666;
            font-family: 'Noto Sans TC', sans-serif;
        }

        .splide{
            margin: auto;
            
        }
        .splide__slide{
            position: relative;
            /* width: 280px; */
            height: 320px;
            /* background-color: black; */
            /* background: linear-gradient(to bottom, rgba(0,0,0,0) 0%,rgba(0,0,0,0.65) 100%); */
            box-shadow: 0px 0px 5px 0.6px #999;
            
        }
        .splide__slide img{
            width: 100%;
            height: 100%;
            /* opacity: 0.5; */
        }

        .splide__slide .p_t{
            position: absolute;
            
            width: 100%;
            bottom: 0px;
            background-color: rgba(0,0,0,0.7);;
            padding: 7px 0px 10px;
            color: aliceblue;     
            font-family: 'Noto Sans TC', sans-serif;       
        }
        .t_name{
            font-size: 18px;
            font-weight: 700;

            text-align: center;
            margin: 8px;
        }
        .p_t span{
            display: flex;
            justify-content: space-around;
            /* padding: 5px; */
            font-size: 13px;
            margin: 0px 10px;
        }
        .p_t span i{
            margin: 0px 10px 0px 0px ;
        }

        /* <p class="t_name">教練名稱</p>
                    <p class="t_location">地點</p>
                    <p class="t_ltimes">20次課程媒合</p> */

        /*評價星星*/

        .p_t span:nth-child(3) p{
            /* vertical-align: middle; */
            margin: 6px 0px 0px -80px;
            font-size: 15px;
        }

        .ratings {
            position: relative;
            bottom: 20%;
            left: 4%;
            vertical-align: middle;
            display: inline-block;
            color: #b1b1b1;
            overflow: hidden;
        }
        .full-stars {
            position: absolute;
            left: 0;
            top: 0;
            white-space: nowrap;
            overflow: hidden;
            color: #fde16d;
        }
        .empty-stars:before, .full-stars:before {
            content:"\2605\2605\2605\2605\2605";
            font-size: 15pt;
        }
        .empty-stars:before {
            -webkit-text-stroke: 1px #848484;
        }
        .full-stars:before {
            -webkit-text-stroke: 1px orange;
        }
        /* Webkit-text-stroke is not supported on firefox or IE */

        /* Firefox */
        @-moz-document url-prefix() {
            .full-stars {
                color: #ECBE24;
            }
        }


        /*nav*/

        header{
            background-color: #fff;
            padding: 10px 100px 10px 100px;

        }
        header ul{
            display: flex;
            flex-wrap: wrap;
            align-items: center;
            justify-content: center;
            width: 100%;
            max-width: 1200px;
            margin: auto;
        }
        .items{
            display: inline-flex;
            padding: 0 25px;
        }
        .items li{
            font-size: 14px;
            margin: 0 20px;
            font-family: 'Noto Sans TC', sans-serif;
        }
        .items li a{
            color: #333;
            transition: .3s;
        }
        .items li a:hover{
            color: #59ddb8;
            
        }
        .logo{
            flex: 1;
        }
        .logo img{
            vertical-align: bottom;
            width: 200px;

        }
        .login_btn{
            padding: 10px 20px;
            border: none;
            border-radius: 10px;
            color: #fff;
            background-color: #59ddb8;
            cursor: pointer;
            font-family: 'Noto Sans TC', sans-serif;
        }
        .login_btn:hover{
            padding:9px 19px;
            color: rgb(5, 230, 192);
            background-color:#fff;
            border: 1px solid #59ddb8;
        }
        .slider{
            position: relative;
        }


        .banner{
            position: relative;
            background-image: url('/images/banner_1.jpg');
            background-size: cover;
            background-repeat: round;
            height: 100vh;
            margin: auto;
            max-height: 600px;
            
        }

        .slider .ad{
            width: 500px;
            position: absolute;
            left: 20%;
            top: 30%;
            color: #fff
            /* background-color: white; */
        }
        .slider h3{
            padding: 0 0 10px;
            font-size: 30px;
            line-height: 35px;
            color:#00ffb7;
            font-family: 'Noto Sans TC', sans-serif;
        }
        .slider p{
            padding: 3px;
            line-height: 22px;
            font-family: 'Noto Sans TC', sans-serif;
        }

        /*搜尋*/
        .search_trainer{
            position: absolute;
            top: 70%;
            width: 100%;
            display: flex;
            justify-content: center;
        }
        .search_trainer li{
            margin: 0px 10px;
        }
        .search_trainer select{
            width: 150px;
        }
        .search_trainer select,.search_input,.search_btn{
            padding: 15px 30px;
            border-radius: 10px;
            border: none;
            font-size: 16px;
            font-family: 'Noto Sans TC', sans-serif;
            text-align: center;
            vertical-align: baseline;
        }
        .search_trainer .search_input{
            width: 200px;
        }
        .search_trainer .search_btn{
            background-color: #59ddb8;
            color: #fff;
            /* font-weight: bold; */
            font-family: 'Noto Sans TC', sans-serif;
            cursor: pointer;
        }
        .search_trainer .search_btn:hover{
            padding: 14px 29px;
            color: rgb(5, 230, 192);
            background-color:#fff;
            border: 1px solid #59ddb8;
        }


        /* footer */

        footer{
            padding: 100px 0 0 0;
            background:#888
        }

        footer .container{
            display: flex;
            width: 1200px;
            margin: auto;
            font-family: 'Noto Sans TC', sans-serif;
        }
        .footer-item h3{
            font-size: 20px;
            color: #fff;
            border-bottom: 1px solid #fff;
            margin-bottom: .5em;
            padding-bottom: .5em;
        }
        .footer-item{
            width: 0;
            flex-grow: 1;
            margin: 0 100px;
        }
        .footer-item nav{
            display: flex;
            flex-direction: column;
 
        }
        .footer-item nav a{
            color: #fff;
            font-size: 14px;
            line-height: 1.2;
            text-decoration: none;
            padding: 5px 0;
        }
        .copyright{
            width: 100%;
            text-align: center;
            font-size: 13px;
            font-family:Verdana, Geneva, Tahoma, sans-serif;
            margin: 100px 0 0;
            padding: 10px 0px;
            background-color: #000;
            color: #fff;
        }


        /* @media screen and (min-width: 768px) {
            
        } */

    </style>
</head>
<body>
    <header>
        <ul>
            <li class="logo">
         
                <a href="#"><img src="./images/logo_black.png"></a>
            </li>
            <div class="items">
                <li><a href="#">關於我們</a></li>
                <li><a href="#">尋找教練</a></li>
                <li><a href="#">購物商城</a></li>
                <li><a href="#">運動論壇</a></li>
            </div>
            <li>
                <button class="login_btn" onclick="Show();">登入/註冊</button>
            </li>            
    </header>
    <div class="slider">
        <div class="banner">
        
        <div class="ad">
            <h3>健身教練與學員的<br>專屬媒合平台</h3>
            <p>教練課程價錢、時段公開透明<br>
            省去詢問時間，免於被健身業務打擾<br>
            透過評價系統，讓您篩選最適合自己的教練！
            </p>
        </div>
     
            <form class="search_trainer" action="#">
                <li>    
                    <select name="" class="lesson">
                        
                        <option value="0">課程種類</option>
                        <option value="1">增肌</option>
                        <option value="2">減脂</option>
                    </select>
                </li>
                <li>
                    
                    <select name="" class="location">
                        <option value="0">地點</option>
                        <option value="1">台北市</option>
                        <option value="2">新北市</option>
                    </select>
                </li>
                <li><input type="search" placeholder="輸入關鍵字" class="search_input">    </li>
                <li><button class="search_btn">搜尋教練</button>    </li>
            </form>
        </div>
    </div>

    <!-- 人氣教練 -->

    <span class="hot_trainer">
        <img src="data:image/png;base64,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"> 
        <h3>本月人氣教練</h3>
    </span>
    
    <div class="splide">
        <div class="splide__track">
            <ul class="splide__list">
                <div class="splide__slide">
                    <div class="p_t">
                        <p class="t_name">林瑪莉</p>
                        <span>
                            <p class="t_location"><i class="fas fa-map-marker-alt"></i>台北市</p>
                            <p class="t_ltimes"><i class="fas fa-user-friends"></i>20次課程媒合</p>
                        </span>
                        <span>
                            <div class="ratings">
                                <div class="empty-stars"></div>
                                <div class="full-stars" style="width:80%"></div>                            
                            </div>
                            <p>(18)</p>
                        </span>
                    </div>
                    <img src="">
                </div>

                <div class="splide__slide">
                    <div class="p_t">
                        <p class="t_name">林瑪莉</p>
                        <span>
                            <p class="t_location"><i class="fas fa-map-marker-alt"></i>台北市</p>
                            <p class="t_ltimes"><i class="fas fa-user-friends"></i>20次課程媒合</p>
                        </span>
                        <span>
                            <div class="ratings">
                                <div class="empty-stars"></div>
                                <div class="full-stars" style="width:80%"></div>                            
                            </div>
                            <p>(18)</p>
                        </span>
                    </div>
                    <img src="/images/2.png">
                </div>

                <div class="splide__slide">
                    <div class="p_t">
                        <p class="t_name">林瑪莉</p>
                        <span>
                            <p class="t_location"><i class="fas fa-map-marker-alt"></i>台北市</p>
                            <p class="t_ltimes"><i class="fas fa-user-friends"></i>20次課程媒合</p>
                        </span>
                        <span>
                            <div class="ratings">
                                <div class="empty-stars"></div>
                                <div class="full-stars" style="width:80%"></div>                            
                            </div>
                            <p>(18)</p>
                        </span>
                    </div>
                    <img src="/images/3.jpg">
                </div>
                
                <div class="splide__slide">
                    <div class="p_t">
                        <p class="t_name">林瑪莉</p>
                        <span>
                            <p class="t_location"><i class="fas fa-map-marker-alt"></i>台北市</p>
                            <p class="t_ltimes"><i class="fas fa-user-friends"></i>20次課程媒合</p>
                        </span>
                        <span>
                            <div class="ratings">
                                <div class="empty-stars"></div>
                                <div class="full-stars" style="width:80%"></div>                            
                            </div>
                            <p>(18)</p>
                        </span>
                    </div>
                    <img src="/images/1.jpg">
                </div>

                <div class="splide__slide">
                    <div class="p_t">
                        <p class="t_name">林瑪莉</p>
                        <span>
                            <p class="t_location"><i class="fas fa-map-marker-alt"></i>台北市</p>
                            <p class="t_ltimes"><i class="fas fa-user-friends"></i>20次課程媒合</p>
                        </span>
                        <span>
                            <div class="ratings">
                                <div class="empty-stars"></div>
                                <div class="full-stars" style="width:80%"></div>                            
                            </div>
                            <p>(18)</p>
                        </span>
                    </div>
                    <img src="/images/2.png">
                </div>

                <div class="splide__slide">
                    <div class="p_t">
                        <p class="t_name">林瑪莉</p>
                        <span>
                            <p class="t_location"><i class="fas fa-map-marker-alt"></i>台北市</p>
                            <p class="t_ltimes"><i class="fas fa-user-friends"></i>20次課程媒合</p>
                        </span>
                        <span>
                            <div class="ratings">
                                <div class="empty-stars"></div>
                                <div class="full-stars" style="width:80%"></div>                            
                            </div>
                            <p>(18)</p>
                        </span>
                    </div>
                    <img src="/images/3.jpg">
                </div>
                
            </ul>
        </div>
    </div>


    <!-- 登入 -->

    <div id="loginbox" class="screenbox hide">
    <div  class="from-box ">
        <form id="login" class="input-group" action="#">
          <div>
              <div class="boxlogo" onclick="Hide();"><img class="loginlogo" src="images/logo_black.png" alt="Train Me" title="Train Me"></div>
              <input type="text" name="email" class="input-field" placeholder="帳號" required>
              <input type="password" name="pswd" class="input-field" placeholder="密碼" required>
              <p class="error" size="-1"> ${ErrorMsgKey.LoginError} </p>
              <input type="checkbox" class="chech-box"><span class="remberpw">記住密碼</span>
              
              <button type="submit" class="submit-btn">登入</button>
              
              <p class="ask-register">還沒有Train Me的帳號嗎？</p>
              
              <!-- <p class="ask-register">還沒有Train Me的帳號嗎？<span class="span-btn" onclick="register()">點我註冊</span></p> -->
              <div class="register-btn">
                <button type="button" class="submit-btn register-st-btn" onclick="register()">註冊學員</button>
                <button type="button" class="submit-btn register-tr-btn" onclick="register()">註冊教練</button>
              </div>
           </div>
        </form>
        <form id="register" class="input-group" action="#">
          <h2>註冊學員</h2>
          <input type="email" name="email" value="${param.email}" class="input-field" placeholder="電子信箱" required>
          <p class="error" color="red" size="-1">${MsgMap.errorEmail} ${MsgMap.emailError} </p> 
          <input type="password" name="password" class="input-field" placeholder="密碼" required>
          <p class="error" color="red" size="-1">${MsgMap.errorPasswordEmpty} ${MsgMap.passwordError}</p> 
          <input type="password" name="passwordcheck" class="input-field" placeholder="確認密碼" required>
          <p class="error" color="red" size="-1">${MsgMap.errorPpasswordCcheckEmpty} ${MsgMap.passwordCheckError}</p> 
          <input type="text" name="name" class="input-field" placeholder="姓名" required>
          <p class="error" color="red" size="-1">${MsgMap.errorName}</p>
          <input type="text" name="phone" class="input-field" placeholder="手機" required>
          <p class="error" color="red" size="-1">${MsgMap.errorPhone}</p>
          <input type="text" name="id" class="input-field" placeholder="身分證字號" required>
          <p class="error" color="red" size="-1">${MsgMap.errorId}</p>
          <div class="date_sex_select">
            <label for="signup-date" >生日：</label>
            <input name="birthday" type="date" class="input-field birthday" required>
            <label for="signup-sex" >性別：</label>
            <select name="" class="sex input-field">
              <option value="man">男</option>
              <option value="woman">女</option>
            </select>
          </div>
          
          <button type="submit" class="submit-btn register-btn">註冊</button>
          <div class="askac">
            <p>已有帳號？<span class="span-btn" onclick="login()">登入</span></p>
          </div>
        </form>
      </div>
    </div>

    <!-- 其他區塊 -->
    <div class="about">

    </div>

    <!-- footer -->

    <footer>
        <div class="container">
            <div class="footer-item">
                <h3>本站地圖</h3>
                <nav>
                    <a href="#">關於我們</a>
                    <a href="#">搜尋教練</a>
                    <a href="#">購物商城</a>
                    <a href="#">運動論壇</a>
                </nav>
            </div>

            <div class="footer-item">
                <h3>本站地圖</h3>
                <nav>
                    <a href="#">關於我們</a>
                    <a href="#">搜尋教練</a>
                    <a href="#">購物商城</a>
                    <a href="#">運動論壇</a>
                </nav>
            </div>

            <div class="footer-item">
                <h3>本站地圖</h3>
                <nav>
                    <a href="#">關於我們</a>
                    <a href="#">搜尋教練</a>
                    <a href="#">購物商城</a>
                    <a href="#">運動論壇</a>
                </nav>
            </div>
            
        </div>
        <div class="copyright">
            Copyright &copy; 2021 Train Me
        </div>
    </footer>

    
    <script src="./js/jquery-3.5.1.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@splidejs/splide@2.4.21/dist/js/splide.min.js"></script>
    <script>

        function Show(){
              document.getElementById('loginbox').classList.remove('hide');
          }
        function Hide(){
            document.getElementById('loginbox').classList.add('hide');
        }
        var x = document.getElementById("login");
        var y = document.getElementById("register");
  
        function register() {
          x.style.left = "-400px"
          y.style.left = "50px";
        }
  
        function login() {
          x.style.left = "50px"
          y.style.left = "450px";
        }
  
        // 教練推薦


        document.addEventListener( 'DOMContentLoaded', function () {
            new Splide( '.splide', {
            width: '1200px',
            // fixedWidth: '12rem',
            // fixedHeight: '8rem',
            padding: {
                left:20,
                right:20,
            },               
            perPage: 4,
            perMove: 1,
            gap: 40,
            rewind : true,
            pagination :false,
            // arrowPath: 'M339.7,10l-65.1,65.3L611.3,500L274.6,924.7l65.1,65.3l385.7-490.2L339.7,10z'
        } ).mount();
        } );

      </script>

</body>
</html>