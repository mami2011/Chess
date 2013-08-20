// When mouse over show the help message
$(document).ready(function(){
  $("#emailId").focusin(function(){
    $("#email-info").css({
    	"display":"inline",
    	"color": "#8A8A93"});
  });
});

$(document).ready(function(){
  $("#emailId").focusout(function(){
    $("#email-info").css("display","none");
  });
});

$(document).ready(function(){
  $("#password").focusin(function(){
    $("#pwd-info").css({
    	"display":"inline",
    	"color": "#8A8A93"});
  });
});

$(document).ready(function(){
  $("#password").focusout(function(){
    $("#pwd-info").css("display","none");
  });
});

$(document).ready(function(){
  $("#confirmpassword").focusin(function(){
    $("#conf-pwd-info").css({
    	"display":"inline",
    	"color": "#8A8A93"});
  });
});

$(document).ready(function(){
  $("#confirmpassword").focusout(function(){
    $("#conf-pwd-info").css("display","none");
  });
});