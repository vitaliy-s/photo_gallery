<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="col-lg-7">
    <span class="text-center text-success"><h2>Регистрация</h2></span>
    <form class="form-horizontal" method="post" id="register_form">
        <div class="form-group">
            <label class="control-label col-xs-3" for="last_name">* Фамилия:</label>
            <div class="col-xs-9">
                <input type="text" class="form-control" name="n_lastName" id="last_name" placeholder="Введите фамилию">
                <span id="err_lastName"></span>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-xs-3" for="first_name">* Имя:</label>
            <div class="col-xs-9">
                <input type="text" class="form-control" name="n_firstName" id="first_name" placeholder="Введите имя">
                <span id="err_firstName"></span>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-xs-3">Дата рождения:</label>
            <div class="col-xs-3">
                <input type="text" id="datepicker">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-xs-3" for="input_email">* Email:</label>
            <div class="col-xs-9">
                <input type="email" class="form-control" name="n_mail" id="input_email" placeholder="Email">
                <span id="err_mail"></span>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-xs-3" for="input_password">* Пароль:</label>
            <div class="col-xs-9">
                <input type="password" class="form-control" name="input_password" id="input_password" placeholder="Введите пароль">
                <span id="err_password"></span>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-xs-3" for="confirm_password">Подтвердите пароль:</label>
            <div class="col-xs-9">
                <input type="password" class="form-control" name="confirm_password" id="confirm_password" placeholder="Введите пароль ещё раз">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-xs-3" for="infoUser">О Себе:</label>
            <div class="col-xs-9">
                <textarea rows="3" class="form-control" id="infoUser" placeholder="Введите информацию"></textarea>
            </div>
        </div>
        <br/>
        <div class="form-group">
            <div class="col-xs-offset-3 col-xs-9">
                <input type="submit" class="btn btn-primary" id="btn-submitNewUser" value="Регистрация">
                <input type="reset" class="btn btn-default" value="Очистить форму">
            </div>
        </div>
    </form>
    <div class="text-danger">
        <span class="text-center"><h4>Поля с '*' - обязательны к заполнению !</h4></span>
    </div>
</div>