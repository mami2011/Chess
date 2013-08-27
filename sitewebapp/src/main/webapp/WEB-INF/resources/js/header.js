// Set current page in top-nav
(function() {
	var topNav = $('.hdr .topnav'),
		location = document.location.href, 
		link
	;
	
	if (location.indexOf('accounthub') > 0) {
		link = topNav.find('.accounthub');
		if (link) {
			link.addClass('curr');
		}
	}
})();

// Language menu
(function() {
	var _menu = $('#languageMenu');
	
	$('#langBtn').bind('click', function(evt) {
		if (_menu.is(':visible')) {
			_menu.hide();
		}
		else {
			_menu.show();
		}
		return false;
	});

	$('body').bind('click', function(evt) {
		if (_menu.is(':visible') && evt.target.id!=='languageMenu') {
			_menu.hide();
		}
	});
	
})();

// Profile dropdown menu
(function() {
	var _menu = $('#profileMenu');
	
	$('#profileBtn').bind('click', function(evt) {
		if (_menu.is(':visible')) {
			_menu.hide();
		}
		else {
			_menu.show();
		}
		return false;
	});

	$('body').bind('click', function(evt) {
		if (_menu.is(':visible') && evt.target.id!=='profileMenu') {
			_menu.hide();
		}
	});
	
})();