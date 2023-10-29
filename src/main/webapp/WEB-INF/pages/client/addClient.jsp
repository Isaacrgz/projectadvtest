<div class="modal fade" tabindex="-1" id="addModalClient">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">A&ntilde;adir cliente</h5>
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>

            <form action="${pageContext.request.contextPath}/ServletController?action=insertC" method="post" class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="clave">Clave</label>
                        <input type="text" class="form-control" name="clave" required>
                    </div>
                    <div class="form-group">
                        <label for="razonSocial">Raz&oacute;n social</label>
                        <input type="text" class="form-control" name="razonSocial" required>
                    </div>
                    <div class="form-group">
                        <label for="rfc">RFC</label>
                        <input type="text" class="form-control" name="rfc" required>
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Guardar</button>
                </div>
            </form>
        </div>
    </div>
</div>