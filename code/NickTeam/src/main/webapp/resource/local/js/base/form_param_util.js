/**
 * 将从表单中获取的序列化数据数据转化成JSON <br />
 * 例:id=1&name=2&type=3 ==> {'id':'1','name':'2','type':'3'}
 * 
 * @param serialize
 */
function serializeToJSON(serialize) {
	var json = {};
	if (!serialize) {
		return json;
	}
	var arr = serialize.split("&");
	for ( var i = 0; i < arr.length; i++) {
		var line = arr[i];
		if (!line) {
			continue;
		}
		var a = line.split("=");
		if (a[0] && a[1]) {
			json[a[0]] = decodeURI(a[1]);
		}
	}
	return json;
}