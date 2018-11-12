<%@include file="/WEB-INF/view/components/header.jsp" %>
<div id="wrapper">

    <!-- Sidebar -->

    <%@include file="/WEB-INF/view/components/sidebar.jsp" %>
    <div id="content-wrapper">

        <div class="container-fluid">

            <div class="card card-login mx-auto mt-12">
                <div class="card-header">Nowy pracownik</div>
                <div class="card-body">
                    <form action="/admin/employer/add" method="post">
                        <div class="form-group">
                            <div class="form-label-group">
                                <input type="text" id="firstName" class="form-control" required="required" name="firstName">
                                <label for="firstName">Imię</label>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-label-group">
                                <input type="text" id="lastName" class="form-control" required="required" name="lastName">
                                <label for="lastName">Nazwisko</label>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-label-group">
                                <input type="text" id="email" class="form-control" required="required" name="email">
                                <label for="email">Email</label>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-label-group">
                                <input type="text" id="hourlyRate" class="form-control" required="required" name="hourlyRate">
                                <label for="hourlyRate">Stawka godzinowa</label>
                            </div>
                        </div>
                        <input type="submit" value="dodaj">
                    </form>
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
