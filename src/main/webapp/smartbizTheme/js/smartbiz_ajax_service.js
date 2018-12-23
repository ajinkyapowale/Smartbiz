var csrfParameter = $("meta[name='_csrf_parameter']").attr("content");
var csrfHeader = $("meta[name='_csrf_header']").attr("content");
var csrfToken = $("meta[name='_csrf']").attr("content");
var headers = {};
headers[csrfHeader] = csrfToken;

//Generic function to make an AJAX call
var ajaxService = function(data, dataURL, requestType) {
    // Return the $.ajax promise
    return $.ajax({
        data: data,
        dataType: 'json',
        url: dataURL,
        type: requestType,
        contentType: 'application/json; charset=utf-8',
        headers: headers
    });
}





/*$.ajax({
	type: 'POST',
	url: ,
	headers: headers,
	dataType: 'json',
	data: JSON.stringify(vendor),
	contentType: 'application/json; charset=utf-8',
	success: function(response) {
		var vendor = response;
		var srNo = ($('#vendorTbl tbody tr').length)+1;
		var doj = new Date(vendor.createdOn);
		var month = (doj.getMonth() + 1).length==2?(doj.getMonth() + 1):"0"+(doj.getMonth() + 1);

		$('.singleSelect, .multiSelect').hide();

		var newRow = '<tr vid="'+vendor.vid+'">'+
		'<td class="singleSelect">'+
		'<input type="radio" name="selectedVendor" value="'+vendor.vid+'" vName="'+vendor.name+'"/>'+
		'</td>'+
		'<td class="multiSelect">'+
		'<input type="checkbox" name="selectedVendors" value="'+vendor.vid+'" vName="'+vendor.name+'"/>'+
		'</td>'+
		"<td>" +srNo+"</td>"+
		"<td>" +vendor.name+"</td>"+
		"<td>" +doj.getDate() + '/' + month +	'/' +  doj.getFullYear()+"</td></tr>";

		// Replace existing row if edited or add new row in the end
		if ($('#vendorTbl tbody tr[vid="'+vendor.vid+'"]').length == 0){
			$('#vendorTbl tbody').append(newRow);
		}else {
			var oldSrNo = $('#vendorTbl tbody tr[vid="'+vendor.vid+'"] td:nth-child(3)').text();
			$('#vendorTbl tbody tr[vid="'+vendor.vid+'"]').replaceWith(newRow);
			$('#vendorTbl tbody tr[vid="'+vendor.vid+'"] td:nth-child(3)').text(oldSrNo);
		}

		$('.floatingActionPanel').fab({action:"closeConfirmationDrawer"});

		$('#vendorFormModal').modal('hide');
		jcf.replace ($('input[type=checkbox][value="'+vendor.vid+'"]'));
		jcf.replace ($('input[type=radio][value="'+vendor.vid+'"]'));

		$('#pageAlert').addClass("alert-success");
		$('#pageAlert').empty().append('<strong>Success!</strong> Vendor "'+vendor.name+'" saved.');

		$('#pageAlert').fadeIn ("slow", function(){
			setTimeout(function(){
				$('#pageAlert').fadeOut ("fast");
				$('#pageAlert').removeClass("alert-success");
			}, 2000);
		});

	},
	error: function(error) {
		console.log(error);
		$('#vendorFormModal').modal('hide');
		$('#pageAlert').addClass("alert-danger");
		$('#pageAlert').empty().append('<strong>Error!</strong> Unable to save Vendor "'+vendor.name+'".');

		$('#pageAlert').fadeIn ("slow", function(){
			setTimeout(function(){
				$('#pageAlert').fadeOut ("fast");
				$('#pageAlert').removeClass("alert-danger");
			}, 2000);
		});
	}
});*/