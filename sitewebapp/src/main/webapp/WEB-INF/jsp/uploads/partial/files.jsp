<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div>

	<a id="fileUploader" href="javascript:;">upload</a>
	
	
	<script>
		
		var Popup = function() {
			
			var left,
				top,
				width = 575,
				height = 325,
				topOffset = screen.height/10,
				props
			;
			
			left = screen.width/2 - width/2;
			top = screen.height/2 - height/2 - topOffset;
			
			props = 'left=' + left + ',top=' + top + ',width=' + width + ',height=' + height + ',toolbar=0,location=0,status=0,menubar=0,resizable=1';
			
			$('#fileUploader').bind('click', function() {
				 var popup = window.open('../fileUploader', 'popup', props);
			});
		}
		
		var p = Popup();
		
	
	</script>
	a list of uploaded files
</div>


