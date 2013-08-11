<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>


<t:page stylesheet="register.css">


    <div class="reg main input-group bx-rnd-shdw">
        <h3 class="ttl">Sign-in</h3>


        <form method="post" action="">

            <div>
                <input class="form-control" placeholder="Email" name="email" type="email" value=""/>
            </div>
            <div>
                <input class="form-control" placeholder="Password" type="password" name="password"/>
            </div>
            <div>
                <input class="form-control" placeholder="Confirm password" type="text" name="confirmationcode"/>
            </div>
            <div class="submit">
                <input type="submit"class="btn lg" value="Submit"/>
            </div>
        </form>
    </div>

</t:page>
