<%--
  Created by IntelliJ IDEA.
  User: 86176
  Date: 2019/10/7
  Time: 23:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品展示</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
    //查询商品表信息
    <script>
        $(function() {
            queryList(1);
        })
        function queryList() {
            $.post(
                "${pageContext.request.contextPath}/commodity/queryCommodityList",
                {},
                function (data) {
                    $("#commodityListTable").html(data)
                }
            )
        }

    </script>
</head>
<body>
</body>
</html>
