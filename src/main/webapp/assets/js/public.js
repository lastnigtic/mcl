/**
 * Created by Administrator on 2018/1/20 0020.
 */
function _fix(n) {
    if (n < 10) {
        return '0' + n
    }
    return n
}
// 获取日期
function filterDate(str){
    let date = new Date(str),
        year = date.getFullYear(),
        month = date.getMonth() + 1,
        day = date.getDay();
    return year + '-' + _fix(month) + '-' + _fix(day)
}

function GetQueryString(name)
{
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r!=null)return  unescape(r[2]); return null;
}