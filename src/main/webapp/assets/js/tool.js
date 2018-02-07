
// 修改日期
$('.J-Date').each(function(idx, item){
	item = $(item);
	if(item.text()){
        item.text(filterDate(item.text()));
	}else if(item.val()){
        item.val(filterDate(item.val()));
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
//限制长度
$('.J-len').each(function(idx, item){
	item = $(item);
	if(item.text().length > 26){
		item.text(item.text().substring(0, 25)+'...')
	}
})
//限制正数
$('.J-positiveNum').on('blur',function(e){
	var tar = $(e.target);
	if(tar.val() < 0){
		tar.val(0)
	}
})

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