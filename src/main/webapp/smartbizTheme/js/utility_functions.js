function getCommaSeperatedListOfAttr (list, attrName){
	var result = {list:[], str:""};
	var cnt = list.length;
	for (i=0; i<cnt-1; i++){
		result.str += $(list[i]).attr(attrName) +", ";
		result.list.push($(list[i]).val());
	}
	result.str = result.str.slice((result.str.length)*-1,(result.str.length-2));
	result.str += (cnt>1?" and ":"")+$(list[cnt-1]).attr(attrName);
	result.list.push($(list[cnt-1]).val());
	
	return result;
}