<%@include file="/WEB-INF/view/components/header.jsp" %>
<div id="wrapper">

    <!-- Sidebar -->

    <%@include file="/WEB-INF/view/components/sidebar.jsp" %>
    <div id="content-wrapper">

        <div class="container-fluid">


            <!-- DataTables Example -->
            <div class="card mb-3">
                <c:if test="${not empty confirm}">
                    <div class="alert alert-success" role="success">
                            ${confirm}
                    </div>

                </c:if>
                <div class="card-header">
                    <i class="fas fa-table"></i>
                    Lista pracownikow  <a class="nav-link" href="/admin/employer/add"><i class="fas fa-sign-out-alt"></i>Dodaj pracownika</a>
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                            <thead>
                            <tr>
                                <th>Imię</th>
                                <th>Nazwisko</th>
                                <th>Stanowisko</th>
                                <th>E-mail</th>
                                <th>Stawka godzinowa</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="tempUser" items="${USER_LIST}">
                                <tr>
                                    <td>${tempUser.firstName}</td>
                                    <td>${tempUser.lastName}</td>
                                    <td>${tempUser.roleName}</td>
                                    <td>${tempUser.email}</td>
                                    <td>${tempUser.hourlyRate} zł</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
            </div>

        </div>
        <!-- /.container-fluid -->

        <!-- Sticky Footer -->
        <footer class="sticky-footer">
            <div class="container my-auto">
                <div class="copyright text-center my-auto">
                    <span>Copyright © Your Website 2018</span>
                </div>
            </div>
        </footer>

    </div>
    <!-- /.content-wrapper -->

</div>
<!-- /#wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                <a class="btn btn-primary" href="login.html">Logout</a>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript-->
<script src="/../assets/vendor/jquery/jquery.min.js"></script>
<script src="/../assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="/../assets/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Page level plugin JavaScript-->
<script src="/../assets/vendor/chart.js/Chart.min.js"></script>
<script src="/../assets/vendor/datatables/jquery.dataTables.js"></script>
<script src="/../assets/vendor/datatables/dataTables.bootstrap4.js"></script>

<!-- Custom scripts for all pages-->
<script src="/../assets/js/sb-admin.min.js"></script>

<!-- Demo scripts for this page-->
<script src="/../assets/js/demo/datatables-demo.js"></script>
<script src="/../assets/js/demo/chart-area-demo.js"></script>

</body>

</html>
