function getUrl(){
    var baseUrl = $("meta[name=baseUrl]").attr("content")
    return baseUrl + "/api/employee";
}

function addEmployee(event){

    var $form = $("#employee-create-form");
    var json = toJson($form);


    console.log(json);
    var url = getUrl();
    $.ajax({
       url: url,
       type: 'POST',
       contentType: "application/json; charset=utf-8",
       data: json,
       success: function(response){
           alert("Employee created successfully");
           getEmployeeList();
       },
       error: function(jqXHR, textStatus, errorThrown){
            console.log(textStatus, errorThrown);
           alert("An error has occurred");
       }
    })

    return false;
}


function updateEmployee(event){

    var $form = $("#employee-update-form");
    var json = toJson($form);

    var url = getUrl();
    $.ajax({
        url: url,
        type: 'PUT',
        data: json,
        success: function(response){
            console.log("Employee updated");
            getEmployeeList();
        },
        error: function(){
            alert("An error has occurrsed");
        }
    })


}

function deleteEmployee(id){
    var url = getUrl();
    $.ajax({
        url: url+ '/'+id,
        type: 'DELETE',
        success: function(data){
            console.log("Employee deleted");
            getEmployeeList();
        },
        error: function(){
            alert("An error has ocurred");
        }
    });
}

function getEmployeeList(){
    var url = getUrl();
    console.log(url);
    $.ajax({
        url: url,
        type: 'GET',
        success: function(response){
            console.log("Employee data fetched");
            displayEmployeeList(response);
        },
        error: function(){
            alert("An error has occurred");
        }
     })

}


// Init
function init(){
    $('#add-employee').click(addEmployee);
    $('#refresh-data').click(getEmployeeList);
}

$(document).ready(init);
$(document).ready(getEmployeeList);

// UI 

function displayEmployeeList(data){
    var $tbody = $('#employee-table').find('tbody');
    $tbody.empty();
//    var obj = JSON.parse(data);
    for(var i in data){
        var e = data[i];
        console.log(e);
        var buttonHtml = '<button onclick="deleteEmployee('+e.id +')">delete</button>';
        var hrefHtml = '<a href="update.html">Update employee</a>';
        var row = '<tr>'
		+ '<td>' + e.id + '</td>'
		+ '<td>' + e.name + '</td>'
		+ '<td>'  + e.age + '</td>'
		+ '<td>' + buttonHtml + "|" + hrefHtml + '</td>'
		+ '</tr>';
    $tbody.append(row);
    }
}


// Helper
function toJson($form){
    var serialized = $form.serializeArray();
    console.log(serialized);
    var data = {};
    for(var s in serialized){
        data[serialized[s]['name']] = serialized[s]['value'];
    }

    console.log(typeof(data));
    var json = JSON.stringify(data);
    console.log(json);
    return json;
}

