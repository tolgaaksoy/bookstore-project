
$('document').ready(function(){
	
	$('table #editButton').on('click',function(event){
		event.preventDefault();
			
		var href = $(this).attr('href');
		
		$.get(href, function(book, status){
			$('#idEdit').val(book.id);
			$('#cityEdit').val(book.bookName);
			$('#addressEdit').val(book.bookSubName);
			$('#isbnEdit').val(book.isbn);
			$('#ddlBookstoreEdit').val(book.bookstoreid);
			$('#ddlAuthorEdit').val(book.authorid);
			$('#descriptionEdit').val(book.description);
		});					
		$('#editModal').modal();
	});
	
	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(book, status){
			$('#idDetails').val(book.id);
			$('#bookNameDetails').val(book.bookName);
			$('#bookSubNameDetails').val(book.bookSubName);
			$('#isbnDetails').val(book.isbn);
			$('#ddlAuthorDetails').val(book.authorid);
			$('#ddlBookstoreDetails').val(book.bookstoreid);
			$('#descriptionDetails').val(book.description);
			// $('#lastModifiedByDetails').val(book.lastModifiedBy);
			// $('#lastModifiedDateDetails').val(book.lastModifiedDate.substr(0,19).replace("T", " "));
		});			
		$('#detailsModal').modal();		
	});

	$('.table #deleteButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModal #delRef').attr('href', href);
		$('#deleteModal').modal();
	});
});