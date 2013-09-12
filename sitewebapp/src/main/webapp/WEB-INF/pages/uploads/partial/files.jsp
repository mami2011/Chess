<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div>

	<a id="fileUploader" href="javascript:;">upload</a>
	
	
	<script>
		
		var Popup = function() {
			
			var left,
				top,
				width = 575,
				height = 325,
				props
			;

			$('#fileUploader').bind('click', function() {
				
				wLeft = window.screenLeft ? window.screenLeft : window.screenX;
				wTop = window.screenTop ? window.screenTop : window.screenY;
				
				left = wLeft + (window.innerWidth/2) - (width/2);
				top = wTop + (window.innerHeight/2) - (height/2);
				
				// Prevent top of popup from being above parent window
				if (top < wTop) {
					top = wTop;
				}
				
				props = 'left=' + left + ',top=' + top + ',width=' + width + ',height=' + height + ',toolbar=0,location=0,status=0,menubar=0,resizable=1';
				
				 var popup = window.open('../fileUploader', 'popup', props);
			});
		}
		
		var p = Popup();
		
	
	</script>
	a list of uploaded files
</div>


