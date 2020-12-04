var xmlHttp;

//����XMLHttpRequest
function createXmlHttpRequest(){
	try {
		xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
	} catch (e) {
		try {
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		} catch (e) {
			try {
				xmlHttp = new XMLHttpRequest();
				if (xmlHttp.overrideMimeType) {
					xmlHttp.overrideMimeType("text/xml");
				}
			} catch (e) {
			}
		}
	}
}

//������
function doAjax(url){
	//1.����XMLHttpRequest����
	createXmlHttpRequest();

	//var username = document.loginForm.username.value;
	//var password = document.loginForm.password.value;

	if(xmlHttp!=null){
		//var url ="chap12/AjaxLoginServlet?username="+username+"&password="+password;

		//2.��������������Ӵ���
		xmlHttp.open("get",url,false);
		//��Ϊ��POST��ʽ�ύ����Ҫ��������ͷ����Ϣ
		//xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded;");

		//3.���ûص�����
		xmlHttp.onreadystatechange=processRequest;

		//4.��������
		xmlHttp.send(null);
	}else{
		alert("���ܴ���XMLHttpRequest����ʵ��")
	}
}

//ȥ���ı��������˵Ŀո�
String.prototype.trim=function(){
	var m=this.match(/^\s*(\S+(\s+\S+)*)\s*$/);
	return (m==null)?"":m[1];
}

