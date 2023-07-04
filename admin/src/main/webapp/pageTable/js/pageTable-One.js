
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
            layer.open({
                title: '添加用户',
                type: 1,
                area: ['80%','80%'],
                content: `
                     <div style="padding: 16px;">
                     <link rel="stylesheet" href="layui/css/layui.css">
                           <div class = "div_One_AddUserInfo">
                             <table  style="height: 340px;">
                                    <ul>
                                        <tr>
                                            <td>
                                                <span class="layui-icon  layui-icon-username" style="font-size: 20px;">用户</span>
                                            </td>
                                            <td>
                                                <input  type="text" placeholder="请点击按钮自动生成账号"   id = "userInfoName"  disabled = "disabled" style="border:2px solid grey;border-radius: 5px;font-size: 25px;width: 300px;cursor: not-allowed;">
                                                <button id = "buttonUserInfoName" class = "buttonUserInfoName"><span style = "font-size:20px;color:white">随机</span></button>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <span class = "layui-icon  layui-icon-password" style="font-size: 20px;">密码：</span>
                                            </td>
                                            <td>
                                                <input type="password" id = "userInfoPassword" value="123" disabled = "disabled" style="border:2px solid grey;border-radius: 5px;font-size: 25px;width: 300px;cursor: not-allowed;">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <span class = "layui-icon  layui-icon-tree" style="font-size: 20px;">昵称：</span>
                                            </td>
                                            <td>
                                                <input type="text" id = "userInfoDikName" value="小六" disabled = "disabled" style="border:2px solid grey;border-radius: 5px;font-size: 25px;width: 300px;cursor: not-allowed;">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <span class = "layui-icon  layui-icon-cellphone"  style="font-size: 20px;">号码：</span>
                                            </td>
                                            <td>
                                                <input type="text" id = "userInfoPhone" placeholder="138xxxxx" style="border:2px solid grey;border-radius: 5px;font-size: 25px;width: 300px;">
                                            </td>
                                        </tr>
                                         <tr>
                                            <td>
                                                <span class = "layui-icon  layui-icon-moon"  style="font-size: 20px;">证件：</span>
                                            </td>
                                            <td>
                                                <input class = "layui-icon  layui-icon-eye-invisible"  type="text" id = "userInfoIdCard" placeholder="输入正确的证件号" style="border:2px solid grey;border-radius: 5px;font-size: 25px;width: 300px;">
                                            </td>
                                        </tr>
                                    </ul>
                             </table>

                             <div class = "div_Two_UserInfo">
                                <fieldset class="layui-elem-field">
                                    <legend>注册规则</legend>
                                    <div class="layui-field-box">
                                        <p>
                                            一、违规处理<br>

                                            <br>1. 对于提供虚假信息、违反法律法规的用户，网站将采取封禁账号、删除信息等措施。
                                            <br> 2. 对于恶意攻击、破坏网站秩序的用户，网站将采取限制访问、法律追究等措施。
                                            <br>3. 用户如发现其他用户有违规行为，可向网站举报，网站将核实后进行处理。

                                            <br> <br> 二、附则

                                            <br> 1. 本规则将根据实际情况进行更新和调整，更新后的规则将在网站公布，请用户留意查阅。
                                            <br>2. 本规则最终解释权归网站所有。
                                            <br> 3. 如遇不可抗力因素导致无法正常运营，网站将尽力通知用户并协商解决方式。
                                        </p>
                                    </div>
                                </fieldset>
                             </div>
                           </div> 
                         
                           <div class = "div_Two_AddUserInfo">
                                <span class = "layui-icon layui-icon-ok-circle" style = "font-size:20px;">状态（默认启动）</span>
                                <div class="layui-form" style = "margin-bottom:10px">
                                        <input type="checkbox" name="AAA" title="默认" lay-skin="tag" checked> 
                                        <input type="checkbox" name="BBB" title="封禁" lay-skin="tag" disabled>
                                </div>
                                <span class = "layui-icon layui-icon-ok-circle" style = "font-size:20px;">SteamID（默认NULL）</span>
                                <div class="layui-form" style = "margin-bottom:10px">
                                        <input type="checkbox" name="CCC" title="默认" lay-skin="tag" checked> 
                                        <input type="checkbox" name="DDD" title="封禁" lay-skin="tag" disabled>
                                </div>
                                <span class = "layui-icon layui-icon-ok-circle" style = "font-size:20px;">Steam秘钥（默认NULL）</span>
                                <div class="layui-form" style = "margin-bottom:10px">
                                        <input type="checkbox" name="EEE" title="默认" lay-skin="tag" checked> 
                                        <input type="checkbox" name="FFF" title="封禁" lay-skin="tag" disabled>
                                </div>
                                <span class = "layui-icon layui-icon-ok-circle" style = "font-size:20px;">用户（默认普通用户）</span>
                                <div class="layui-form">
                                        <input type="checkbox" name="GGG" title="默认" lay-skin="tag" checked> 
                                        <input type="checkbox" name="HHHH" title="封禁" lay-skin="tag" disabled>
                                </div>
                                <button class = "buttonAdd"><span style = "font-size:20px">用户添加</span></button>
                           </div>
                           <script src="layui/layui.js"></script>
                     </div>
                `
              });
           $(document).ready(function() {
                // 通过id选择器获取按钮元素，并为其添加点击事件
              $("#buttonUserInfoName").click(function() {
              //生成11位随机数
              var randomNumber = Math.floor(Math.random() * 90000000000) + 10000000000;
             // 在点击时执行的代码
             $("#userInfoName").val(randomNumber);
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