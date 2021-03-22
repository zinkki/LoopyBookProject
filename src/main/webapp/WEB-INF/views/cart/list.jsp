<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="../includes/header.jsp"%>

<div id="contents">


	<div class="titleArea">
		<h2>
			<span>CART</span>
		</h2>
	</div>

	<!-- EDNplus 장바구나 스크립트 -->
	<script type="text/javascript"
		src="//script.about.co.kr/templates/script/cm/adbay.cart.controller.js"></script>


	<div id="adbay_cart" style="display: none;"></div>
	<!-- EDNplus 장바구나 스크립트 종료 -->

	<!-- 장바구니 모듈 Package -->
	<div class="xans-element- xans-order xans-order-basketpackage ">

		<div class="orderListArea">
			<div class="xans-element- xans-order xans-order-normtitle title ">
				<h3>일반상품 (2)</h3>
			</div>

			<!-- 일반상품 (기본배송) -->
			<table border="1" summary=""
				class="xans-element- xans-order xans-order-normnormal boardList xans-record-">
				
				<thead>
					<tr>
						<th scope="col" class="chk">
							<input type="checkbox"onclick="Basket.setCheckBasketList('basket_product_normal_type_normal', this);">
						</th>
						<th scope="col" class="thumb">BOOK IMAGE</th>
						<th scope="col" class="product">TITLE</th>
						<th scope="col" class="price">PRICE</th>
						<th scope="col" class="amount">AMOUNT</th>
						<th scope="col" class="total">CHARGE</th>
						<th scope="col" class="button">SELECT</th>
					</tr>
				</thead>
				
				<tbody class="xans-element- xans-order xans-order-list">
					<tr class="xans-record-">
						<td> ${fileName } </td>
						<td> ${book_title }</td>
						<td class="product">${amount } </td>
						<td class="price"> </td>
						<td>
							<span class="quantity"><input id="quantity_id_0"
								name="quantity_name_0" size="2" value="1" type="text">
								<a href="javascript:;" onclick="Basket.addQuantityShortcut('quantity_id_0', 0);">
									<img src="http://img.echosting.cafe24.com/skin/base_ko_KR/order/btn_quantity_up.gif"
									alt="증가" class="QuantityUp"></a><a href="javascript:;"
									onclick="Basket.outQuantityShortcut('quantity_id_0', 0);">
									<img src="http://img.echosting.cafe24.com/skin/base_ko_KR/order/btn_quantity_down.gif"
									alt="감소" class="QuantityDown">
								</a>
							</span> 
							<a href="javascript:;" onclick="Basket.modifyQuantity()">
							<img src="/web/season2_skin/base/btn/btn_quantity_modify.png" alt="변경" title=""></a>
						</td>
						<td class="total">
							<strong>90,000원</strong>
							<div class="displaynone"></div>
						</td>
						<td class="button">
							<a href="javascript:;" onclick="Basket.orderBasketItem(0);" class="btntype6">주문하기</a>
							<a href="javascript:;" onclick="Basket.deleteBasketItem(0);" class="btntype7">삭제</a>
						</td>
					</tr>

				</tbody>
				<tfoot>
					<tr>
						<td colspan="10"><strong class="type">[기본배송]</strong> 상품구매금액
							<strong>138,000 <span class="displaynone">()</span></strong><span
							class="displaynone"> </span> + 배송비 0 (무료)<span
							class="displaynone"> </span> = 합계 : <strong class="total"><span>133,500</span>원</strong>
							<span class="displaynone"> </span></td>
					</tr>
				</tfoot>
			</table>
		</div>

		<!-- 선택상품 제어 버튼 -->
		<div class="xans-element- xans-order xans-order-selectorder ">
			<span class="left"> <strong class="ctrlTxt">선택상품을</strong> <a
				href="#none" onclick="Basket.deleteBasket()" class="btntype8">삭제하기</a>

			</span> <span class="right"> <a href="#none"
				onclick="Basket.emptyBasket()" class="btntype8">장바구니비우기</a>
			</span>
		</div>


		<!-- 주문 버튼 -->
		<div class="xans-element- xans-order xans-order-totalorder">
			<a href="#none" onclick="Basket.orderSelectBasket(this)"
				link-order="/order/orderform.html?basket_type=all_buy"
				link-login="/member/login.html" class=""><img
				src="/web/season2_skin/base/btn/btn_order_select.png"
				onmouseover="this.src='/web/season2_skin/base/btn/btn_order_select_over.png' "
				onmouseout="this.src='/web/season2_skin/base/btn/btn_order_select.png' "
				alt="선택상품주문" title=""></a> <a href="#none"
				onclick="Basket.orderAll(this)"
				link-order="/order/orderform.html?basket_type=all_buy"
				link-login="/member/login.html" class=" "><img
				src="/web/season2_skin/base/btn/btn_order_all.png"
				onmouseover="this.src='/web/season2_skin/base/btn/btn_order_all_over.png' "
				onmouseout="this.src='/web/season2_skin/base/btn/btn_order_all.png' "
				alt="전체상품주문"></a><span class="right"> <a href="/"
				class="btntype8">쇼핑계속하기</a>
			</span>
		</div>
		<br>
		<!-- 네이버 체크아웃 구매 버튼  -->
		<div id=""></div>
	</div>
	<!-- //장바구니 모듈 Package -->

	<!-- 관심상품 목록 -->
	<div
		class="xans-element- xans-myshop xans-myshop-wishlist displaynone xans-record-">
		<!--
    $login_page = /member/login.html
    $count = 5
    $mode = basket
    -->

	</div>

</div>

<%@ include file="../includes/footer.jsp"%>