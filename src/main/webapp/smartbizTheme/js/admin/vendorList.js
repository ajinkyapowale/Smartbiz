$('document').ready(function(){

	var selectedVendors;
	var selectedVendor;

	/*var dataTbl = $('#vendorTbl').DataTable({
		"columnDefs": [ {
			"targets": [ 0, 1 ],
			"orderable": false,
			"visible": false,
			"searchable": false
		} ]
	});
	 */
	$("#vendorForm").validate({
		rules: {
			name: {
				required: true,
				maxlength: 30
			}
			/*email: {
				required: true,
				email: true
			}*/
		}
	});

	$('#vendorFormModal').on('show.bs.modal', function (event) {

		if (event.hasOwnProperty('relatedTarget') && event.relatedTarget.id == 'addVendorBtn'){
			$(this).find('#vendorFormModalLabel').text('Add new vendor');
		}

		$('.floatingActionPanel').fab({action:"closeActionDrawer"});
	});
	$('#vendorFormModal').on('hide.bs.modal', function (event) {
		$(this).find('input,textarea').val("");  // Very important to avoid data inconsistencies
	});

	$('#saveVendorBtn').on('click',function(){
	//$('#vendorForm').on('submit',function(){

		var vendor;
		// If vid is not present that means we need to modify the selected vendor or else create a new blank vendor object
		if ($('#vendorFormModal .modal-body input[type="hidden"][name="vid"]').val()==""){ 
			vendor = {};
		}else{
			vendor = selectedVendor;
		}
		// Sets vendor properties to corresponding inputs
		$('#vendorFormModal .modal-body input').each(function(key,value) {
			var field = $(this).attr('name');
			vendor[field] = $(this).val();
		});

		console.log("Sending "+JSON.stringify(vendor));

		var saveVendor = ajaxService (JSON.stringify(vendor), 'saveVendor', 'POST');

		saveVendor.then (function(response){ // Ajax success

			var vendor = response;
			var srNo = ($('#vendorTbl tbody tr').length)+1;
			var doj = new Date(vendor.createdOn);
			var month = (doj.getMonth() + 1).length==2?(doj.getMonth() + 1):"0"+(doj.getMonth() + 1);
			var day = doj.getDate().length==2?doj.getDate():"0"+doj.getDate();

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
			"<td>" +day + '/' + month +	'/' +  doj.getFullYear()+"</td></tr>";

			// Replace existing row if edited or add new row in the end
			if ($('#vendorTbl tbody tr[vid="'+vendor.vid+'"]').length == 0){
				$('#vendorTbl tbody').append(newRow);
				//var jRow = parseHTML(newRow);
				//dataTbl.row.add(jRow).draw();
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

		function(error){ // Ajax Error

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
		});

	});

	$('#editVendorBtn').on('click',function(){
		$('.multiSelect').hide();
		$('.singleSelect').show();
		$('.floatingActionPanel').fab({action:"openConfirmationDrawer",callback:editVendor});
	});

	$('#deleteVendorBtn').on('click',function(){
		$('.singleSelect').hide();
		$('.multiSelect').show();
		$('.floatingActionPanel').fab({action:"openConfirmationDrawer",callback:deleteVendors});

	});

	$('.floatingCancelButton').on('click',function(){
		$('.singleSelect, .multiSelect').hide();
		$('.floatingActionDrawerButton').show();
		$('.floatingActionPanel').fab({action:"closeConfirmationDrawer"});
		$('input[type=checkbox][name=selectedVendors], input[type=radio][name=selectedVendor]').prop('checked',false);
		jcf.refresh('input[type=checkbox][name=selectedVendors], input[type=radio][name=selectedVendor]');
	});

	$( "#vendorTbl tbody" ).on( "change", "input[type=radio][name=selectedVendor]", function( event ) {
		var selectedItems = $('input[type=radio][name=selectedVendor]:checked').length;
		if (selectedItems == 0) {
			$('.floatingConfirmButton').addClass('disabled');
		}
		else {
			$('.floatingConfirmButton').removeClass('disabled');
		}
	});

	$( "#vendorTbl tbody" ).on( "change", "input[type=checkbox][name=selectedVendors]", function( event ) {
		var selectedItems = $('input[type=checkbox][name=selectedVendors]:checked').length;
		if (selectedItems == 0) {
			$('.floatingConfirmButton').addClass('disabled');
		}
		else {
			$('.floatingConfirmButton').removeClass('disabled');
		}
	});

	function deleteVendors(){
		selectedVendors = [];
		var vNames = getCommaSeperatedListOfAttr ($('input[type=checkbox][name=selectedVendors]:checked'), "vname");
		selectedVendors = vNames.list;
		$( "#vendorTbl tbody tr" ).removeClass("markRemove");
		$('input[type=checkbox][name=selectedVendors]:checked').closest('tr').addClass('markRemove');

		$('#modalVendorName').text(vNames.str);
		$('#deleteVendorWarning').modal();
	}

	$('#deleteVendorConfirmBtn').on('click',function(){
		console.log("Sending "+JSON.stringify(selectedVendors));

		var deleteVendor = ajaxService (JSON.stringify(selectedVendors), 'deleteVendors', 'POST');
		deleteVendor.then (function(response){ // ajax success

			console.log (response);
			$('.markRemove').remove();
			var idx=1; 
			$('#vendorTbl tbody tr td:nth-child(3)').each(function(){
				$(this).text(idx++);
			});
			$('.multiSelect').hide();
			$('.floatingActionPanel').fab({action:"closeConfirmationDrawer"});

			$('#deleteVendorWarning').modal('hide');

			$('#pageAlert').addClass("alert-success");
			$('#pageAlert').empty().append('<strong>Success!</strong> "'+$('#modalVendorName').text()+'" deleted.');

			$('#pageAlert').fadeIn ("slow", function(){
				setTimeout(function(){
					$('#pageAlert').fadeOut ("fast");
					$('#pageAlert').removeClass("alert-success");
				}, 2000);
			});

		}, function(error){ //ajax error

			console.log(error);
			$('#vendorFormModal').modal('hide');
			$('#pageAlert').addClass("alert-danger");
			$('#pageAlert').empty().append('<strong>Error!</strong> Unable to delete Vendors "'+$('#modalVendorName').text()+'".');

			$('#pageAlert').fadeIn ("slow", function(){
				setTimeout(function(){
					$('#pageAlert').fadeOut ("fast");
					$('#pageAlert').removeClass("alert-danger");
				}, 2000);
			});

		});
	});

	function editVendor(){
		var selectedVid = $('input[type=radio][name=selectedVendor]:checked').val();
		console.log("Editing "+JSON.stringify(selectedVid));

		var editVendor = ajaxService (JSON.stringify(selectedVid), 'getVendor', 'POST');
		editVendor.then (function(response){ // ajax success

			console.log (response);
			selectedVendor = response;

			/*var doj = new Date(vendor.createdOn);
			var month = (doj.getMonth() + 1).length==2?(doj.getMonth() + 1):"0"+(doj.getMonth() + 1);
			$('#vendorViewModal .modalVendorName').text(vendor.name);
			vendor.createdOn = doj.getDate() + '/' + month +	'/' +  doj.getFullYear();*/

			// Sets vendor properties to corresponding form labels
			$('#vendorFormModal .modal-body input').each(function(key,value) {
				var field = $(this).attr('name');
				var value = selectedVendor[field];
				$(this).val(value);
			});

			$('#vendorFormModal #vendorFormModalLabel').text('Edit vendor - '+selectedVendor.name);
			$('#vendorFormModal').modal('show');

		}, function(error){ //ajax error

			console.log(error);
			$('#pageAlert').addClass("alert-danger");
			$('#pageAlert').empty().append('<strong>Error!</strong> Unable to Edit requested vendor.');

			$('#pageAlert').fadeIn ("slow", function(){
				setTimeout(function(){
					$('#pageAlert').fadeOut ("fast");
					$('#pageAlert').removeClass("alert-danger");
				}, 2000);
			});

		});

	}

	$('.floatingActionDrawerButton').on('click', function(){
		$('.floatingActionPanel').fab({action:"toggleActionDrawer"});
	});

	$( "#vendorTbl tbody" ).on( "click", "td:nth-child(n+3)", function( event ) { // Bind click event on all cells except first 2
		event.stopPropagation();

		var selectedVid = $(this).closest('tr').attr('vid');
		console.log(selectedVid );

		var vendorDetails = ajaxService (JSON.stringify(selectedVid), 'getVendor', 'POST');
		vendorDetails.then (function(response){ // ajax success

			console.log (response);
			var vendor = response;

			var doj = new Date(vendor.createdOn);
			var month = (doj.getMonth() + 1).length==2?(doj.getMonth() + 1):"0"+(doj.getMonth() + 1);
			var day = doj.getDate().length==2?doj.getDate():"0"+doj.getDate();

			$('#vendorViewModal .modalVendorName').text(vendor.name);
			vendor.createdOn = day + '/' + month +	'/' +  doj.getFullYear();

			// Sets vendor properties to corresponding form labels
			$('#vendorViewModal .formValue').each(function(key,value) {
				var field = $(this).attr('id');
				var value = vendor[field];
				$(this).text(value);
			});

			$('#vendorViewModal').modal('show');

		},
		function(error){ // ajax error

			console.log(error);
			$('#pageAlert').addClass("alert-danger");
			$('#pageAlert').empty().append('<strong>Error!</strong> Unable to show requested vendor.');

			$('#pageAlert').fadeIn ("slow", function(){
				setTimeout(function(){
					$('#pageAlert').fadeOut ("fast");
					$('#pageAlert').removeClass("alert-danger");
				}, 2000);
			});

		});

	});
});