(function ($) {
    "use strict";
	/*---------------------
   	Testimonial Carousel
	--------------------- */
	$(".testimonial-wrap").owlCarousel({

	    autoPlay: 5000, //Set AutoPlay to 5 seconds
	    singleItem: true,
	    transitionStyle : "backSlide",
	    autoHeight: true,
	    pagination: false,
	    navigation: true,
	    stopOnHover: true,
	    navigationText: ["<i class='fa fa-angle-left'></i>","<i class='fa fa-angle-right'></i>"]
	});
	/*--------------------
	Slider Carousel
	----------------------*/
	$(".slider-section").owlCarousel({
	 
	      navigation : true, // Show next and prev buttons
	      slideSpeed : 300,
	      pagination: false,
	      paginationSpeed : 400,
	      singleItem:true,
	      transitionStyle : "fade",
	 	  navigationText: ["<i class='fa fa-angle-left'></i>","<i class='fa fa-angle-right'></i>"]
	  });
	/*---------------------
   	Partners logo Carousel
	--------------------- */
	$(".partners-logo-carosel").owlCarousel({

	    autoPlay: 3000, //Set AutoPlay to 3 seconds
	    items: 5,
	    autoHeight: false,
	    pagination: false,
	    navigation: false,
	    itemsTablet : [768,3]
	});
	/*---------------------
   	Partners logo Carousel
	--------------------- */
	$(".similar-cat-wrap").owlCarousel({

	    autoPlay: 3000, //Set AutoPlay to 3 seconds
	    items: 4,
	   	pagination: false,
	    navigation: true,
	    navigationText: ["<i class='fa fa-angle-left'></i> Previous","Next <i class='fa fa-angle-right'></i>"]
	});
	/*---------------------
   	Single Property Slider Thumbnail Carousel Init Hear
	--------------------- */
	$("#bx-pager").owlCarousel({
		items: 5,
		itemsTablet: [768,4],
		itemsMobile: [360,2],
	    autoPlay: false, //Set AutoPlay to 3 seconds
	    autoHeight: true,
	    pagination: false,
	    navigation: true,
	    navigationText: ["<i class='fa fa-angle-left'></i>","<i class='fa fa-angle-right'></i>"]
	});
	/*---------------------
   	scrollUp
	--------------------- */	
	$.scrollUp({
        scrollText: '<i class="fa fa-angle-up"></i>',
        easingType: 'linear',
        scrollSpeed: 900,
        animation: 'fade'
    });
    /*-----------------------------------------
    	Property Page Toggle Function
    -------------------------------------------*/ 

    $(".clickable-btn").on("click", function(){
    	$('.toggle-btn.text-center').toggleClass("btn-clicked"); 
        $(".property-query-area.property-page-bg").slideToggle("slow");
    });
	/*--------------------------------------------------
	BX Slider Pager Activation
	----------------------------------------------------*/
    $('.bxslider').bxSlider({
	  pagerCustom: '#bx-pager',
	  auto: true,
	  controls: false
	});
	/*--------------------------------
	Mobile Menu active
	-----------------------------------*/
	$('#mobile-menu').meanmenu();
})(jQuery);