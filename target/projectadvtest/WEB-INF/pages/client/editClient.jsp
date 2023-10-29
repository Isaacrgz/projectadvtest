<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Editar cliente</title>
        <jsp:include page="/WEB-INF/pages/commons/headItems.jsp" />
    </head>
    <body>
        <!-- Header section -->
        <jsp:include page="/WEB-INF/pages/commons/header.jsp" />

        <form action="${pageContext.request.contextPath}/ServletController?action=modifyC&idClient=${client.idClient}" method="post" class="was-validated">
            <!-- Nav buttons -->
            <jsp:include page="/WEB-INF/pages/commons/navButtonEdit.jsp" />

            <section id="details">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Editar cliente</h4>
                                </div>
                                <div class="card-body">
                                    <div class="form-group">
                                        <label for="clave">Clave</label>
                                        <input type="text" class="form-control" value="${client.clave}" name="clave" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="razonSocial">Raz&oacute;n social</label>
                                        <input type="text" class="form-control" name="razonSocial" value="${client.razonSocial}" required >
                                    </div>
                                    <div class="form-group">
                                        <label for="rfc">RFC</label>
                                        <input type="text" class="form-control" name="rfc" value="${client.rfc}" required>
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