<div class="modal fade" tabindex="-1" id="addmodal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">A&ntilde;adir direccion</h5>
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