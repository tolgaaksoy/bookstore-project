$('document').ready(function() {

    $('table #editButton').on('click',function(event){
        event.preventDefault();

        var href = $(this).attr('href');

        $.get(href, function(bookstore, status){
            $('#idEdit').val(bookstore.id);
            $('#bookstoreNameEdit').val(bookstore.bookstoreName);
            $('#descriptionEdit').val(bookstore.description);
        });
        $('#editModal').modal();
    });


    $('.table #detailsButton').on('click',function(event) {
        event.preventDefault();

        var href= $(this).attr('href');

        $.get(href, function(bookstore, status){
            $('#idDetails').val(bookstore.id);
            $('#bookstoreNameDetails').val(bookstore.bookstoreName);
            $('#bookstoreDescriptionDetails').val(bookstore.description);
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
