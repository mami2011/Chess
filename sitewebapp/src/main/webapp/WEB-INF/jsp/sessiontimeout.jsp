<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:page stylesheet="register.css">

    <div class="reg main input-group bx-rnd-shdw">
        <h3 class="ttl">Session timeout</h3>
        <div class="msg">
            Sorry, your session has timeout.
            <p>
                <a href="signin">Please click here to sign-in again.</a>
            </p>
        </div>
    </div>

</t:page>
