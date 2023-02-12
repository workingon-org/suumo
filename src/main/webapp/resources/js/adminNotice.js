function Checkform() {

    if( frm.title.value == "" ) {
    
        frm.title.focus();
        alert("Title을 입력해 주십시오.");
        
        return false;
        
    }
    if( frm.content.value == "") {
    
    frm.content.focus();
    alert("내용을 입력해 주십시오.");
    
    	return false;
    }
}

