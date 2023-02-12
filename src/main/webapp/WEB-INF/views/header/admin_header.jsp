<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Navbar -->
<div class="site-mobile-menu">
	<div class="site-mobile-menu-header">
		<div class="site-mobile-menu-close mt-3">
			<span class="icon-close2 js-menu-toggle"></span>
		</div>
	</div>
	<div class="site-mobile-menu-body"></div>
</div>
<header class="site-navbar" role="banner" style="position: relative!important;">
	<div class="container"
		style="position: relative;">
		<div class="row align-items-center">

			<div class="col-11 col-xl-2">
				<h1 class="mb-0 site-logo">
					<a href="/" class="text-white mb-0">Pj_Hotel</a>
				</h1>
			</div>
			<div class="col-12 col-md-10 d-none d-xl-block">
				<nav class="site-navigation position-relative text-right"
					role="navigation">

					<ul class="site-menu js-clone-nav mr-auto d-none d-lg-block">
						<li class="active"><a href="/admin"><span>Home</span></a></li>
						<li class="has-children"><a><span>Main</span></a>
							<ul class="dropdown arrow-top">
								<c:if test="${empty sessionScope.loginUserInfo.name}">
									<li><a href="/login">Login</a></li>
									<li><a href="/signup">Signup</a></li>
								</c:if>
								<li><a href="/reservation">Reservation</a></li>
								<li><a href="/board">Board</a></li>
								<li class="has-children"><a href="/room/Deluxe">Room</a>
									<ul class="dropdown">
										<li><a href="#">Standand</a></li>
										<li><a href="#">Deluxe</a></li>
										<li><a href="#">Suite</a></li>
										<li><a href="#">Royal</a></li>
									</ul></li>
							</ul></li>
						<li><a href="/admin/book/list"><span>Bookings</span></a></li>
						<li><a href="/admin/room/roominfolist"><span>RoomInfo</span></a></li>
						<li><a href="/admin/userInfo/userList"><span>Customer</span></a></li>
						<li><a href="/admin/notice/list"><span>Notice</span></a></li>
					</ul>
				</nav>
			</div>


			<div class="d-inline-block d-xl-none ml-md-0 mr-auto py-3"
				style="position: relative; top: 3px;">
				<a href="#" class="site-menu-toggle js-menu-toggle text-white"><span
					class="icon-menu h3"></span></a>
			</div>
		</div>
	</div>
</header>