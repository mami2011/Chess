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