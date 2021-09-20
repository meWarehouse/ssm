<%--
  Created by IntelliJ IDEA.
  User: wen
  Date: 2020/6/1
  Time: 0:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<jsp:include page="/emp/bootstrapMag"></jsp:include>--%>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="${PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
    <script type="text/javascript" src="${PATH}/static/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="${PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>


</head>
<body>

<!-- 员工添加的模态框 -->
<div class="modal fade" id="empAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">

            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">员工添加</h4>
            </div>

            <div class="modal-body">

                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">empName</label>
                        <div class="col-sm-10">
                            <input type="text" name="empName" class="form-control" id="empName_add_input" placeholder="empName">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">email</label>
                        <div class="col-sm-10">
                            <input type="text" name="email" class="form-control" id="email_add_input" placeholder="email@atguigu.com">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">gender</label>
                        <div class="col-sm-10">
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="gender1_add_input" value="M" checked="checked"> 男
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="gender2_add_input" value="W"> 女
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">deptName</label>
                        <div class="col-sm-4">
                            <!-- 部门提交部门id即可 -->
                            <select class="form-control" name="dId">
                            </select>
                        </div>
                    </div>
                </form>

            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="emp_save_btn">保存</button>
            </div>

        </div>
    </div>
</div>

<div class="container">
    <!-- 标题 -->
    <div class="row">
        <div class="col-md-12">
            <h1>SSM-CRUD</h1>
        </div>
    </div>

    <!-- 按钮 -->
    <div class="row">
        <div class="col-md-4 col-md-offset-8">
            <button class="btn btn-primary" id="emp_add_modal_btn">新增</button>
            <button class="btn btn-danger" id="emp_delete_all_btn">删除</button>
        </div>
    </div>

    <!-- 显示表格数据 -->
    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover" id="emps_table">
                <thead>
                <tr>
<%--                    <th>--%>
<%--                        <input type="checkbox" id="check_all"/>--%>
<%--                    </th>--%>
                    <th>#</th>
                    <th>empName</th>
                    <th>gender</th>
                    <th>email</th>
                    <th>deptName</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>

                </tbody>
            </table>
        </div>
    </div>

    <!-- 显示分页信息 -->
    <div class="row">
        <!--分页文字信息  -->
        <div class="col-md-6" id="page_info_area"></div>
        <!-- 分页条信息 -->
        <div class="col-md-6" id="page_nav_area"></div>

    </div>

</div>

<script type="text/javascript">

    var recordnumber;

    $(function () {
       to_page(1);
    });

    function to_page(pn) {
        $.ajax({
            url:"${PATH}/emp/bootstrapMag?pn="+pn,

            type:"GET",
            success:function (result) {
                // console.log(result);
                main_table_data(result);
                page_info_area(result);
                page_nav_area(result);
            }

        });
    }

    /* 显示 employees 数据 */
    function main_table_data(result) {

        $("#emps_table tbody").empty();

       var emps_date = result.extend.pageInfo.list;

      $.each(emps_date,function (index,item) {

          var $tr = $("<tr></tr>");

          var $empId = $("<td></td>").append(item.empId);
          var $empName = $("<td></td>").append(item.empName);
          var $gender = $("<td></td>").append(item.gender == 'M' ? "男":"女");
          var $email = $("<td></td>").append(item.email);
          var $deptName = $("<td></td>").append(item.department.deptName);

          var $edit_btn = $("<button></button>").addClass("btn btn-primary btn-sm edit_btn").append("<a></a>").append("编辑");
          var $del_btn = $("<button></button>").addClass("btn btn-danger btn-sm delete_btn").append("<a></a>").append("删除");

          var $td = $("<td></td>").append($edit_btn).append(" ").append($del_btn);

          $tr.append($empId).append($empName).append($gender).append($email).append($deptName).append($td).appendTo("#emps_table tbody");

      })

    }

    //显示分页信息
    function page_info_area(result) {

        $("#page_info_area").empty();

        $("#page_info_area").append("当前"+result.extend.pageInfo.pageNum+"页，总"+result.extend.pageInfo.pages+"页，总"+result.extend.pageInfo.total+"条记录");

        recordnumber = result.extend.pageInfo.total;

    }

    //分页栏
    function page_nav_area(result) {

        $("#page_nav_area").empty();

        var $nav = $("<nav></nav>").attr("aria-label","Page navigation");
        var $ul = $("<ul></ul>").addClass("pagination");

        //首页
        var $first_page = $("<li></li>").append($("<a></a>").attr("href","#").append("首页"));
        //上一页
        var $pre_page = $("<li></li>").append($("<a></a>").attr("href","#").append("&laquo;"));

        if(result.extend.pageInfo.isFirstPage){
            $first_page.addClass("disabled");
            $pre_page.addClass("disabled")
        }else{
            $first_page.click(function () {
                to_page(1);
            });

            $pre_page.click(function () {
                to_page(result.extend.pageInfo.pageNum-1);
            });
        }

        $ul.append($first_page).append($pre_page);

        //连续显示的页
        $.each(result.extend.pageInfo.navigatepageNums,function (index,item) {
            var $li = $("<li></li>").append($("<a></a>").append(item));

            if(result.extend.pageInfo.pageNum == item){
                $li.addClass("active");
            }

            $li.click(function () {
                to_page(item);
            });

            $ul.append($li);
        });
        //下一页
        var $next_page = $("<li></li>").append($("<a></a>").attr("href","#").append("&raquo;"));
        //末页
        var $last_page = $("<li></li>").append($("<a></a>").attr("href","#").append("末页"));


        if(result.extend.pageInfo.isLastPage){
            $next_page.addClass("disabled");
            $last_page.addClass("disabled");
        }else {
            $next_page.click(function () {
                to_page(result.extend.pageInfo.pageNum+1);
            });

            $last_page.click(function () {
                to_page(result.extend.pageInfo.pages);
            });
        }

        $ul.append($next_page).append($last_page)

        //每页显示的记录数 跳转
        /*
            <li>
                <a></a>
                <input></input>
            </li>
            跳转到【】  每页显示的记录数【】
         */

        var $leap_input = $("<input />").attr("size","1").attr("placeholder","页码").append("页");
        $leap_input.change(function () {
            alert($(this).val())

            //校验是否数字 是否合法
            var reg = /^[0-9]+$/;
            var flag = false;
            if(reg.test($(this).val())){
                if($(this).val() > 0 && $(this).val() <= result.extend.pageInfo.pages){
                    flag = true;
                }
            }

            if(flag){
                to_page($(this).val());
            }else{
                alert("输入页码错误");
                $(this).val("");
            }
        });

        var $leap_li = $("<li></li>").append($("<a></a>").append("跳转到")).append($leap_input);

        $ul.append($leap_li).appendTo($nav);


        $("#page_nav_area").append($nav);


    }

    //查询部门
    function find_dept(ele){
        $(ele).empty();
        $.ajax({
            url:"${PATH}/dept/getdept",
            type: "GET",
            success:function (result) {
                // console.log(result);
                $.each(result.extend.depts,function () {
                    //<option>1</option>
                    $("<option></option>").append(this.deptName).attr("value",this.deptId).appendTo(ele);

                });


            }
        });
    }

    //重置模态框
    function reset_form(ele){
        $(ele)[0].reset();
        $(ele).find("*").removeClass("has-error has-success");
        $(ele).find(".help-block").text("");
    }

    // emp_add_modal_btn  弹出模态框
    $("#emp_add_modal_btn").click(function () {
        reset_form("#empAddModal form");
        //弹出模态框前先查出部门信息
        find_dept("#empAddModal select");


        $('#empAddModal').modal({
            backdrop:"static"
        })
    });

    //前端 jquery 校验用户名 校验邮箱
    function validate_add_form(){

        var empName = $("#empName_add_input").val();
        var regName = /(^[a-zA-Z0-9_-]{5,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
        if(!regName.test(empName)){
            // alert("用户名必须是数字字母组合5-16位或2-5位汉字");
            // $("#empName_add_input").parent().addClass("has-error")
            // $("#empName_add_input").next("span").text("用户名必须是数字字母组合5-16位或2-5位汉字");
            show_validate_msg("#empName_add_input","error","用户名必须是数字字母组合5-16位或2-5位汉字");
            return false;

        }else{
            // $("#empName_add_input").parent().addClass("has-success")
            // $("#empName_add_input").next("span").text("");
            show_validate_msg("#empName_add_input","success","");
        }

        var email = $("#email_add_input").val();
        var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
        if(!regEmail.test(email)){
            // alert("邮箱格式错误");
            // $("#email_add_input").parent().addClass("has-error")
            // $("#email_add_input").next("span").text("邮箱格式错误");
            show_validate_msg("#email_add_input","error","邮箱格式错误");
            return false;

        }else {
            // $("#email_add_input").parent().addClass("has-success")
            // $("#email_add_input").next("span").text("");
            show_validate_msg("#email_add_input","success","");
        }

        return true;

    }

    //校验方法抽取 show_validate_msg
    function show_validate_msg(ele,status,msg){
        $(ele).parent().removeClass("has-error has-success");
        $(ele).next("span").text("");

        if("success" == status){
            $(ele).parent().addClass("has-success");
            $(ele).next("span").text(msg);
        }else if("error" == status){
            $(ele).parent().addClass("has-error");
            $(ele).next("span").text(msg);
        }

    }

    //后端 emp 重复性校验
    $("#empName_add_input").change(function () {

        $.ajax({
            url:"${PATH}/emp/check?empName="+$(this).val(),
            type:"POST",
            success:function (result) {
                if(result.code ==100 ){
                    show_validate_msg("#empName_add_input","success",result.msg);
                    $("#emp_save_btn").attr("ajax-va","success");
                }else{
                    show_validate_msg("#empName_add_input","error",result.extend.msg);
                    $("#emp_save_btn").attr("ajax-va","error");
                }
            }
        });

    });


    //保存信息 emp_save_btn
    $("#emp_save_btn").click(function () {

        // alert($("#empAddModal form").serialize());
        //校验
        if(!validate_add_form()){
            return false;
        }

        if($(this).attr("ajax-va") == "error"){
            return false;
        }

        $.ajax({
            url:"${PATH}/emp/saveemp",
            data:$("#empAddModal form").serialize(),
            type:"GET",
            success:function (result) {
                // alert(result.msg);
                $("#empAddModal").modal('hide');
                to_page(recordnumber);

            }
        });
    });


</script>



</body>
</html>
