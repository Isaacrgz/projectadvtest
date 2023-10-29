<section id="actions" class="py-4 mb-4 bg-light">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <a href="#" class="btn btn-primary btn-block" data-toggle="modal" data-target="#addModalClient">
                    <i class="fas fa-plus"></i> A&ntilde;adir cliente
                </a>
            </div>
            <div class="col-md-3">

            </div>
            <div class="col-md-3">
                <a href="#" class="btn btn-primary btn-block" data-toggle="modal" data-target=".examplemodal">
                    <i class="fas fa-plus"></i> A&ntilde;adir direcci&oacute;n
                </a>

                <div class="modal fade examplemodal" tabindex="-1">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <div class="modal-header bg-info text-white">
                                <h5 class="modal-title">A&ntilde;adir direcci&oacute;n</h5>
                                <button class="close" data-dismiss="modal">
                                    <span>&times;</span>
                                </button>
                            </div>
                
                            <form action="${pageContext.request.contextPath}/ServletController?action=insertA" method="post" class="was-validated">
                                <div class="modal-body">
                                    <div class="form-group">
                                        <label for="calle">Calle</label>
                                        <input type="text" class="form-control" name="calle" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="colonia">Colonia</label>
                                        <input type="text" class="form-control" name="colonia" required>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button class="btn btn-primary" type="submit">Guardar</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</section>