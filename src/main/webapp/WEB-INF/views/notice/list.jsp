<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="../includes/header.jsp"%>
<main>
	<div class="modal" tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Alert</h5>
					<button type="button" class="btn-close" data-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<p>Modal body text goes here..</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>

	<div class="container-fluid">
		<h1 class="mt-4">TestBoard</h1>
		<ol class="breadcrumb mb-4">
			<li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
			<li class="breadcrumb-item active">Board</li>
		</ol>
		<div class="card mb-4">
			<div class="card-body">
				DataTables is a third party plugin that is used to generate the demo
				table below. For more information about DataTables, please visit the
				<a target="_blank" href="https://datatables.net/">official
					DataTables documentation</a> .
			</div>
		</div>
		<div class="card mb-4">
			<div class="card-header">
				<i class="fas fa-table mr-1"></i> List <a
					class="btn btn-outline-info btn-sm" href="/board/register"
					style="float: right;">Register</a>
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<div class="input-group">
						<select class="custom-select col-md-1 " id="inputGroupSelect04">
							<option selected>Amount</option>
							<option value="10">10</option>
							<option value="20">20</option>
							<option value="50">50</option>
							<option value="100">100</option>
						</select>
						<div class="input-group-append">
							<button class="btn btn-outline-secondary getAmount" type="button">Button</button>
						</div>
					</div>
					<table class="table table-bordered" id="" width="100%"
						cellspacing="0">
						<thead>
							<tr>
								<th>Bno</th>
								<th>Title</th>
								<th>Writer</th>
								<th>RegDate</th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th>Bno</th>
								<th>Title</th>
								<th>Writer</th>
								<th>RegDate</th>
							</tr>
						</tfoot>
						<tbody>
							<c:forEach items="${list }" var="notice">
								<tr>
									<td><c:out value="${notice.seq_bno }"></c:out></td>
									<td><a href="${notice.seq_bno }"><c:out
												value="${notice.notice_title }"></c:out></a></td>
									<td><c:out value="${notice.notice_writer }"></c:out></td>
									<td><c:out value="${notice.notice_date }" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

					<div style="float: right;">
						<nav aria-label="Page navigation example">
							<ul class="pagination">
								<c:if test="${page.prev }">
									<li class="page-item"><a class="page-link"
										href="${page.startPage - 1 }">Prev</a></li>
								</c:if>
								<c:forEach begin="${page.startPage }" end="${page.endPage }"
									var="num">
									<li
										class="page-item ${page.cri.pageNum == num ? 'active' : ''}"><a
										class="page-link" href="${num }">${num }</a></li>
								</c:forEach>
								<c:if test="${page.next }">
									<li class="page-item"><a class="page-link"
										href="${page.endPage + 1 }">Next</a></li>
								</c:if>
							</ul>
						</nav>
					</div>
					<form id="actionForm" method="get">
						<input type="hidden" name="pageNum" value="${page.cri.pageNum }">
						<input type="hidden" name="amount" value="${page.cri.amount }">
					</form>
				</div>
			</div>
		</div>
	</div>
</main>

<script type="text/javascript">
	$(document).ready(function() {
		var result = '<c:out value="${result }"></c:out>';

		showModal(result);

		function showModal(result) {

			if (result === "success") {
				$('.modal-body').html("Success Remove!");
				$('.modal').modal('show');
				history.pushState(null, null, location.href);
				window.onpopstate = function() {
					$('.modal-body').html("This content has been removed.");
					$('.modal').modal('show');
					history.go(1);
					history.replace(null, null, null);
				};
			}
		}
	});
</script>


<%@ include file="../includes/footer.jsp"%>