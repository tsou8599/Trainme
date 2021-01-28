<!DOCTYPE HTML>
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta charset="UTF-8">
<title>學生個人資料</title>

  <style>
    #bigbox{
        border: 5px rgb(103, 202, 153) dashed;
        border-radius: 30px;
        width: 800px;
        min-height: 1000px;
        margin: 0 auto;
        text-align: center;
    }
    #photo{
        height: 150px;
        width: 150px;
        border: 3px rgb(0, 0, 0) solid;
        border-radius: 50%;
        margin: 30px;
        text-align: center;
        /* 出現手指按紐 */
        cursor:pointer
        
    }
    #theFile{         
        display: none;
    }
    .memberDataBox{
        margin: 10px;
    }
    .memberDataForm{
        /* border: 3px rgb(251, 255, 16) solid; */
        width: 100%; /* 表單寬度 */
        line-height: 40px; /* 間距 */
    }
  
  .memberDataLabel{
    /* border: 3px rgb(255, 24, 24) solid; */
    width: 100px;
    display: inline-block;
  
  }
  .mdiDiv{
    /* border: 3px rgb(24, 255, 128) solid; */
    min-width: 200px;
    display: inline-block;
  }
  .mdiInput{
    height: 20px;
    border-radius: 20px;
    outline:none;
  }
  #sex{
      border: 2px rgb(0, 0, 0) solid;
      width: 165px;
      height: 25px;
      padding: 0 0 0 70px;
  }
  #submitBt{
      margin: 50px;
      width: 80px;
      height: 30px;
      border-radius: 20px;
  }


</style>
</head>
<body>
<div id="bigbox">
    <h1>學員個人資料</h1>

    <!-- 用label包住<input>時，按label就等投於按input -->
    <label>
        <img src="/Shinnosuke/Shinnosuke1.jpg" alt="" id="photo">
        <input type="file" accept="image/*" id="theFile"  class="fileInput"  value="" />
        <!-- accept : 限制上傳檔案類型 -->
    </label>

        <div class="memberDataBox">
            <!-- 表單內有夾帶檔案要使用，enctype="multipart/form-data" 要求不進行URL編碼，避免破壞檔案組成結構 -->
            <form action="" method="post" class="memberDataForm" enctype="multipart/form-data">

                    <div class="memberDataBox">
                        <div class="memberDataLabel"><label for="txt_nickname">暱 稱：</label></div>
                        <div class="mdiDiv"><input type="text" class="mdiInput" id="txt_nickname"  /></div>
                    </div>
                    <div class="memberDataBox">
                        <div class="memberDataLabel"> <label for="txt_phone">電 話：</label></div>
                        <div class="mdiDiv"> <input type="text" class="mdiInput"  id="txt_phone" required="required" /></div>
                    </div>
                    
                    <div class="memberDataBox">
                        <div class="memberDataLabel"> <label >地 址 : </label></div>
                        <div class="mdiDiv"> 
                             <select name="city" id="city" class="mdiInput"  style=" width: 80px; height: 28px;">
                            	  <option value="0">請選擇</option>
                             </select>
                             <select name="area" id="area" class="mdiInput" style="width: 80px; height: 28px;" >
                              
                            </select>
                            <input type="text" class="mdiInput"  id="txt_add"   />
                        </div>
                    </div>
                   
                    
                    <input type="submit" id="submitBt" />
                   
            </form>
            
        </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script>
    //送出表單
    let submitBt = document.getElementById('submitBt');
    submitBt.addEventListener('click',function () {
        let form =document.forms[0];
        form.submit();
    })

    //更換大頭照
    let theFile = document.getElementById('theFile');
    theFile.addEventListener('change',function () {
        showImg(theFile);
  
    })

    function showImg(imgFile) {
        var file = imgFile.files[0];
       
            // 建立FileReader物件
            var fr = new FileReader();
            
            let photo = document.getElementById('photo');
            //註冊load事件
            fr.addEventListener('load', function(e) {
                 photo.src = e.target.result;
            });
            //readAsDataURL去讀 file 把檔案轉成 URL
            fr.readAsDataURL(file);
             
    }
    

    // 縣市列表
    var cityList = document.getElementById('city');

    axios.get("/trainme/CityList")
    .then(function (res) {
        var citys = res.data;
        console.log(city);
        for(city of citys){

            var option = document.createElement("option");
            option.value = city.id;
            option.innerHTML = city.name;
            cityList.appendChild(option);
        }

    })

    // 當切換縣市時，更改行政區類表
    cityList.addEventListener("change",function (e) {
    	
	
    	 // 行政區列表
        var areaList = document.getElementById('area');
        if(areaList.firstChild){
            areaList.removeChild(areaList.firstChild);
        }

        axios.get("/trainme/AreaList", {
        	    params: {
        	    	cityId: cityId
        	    }})
        .then(function (res) {
            var areas = res.data;
            console.log(area);
            for(area of areas){

                var option = document.createElement("option");
                option.value = area.id;
                option.innerHTML = area.name;
                areaList.appendChild(option);
            }

        })
        
    })
    
    
    
    

  

</script>
  
</body>
</html>

</body>
</html>