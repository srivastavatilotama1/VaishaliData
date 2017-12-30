var msg;
msg="<p><code>The actual script is in external script filecalled &quotvar.js&quot</code></p>";
function add_nos(headVar,bodyVar)
{
	document.write(msg+"<br>");
	var res=headVar+bodyVar;
	return res;
}