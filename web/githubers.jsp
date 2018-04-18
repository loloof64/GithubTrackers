<%@ page import="fr.wildcodeschool.githubtracker.model.Githuber" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp" />
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<body>
    <div class="list-group">
        <c:forEach items="${listOfGithubers}" var="currentUser">
            <li class="list-group-item">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-6">
                                <img src="${currentUser.avatarUrl}" width="100" height="100">
                            </div>
                            <div class="col-lg-6">
                                <div class="row">
                                    <div class="col-lg-8">
                                        ${currentUser.name}
                                    </div>
                                    <div class="col-lg-4">
                                        (${currentUser.login})
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-12">
                                        ${currentUser.email}
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
            </li>
        </c:forEach>
    </div>
</body>
</html>
