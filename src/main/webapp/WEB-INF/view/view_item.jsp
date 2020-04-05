<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.learn.util.Mappings" %>
<html>
<head>
    <title>View item</title>
</head>
<body>
    <div align="center">
          <c:url var="addUrl" value="${Mappings.ITEMS}"/>
          <a href="${addUrl}">View All Items</a>

           <table border=1 cellpadding="5">

                          <tr>
                              <td><label>ID</label></td>
                              <td>
                                  <c:out value="${todoItem.id}"/>
                              </td>
                          </tr>
                          <tr>
                              <td><label>Title</label></td>
                              <td>
                                <c:out value="${todoItem.title}"/>
                              </td>
                          </tr>
                          <tr>
                              <td><label>Deadline</label></td>
                              <td>
                                <c:out value="${todoItem.deadline}"/>
                              </td>
                          </tr>
                          <tr>
                              <td><label>Details</label></td>
                              <td>
                                <c:out value="${todoItem.details}"/>
                              </td>
                          </tr>

                      </table>

                   <c:url var="items" value="${Mappings.ITEMS}"/>
                            <a href="${items}">View All Items</a>
    </div>
</body>
</html>