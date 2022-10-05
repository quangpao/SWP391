<%-- 
    Document   : blog.jsp
    Created on : Oct 2, 2022, 7:56:55 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <!--    Chi tap trung render ra duoc post, phan UI khong lam-->
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Blog</title>
    </head>
    <body>

        <section>

            <div class="row">
                <div class="col-md-6 mb-5 mb-lg-0 rounded"
                     style="overflow-y :scroll; height:100vh; background-color: #282C34;">
                    <div class="blog_left_sidebar bt-3 pt-5">
                        <c:forEach items="${posts}" var="item">


                            <!--Moi blog se duoc render o day-->

                            <article class="blog_item rounded" style="background-color:white;">
                                <div class="blog_item_img">
                                                                        <!--Cai src anh nay la gi?-->
                                    <img class="card-img rounded-0" src="assets/img/blog/single_blog_1.png" alt="">
                                    <a href="#" class="blog_item_date">
                                        <h3>${item.timeParse().get(1)}</h3>
                                        <p>${item.timeParse().get(0)}</p>
                                    </a>
                                </div>
                                <div class="blog_details">
                                    
                                    <!--Phan title-->
                                    <div class="d-inline-block">
                                        <!--Link dan den blogDetails, chua viet-->
                                        <form action="${pageContext.request.contextPath}/blog-details" method="GET">
                                            <button name="postID" value="${item.postID}">
                                                <h2 class="blog-head" style="color: #2d2d2d;"> ${item.postID}
                                                </h2>
                                            </button>
                                        </form>
                                    </div>
                                    <p style="color: #2d2d2d ;">That dominion stars lights dominion divide years for
                                        fourth have don't stars is that
                                        he earth it first without heaven in place seed it second morning saying.</p>
                                    <ul class="blog-info-link">
                                        <li><a href="#"><i class="fa fa-user"></i> Travel, Lifestyle</a></li>
                                        <li><a href="#"><i class="fa fa-comments"></i> 03 Comments</a></li>
                                    </ul>
                                    <div class="comment-form mx-2 my-0">
                                        <h4 class="mb-0">Leave a comment<Command></Command>ent</h4>
                                        <form class="form-contact comment_form form-group" action="#" id="commentForm">
                                            <input type="text" class="form-control" placeholder="Write your comment">
                                        </form>
                                    </div>
                                </div>

                                <div class="comments-area mx-2 my-0">
                                    <h4>03 Comments</h4>

                                    <div class="comment-list">
                                        <div class="single-comment justify-content-between d-flex" style="border-bottom: solid 1px bla ;">
                                            <div class="user justify-content-between d-flex">
                                                <div class="thumb">
                                                    <img src="assets/img/blog/comment_1.png" alt="">
                                                </div>
                                                <div class="desc">

                                                    <p class="comment" style="line-height: 16px; font-size: smaller;">
                                                        Multiply sea night grass fourth day sea lesser rule open subdue

                                                    </p>


                                                    <div class="d-flex justify-content-between">
                                                        <div class="d-flex align-items-center">
                                                            <h5>
                                                                <a href="#">Emilly Blunt</a>
                                                            </h5>
                                                            <p class="date">December 4, 2017 at 3:12 pm </p>
                                                        </div>
                                                        <div class="reply-btn">
                                                            <a href="#" class="btn-reply text-uppercase">reply</a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <hr/>
                                        </div>
                                    </div>
                                    <div class="comment-list">
                                        <div class="single-comment justify-content-between d-flex" style="border-bottom: solid 1px bla ;">
                                            <div class="user justify-content-between d-flex">
                                                <div class="thumb">
                                                    <img src="assets/img/blog/comment_1.png" alt="">
                                                </div>
                                                <div class="desc">

                                                    <p class="comment" style="line-height: 16px; font-size: smaller;">
                                                        Multiply sea night grass fourth day sea lesser rule open subdue
                                                        female fill which them

                                                    </p>


                                                    <div class="d-flex justify-content-between">
                                                        <div class="d-flex align-items-center">
                                                            <h5>
                                                                <a href="#">Emilly Blunt</a>
                                                            </h5>
                                                            <p class="date">December 4, 2017 at 3:12 pm </p>
                                                        </div>
                                                        <div class="reply-btn">
                                                            <a href="#" class="btn-reply text-uppercase">reply</a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <hr/>
                                        </div>
                                    </div>
                                </div>
                            </article>

                        </c:forEach>


                        <nav class="blog-pagination justify-content-center d-flex">
                            <ul class="pagination">
                                <li class="page-item">
                                    <a href="#" class="page-link" aria-label="Previous">
                                        <i class="ti-angle-left"></i>
                                    </a>
                                </li>
                                <li class="page-item">
                                    <a href="#" class="page-link">1</a>
                                </li>
                                <li class="page-item active">
                                    <a href="#" class="page-link">2</a>
                                </li>
                                <li class="page-item">
                                    <a href="#" class="page-link" aria-label="Next">
                                        <i class="ti-angle-right"></i>
                                    </a>
                                </li>
                            </ul>
                        </nav>
                    </div>
                </div>
                <!--////////////////////////////////-->

            </div>

        </section>

    </body>
</html>
