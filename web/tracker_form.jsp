<%@ page import="fr.wildcodeschool.githubtracker.model.Githuber" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp" />
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<body>

<form method="POST" action="track">
    <li class="list-group-item">
        <div class="container">
            <div class="row">
                <h2 class="col-12">
                    Github Tracker
                </h2>
            </div>

            <div class="row">
                <div class="col-6">
                    Login :
                </div>
                <div class="col-6">
                    <input type="text" name="login" id="login" />
                </div>
            </div>

            <div class="row">
                <div class="col-xs-offset-3"></div>
                <div class="col-6">
                    <button type="submit">Submit</button>
                </div>
            </div>
        </div>
    </li>
</form>

</body>
</html>
