<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="poly.service.impl.OcrService"%>
<%@page import="poly.service.IOcrService"%>
<%@page import="poly.dto.OcrDTO"%>
<%@page import="static poly.util.CmmUtil.nvl"%>
<%@page import="poly.controller.ImgController"%>
<%
	String value = nvl((String) request.getAttribute("value"));
ImgController ic = new ImgController();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>시험문제</title>
<meta name="viewport" content="width=device-width" />
<link type="text/css" rel="stylesheet"
	href="http://jcrop-cdn.tapmodo.com/v0.9.12/css/jquery.Jcrop.min.css" />
<!-- 추가 내용 시작-->

<link
	href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&display=swap"
	rel="stylesheet" />
<link type="text/css" rel="stylesheet" href="/css/img.css" />
<link type="text/css"
	href="https://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css"
	rel="stylesheet" />

<link type="text/css" rel="stylesheet" href="/css/style.css" />
<link type="text/css" rel="stylesheet" href="/css/style2.css" />
<!--  추가 내용 끝-->
<style type="text/css">
.qna__ques {
	text-align: center;
}

canvas, #uploadFile, .qna__btn__edit, .qna__btn__cut, .qna__btn__enroll
	{
	display: none;
}

html, body {
	margin: 0;
	padding: 0;
	width: 100%;
	height: 100%;
	font-family: "Black Han Sans", "Oswald", Verdana, sans-serif;
	background-image: url("/img/pasta2.jpg");
}

input[type="text"] {
	font-size: 25px;
	height: 30px;
	font-family: "Black Han Sans", "Oswald", Verdana, sans-serif;
}
</style>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript"
	src="http://jcrop-cdn.tapmodo.com/v0.9.12/js/jquery.Jcrop.min.js"></script>
