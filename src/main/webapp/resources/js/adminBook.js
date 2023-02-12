function adminBookListPaging(val) {
	$('#currentPage').val(val);
	document.getElementById('adminBookListForm').submit();
}
function exportForData() {
	var currentPage = $('#currentPage').val();
	var title = $('#title').val();
	var content = $('#content').val();
	var startDate = $('#startDate').val();
	var endDate = $('#endDate').val();
	var deleteFlag = $('#deleteFlag').prop("checked");
	$.ajax({
		type: 'GET',
		url: '/admin/book/exportForData',
		data: { "currentPage": currentPage, "title": title, "content": content, "startDate": startDate, "endDate": endDate, "deleteFlag": deleteFlag },
		datatype: "text"
		
	}).done(function(data) {
		alert(data);
	}).fail(function(error) {
		alert("エラー　：　" + error);
	})
}
function exportForView() {
	var currentPage = $('#currentPage').val();
	var title = $('#title').val();
	var content = $('#content').val();
	var startDate = $('#startDate').val();
	var endDate = $('#endDate').val();
	var deleteFlag = $('#deleteFlag').prop("checked");
	location.href = "/admin/book/exportForView" +
		"?title=" + title +
		"&content=" + content +
		"&startDate=" + startDate +
		"&endDate=" + endDate +
		"&deleteFlag=" + deleteFlag +
		"&currentPage=" + currentPage;
}
function adminBookDetailUpdate(val) {
	location.href = "/admin/book/update/" + val;
}
function adminBookDetailCancel(val) {
	if (confirm('예약정보를 취소하시겠습니가?')) {
		location.href = "/admin/book/delete/" + val;
	}
}
function adminCalendarLink(val) {
	$("#adminCalendar").attr("action", "/admin/calendar/" + val);
	document.getElementById('adminCalendar').submit();
}
$(document).ready(function() {
	var message = $("#message").val();
	if (message) {
		alert(message);
	}
});