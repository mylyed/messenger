<#assign ctx=request.contextPath>
<html>
<head>
    <meta charset="utf-8">
    <title>Messenger</title>
    <link rel="stylesheet" href="${ctx}/static/layui/css/layui.css" media="all">
</head>
<body>
<script src="${ctx}/static/layui/layui.js"></script>
<script src="${ctx}/static/layui/layui.js"></script>
<script src="${ctx}/static/socket.io/socket.io.js"></script>
<button>aaa</button>

<script>

    var userid = "${userid}";

    layui.use('layim', function (layim) {
        //基础配置
        layim.config({
            title: "Messenger",
            isAudio: false,
            isVideo: true,
            isgroup: true,
            // 是否授权
            copyright: true,
            notice: true,
            skin: [],
            //用于设定主面板是否在页面打开时，始终最小化展现
            min: false,
            //关闭声音
            voice: false,
            initSkin: '5.jpg',
            //获取主面板列表信息
            init: {
                url: '${ctx}/userInfo'
                , data: {"userid": userid}
            }

            //获取群员接口（返回的数据格式见下文）
            , members: {
                url: '${ctx}/groupInfo' //接口地址（返回的数据格式见下文）
                , type: 'get' //默认get，一般可不填
                , data: {} //额外参数
            }

            // //上传图片接口（返回的数据格式见下文），若不开启图片上传，剔除该项即可
            // , uploadImage: {
            //     url: '' //接口地址
            //     , type: 'post' //默认post
            // }
            //
            // //上传文件接口（返回的数据格式见下文），若不开启文件上传，剔除该项即可
            // , uploadFile: {
            //     url: '' //接口地址
            //     , type: 'post' //默认post
            // }


            //扩展工具栏，下文会做进一步介绍（如果无需扩展，剔除该项即可）
            , tool: [{
                alias: 'code' //工具别名
                , title: '代码' //工具名称
                , icon: '&#xe64e;' //工具图标，参考图标文档
            }]
            //
            // , msgbox: layui.cache.dir + 'css/modules/layim/html/msgbox.html' //消息盒子页面地址，若不开启，剔除该项即可
            // , find: layui.cache.dir + 'css/modules/layim/html/find.html' //发现页面地址，若不开启，剔除该项即可
            // , chatLog: layui.cache.dir + 'css/modules/layim/html/chatlog.html' //聊天记录页面地址，若不开启，剔除该项即可
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
            //初始化socket
        });

        var socket = io.connect('http://192.168.56.1:9092?userid=' + userid);

        socket.on('connect', function () {
            console.log("连接上了服务器")
        });

        socket.on('connect_failed', function (data) {
            console.log(data)
            console.log("连接失败")
        });

        socket.on('chatevent', function (data) {
            //接收到了消息
            console.log(data)
            layim.getMessage(data);

        });

        socket.on('disconnect', function () {
            console.log("断开了服务器")
        });


        //监听发送消息
        layim.on('sendMessage', function (data) {
            console.log(data);
            //websocket发送消息
            socket.emit('chatevent', data);
        });

        layim.on('chatChange', function (res) {
            console.log(res);
        });

    });


</script>
</body>
</html>