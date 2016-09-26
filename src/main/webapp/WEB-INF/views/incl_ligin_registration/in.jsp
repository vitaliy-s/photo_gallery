<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="col-md-4">
    <span class="text-center text-success"><h2>Login</h2></span>
    <form method="POST" action="${contextPath}/login" class="form-horizontal">
            <div class="form-group ${error != null ? 'has-error' : ''}">
                <label for="inputEmail" class="control-label col-xs-2">Login</label>
                <div class="col-xs-10">
                    <span>${message}</span>
                    <input name="username" type="text" class="form-control" id="inputEmail" placeholder="Login">
                </div>
            </div>
            <div class="form-group ${error != null ? 'has-error' : ''}">
                <label for="inputPassword" class="control-label col-xs-2">Пароль</label>
                <div class="col-xs-10">
                    <input name="password" type="password" class="form-control" id="inputPassword" placeholder="Пароль">
                    <span>${error}</span>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </div>
            </div>
            <div class="form-group">
                <div class="col-xs-offset-2 col-xs-10">
                    <div class="checkbox">
                        <label><input type="checkbox"> Запомнить</label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-xs-offset-2 col-xs-10">
                    <button type="submit" class="btn btn-primary">Войти</button>
                </div>
            </div>
    </form>

</div>