<script type="text/javascript" src="/js/pixelate.js"></script>
<script type="text/javascript" src="/js/html2canvas.js"></script>
<script type="text/javascript">
      let jcropApi = null;
      // @breif 이미지 크롭 영역지정 UI 나타내기
      function imgCropDesignate() {
        let editWidth = $("#editImg").width();
        let editHeight = $("#editImg").height();

        // @breif jcrop 실행시 크롭영역을 미리 세팅

        let x1 = 0;
        let y1 = 0;
        let x2 = 100;
        let y2 = 100;

        // @breif jcrop 실행
        $("#editImg").Jcrop(
          {
            bgFade: true,
            bgOpacity: 0.2,
            setSelect: [x1, y1, x2, y2],
            onSelect: updateCoords,
            maxSize: [10000,100]
          },
          function () {
            jcropApi = this;
          }
        );

        $(".jcrop-holder").css("position", "absolute");
        $(".jcrop-holder").css("right", "0");
        $(".jcrop-holder").css("bottom", "0");
        $(".jcrop-holder").css("width", "100%");
        $(".jcrop-holder").css("height", "100%");

        $(".qna__btn__edit").css("display", "none");
        $(".qna__btn__cut").css("display", "inline");
        $(".qna__btn__enroll").css("display", "inline");
      }

      // @breif 지정된 크롭 한 영역( 좌표, 넓이, 높이 )의 값을 보관하는 함수
      function updateCoords(crap) {
        $("#xAxis").val(crap.x);
        $("#yAxis").val(crap.y);
        $("#wLength").val(crap.w);
        $("#hLength").val(crap.h);
      }

      // @breif 크롭한 영역 잘라내고 추출하기
      function imgCropApply(lang) {
        if (parseInt($("#wLength").val()) == "NaN") {
          alert("이미지를 크롭한 이후\n자르기 버튼을 클릭하세요.");
          return false;
          } else {
            for (cnt = 1; cnt < 6; cnt++) {
            let crop_img = "#crop__img__0" + cnt;
            let crop_id = document.querySelector(crop_img).src;
              if (crop_id !== undefined && crop_id !== "") continue;
            partShot();
            let edit_img = "#editImg";
            let crop_img_sel = document.querySelector(crop_img);

            let editImage = new Image();
            editImage.src = $("#editImg").attr("src");

            editImage.onload = function () {
              // @breif 캔버스 위에 이미지 그리기
              let canvas = document.querySelector("canvas");
              let canvasContext = canvas.getContext("2d");

              // @breif 캔버스 크기를 이미지 크기와 동일하게 지정
              canvas.width = $("#wLength").val();
              canvas.height = $("#hLength").val();
              canvasContext.drawImage(
                this,
                $("#xAxis").val(), // 자르기를 시작할 x좌표
                $("#yAxis").val(), // 자르기를 시작할 y좌표
                $("#wLength").val(), // 잘라낸 이미지의 넓이
                $("#hLength").val(), // 잘라낸 이미지의 높이
                0, // 캔버스에 이미지를 배치할 x좌표
                0, // 캔버스에 이미지를 배치할 y좌표
                $("#wLength").val(), // 사용할 이미지의 넓이(이미지 스트레칭 또는 축소)
                $("#hLength").val() // 사용할 이미지의 높이(이미지 스트레칭 또는 축소)
              );

              // @breif 편집한 캔버스의 이미지를 화면에 출력한다.
              let dataURI = canvas.toDataURL("image/jpeg");
              let edit_id = document.querySelector(edit_img);

              crop_img_sel.setAttribute("src", dataURI);
              crop_img_sel.style.width = $("#wLength").val();
              crop_img_sel.style.height = $("#hLength").val();
              //$("#editImg"+cnt).attr("src", dataURI);

              let temp_img = document.createElement("img");
              temp_img.setAttribute("src", "../../../img/0" + cnt + ".png");
              temp_img.setAttribute("id", "shade__img__0"+cnt);

              temp_img.style.position = "absolute";
              temp_img.style.left = $("#xAxis").val() + "px";
              temp_img.style.top = $("#yAxis").val() + "px";
              temp_img.style.width = $("#wLength").val() + "px";
              temp_img.style.height = $("#hLength").val() + "px";

              let temptemp = document.querySelector(".qna__ques__pic");
              temptemp.appendChild(temp_img);
              // 원본 이미지를 모자이크 크기만큼 그리기
              canvasContext.drawImage(
                canvas,
                $("#xAxis").val(),
                $("#yAxis").val(),
                $("#wLength").val(),
                $("#hLength").val()
              );

              $(".qna__ques").css("position", "relative");

              // 이미지 사이즈 크기 조절 시에 대한 안티앨리어싱 끄기
              canvasContext.msImageSmoothingEnabled = false;
              canvasContext.mozImageSmoothingEnabled = false;
              canvasContext.webkitImageSmoothingEnabled = false;
              canvasContext.imageSmoothingEnabled = false;

              // 이미지를 원본 사이즈로 다시 그리면 모자이크 완성
              canvasContext.drawImage(
                canvas,
                $("#xAxis").val(),
                $("#yAxis").val(),
                $("#wLength").val(),
                $("#hLength").val(),
                $("#xAxis").val(),
                $("#yAxis").val(),
                canvas.width,
                canvas.height
              );

               $.ajax({
                url: '/img/img2.do',
                async : true,
                type : "post",
                data : {base64 : dataURI,
                        num : cnt,
                        lang : lang},
                success: function(data){
                	console.log("성공");
                	console.log(data);
                	let decodedata = decodeURI(data);
                	console.log(decodedata);
                	document.querySelector('#answer_0'+cnt).setAttribute('value', data);
                	document.querySelector('#cropImgSrc0'+cnt).setAttribute('value', dataURI);
                }
              }) 

              imgCropDesignate();

            };
            
            // @details JCROP을 종료한다.
            jcropApi.destroy();
            jcropApi = null;
            break;
          }
        }
      }

      // @breif 이미지 업로드 함수
      function uploadImgFilePrinted(up) {
        // @details 업로드 파일 정보를 받아온다.
        
        let fileInfo = document.querySelector("#"+up).files[0];
        //let fileInfo = document.getElementById("uploadFile").files[0];
        let reader = new FileReader();

        let jcrop = document.querySelector('.jcrop-holder');
        if (jcrop !== null) {
        	jcrop.parentNode.removeChild(jcrop);
            jcropApi.destroy();
            jcropApi = null;
        }
        reader.onload = function () {
          // @details 업로드 이미지 출력
          $("#editImg").attr("src", reader.result);

          // @details 이미지 크기를 제목 영역과 같게 출력
          //$("#editImg").css("width", $("h1").width());

          // @details 이미지 업로드 기능 제거, 추가 업로드 방지
          $("#editImg").parent("a").removeAttr("onClick");

          // @details 편집버튼 노출
          $(".qna__btn__edit").css("display", "inline");

          $(".qna__ques").css("postion", "relative");

          canvasDrawImage(function () {
            alert("이미지 업로드가 완료되었습니다.");
          });
        };

        if (fileInfo) {
          // @details readAsDataURL을 통해 업로드한 파일의 URL을 읽어 들인다.
          reader.readAsDataURL(fileInfo);
        }
        
      }

      // @breif 캔버스 이미지 생성
      function canvasDrawImage(callback) {
        let prepImage = new Image();
        prepImage.src = $("#editImg").attr("src");

        prepImage.onload = function () {
          // @details 캔버스 위에 이미지 그리기
          // jQuery("canvas") 와같은 명령은 사용할 수 없다.
          let canvas = document.querySelector("canvas");
          let canvasContext = canvas.getContext("2d");

          $('#editImg').css("width","100%");
          $('#editImg').css("height","100%");
          
          canvas.width = $("#editImg").width();
          canvas.height = $("#editImg").height();
          canvasContext.drawImage(
            this,
            0,
            0,
            $("#editImg").width(),
            $("#editImg").height()
          );

          // @details 캔버스의 이미지
          let dataURI = canvas.toDataURL("image/jpeg");
          $("#editImg").attr("src", dataURI);

          callback();
        };
      }

      // 되돌리기
      function cancelCropImage(cnt) {
        
        let crp_img = "#crop__img__" + cnt;
        if (document.querySelector(crp_img).src === null || document.querySelector(crp_img).src === "") return;
        document.querySelector(crp_img).removeAttribute('src');

        let shade_img = "#shade__img__" + cnt;
        let shade_id = document.querySelector(shade_img);
        let input_value = "#answer_" + cnt;
        let input_id = document.querySelector(input_value);
        shade_id.parentNode.removeChild(shade_id);
        input_id.removeAttribute('value');

      }

      // 부분 스샷
      function partShot() {
        //특정부분 스크린샷
        html2canvas(document.querySelector(".qna__ques__pic"))
          //id container 부분만 스크린샷
          .then(function (canvas) {
            //jpg 결과값
            drawImg(canvas.toDataURL("image/jpeg"));
            //이미지 저장
            //saveAs(canvas.toDataURL(), "file-name.jpg");
          })
          .catch(function (err) {
            console.log(err);
          });
      }

      function drawImg(imgData) {
        console.log(imgData);
        //imgData의 결과값을 console 로그롤 보실 수 있습니다.
        return new Promise(
          function resolve() {
            //내가 결과 값을 그릴 canvas 부분 설정
            var canvas = document.getElementById("canvas");
            var ctx = canvas.getContext("2d");
            //canvas의 뿌려진 부분 초기화
            ctx.clearRect(0, 0, canvas.width, canvas.height);

            var imageObj = new Image();
            imageObj.onload = function () {
              ctx.drawImage(imageObj, 10, 10);
              //canvas img를 그리겠다.
            };
            imageObj.src = imgData;
            //그릴 image데이터를 넣어준다.
            document.querySelector('#editImgSrc').setAttribute('value', imageObj.src);
          },
          function reject() {}
        );
      }

      function saveAs(uri, filename) {
        var link = document.createElement("a");
        if (typeof link.download === "string") {
          link.href = uri;
          link.download = filename;
          document.body.appendChild(link);
          link.click();
          document.body.removeChild(link);
        } else {
          window.open(uri);
        }
      }

    </script>
