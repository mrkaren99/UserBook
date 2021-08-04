
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="modal fade" id="confirm-delete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">

            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">Confirm Delete</h4>
            </div>

            <div class="modal-body">
                <p>You are about to delete one track, this procedure is irreversible.</p>
                <p>Do you want to proceed?</p>
                <p class="debug-url"></p>
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                <a class="btn btn-danger btn-ok">Delete</a>
            </div>
        </div>
    </div>
</div>


<div class="container">
    <div class="row col-md-6 col-md-offset-2 custyle">
        <table class="table table-striped custab">
            <thead>
            <a href="/addBook" class="btn btn-primary btn-xs pull-right"><b>+</b> Add new Book</a>
            <tr>
                <th>Title</th>
                <th>Price</th>
                <th class="text-center">Action</th>
            </tr>
            </thead>

            <c:forEach var="book" items="${requestScope.get('books')}">

                <tr>
                    <td><c:out value="${book.getTitle()}" />
                    </td>
                    <td><c:out value="${book.price}" />
                    </td>
                    <td><a href="/singleBook?id=<c:out value="${book.id}" />">Show more</a> | <a
                            href="/updateBook?id=<c:out value="${book.id}" />">Update</a> |
                        <a href="#"
                           data-href="/deleteBook?id=<c:out value="${book.id}" />"
                           data-toggle="modal"
                           data-target="#confirm-delete">Delete</a></td>
                </tr>

            </c:forEach>

        </table>
    </div>
</div>

<script>
    $('#confirm-delete').on('show.bs.modal', function(e) {
        $(this).find('.btn-ok').attr('href', $(e.relatedTarget).data('href'));

        $('.debug-url').html('Delete URL: <strong>' + $(this).find('.btn-ok').attr('href') + '</strong>');
    });
</script>

