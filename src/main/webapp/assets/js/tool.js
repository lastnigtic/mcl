

// 修改日期
$('.J-Date').each(function(idx, item){
	item = $(item);
	if(item.text()){
        item.text(filterDate(item.text()));
	}
})
function filterDate(str){
	var date = new Date(str),
	year = date.getFullYear(),
	month = date.getMonth() + 1,
	day = date.getDate();
	return year + '-' + _fix(month) + '-' + _fix(day)
}
function _fix(n) {
	if (n < 10) {
		return '0' + n
	}
	return n
}

// checkbox选中
$('.J-tag').each(function(){
	var tagBox = $(this);
    var value = tagBox.data('value');
	tagBox.children().each(function(idx,item){
		item = $(item);
        if(value.indexOf(item.text().trim()) > 0){
            item.find('input')[0].checked = true;
        }
	})
})