</head>
<body>
<div class="bgcol">
	<input type="hidden" id="xAxis" value="0" placeholder="선택영역의_x좌표" />
	<input type="hidden" id="yAxis" value="0" placeholder="선택영역의_y좌표" />
	<input type="hidden" id="wLength" value="0" placeholder="선택영역의_w넓이" />
	<input type="hidden" id="hLength" value="0" placeholder="선택영역의_h높이" />
	<input type="file" id="uploadFile"
		onChange="uploadImgFilePrinted('uploadFile');" accept="image/*" />
	<form action="/img/img/enrollment.do" method="post" id="formform"
		name="formform">
		<div class="navbar navbar-fixed-top">
			<nav class="navbar-inner header">
				<div class="container">
					<a href="/main/mainPage.do">
						<div class="brand" style="color: #f89406">QUIZ GENERATOR</div>
					</a>
					<ul class="nav pull-right">
						<li><a class="nav-link"> MYPAGE </a></li>
						<li><a class="nav-link"> BOARD </a></li>
						<li><a class="nav-link"> LOGOUT </a></li>
					</ul>
					<div class="triangle-down center">
						<p>
							<i id="toggle" class="fa fa-chevron-down fa-2x isDown"></i>
						</p>
					</div>
				</div>
			</nav>
			<br />
		</div>
		<div id="qna">
			
				<div class="qna qna__ques_o" id="qna__ques">
					<div class="qna__ques qna__ques__pic">
						<a href="javascript:;" onClick="$('#uploadFile').click();"
							id="pic_id"> <img id="editImg" src="../../../img/user.png">
						</a> <input type="hidden" id="editImgSrc" name="editImgSrc" />
					</div>
					<canvas id="canvas"></canvas>
				</div>

				<div class="qna qna__btn" id="qna__btn">

					<div class="btn qna__btn qna__btn__edit"
						onClick="imgCropDesignate();">편집</div>
					<div class="btn qna__btn qna__btn__upload">
						<input type="file" name="file" id="uploadAnother"
							onChange="uploadImgFilePrinted('uploadAnother');"
							accept="image/*" style="display: none;" />
						<div class="button" onClick="$('#uploadAnother').click();">업로드</div>
					</div>
					<div class="btn qna__btn qna__btn__cut">
						<label> <input type="checkbox" id="hangul" name="lang"
							value="hangul" />한글
						</label> <br />
						<div class="btn qna__btn qna__btn__cut"
							onClick="imgCropApply($('#hangul').is(':checked'));">자르기</div>
					</div>
					<div class="btn qna__btn qna__btn__enroll"
						onClick="document.getElementById('formform').submit();">등록</div>
					<!-- 
				<div class="btn qna__btn qna__btn__cap">
					<input type="button" value="임시캡쳐" onclick="partShot();" />
				</div>
				 -->
				</div>

				<div class="qna qna__ans" id="qna__ans">
					<div class="qna__ans qna__ans__title title">
						<p>
							- 한글은 한글 체크 / 숫자, 영어는 한글 체크 해제 <br /> - 색깔 영역을 더블 클릭하면 해당 가리개,
							이미지가 지워집니다.
						</p>
					</div>
					<div class="qna__ans qna__ans__group" id="qna__ans__group">
						<div class="qna__ans__grp ans__group__01">
							<div class="qna__ans__group__num">
								<img class="colorShade" src="/img/01.png"
									ondblClick="cancelCropImage('01');" />
							</div>
							<div class="qna__ans__group__qna">
								<div class="qna__ans__group__pic qna__ans__group__pic__01">
									<img id="crop__img__01"> <input type="hidden"
										id="cropImgSrc01" name="cropImgSrc01" />
								</div>
								<div class="qna__ans__group__answer">
									<input type="text" class="answer" id="answer_01"
										name="answer_01" />
								</div>
							</div>
						</div>
						<div class="qna__ans__grp ans__group__02">
							<div class="qna__ans__group__num">
								<img class="colorShade" src="/img/02.png"
									ondblClick="cancelCropImage('02');" />
							</div>
							<div class="qna__ans__group__qna">
								<div class="qna__ans__group__pic qna__ans__group__pic__02">
									<img id="crop__img__02"> <input type="hidden"
										id="cropImgSrc02" name="cropImgSrc02" />
								</div>
								<div class="qna__ans__group__answer">
									<input type="text" class="answer" id="answer_02"
										name="answer_02" />
								</div>
							</div>
						</div>
						<div class="qna__ans__grp ans__group__03">
							<div class="qna__ans__group__num">
								<img class="colorShade" src="/img/03.png"
									ondblClick="cancelCropImage('03');" />
							</div>
							<div class="qna__ans__group__qna">
								<div class="qna__ans__group__pic qna__ans__group__pic__03">
									<img id="crop__img__03"> <input type="hidden"
										id="cropImgSrc03" name="cropImgSrc03" />
								</div>
								<div class="qna__ans__group__answer">
									<input type="text" class="answer" id="answer_03"
										name="answer_03" />
								</div>
							</div>
						</div>
						<div class="qna__ans__grp ans__group__04">
							<div class="qna__ans__group__num">
								<img class="colorShade" src="/img/04.png"
									ondblClick="cancelCropImage('04');" />
							</div>
							<div class="qna__ans__group__qna">
								<div class="qna__ans__group__pic qna__ans__group__pic__04">
									<img id="crop__img__04"> <input type="hidden"
										id="cropImgSrc04" name="cropImgSrc04" />
								</div>
								<div class="qna__ans__group__answer">
									<input type="text" class="answer" id="answer_04"
										name="answer_04" />
								</div>
							</div>
						</div>
						<div class="qna__ans__grp ans__group__05">
							<div class="qna__ans__group__num">
								<img class="colorShade" src="/img/05.png"
									ondblClick="cancelCropImage('05');" />
							</div>
							<div class="qna__ans__group__qna">
								<div class="qna__ans__group__pic qna__ans__group__pic__05">
									<img id="crop__img__05"> <input type="hidden"
										id="cropImgSrc05" name="cropImgSrc05" />
								</div>
								<div class="qna__ans__group__answer">
									<input type="text" class="answer" id="answer_05"
										name="answer_05" />
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>
