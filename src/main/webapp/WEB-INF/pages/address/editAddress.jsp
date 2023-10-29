<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Editar direcci&oacute;n</title>
        <jsp:include page="/WEB-INF/pages/commons/headItems.jsp" />
    </head>
    <body>
        <!-- Header section -->
        <jsp:include page="/WEB-INF/pages/commons/header.jsp" />

        <form action="${pageContext.request.contextPath}/ServletController?action=modifyA&idAddress=${address.idAddress}" method="post" class="was-validated">
            <!-- Nav buttons -->
            <jsp:include page="/WEB-INF/pages/commons/navButtonEditA.jsp" />

            <section id="details">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Editar direcci&oacute;n</h4>
                                </div>
                                <div class="card-body">
                                    <div class="form-group">
                                        <label for="calle">Calle</label>
                                        <input type="text" class="form-control" value="${address.calle}" name="calle" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="colonia">Colonia</label>
                                        <input type="text" class="form-control" name="colonia" value="${address.colonia}" required >
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </form>

        <!-- Footer section -->
        <jsp:include page="/WEB-INF/pages/commons/footer.jsp" />

        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
    </body>
</html>