<section id="actions" class="py-4 mb-4 bg-light">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <a href="index.jsp" class="btn btn-light btn-block">
                    <i class="fas fa-arrow-left"></i> Regresar
                </a>
            </div>
            <div class="col-md-3">
                <button type="submit" class="btn btn-success btn-block">
                    <i class="fas fa-check"></i> Actualizar cliente
                </button>
            </div>
            <div class="col-md-3">
                <a href="${pageContext.request.contextPath}/ServletController?action=deleteC&idClient=${client.idClient}" 
                    class="btn btn-danger btn-block">
                    <i class="fas fa-trash"></i> Borrar cliente
                </a>
            </div>
        </div>
    </div>
</section>