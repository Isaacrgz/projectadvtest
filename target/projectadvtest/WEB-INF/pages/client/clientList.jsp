<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<section id="clients">
    <div class="container">
        <div class="row">
            <!-- Clients list -->
            <div class="col-md-7">
                <div class="card">
                    <div class="card-header">
                        <h4>Lista de clientes ${mensajeC}</h4>
                    </div>
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>Clave</th>
                                <th>Raz&oacute;n social</th>
                                <th>RFC</th>
                                <th></th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="client" items="${clients}" varStatus="status">
                                <tr>
                                    <td>${status.count}</td>
                                    <td>${client.clave}</td>
                                    <td>${client.razonSocial}</td>
                                    <td>${client.rfc}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/ServletController?action=editC&idClient=${client.idClient}"
                                           class="btn btn-secondary">
                                            <i class="fa-regular fa-pen-to-square" style="color: #f5f5f5;"></i>
                                        </a>
                                    </td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/ServletController?action=listarA&idClient=${client.idClient}&clave=${client.clave}"
                                           class="btn btn-info">
                                           <i class="fa-solid fa-angles-right"></i>
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <!-- Lateral total cards -->
            <div class="col-md-5">
                <div class="card">
                    <div class="card-header">
                        <h4>Direcciones de ${mensaje}</h4>
                    </div>
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>Calle</th>
                                <th>Colonia</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="address" items="${addresses}" varStatus="status">
                                <tr>
                                    <td>${status.count}</td>
                                    <td>${address.calle}</td>
                                    <td>${address.colonia}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/ServletController?action=editA&idAddress=${address.idAddress}"
                                            class="btn btn-secondary">
                                            <i class="fa-solid fa-angles-right"></i>
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- Add client MODAL -->
<jsp:include page="/WEB-INF/pages/client/addClient.jsp" />