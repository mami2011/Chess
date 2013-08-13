
// When language menu is changed, form is submitted to set the language
(function() {
	var _form, _menu = $('#home-header-lang-menu');
	if (_menu) {
		_menu.bind('change', function() {
			_form = $(this).closest('form');
			if (_form) {
				_form.submit();
			}
		});
	}
})();