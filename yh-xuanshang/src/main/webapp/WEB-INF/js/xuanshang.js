$("#leibie").mouseover(function () {
    $("#leibieUl").slideDown();
})
// $("#leibie").mouseout(function () {
//     if ($("#leibieUl").mouseover()) {
//         $("#leibieUl").slideDown();
//     } else if ($("#leibieUl").mouseout()) {
//         $("#leibieUl").slideUp();
//     }    
// })
$("#leibieUl").mouseout(function () {
    $("#leibieUl").slideUp();
})


		$(function(){
             $("#page").Page({
                totalPages: 9,//分页总数
                liNums: 7,//分页的数字按钮数(建议取奇数)
                activeClass: 'activP', //active 类样式定义
                callBack : function(page){
                    //console.log(page)
                   
                        // $('.fenye').children().length/6
                   console.log((page*6-1),((page-1)*6));
                //    for (var i = 0; i < 20; i++) {
                //        console.log($(".fenye").append("<li></li>"));
                //    } 

                }
            });
		})