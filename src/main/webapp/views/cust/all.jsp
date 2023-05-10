<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">Cust All</h1>

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Cust All</h6>


        </div>
        <form id="search_form" class="form-inline well">
            <div class="form-group">
                <label class="control-label col-sm-2">Location</label>
                <div class="col-sm-2">
                    <select class="form-control" id="loc" name="loc">
                        <option value="s"  <c:if test="{ms.loc=='s'}">selected</c:if>></option>
                        <option value="b"  <c:if test="{ms.loc=='b'}">selected</c:if>></option>
                        <option value="j"  <c:if test="{ms.loc=='j'}">selected</c:if>></option>
                    </select>

                    <input type="text" name="img" class="form-control" id="Location" placeholder="Enter location">
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="title"> TITLE</label>
                <div class="col-sm-10">
                    <input type="text" name="title" class="form-control" id="title" placeholder="Enter title"
                           value="${ms.title}">
                </div>
            </div>
        </form>


        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>NAME</th>
                    </tr>
                    </thead>
                    <tfoot>
                    <tr>
                        <th>ID</th>
                        <th>NAME</th>
                    </tr>
                    </tfoot>
                    <tbody>
                    <c:forEach var="obj" items="${clist}">
                        <tr>
                            <td><a href="/cust/detail?id=${obj.id}">${obj.id}</a></td>
                            <td>${obj.name}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</div>
<!-- /.container-fluid -->