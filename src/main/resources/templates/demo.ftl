<#assign ctx=request.contextPath>
<html>
<head>
    <meta charset="utf-8">
    <title>LayIM测试</title>
    <link rel="stylesheet" href="${ctx}/static/layui/css/layui.css" media="all">
</head>
<body>
<script src="${ctx}/static/layui/layui.js"></script>
<script>
    // layui.use('layim', function (layim) {
    //     //先来个客服模式压压精
    //     layim.config({
    //         brief: true //是否简约模式（如果true则不显示主面板）
    //     }).chat({
    //         name: '客服姐姐'
    //         , type: 'friend'
    //         , avatar: 'http://tp1.sinaimg.cn/5619439268/180/40030060651/1'
    //         , id: -2
    //     });
    // });

    layui.use('layim', function (layim) {
        //基础配置
        layim.config({
            title: "主面板最小化后显示的名称",
            isAudio: false,
            isVideo: true,
            isgroup: true,
            // 是否授权
            copyright: true,
            notice: true,
            skin: [],
            //关闭声音
            voice: false,
            initSkin: '5.jpg',
            //获取主面板列表信息
            init: {
                url: '${ctx}/mine'
                , data: {}
            }

            //获取群员接口（返回的数据格式见下文）
            , members: {
                url: '${ctx}/getMembers' //接口地址（返回的数据格式见下文）
                , type: 'get' //默认get，一般可不填
                , data: {} //额外参数
            }

            //上传图片接口（返回的数据格式见下文），若不开启图片上传，剔除该项即可
            , uploadImage: {
                url: '' //接口地址
                , type: 'post' //默认post
            }

            //上传文件接口（返回的数据格式见下文），若不开启文件上传，剔除该项即可
            , uploadFile: {
                url: '' //接口地址
                , type: 'post' //默认post
            }
            //扩展工具栏，下文会做进一步介绍（如果无需扩展，剔除该项即可）
            , tool: [{
                alias: 'code' //工具别名
                , title: '代码' //工具名称
                , icon: '&#xe64e;' //工具图标，参考图标文档
            }]

            , msgbox: layui.cache.dir + 'css/modules/layim/html/msgbox.html' //消息盒子页面地址，若不开启，剔除该项即可
            , find: layui.cache.dir + 'css/modules/layim/html/find.html' //发现页面地址，若不开启，剔除该项即可
            , chatLog: layui.cache.dir + 'css/modules/layim/html/chatlog.html' //聊天记录页面地址，若不开启，剔除该项即可
        });

        //监听自定义工具栏点击，以添加代码为例
        layim.on('tool(code)', function (insert, send, obj) { //事件中的tool为固定字符，而code则为过滤器，对应的是工具别名（alias）
            layer.prompt({
                title: '插入代码'
                , formType: 2
                , shade: 0
            }, function (text, index) {
                layer.close(index);
                insert('[pre class=layui-code]' + text + '[/pre]'); //将内容插入到编辑器，主要由insert完成
                //send(); //自动发送
            });
            console.log(this); //获取当前工具的DOM对象
            console.log(obj); //获得当前会话窗口的DOM对象、基础信息
        });

        //监听在线状态的切换事件
        layim.on('online', function (data) {
            console.log(data);
        });

        //监听签名修改
        layim.on('sign', function (value) {
            console.log(value);
        });
        //监听layim建立就绪
        layim.on('ready', function (res) {
            //console.log(res.mine);
            layim.msgbox(5); //模拟消息盒子有新消息，实际使用时，一般是动态获得


            //添加好友（如果检测到该socket）
            layim.addList({
                type: 'group'
                , avatar: "http://tva3.sinaimg.cn/crop.64.106.361.361.50/7181dbb3jw8evfbtem8edj20ci0dpq3a.jpg"
                , groupname: 'Angular开发222'
                , id: "12333333"
                , members: 0
            });
            layim.addList({
                type: 'friend'
                , avatar: "http://tp2.sinaimg.cn/2386568184/180/40050524279/0"
                , username: '冲田杏梨2222'
                , groupid: 2
                , id: "1233333312121212"
                , remark: "本人冲田杏梨将结束AV女优的工作"
            });

            //收到消息
            layim.getMessage({
                username: "Hi"
                , avatar: "http://qzapp.qlogo.cn/qzapp/100280987/56ADC83E78CEC046F8DF2C5D0DD63CDE/100"
                , id: "10000111"
                , type: "friend"
                , content: "临时消息：" + new Date().getTime()
            });

            // layim.getMessage({
            //     groupname: "群消息"
            //     , avatar: "http://qzapp.qlogo.cn/qzapp/100280987/56ADC83E78CEC046F8DF2C5D0DD63CDE/100"
            //     , id: "10001230111"
            //     , type: "group"
            //     , content: "临时消息：" + new Date().getTime()
            // });
        });


        //监听发送消息
        layim.on('sendMessage', function (data) {
            console.log(data);
            var To = data.to;
            console.log(To);

            if (To.type === 'friend') {
                layim.setChatStatus('<span style="color:#FF5722;">对方正在输入。。。</span>');
            }

            //演示自动回复
            setTimeout(function () {
                var obj = {};
                if (To.type === 'group') {
                    obj = {
                        username: '模拟群员' + (Math.random() * 100 | 0)
                        , avatar: layui.cache.dir + 'images/face/' + (Math.random() * 72 | 0) + '.gif'
                        , id: To.id
                        , type: To.type
                        , content: "这里是消息"
                    }
                } else {
                    obj = {
                        username: To.name
                        , avatar: To.avatar
                        , id: To.id
                        , type: To.type
                        , content: "这里是消息"
                    }
                    layim.setChatStatus('<span style="color:#FF5722;">在线</span>');
                }
                layim.getMessage(obj);
            }, 1000);
        });

        //聊天窗口切换
        layim.on('chatChange', function(res){
            var type = res.data.type;
            console.log(res.data.id)
            if(type === 'friend'){
                //模拟标注好友状态
                layim.setChatStatus('<span style="color:#FF5722;">在线</span>');
            } else if(type === 'group'){
                //模拟系统消息
                layim.getMessage({
                    system: true
                    ,id: res.data.id
                    ,type: "group"
                    ,content: '模拟群员'+(Math.random()*100|0) + '加入群聊'
                });
            }
        });


        // layim.chat({
        //     name: '张三' //名称
        //     , type: 'friend' //聊天类型
        //     , avatar: 'http://tp1.sinaimg.cn/5619439268/180/40030060651/1' //头像
        //     , id: 11111 //好友id
        // })

        // layim.chat({
        //     name: 'LayIM畅聊'
        //     ,type: 'group' //群组类型
        //     ,avatar: 'http://tp2.sinaimg.cn/5488749285/50/5719808192/1'
        //     ,id: 10000000 //定义唯一的id方便你处理信息
        //     ,members: 123 //成员数，不好获取的话，可以设置为0
        // });

        //添加好友
        // layim.add({
        //     type: 'friend' //friend：申请加好友、group：申请加群
        //     ,username: 'xxx' //好友昵称，若申请加群，参数为：groupname
        //     ,avatar: 'http://tp2.sinaimg.cn/5488749285/50/5719808192/1' //头像
        //     ,submit: function(group, remark, index){ //一般在此执行Ajax和WS，以通知对方
        //         console.log(group); //获取选择的好友分组ID，若为添加群，则不返回值
        //         console.log(remark); //获取附加信息
        //         layer.close(index); //关闭改面板
        //     }
        // });


        //接受还有好友申请
        // layim.setFriendGroup({
        //     type: 'friend'
        //     , username: 'xxx' //好友昵称，若申请加群，参数为：groupname
        //     , avatar: 'http://tp2.sinaimg.cn/5488749285/50/5719808192/1' //头像
        //     , group: layim.cache().friend //获取好友列表数据
        //     , submit: function (group, index) {
        //         //一般在此执行Ajax和WS，以通知对方已经同意申请
        //         //……
        //         //同意后，将好友追加到主面板
        //         layim.addList(data); //见下文
        //     }
        // });

        console.log(layim.cache())


    });


</script>
</body>
</html>