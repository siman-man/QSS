$(function() {
	marked.setOptions({
		langPrefix: ''
	})
	
	$("#title").keyup(function(){
		var src = $(this).val();
		
		$("#preview-title").html(src);
	});
	
	$("#editor").keyup(function(){
		var src = $(this).val();
		
		var html = marked(src);
		
		$("#preview").html(html);
		
		$("pre code").each(function(i, block){
			hljs.highlightBlock(block);
		});
	});
});