<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="panel panel-heading">
    <div class="row">
        <div class="col-md-4 col-md-offset-6 alert alert-info">
            <div class="text-center">
                <p>First Name : <span id="h_name"></span></p>
                <p>Last name : <span id="h_last"></span></p>
                <p>Email : <span id="h_mail"></span></p>
                <p>Birthday : <span id="h_birthday"></span></p>
            </div>


            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <form id="logoutForm" method="POST" action="${contextPath}/logout">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
              <%--  <p>Welcome ${pageContext.request.userPrincipal.name}</p>--%>
            </c:if>
        </div>
        <div class="col-md-1 col-md-offset-1">
            <a class="btn btn-primary" onclick="document.forms['logoutForm'].submit()">Logout</a>
        </div>
    </div>
</div>
<div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</div>


<%-- <c:if test="${pageContext.request.userPrincipal.name != null}">
     <form id="logoutForm" method="POST" action="${contextPath}/logout">
         <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
     </form>

     <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>

 </c:if>--%>




