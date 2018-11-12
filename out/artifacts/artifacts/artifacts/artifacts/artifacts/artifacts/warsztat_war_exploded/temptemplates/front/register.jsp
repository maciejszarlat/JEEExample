<%@include file="/WEB-INF/view/components/header.jsp"%>

<!-- Begin page content -->
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-3">
        </div>

        <div class="col-lg-6">

            <form action="/register" method="post">
                <div class="form-group">
                    <label for="exampleInputEmail1">E-mail</label>
                    <input type="email" name="email" class="form-control" id="exampleInputEmail1"
                           aria-describedby="emailHelp" value="${email}">

                </div>
                <c:if test="${not empty errorDup}">
                    <div class="alert alert-danger" role="alert">
                            ${errorDup}
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

        <div class="col-lg-3">
        </div>
    </div>
</div>


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
</body>
</html>
