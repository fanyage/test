<%--
  Created by IntelliJ IDEA.
  User: 86176
  Date: 2019/10/6
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品添加</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
    <link href="<%=request.getContextPath()%>/js/fileinput5/css/fileinput.min.css" media="all" rel="stylesheet" type="text/css" />
    <link href="<%=request.getContextPath()%>/js/bootstrap3/css/bootstrap.css" media="all" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/js/bootstrap-datetimepicker/datetimepicker/bootstrap-datetimepicker.css" rel="stylesheet"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/fileinput5/js/fileinput.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootbox/bootbox.all.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap3/js/bootstrap.min.js"></script>
    <script>
        function insertCommodity(){
            var name=$("[name='name']").val();//商品名称
            var price=$("[name='price']").val();//商品价格
            var photo=$("[name='photo']").val();//商品图片路径
            var sum=$("[name='sum']").val();//商品库存
            var putaway=$("[name='putaway']:checked").val();//商品是否上架
            var category=$("[name='category']").val();//商品分类
            var shopnameid=$("[name='shopnameid']").val();//商品对应商店
            if (name!=""){
                    if (price!="") {
                        if (sum!=""){
                            if (putaway!=""){
                                if (category!=""){
                                    if(shopnameid!=""){
                                        $.post(
                                            "${pageContext.request.contextPath}/commodity/insertCommodity",
                                            {
                                                "name":name,
                                                "price":price,
                                                "photo":photo,
                                                "sum":sum,
                                                "putaway":putaway,
                                                "category":category,
                                                "shopnameid":shopnameid
                                            },
                                            function(data){

                                            }
                                        )
                                    }else {
                                        alert("商店为必填")
                                    }
                                }else {
                                    alert("分类为必填")
                                }
                            }else {
                                alert("上下架为必填")
                            }
                        }else{
                            alert("商品库存不可为空")
                        }
                    }else{
                        alert("商品价格不可为空")
                    }
            }else{
                alert("商品名称不可为空")
            }
        }
    </script>
</head>
    <center>
        <form  >
            商品名称:<input type="text" name="name"><br>
            商品价格:<input type="text" name="price"> <br>
            商品图片:<input type="file" id="file" onchange="uplaodFilee()"><br>
            <input type="text" name="photo" id="upload">
            <div id="img"></div>
            商品库存:<input type="text" name="sum"><br>
            商品分类:<select name="category">
                    </select><br>
            商店<select name="shopnameid">
                </select><br>
            是否上架:<input type="radio" name="putaway" value="上架">上架
                     <input type="radio" name="putaway" value="下架">下架<br>
                <input type="button" onclick="insertCommodity()" value="添加商品">
                <input type="reset" value="重置">
        </form>
    </center>
</body>
<script>
    function uplaodFilee(){
        var form = new FormData();
        form.append("file",$("#file").get(0).files[0]);
        $.ajax({
            contentType:false,
            processData:false,
            url:"<%=request.getContextPath()%>/commodity/uploadFile",
            data:form,
            dataType:"json",
            type:"post",
            success:function(res){
                var aa = res.aaa
                var fileName=res.fileName;
                $("#upload").val(aa);
                $("#img").append("<img  src='<%=request.getContextPath()%>/"+aa+"' width='100' > ")
            },
            error:function(){
                alert("程序出现问题");
            }

        })

    }
</script>
<script type="text/javascript">
    $(function(){
        $("#file").fileinput({
            language: 'zh', //设置语言
            uploadUrl:"http://127.0.0.1/testDemo/fileupload/upload.do", //上传的地址
            allowedFileExtensions: ['jpg', 'gif', 'png'],//接收的文件后缀
            //uploadExtraData:{"id": 1, "fileName":'123.mp3'},
            uploadAsync: true, //默认异步上传
            showUpload:true, //是否显示上传按钮
            showRemove :true, //显示移除按钮
            showPreview :true, //是否显示预览
            showCaption:false,//是否显示标题
            browseClass:"btn btn-primary", //按钮样式
            dropZoneEnabled: false,//是否显示拖拽区域
            //minImageWidth: 50, //图片的最小宽度
            //minImageHeight: 50,//图片的最小高度
            //maxImageWidth: 1000,//图片的最大宽度
            //maxImageHeight: 1000,//图片的最大高度
            //maxFileSize:0,//单位为kb，如果为0表示不限制文件大小
            //minFileCount: 0,
            maxFileCount:10, //表示允许同时上传的最大文件个数
            enctype:'multipart/form-data',
            validateInitialCount:true,
            previewFileIcon: "<iclass='glyphicon glyphicon-king'></i>",
            msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
        }).on("fileuploaded", function (event, data, previewId, index){
        });
    })
</script>
</html>
