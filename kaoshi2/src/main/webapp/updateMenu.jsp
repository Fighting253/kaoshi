<%-- JSP 页面 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String contextPath = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + contextPath + "/";
%>
<!DOCTYPE html>
<html lang="zh-cn">
<base href="<%=basePath%>">
<head>
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>更新菜单</title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
    <script>
        var flag = false;

        function checkCode(code) {
            // 把用户输入的编号发送到服务器，验证是否存在该编号
            $.get("${pageContext.request.contextPath}/checkCode?code=" + code, function (result) {
                if (result == "true") { // 说明可用
                    $("#codeIs").html("√").css("color", "green", "font-weight", "bold");
                    flag = true;
                } else {
                    // 不可用
                    $("#codeIs").html("编号已存在，请更换编号").css("color", "red");
                    flag = false;
                }
            }, "text");
        }

        function clearMessage() {
            $("#codeIs").html(""); // 清空
        }

        function checkData() {
            var code = $("input[name='code']").val();
            checkCode(code);
            return flag;
        }

        $(document).ready(function () {
            $("form").submit(function (e) {
                var isValid = checkData();
                if (!isValid) {
                    e.preventDefault();
                }
            });
        });
    </script>
</head>
<body>

<div class="panel admin-panel">
    <div style="text-align:center; background-color: #00BFFF;font-family: 'Arial', sans-serif; font-size: 24px; font-weight: bold;">
        <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span><h1>更新菜单</h1></strong></div>
        <div class="body-content">
            <form method="post" class="form-x" action="${pageContext.request.contextPath}/updateMenu">
                <div class="form-group">
                    <div class="label">
                        <label>编号：</label>
                    </div>
                    <div class="field">
                        <input type="hidden" name="dname" value="${menu.dname}">
                        <input type="text" class="input w50" value="${menu.code}" name="code" placeholder="请输入编号" data-validate="required:请输入编号" style="height: 40px; width: 190px;font-size: 18px;" onblur="checkCode(this.value)"/>
                        <span id="codeIs"></span>
                        <div class="tips"></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>菜名：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input w50" value="${menu.dname}" name="dname" placeholder="请输入菜名" data-validate="required:请输入菜名" style="height: 40px; width: 190px;font-size: 18px;"readonly/>
                        <div class="tips"></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>价格：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input w50" value="${menu.price}" name="price" placeholder="请输入价格" data-validate="required:请输入价格" style="height: 40px; width: 190px;font-size: 18px;" />
                        <div class="tips"></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>分类：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input w50" value="${menu.classification}" name="classification" placeholder="请输入分类" data-validate="required:请输入分类" style="height: 40px; width: 190px;font-size: 18px;" />
                        <div class="tips"></div>
                    </div>
                </div>
                <br>
                <div class="form-group">
                    <div class="label">
                        <label></label>
                    </div>
                    <div class="field">
                        <button class="button bg-main icon-check-square-o" type="submit" style="height: 40px; width: 80px;font-size: 18px;"> 提交&nbsp;&nbsp;&nbsp;&nbsp;</button>
                        <input class="button bg-main icon-check-square-o" type="reset" style="width: 80px;height: 40px" onclick="clearMessage()">
                    </div>
                </div>
            </form>
        </div>
    </div>

</body>
</html>
