<c:forEach var="address" items="${addresses}" varStatus="status">
    <tr>
        <td>${status.count}</td>
        <td>${address.calle}</td>
        <td>${address.colonia}</td>
        <td>
            <a href="${pageContext.request.contextPath}/ServletController?action=editA&idAddress=${address.idAddress}"
                class="btn btn-secondary">
                <i class="fas fa-angle-double-right"></i> 
            </a>
        </td>
    </tr>
</c:forEach>