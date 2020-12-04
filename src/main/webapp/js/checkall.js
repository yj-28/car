function checkall(all){

	var ids=document.getElementsByName("id");
	

	for(var i=0;i<ids.length;i++){
		ids[i].checked=all.checked;
	}
}