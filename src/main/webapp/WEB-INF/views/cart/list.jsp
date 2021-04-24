<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="../includes/header.jsp"%>

<div class="container-fluid">
	<br>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid" >
			<h2>CART</h2>
			<div class="collapse navbar-collapse" id="navbarNav"></div>
		</div>
	</nav>
	<br>
	<div id="contents">
		<form id="actionForm" >
			<!-- 일반상품 (기본배송) -->
			<table style="width: 100%" summary="" border="1" class="xans-element- xans-order xans-order-normnormal boardList xans-record-">
				<thead align="center">
					<tr>
						<th scope="col" class="check">CHECK</th>
						<th scope="col" class="thumb" style="width: 10%">ITEM</th>
						<th scope="col" class="product"style="width: 20%" >TITLE</th>
						<th scope="col" class="price">PRICE</th>
						<th scope="col" class="amount">AMOUNT</th>
						<th scope="col" class="total">TOTAL</th>
						<th scope="col" class="button">SELECT</th>
					</tr>
				</thead>
				<tbody class="xans-element- xans-order xans-order-list">
					<c:set var="sum" value="0" />
					<c:forEach items="${bookList }" var="bookList" varStatus="status">
						<tr class="xans-record-" align="center">
							<td><label><input type="checkbox" id="checkBox${status.index}"></label></td>
							<td><a><img style="width: 220px;" src= "${bookList.fileName}"></a></td>
							<td><p>${bookList.book_title }</p><input type="hidden" name="book_id" id="book_id${status.index }" value="${bookList.book_id }"></td>
							<td><p><fmt:formatNumber value="${bookList.book_price }" type="currency"></fmt:formatNumber></p></td>
							<td><span class="btn-group-vertical">
								<button onclick="modifyAmount(${bookList.book_id } , ${cartList[status.index].amount + 1 })" name="cartAmount" value="${cartList[status.index].amount + 1 }" style="border: 0; background-color: #ffffff;"><i class="fas fa-sort-up" ></i></button>
								<button onclick="modifyAmount(${bookList.book_id } , ${cartList[status.index].amount - 1 })" name="cartAmount" value="${cartList[status.index].amount - 1 }" style="border: 0; background-color: #ffffff;margin: 10 10"><i class="fas fa-sort-down" ></i></button>
								</span>
								<input id="cartAmount${status.index }" name="cartAmount" size="2" value="${cartList[status.index].amount }" type="text">		
								<input class="btn btn-outline-secondary btn-sm" onclick="modifyAmount2(${bookList.book_id }, cartAmount${status.index })" type="button" value="변경">
                			</td>
							<td class="total">
								<strong><fmt:formatNumber value="${bookList.book_price * cartList[status.index].amount  }" type="currency"></fmt:formatNumber></strong>
								<input type="hidden" name ="totalPrice" value="${bookList.book_price * cartList[status.index].amount  }">
							</td>
							<td><span class="btn-group-vertical">
								<input id="index${status.index }" name="index" value="${status.index }"type="hidden">		
								<a href="javascript:;" class="btn btn-outline-secondary btn-sm" onclick="oneBookOrder(${bookList.book_id },cartAmount${status.index })" >주문하기</a>
								<a href="javascript:;" class="btn btn-outline-secondary btn-sm" onclick="cart(${bookList.book_id })">삭제</a>
								</span>
							</td>	
						</tr>
					<c:set var="sum" value="${sum + (bookList.book_price * cartList[status.index].amount )}" />
					</c:forEach>
					<tfoot>
						<tr align="center" height="50">
							<td colspan="7">상품구매금액  &nbsp;<strong><fmt:formatNumber value="${sum}"></fmt:formatNumber></strong>
								<span class="displaynone"> </span> + 배송비 <strong><fmt:formatNumber value="${sum < 30000 ? 2500 : 0 }"></fmt:formatNumber></strong>
								<span class="displaynone"> </span> = 합계 : <strong><fmt:formatNumber value="${sum < 30000 ? sum+2500 : sum }" type="currency" ></fmt:formatNumber></strong>
							</td>
						</tr>
					</tfoot>
				</tbody>
			</table>
			<br>
			<div class="xans-element- xans-order xans-order-totalorder" align="center" >
				<button class="btn btn-dark" style="background-color: #b4b4b4; color: black; border: 0;" onclick="selectRemoveBtn()"> 선택상품 삭제하기</button>
				<button class="btn btn-dark" style="background-color: pink; color: black; border: 0;" onclick="checkBtn()"> 선택상품 주문하기</button>
				<button class="btn btn-dark" style="background-color: #b4b4b4; color: black; border: 0;" onclick="allcheckBtn()"> 전체상품 주문하기</button>
			</div>
			<br>
		</form>
	</div>
