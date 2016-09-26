<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Welcome</title>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>


    <![endif]-->

    <jsp:include page="incl_lib/incl_js_css.jsp"/>
<%--    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/lightslider.css">--%>
    <link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/lightslider/1.1.5/css/lightslider.css">

</head>
<body>


<div class="container">
    <div class="row">
        <jsp:include page="incl_head/header.jsp"/>

        <div class="alert alert-info">
            <h3 class="text-center text-success">You have gallerys:</h3>
            <div id="btn_ganre" class="btn-group"></div>
        </div>

        <div class="alert alert-info">
            <div class="row">
                <div class="col-md-6 well wrap">
                    <div class="slider karkas" id="carusel_photo">
                        <ul id="lightSlider"></ul>
                    </div>
                </div>

                <div class="col-md-5 col-md-offset-1">
                    <div class="row">
                        <div class="col-md-5 well">
                            <h5 class="text-center">Create Gallery</h5>
                            <span id="span_create_gallery" class=""></span>
                            <form action="" class="form-horizontal" method="post">
                                <div class="form-group">
                                        <input type="text" class="form-control" name="gallery_name" id="gallery_name"
                                               placeholder="Gallery Name">
                                </div>
                                <input type="button" class="btn btn-primary btn-sm" id="btn_new_gallery" value="New Gallery">
                            </form>
                        </div>

                        <div class="col-md-6 col-md-offset-1 well">
                            <h5 class="text-center">Upload Files</h5>
                            <form action="" method="post" id="test_form_uploud" >
                                <select name="select_gallery_list" id="select_gallery_list" class="form-control" required></select>
                                <br>
                                <div class="">
                                    <input id="fileupload" type="file" name="files[]" data-url="/uploadPhoto" multiple>
                                </div>
                            </form>
                            <br>
                            <div id="progress" class="progress progress-striped">
                                <div class="bar" style="width: 0%;"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


    </div>
</div>

<script src="${pageContext.request.contextPath}/resources/js/vendor/jquery.ui.widget.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.iframe-transport.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.fileupload.js"></script>
<%--<script src="${pageContext.request.contextPath}/resources/js/lightslider/lightslider.js"></script>--%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/lightslider/1.1.5/js/lightslider.js"></script>

</body>
</html>
