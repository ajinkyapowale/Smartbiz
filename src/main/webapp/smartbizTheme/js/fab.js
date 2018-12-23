/*
 * 
 * fab 1.0 - Floating buttons for Smartbiz
 * Version 1.0
 * 
 * Date: 26th July 2018
 *
 */
/**
 * 
 * @description Creates a floating action panel with flaoting action buttons, speed dial and confirmation buttons
 * 
 * @example $('div').fab();
 * @desc Create a simple popup interface.
 *
 * @option Boolean modal (optional) Boolean flag indicating if popup
 *		   should be closed if its overlay is clicked.
 * 
 * @option String modal (optional).
 *         String "open" indicating popup should open.
 *         String "close" indicating popup should close.
 * 
 * @type jQuery
 * 
 * @name fab
 * 
 * @cat Plugins/fab
 * 
 * @author Ajinkya A. Powale
 *
 **/
(function ( $ ) {
	/*var popups=[]; // Records open popups 
	var popupCount=0;// Records number of open popups 
	var popupContent;// Records links, buttons, inputs in the active popup
	
	var keycodes = {
		BACKSPACE: 8,
		COMMA: 188,
		DELETE: 46,
		DOWN: 40,
		END: 35,
		ENTER: 13,
		ESCAPE: 27,
		HOME: 36,
		LEFT: 37,
		PAGE_DOWN: 34,
		PAGE_UP: 33,
		PERIOD: 190,
		RIGHT: 39,
		SPACE: 32,
		TAB: 9,
		UP: 38
	};*/
	
	
	
	$.fn.fab = function ( options ) {
		'use strict';
		var settings = $.extend({
            // Default settings
			/*action:"",
			callback:""*/
        }, options );
		
		var settings = options;
		
		function openActionDrawer(){
			closeConfirmationDrawer();
			$('.floatingActionDrawerButton').addClass('animateFABDrawer');
			$('.floatingActionButton').show();
		}
		
		function closeActionDrawer(){
			$('.floatingActionDrawerButton').removeClass('animateFABDrawer');
			$('.floatingActionButton').hide();
		}
		
		function toggleActionDrawer(){
			if ($('.floatingActionDrawerButton').hasClass('animateFABDrawer')){
				closeActionDrawer();
			}else{
				openActionDrawer();
			}
		}
		
		function openConfirmationDrawer(){
			closeActionDrawer();
			$('.floatingActionDrawerButton').hide();
			$('.floatingConfirmButton').addClass('disabled');
			$('.floatingConfirmButton, .floatingCancelButton').show();
			$('.floatingConfirmButton').on('click',function(){
				if (!$(this).hasClass("disabled")){
					settings.callback.call(settings.callback.arguments);
				}
			});
		}
		function closeConfirmationDrawer(){
			$('.floatingConfirmButton, .floatingCancelButton').hide();
			$('.floatingActionDrawerButton').removeClass('animateFABDrawer').show();
			$('.floatingConfirmButton').off('click');
		}
		
		function toggleConfirmationDrawer(){
			if ($('.floatingActionDrawerButton').css('display')=='none'){
				closeConfirmationDrawer();
			}else{
				openConfirmationDrawer();
			}
		}
		
		if (settings.action=="openActionDrawer"){
			openActionDrawer();
		}
		else if(settings.action=="closeActionDrawer"){
			closeActionDrawer();
		}
		else if(settings.action=="toggleActionDrawer"){
			toggleActionDrawer();
		}
		else if(settings.action=="openConfirmationDrawer"){
			openConfirmationDrawer();
		}
		else if(settings.action=="closeConfirmationDrawer"){
			closeConfirmationDrawer();
		}
		else if(settings.action=="toggleConfirmationDrawer"){
			toggleConfirmationDrawer();
		}
		return this;
	};
	

}( jQuery ));