</div>
<!-- ???이건뭘까...modal...??? -->
<div class="modal" tabindex="-1" id="cartDelete_modal">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Modal title</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body" id="cart_modal_body">
				<p>Modal body text goes here.</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" data-dismiss="modal"
					id="deleteBtn" onclick="cartdelete()">삭제</button>
				<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
//한개 목록 삭제 버튼 눌렀을 때 >>O
function cart(id){
	var book_id = id;
	var actionForm = $("#actionForm");
    $('#cart_modal_body').html("선택하신 상품을 삭제하시겠습니까?");
	$('#cartDelete_modal').modal('show');
	
	$('#deleteBtn').click(function(e) {
		$.ajax({
		    url: "/cart/remove",
		    type: "POST",
		    data: { "book_id" : book_id },
		    success : function(){
		     	location = '/cart/list';
		    },
		    error : function(){
		    	alert("!!!!!!");	
		    }
		  });
	});
}	
// 수량 수정  >> O
function modifyAmount(id,amount){
	var book_id = id;
	var cartAmount = amount;
	$.ajax({
	    url: "/cart/modify",
	    type: "POST",
	    data: { "book_id" : book_id , "cartAmount" : cartAmount },
	    success : function(){
	     	location = '/cart/list';
	    },
	    error : function(){
	    	alert("!!!!!!");	
	    }
	  });	
}
//수량 플러스 마이너스로 수정 >>O
function modifyAmount2(id,amount){
	var book_id = id;
	var cartAmount = amount.value;
	$.ajax({
	    url: "/cart/modify",
	    type: "POST",
	    data: { "book_id" : book_id , "cartAmount" : cartAmount },
	    success : function(){
	     	location = '/cart/list';
	    },
	    error : function(){
	    	alert("!!!!!!");	
	    }
	  });	
}
//목록에서 한개의 상품 옆 주문하기 눌렀을 때
function oneBookOrder() {
	if(confirm("상품을 주문하시겠습니까?")){
		location.href='/order/oneBookOrder';
	}else {
		history.go(-1);
	}
}
/* function oneBookOrder(id,amount){
	var book_id = id;
	var cartAmount = amount.value;
	$.ajaxSettings.traditional = true;
		$.ajax({
		    url: "/order/oneBookOrder",
		    type: "POST",
		    data: { "book_id" : book_id , "cartAmount" : cartAmount },
		    success : function(){
		     
		    	location = '/order/oneBookOrder';
		    },
		    error : function(){
		    	alert("!!!!!!");	
		    }
		  });
}	 */
// 선택상품 주문
function checkBtn(){
	
	var indexArray = [];
	
	for(var i=0;i<${listSize};i++){
		if(($('#checkBox${status.index}'+i)).prop("checked")){
			indexArray[i] = i;
			console.log('yes');
			
		}else{
			continue;
		}
	}
		
	console.log(indexArray);
	
		$.ajaxSettings.traditional = true;
		$.ajax({
		    url: "/order/selectlist",
		    type: "POST",
		    data: { "indexArray" : indexArray },
		    success : function(){
		     	location = '/order/selectlist';
		    },
		    error : function(){
		    	alert("상품을 선택해주세요!");	
		    }
		  });
}
// 전체상품 주문
function allcheckBtn(){
	var indexArray = [];
	
	for(var i=0;i<${listSize};i++){
		indexArray[i] = i;
		console.log('yes');
	}
		
	console.log(indexArray);
	
		$.ajaxSettings.traditional = true;
		$.ajax({
		    url: "/order/selectlist",
		    type: "POST",
		    data: { "indexArray" : indexArray },
		    success : function(){
		     	location = '/order/selectlist';
		    },
		    error : function(){
		    	alert("상품을 선택해주세요!");	
		    }
		  });
	
}

// 선택상품 삭제하기
function selectRemoveBtn(){
	
var indexArray = [];
	
	for(var i=0;i<${listSize};i++){
		if(($('#checkBox${status.index}'+i)).prop("checked")){
			indexArray[i] = i;
			console.log('yes');
			
		}else{
			continue;
		}
	}
		
	console.log(indexArray);
	
		$.ajaxSettings.traditional = true;
		$.ajax({
		    url: "/cart/selectRemove",
		    type: "POST",
		    data: { "indexArray" : indexArray },
		    success : function(){
		     	location = '/cart/list';
		    },
		    error : function(){
		    	alert("상품을 선택해주세요!");	
		    }
		  });
}
	
</script>

<%@ include file="../includes/footer.jsp"%>