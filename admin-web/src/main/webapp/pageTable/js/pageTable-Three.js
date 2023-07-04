layui.use(['table', 'dropdown','jquery'], function(){
  var table = layui.table;
  var dropdown = layui.dropdown;
  var $ = layui.jquery;
  // 创建渲染实例
  table.render({
    elem: '#test',
    url:'http://localhost:8080/service_api_war_exploded/user/getLimitConditionQuery.do', // 此处为静态模拟数据，实际使用时需换成真实接口
    toolbar: '#toolbarDemo',
    defaultToolbar: ['filter', 'exports', 'print', {
      title: '提示',
      layEvent: 'LAYTABLE_TIPS',
      icon: 'layui-icon-tips'
    }],
    height: 'full-100', // 最大高度减去其他容器已占有的高度差
    css: [ // 重设当前表格样式
      '.layui-table-tool-temp{padding-right: 145px;}'
    ].join(''),
    cellMinWidth: 120,
    page: true,
    parseData:function (res){
                console.log(res);
                return{
                    "code":200,
                    "msg":res.message,
                    "count":res.count,
                    "data":res.data
                }
            },
    response:{
        statusName:'code', //规定返回的状态码字段为code
        statusCode:200 //规定成功的状态码味200
     },
    cols: [[
      {type: 'checkbox', fixed: 'left'},
      {field:'userId', fixed: 'left', width:80, title: 'ID'},
      {field:'userName', width:80, title: '用户'},
      {field:'userEmail', width:80, title: '邮箱地址'},
      {field:'userPassword', width:80, title: '用户密码'},
      {field:'userNickname', width:80, title: '昵称'},
      {field:'userPhone', width:80, title: '手机号'},
      {field:'userIdCard', width:80, title: '身份证'},
      {field:'userState', width:80, title: '状态'},
      {field:'roleLevel', width:80, title: '角色'},
      {field:'userRenewTime', width:80, title: '更新时间'},
      {field:'steamId', width:80, title: 'steamID'},
      {field:'userNickname', width:80, title: 'steam秘钥'},
      {field:'userTime', width:80, title:'注册时间'},
      {fixed: 'right', title:'操作', width: 134, minWidth: 125, toolbar: '#barDemo'}
    ]],
    

    done: function(){
      var userId = this.id;
      // 下拉按钮测试
      dropdown.render({
        elem: '#dropdownButton', // 可绑定在任意元素中，此处以上述按钮为例
        data: [{
          userId: 'add',
          title: '添加',
        },{
          userId: 'update',
          title: '编辑'
        },{
          userId: 'delete',
          title: '注销',
        }],
      
        // 菜单被点击的事件
        click: function(obj){
          var checkStatus = table.checkStatus(userId)
          var data = checkStatus.data; // 获取选中的数据
          console.log(data )    
          switch(obj.userId){
            case 'add':
          var layerInsertInto = layer.open({
                title: '添加',
                type: 1,
                area: ['80%','80%'],
                content:$("#div_UserInfoOne")
              });
            break;
            case 'update':
              if(data.length !== 1) return layer.msg('请选择一行');
              layer.open({
                title: '编辑',
                type: 1,
                area: ['80%','80%'],
                content: `
                      <div class = "div_One_UpdateUserInfo">
                        <div style="float: left;margin-right: 60px;">
                          <table  style="height: 480px;">
                            <ul>
                              <tr>
                                    <td>
                                        <span class="layui-icon  layui-icon-note" style="font-size: 20px;">ID：</span>
                                    </td>
                                    <td>
                                        <input  type="text"  value = ${data[0].userId} id = "userInfoId"  disabled = "disabled" style="border:2px solid grey;border-radius: 5px;font-size: 25px;width: 300px;cursor: not-allowed;">
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="layui-icon  layui-icon-username" style="font-size: 20px;">用户：</span>
                                    </td>
                                    <td>
                                        <input  type="text" placeholder="请点击按钮自动生成账号"  value = ${data[0].userName} id = "userInfoName"  disabled = "disabled" style="border:2px solid grey;border-radius: 5px;font-size: 25px;width: 300px;cursor: not-allowed;">
                                    </td>
                                </tr>
                                <tr>
                                  <td>
                                      <span class="layui-icon layui-icon-email" style="font-size: 20px;">邮箱：</span>
                                  </td>
                                  <td>
                                      <input  type="text" value = ${data[0].userEmail} id = "userInfoEmail"  disabled = "disabled" style="border:2px solid grey;border-radius: 5px;font-size: 25px;width: 300px;cursor: not-allowed;">
                                  </td>
                              </tr>
                                <tr>
                                    <td>
                                        <span class = "layui-icon  layui-icon-password" style="font-size: 20px;">密码：</span>
                                    </td>
                                    <td>
                                        <input type="password" id = "userInfoPassword" value = ${data[0].userPassword}  style="  padding: 0.0rem 0.7rem;border:2px solid grey;border-radius: 5px;font-size: 25px;width: 300px;">
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class = "layui-icon  layui-icon-tree" style="font-size: 20px;">昵称：</span>
                                    </td>
                                    <td>
                                        <input type="text" id = "userInfoDikName" value = ${data[0].userNickname} disabled = "disabled" style="border:2px solid grey;border-radius: 5px;font-size: 25px;width: 300px;cursor: not-allowed;">
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class = "layui-icon  layui-icon-cellphone"  style="font-size: 20px;">号码：</span>
                                    </td>
                                    <td>
                                        <input type="text" id = "userInfoPhone" placeholder="138xxxxx" value = ${data[0].userPhone} style="padding: 0.0rem 0.7rem;border:2px solid grey;border-radius: 5px;font-size: 25px;width: 300px;">
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class = "layui-icon  layui-icon-moon"  style="font-size: 20px;">证件：</span>
                                    </td>
                                    <td>
                                        <input class = "layui-icon  layui-icon-eye-invisible" value = ${data[0].userIdCard}  type="text" id = "userInfoIdCard" placeholder="输入正确的证件号" style="padding: 0.0rem 0.7rem;border:2px solid grey;border-radius: 5px;font-size: 25px;width: 300px;">
                                    </td>
                                </tr>
                                <tr>
                                  <td>
                                      <span class = "layui-icon layui-icon-date"  style="font-size: 20px;">注册时：</span>
                                  </td>
                                  <td>
                                      <input class = "layui-icon  layui-icon-eye-invisible" disabled = "disabled" value = ${data[0].userTime}  type="text" id = "userInfoTime" placeholder="2023-xx-xx" style="padding: 0.0rem 0.7rem;border:2px solid grey;border-radius: 5px;font-size: 25px;width: 300px;cursor: not-allowed;">
                                  </td>
                              </tr>
                              <tr>
                                <td>
                                    <span class = "layui-icon layui-icon-edit"  style="font-size: 20px;">修改时：</span>
                                </td>
                                <td>
                                    <input class = "layui-icon  layui-icon-eye-invisible" disabled = "disabled" value = ${data[0].userRenewTime} type="text" id = "userInfoRenewTime" placeholder="2023-xx-xx" style="padding: 0.0rem 0.7rem;border:2px solid grey;border-radius: 5px;font-size: 25px;width: 300px;cursor: not-allowed;">
                                </td>
                            </tr>
                            </ul>
                          </table>
                        </div>
                        <div style="float: left;margin-right: 90px;">
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
                          <span class = "layui-icon layui-icon-ok-circle" style = "font-size:20px;">交易URL（默认NULL）</span>
                          <div class="layui-form" style = "margin-bottom:10px">
                                  <input type="checkbox" name="SSS" title="默认" lay-skin="tag" checked> 
                                  <input type="checkbox" name="TTT" title="封禁" lay-skin="tag" disabled>
                          </div>
                      </div>
                      <button onclick="" class="buttonUpdateUserInfo"><span style = "font-size:20px;">确认编辑</span></button>


                      <div>

                        <span class = "layui-icon layui-icon-ok-circle" style = "font-size:20px;">用户（默认普通用户）</span>
                        <div class="layui-form">
                          <input type="radio" name="QQQ" value="1" title="默认" checked>
                          <input type="radio" name="QQQ" value="2" title="高级">
                          <input type="radio" name="QQQ" value="3" title="超级">
                          <input type="radio" name="QQQ" value="4" title="禁用">
                        </div>

                      </div>
                      <div style="width: 500px;float: left;">
                        <fieldset style="border: 2px solid grey; margin-top: 30px;" class="layui-elem-field">
                          <legend>修改规则</legend>
                          <div class="layui-field-box">
                              <p>
                                  <h3>一、账号</h3>
                                  不可更改。<br>
                        
                                  <br> <h3>二、密码</h3>
                                  可更改。<br>
                        
                                  <br><h3>三、邮箱地址</h3>
                                  不可更改，由用户本人自己更改。<br>
                        
                        
                                  <br><h3>四、昵称、证件号、SteamID、Seam密钥、交易URL</h3>
                                  不可更改，由用户本人自己更改。<br>
                        
                                  
                                  <br> <h3>五、账号状态</h3>
                                  可更改。<br>
                              </p>
                          </div>
                        </fieldset>
                      </div>
                      <script src="layui/layui.js"></script>  
                    </div>
                `
              });
            break;
            case 'delete':
              if(data.length === 0){
                return layer.msg('请选择一行');
              }
              layer.msg('delete event');
            break;
          }

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

            })
              
          })

        }
      });
      // 重载测试
      dropdown.render({
        elem: '#reloadTest', // 可绑定在任意元素中，此处以上述按钮为例
        data: [{
          userId: 'reload',
          title: '重载'
        },{
          userId: 'reload-deep',
          title: '重载 - 参数叠加'
        },{
          userId: 'reloadData',
          title: '仅重载数据'
        },{
          userId: 'reloadData-deep',
          title: '仅重载数据 - 参数叠加'
        }],
        // 菜单被点击的事件
        click: function(obj){
          switch(obj.userId){
            case 'reload':
              // 重载 - 默认（参数重置）
              table.reload('test', {
                where: {
                  abc: '123456',
                  //test: '新的 test2',
                  //token: '新的 token2'
                },
                /*
                cols: [[ // 重置表头
                  {type: 'checkbox', fixed: 'left'},
                  {field:'id', title:'ID', width:80, fixed: 'left', unresize: true, sort: true, totalRowText: '合计：'},
                  {field:'sex', title:'性别', width:80, edit: 'text', sort: true},
                  {field:'experience', title:'积分', width:80, sort: true, totalRow: true, templet: '<div>{{= d.experience }} 分</div>'},
                  {field:'logins', title:'登入次数', width:100, sort: true, totalRow: true},
                  {field:'joinTime', title:'加入时间', width:120}
                ]]
                */
              });
            break;
            case 'reload-deep':
              // 重载 - 深度（参数叠加）
              table.reload('test', {
                where: {
                  abc: 123,
                  test: '新的 test1'
                },
                //defaultToolbar: ['print'], // 重载头部工具栏右侧图标
                //cols: ins1.config.cols
              }, true);
            break;
            case 'reloadData':
              // 数据重载 - 参数重置
              table.reloadData('test', {
                where: {
                  abc: '123456',
                  //test: '新的 test2',
                  //token: '新的 token2'
                },
                scrollPos: 'fixed',  // 保持滚动条位置不变 - v2.7.3 新增
                height: 2000, // 测试无效参数（即与数据无关的参数设置无效，此处以 height 设置无效为例）
                //url: '404',
                //page: {curr: 1, limit: 30} // 重新指向分页
              });
            break;
            case 'reloadData-deep':
              // 数据重载 - 参数叠加
              table.reloadData('test', {
                where: {
                  abc: 123,
                  test: '新的 test1'
                }
              }, true);
            break;
          }
          layer.msg('成功');
        }
      });
 
      // 行模式
      dropdown.render({
        elem: '#rowMode',
        data: [{
          userId: 'default-row',
          title: '单行模式（默认）'
        },{
          userId: 'multi-row',
          title: '多行模式'
        }],
        // 菜单被点击的事件
        click: function(obj){
          var checkStatus = table.checkStatus(userId)
          var data = checkStatus.data; // 获取选中的数据
          switch(obj.userId){
            case 'default-row':
              table.reload('test', {
                lineStyle: null // 恢复单行
              });
              layer.msg('已设为单行');
            break;
            case 'multi-row':
              table.reload('test', {
                // 设置行样式，此处以设置多行高度为例。若为单行，则没必要设置改参数 - 注：v2.7.0 新增
                lineStyle: 'height: 95px;' 
              });
              layer.msg('即通过设置 lineStyle 参数可开启多行');
            break;
          }
        }
      });
    },
    error: function(res, msg){
      console.log(res, msg)
    }
  });
  
  // 工具栏事件
  table.on('toolbar(test)', function(obj){
    var userId = obj.config.userId;
    var checkStatus = table.checkStatus(userId);
    var othis = lay(this);
    switch(obj.event){
      case 'LAYTABLE_TIPS':
        layer.alert('注意：注销账号需谨慎！');
      break;
    };
  });
  
  // 触发单元格工具事件
  table.on('tool(test)', function(obj){ // 双击 toolDouble
    var data = obj.data; // 获得当前行数据
    // console.log(obj)
    if(obj.event === 'edit'){
      layer.open({
        title: '编辑 - id:'+ data.userId,
        type: 1,
        area: ['80%','80%'],
        content: '<div style="padding: 16px;">自定义表单元素</div>'
      });
    } else if(obj.event === 'more'){
      // 更多 - 下拉菜单
      dropdown.render({
        elem: this, // 触发事件的 DOM 对象
        show: false, // 外部事件触发即显示
        data: [{
          title: '查看',
          userId: 'detail'
        },{
          title: '注销',
          userId: 'del'
        }],
        click: function(menudata){
          if(menudata.userId === 'detail'){
            layer.msg('查看操作，当前行 ID:'+ data.userId);
          } else if(menudata.userId === 'del'){
            layer.confirm('真的注销此账号么 [账号 '+ data.userName +'] 么', function(index){
              obj.del(); // 注销对应行（tr）的DOM结构
              layer.close(index);
              // 向服务端发送注销指令
            });
          } 
        },
        align: 'right', // 右对齐弹出
        style: 'box-shadow: 1px 1px 10px rgb(0 0 0 / 12%);' // 设置额外样式
      })
    }
  });
 
  // 触发表格复选框选择
  table.on('checkbox(test)', function(obj){
    console.log(obj)
  });
 
  // 触发表格单选框选择
  table.on('radio(test)', function(obj){
    console.log(obj)
  });
  
  // 行单击事件
  table.on('row(test)', function(obj){
    //console.log(obj);
    //layer.closeAll('tips');
  });
  // 行双击事件
  table.on('rowDouble(test)', function(obj){
    console.log(obj);
  });
 
  // 单元格编辑事件
  table.on('edit(test)', function(obj){
    var field = obj.field; // 得到字段
    var value = obj.value; // 得到修改后的值
    var data = obj.data; // 得到所在行所有键值
   
    // 编辑后续操作，如提交更新请求，以完成真实的数据更新
    // …
    layer.msg('编辑成功', {icon: 1});
    
    // 其他更新操作
    var update = {};
    update[field] = value;
    obj.update(update);
  });
});
