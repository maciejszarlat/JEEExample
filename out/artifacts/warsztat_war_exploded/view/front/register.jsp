<%@include file="/WEB-INF/view/components/header.jsp" %>
<div id="wrapper">

    <!-- Sidebar -->


    <div id="content-wrapper">

        <div class="container-fluid">

            <div class="container">
                <div class="card card-login mx-auto mt-5">
                    <div class="card-header">Login</div>
                    <div class="card-body">
                        <form action="/register" method="post">
                            <div class="form-group">
                                <label for="exampleInputEmail1">E-mail</label>
                                <input type="text" name="email" class="form-control" id="exampleInputEmail1"
                                       aria-describedby="emailHelp" value="${email}">

                            </div>
                            <c:if test="${not empty errorDup}">
                                <div class="alert alert-danger" role="alert">
                                        ${errorDup}
                                </div>

                            </c:if>
                            <c:if test="${not empty errorWrongEmail}">
                                <div class="alert alert-danger" role="alert">
                                        ${errorWrongEmail}
                                </div>

                            </c:if>

                            <div class="form-group">
                                <label for="exampleInputPassword1">Hasło</label>
                                <input type="password" name="password" class="form-control" id="exampleInputPassword1">
                            </div>
                            <div class="form-group">
                                <label for="exampleInputPassword2">Powtorz hasło</label>
                                <input type="password" name="password2" class="form-control" id="exampleInputPassword2">
                            </div>
                            <c:if test="${not empty errorEmpty}">
                                <div class="alert alert-danger" role="alert">
                                        ${errorEmpty}
                                </div>

                            </c:if>
                            <c:if test="${not empty errorPasswordNotEquals}">
                                <div class="alert alert-danger" role="alert">
                                        ${errorPasswordNotEquals}
                                </div>

                            </c:if>

                            <button type="submit" class="btn btn-primary">Zarejestruj</button>
                        </form>
                        <c:if test="${not empty urlConfirm}">
                            <div class="alert alert-success" role="success">
                                Aby potwierdzić rejestrację kliknij w link: <a href="/checkUserConfirmation?urlConfirm=${urlConfirm}" >Aktywuj!</a>
                            </div>

                        </c:if>
                    </div>
                        <div class="text-center">
                            <a class="d-block small mt-3" href="/login">Zaloguj</a>
                            <a class="d-block small" href="forgot-password.html">Forgot Password?</a>
                        </div>
                    </div>
                </div>
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
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
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
