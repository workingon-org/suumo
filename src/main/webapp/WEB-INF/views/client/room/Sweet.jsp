<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>

<meta charset="UTF-8">
<title>호텔 - 객실 정보</title>

</head>

<body>
	<nav class="navbar navbar-expand-lg bg-light">
		<div class="container-fluid">
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo01"
				aria-controls="navbarTogglerDemo01" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarTogglerDemo01">
				<a class="navbar-brand" href="http://localhost:8080/room/Sweet">스위트</a>
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="http://localhost:8080/room/Deluxe#">디럭스</a></li>
					<li class="nav-item"><a class="nav-link"
						href="http://localhost:8080/room/Standard">스탠다드</a></li>
					<li class="nav-item"><a class="nav-link active"
						href="http://localhost:8080/room/Royal">로열</a></li>
				</ul>	
			</div>
		</div>
	</nav>

	<p></p>


	<div class="roomImg">
		<div id="Img" style="max-width: 100%; height: auto;">
			<div id="carouselExampleIndicators" class="carousel slide"
				data-bs-ride="true">
				<div class="carousel-indicators">
					<button type="button" data-bs-target="#carouselExampleIndicators"
						data-bs-slide-to="0" class="active" aria-current="true"
						aria-label="Slide 1"></button>
					<button type="button" data-bs-target="#carouselExampleIndicators"
						data-bs-slide-to="1" aria-label="Slide 2"></button>
					<button type="button" data-bs-target="#carouselExampleIndicators"
						data-bs-slide-to="2" aria-label="Slide 3"></button>
				</div>
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img
							src="${contextpath}/resources/img/w_03-2_2_1.jpg"
							class="d-block w-70">
					</div>
					<div class="carousel-item">
						<img
							src="${contextpath}/resources/img/w_03-2_2_3.jpg"
							class="d-block w-70">
					</div>
					<div class="carousel-item">
						<img
							src="${contextpath}/resources/img/w_03-2_2_5.jpg"
							class="d-block w-70">
					</div>
				</div>
				<button class="carousel-control-prev" type="button"
					data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
					<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Previous</span>
				</button>
				<button class="carousel-control-next" type="button"
					data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
					<span class="carousel-control-next-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Next</span>
				</button>
			</div>
		</div>
	</div>

	<p></p>
	
	 <div class="container">
      <div class="row">
        <div class="col-6">
   
          <div class="card">
            <div class="card-header">
             	 부대시설	
            </div>
            <img src="images/card-image.png" alt="" />
            <div class="card-body">
            
          		 <li>피트니스 센터 무료 이용</li>
				<li>피트니스 센터는 매월 세 번쨰 수요일 정기 휴일입니다.</li>
				<li>실내 수영장 무료 이용(만 13세 이상 입장 가능)</li>
				<li>사우나 이용 시 유료</li>
				<li>투숙 기간 내 무료 주차 가능</li>
            </div>
          </div>
        </div>
        <div class="col-6">

          <div class="card">
            <div class="card-header">
              	스위트 룸
            </div>
            <img src="images/card-image.png" alt="" />
            <div class="card-body">
              <h5 class="card-title">소개</h5>
              <p class="card-text">스위트 룸은 편안한 침실과 
				안락한 거실이 있어 품격 있는 휴식을 제공합니다.</p>
              				<li>크기&nbsp;${dto.getRoom_size()}&nbsp;&nbsp;|&nbsp;&nbsp;수용인원&nbsp;${dto.getRoom_capacity() }</li>
							<li>구성&nbsp;&nbsp;침실1, 욕실1, 화장실2, 응접실 1</li>
							<li>전망 &nbsp;시티뷰 또는 빌리지뷰</li>
							<li>침대&nbsp;&nbsp;더블(킹 사이즈), 트윈</li>
            </div>
          </div>
        </div>
      </div>
    </div>
    
    <p></p>
		
		<div class="card">
			<div class="card-body">
				<h4 class="card-title">Hotel Info</h4>
				<p class="card-text">
				<li>조식 이용 안내</li>
				<li>다이닝 존(뷔페) : 07:30 ~ 10:30</li>
				<li>체크인 / 체크아웃 시간</li>
				<li>체크인 : 오후 2시 이후</li>
				<li>체크아웃 : 11시</li>
				<p></p>
				<h4>예약 취소/변경 및 No-Show 안내</h4>
					<ul>
						<li>숙박 예정일 7일 전: 위약금 없음</li>
						<li>숙박 예정일 6일 전 ~ 1일 전 : 1박 요금의 20% <br />
						</li>
						<li>숙박 예정일 1일 전(18시 이후 취소 및 변경) : 1박 요금의 80%</li>
			</div>
	</div>
	
</body>
</html>