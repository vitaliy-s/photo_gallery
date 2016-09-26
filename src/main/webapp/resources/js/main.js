$(document).ready(function () {
    $(function () {
        $("#datepicker").datepicker();
    });

    $("#btn-submitNewUser").click(function () {
        validationForm();
    });

    allGallery();

    $("#btn_new_gallery").click(function () {
        createGallery();
    });

    fileupload();

    viewCarusel();

    getAllPhoto();

    infoUserHeader();

});

function infoUserHeader(){
    $.getJSON("userDataView", function (data) {
            $("#h_name").append(data.username);
            $("#h_last").append(data.lastName);
            $("#h_birthday").append(data.birthday);
            $("#h_mail").append(data.email);
        });
}

/*Carusel*/
function viewCarusel(){
    $('#lightSlider').lightSlider({
        gallery:true,
        item:1,
        loop:true,
        thumbItem:10,
        slideMargin:0,
        enableDrag: false,
        autoWidth: true
       /* adaptiveHeight:true*/
       /* currentPagerPosition:'left'*/
        /*onSliderLoad: function(el) {
         el.lightGallery({
         selector: '#imageGallery .lslide'
         });
         }*/
    });
}

/*operation with Photo*/
function getAllPhoto() {

    $.ajax({
        type: "GET",
        url: "/getAllPhoto",
        contentType: "application/json",
        success: function (data) {
            data.forEach(function (item, i, data) {

                console.log("file.thumbnailImageUrl" + item.thumbnailImageUrl);
                console.log("file.imageUrl" + item.imageUrl);

                $("#carusel_photo #lightSlider").append("<li class='lslide' style='width: 450px; margin-right: 0px;' data-thumb='" + item.thumbnailImageUrl + "'>"+
                    "<img src='" + item.imageUrl + "'/></li>");
            });
            console.log("lightSlider");
        },
        error: function (str, status, error) {
            console.log("My Error : " + status + ", " + error);
        }
    });
}

/*operation with fileupload*/
function fileupload() {
    $('#fileupload').fileupload({
        dataType: 'json',
        done: function (e, data) {
            console.log("uploud file success");
            $("#carusel_photo #lightSlider li").empty();
            getAllPhoto();
        },

        progressall: function (e, data) {

            var progress = parseInt(data.loaded / data.total * 100, 10);
            $('#progress .bar').css(
                'width',
                progress + '%'
            );
        },

        dropZone: $('#dropzone')
    });
}

/*operation with Gallery*/
function allGallery() {
    $.getJSON("allGallery", function (data) {
        data.forEach(function (item, i, data) {
            $("#btn_ganre").append("<input type='button' class='btn btn-primary' value='" + item.name + "'>");
            $("#select_gallery_list").append("<option id='" + item.id + "' selected>" + item.name + "</option>");

        });
    });
}

function createGallery() {
    var gallery = {
        name: $("#gallery_name").val()
    };
    $.ajax({
        type: "POST",
        url: "/createGallery",
        contentType: "application/json",
        data: JSON.stringify(gallery),
        success: function () {
            $("#span_create_gallery").empty();
            $("#gallery_name").val("");
            $("#span_create_gallery").append("Success craete gallery name - " + gallery.name);
            $("#btn_ganre").empty();
            $("#select_gallery_list").empty();
            allGallery();
            console.log("gallery create");
        },
        error: function (str, status, error) {
            console.log("My Error : " + status + ", " + error);
        }
    });

}


/*operation with user*/
function registerUserForm() {

    var user = {
        username: $("#first_name").val(),
        lastName: $("#last_name").val(),
        password: $("#input_password").val(),
        passwordConfirm: $("#confirm_password").val(),
        infoUser: $("#infoUser").val(),
        birthday: $("#datepicker").val(),
        email: $("#input_email").val()
    };

    $.ajax({
        type: "POST",
        url: "/registerUser",
        contentType: "application/json",
        data: JSON.stringify(user),
        success: function (result) {
            validUserFormName(result);
            console.log(result);
        },
        error: function (str, status, error) {
            console.log("My Error : " + status + ", " + error);
        }
    });
}


function validationForm() {
    $("#register_form").validate({
        rules: {
            n_lastName: {
                required: true,
                minlength: 2
            },
            n_firstName: {
                required: true,
                minlength: 2
            },
            n_mail: {
                required: true,
                email: true
            },
            input_password: {
                required: true
            },
            confirm_password: {
                required: true,
                equalTo: "#input_password"
            }
        },
        submitHandler: function () {
            registerUserForm();
            console.log("END method");
        }
    });
}

function cleanForm() {
    $("#first_name").val("");
    $("#last_name").val("");
    $("#input_password").val("");
    $("#confirm_password").val("");
    $("#infoUser").val("");
    $("#datepicker").val("");
    $("#input_email").val("");
    $("#err_firstName").val("");
    $("#err_lastName").val("");
    $("#err_mail").val("");
    $("#err_password").val("");
}

function validUserFormName(res) {
    var first = "Err-firstName";
    var existName = "Err-name-exist";
    var last = "Err-LastName";
    var mail = "Err-mail";
    var existMail = "Err-mail-exist";
    var password = "Err-password";
    var success = "success.form";

    if (res === first) {
        $("#err_firstName").append("Error FirstName");
    }

    if (res === existName) {
        $("#err_firstName").append("Error Name Exist");
    }

    if (res === last) {
        $("#err_lastName").append("Error LastName");
    }
    if (res === mail) {
        $("#err_mail").append("Error Mail");
    }
    if (res === existMail) {
        $("#err_mail").append("Error Mail Exist");
    }
    if (res === password) {
        $("#err_password").append("Error password")
    }
    if (res === success) {
        cleanForm();
        alert("register user success");
    }
}

