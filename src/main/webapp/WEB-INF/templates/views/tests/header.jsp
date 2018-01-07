<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

  <script type="text/javascript">
  function doSearch() {
	//make request to server

	$.getJSON("booksSearch.do",{ CHARS: $('#searchBox').val()},
	function(data) {
		
		$('#results').text('');
		
		for(var index in data) {
			$('#results').append('<p>' + data[index].title +'</p>')
		}
		});
		
		
	
}
  </script>

