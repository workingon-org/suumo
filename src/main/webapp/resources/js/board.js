function boardListPaging(val) {
	$('#currentPage').val(val);
	document.getElementById('boardList').submit();
}
/*inquiryDetail.jsp*/
var isOpen = false;
function showDesc(num){
	if(isOpen == false){
		document.querySelector("#hideContent"+num).style.display="block";
		var showContent = document.querySelectorAll("#showContent"+num);
		for(var i=0;i<showContent.length;i++){
			showContent[i].style.display = "none";
		}
		isOpen = true;
	}else{
		document.querySelector("#hideContent"+num).style.display="none";
		var showContent = document.querySelectorAll("#showContent"+num);
		for(var i=0;i<showContent.length;i++){
			showContent[i].style.display = "block";
		}
		isOpen = false;
	}
}