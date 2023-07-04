
function buttonUserInfoHtml(){
    location.href = "userInfo.html" ;
}

function buttonRoleInfoHtml(){
    location.href = "roleInfo.html" ;
}

function buttonPurViewInfoHtml(){
    location.href = "purviewInfo.html" ;
}


/***
 * 添加用户
 */
function buttonAddUserInfo(){
   layui.use(['table','dropdown','jquery'],function(){
        //调用 layui 封装的方法
        var table = layui.table ;
        var dropdown = layui.dropdown ;
        var $ = layui.jquery;
        var layerInsertInto = layer.open({
                title: '添加用户',
                type: 1,
                area: ['80%','80%'],
                content: $("#div_OneAdd")
              });
           $(document).ready(function() {
                // 通过id选择器获取按钮元素，并为其添加点击事件
              $("#buttonUserInfoName").click(function() {
                //生成11位随机数
                var randomNumber = Math.floor(Math.random() * 90000000000) + 10000000000;
                // 在点击时执行的代码
                $("#userInfoName").val(randomNumber);
              });

               $("#buttonSuccessAdd").click(function(){
                   
                if ($("#userInfoName").val() == '') {
                     layer.msg("用户不能为空，请点击随机按钮！")
                    return false;
               }
               if($("#userInfoPhone").val() == ''){
                    layer.msg("手机号不能为空")
                    return false;
               }

               let regularPhone = /^1[3456789]\d{9}$/;
               if(!regularPhone.test($("#userInfoPhone").val())){
                    layer.msg("输入正确的手机号！")
                    return false;
               }


               if($("#userInfoIdCard").val() == ''){
                    layer.msg("证件号不能为空")
                    return false;
               }
               let regularIdCard = /^[1-9]\d{16}[\dXx]$/;
               if(!regularIdCard.test($("#userInfoIdCard").val())){
                    layer.msg("输入正确的证件号！")
                    return false;
               }

                $.ajax({
                    url:'http://localhost:8080/service_api_war_exploded/user/getAddUser.do',
                    type:'post',
                    data:{
                        userName:$("#userInfoName").val(),
                        userEmail:'xxxxx',
                        userPassword:$("#userInfoPassword").val(),
                        userNickName:$("#userInfoDikName").val(),
                        userPhone:$("#userInfoPhone").val(),
                        userIdCard:$("#userInfoIdCard").val(),
                        userEmailCode:'824725',
                    },
                    success:function(res){
                        if(res.code != 200){
                            layer.msg("添加失败")
                            return false;
                        }else{
                            layer.msg("正在添加数据",{icon:16});
                           
                            setInterval(function(){
                                layer.close(layerInsertInto);
                            },3000)
                        }
                    }
                })
         });
      });
   })
};


/***
 * 添加角色
 */
function buttonADDRoleInfo(){
    layui.use(['table','dropdown'],function(){
         //调用 layui 封装的方法
         var table = layui.table ;
         var dropdown = layui.dropdown ;
        layer.open({
            title:'添加角色',
            type:1,
            area:['80%','80%'],
            content:'<div style = "padding:16px;">你好</div>'

        })

    })


};


/***
 * 添加权限
 */
function buttonADDPurviewInfo(){
    layui.use(['table','dropdown'],function(){
    //调用 layui 封装的方法
    var table = layui.table ;
    var dropdown = layui.dropdown ;

    layer.open({
        title:'添加权限',
        type:1,
        area:['80%','80%'],
        content:'<div style = "padding:16px;">你好</div>'
        
    })

    })
}