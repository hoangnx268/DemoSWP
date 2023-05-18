// $(document).ready(function() {
//     $("#nav-user").click(function() {
//         $("#container-wrap").hide();
//         $("#loading").show();
//         setTimeout(
//             function() {
//                 $.ajax({
//                     url: '../views/view-edit-profile.html',
//                     success: function(result) {
//                         $("#loading").hide();
//                         $("#content-view").html(result);
//                     }
//                 });
//             }, 5000
//         )
//         $("#btn-view-content").css("background-color", "");
//         $("#btn-form-content").css("background-color", "");
//         $("#nav-user").css("background-color", "#eee");
//     });
    
//     $("#btn-view-content").click(function() {
//         $("#loading").show();
//         $("#container-wrap").hide();
//         setTimeout(
//             function() {
//                 $.ajax({
//                     url: '../views/view-view-content.html',
//                     success: function(result) {
//                         $("#loading").hide();
//                         $("#content-view").html(result);
//                     }
//                 });
//             }, 5000
//         )
//         $("#btn-view-content").css("background-color", "#eee");
//         $("#btn-form-content").css("background-color", "");
//         $("#nav-user").css("background-color", "");
//     });

//     $("#btn-form-content").click(function() {
//         $("#loading").show();
//         $("#container-wrap").hide();
//         setTimeout(
//             function() {
//                 $.ajax({
//                     url: '../views/view-form-content.html',
//                     success: function(result) {
//                         $("#loading").hide();
//                         $("#content-view").html(result);
//                     }
//                 });
//             }, 5000
//         )
//         $("#btn-view-content").css("background-color", "");
//         $("#btn-form-content").css("background-color", "#eee");
//         $("#nav-user").css("background-color", "");
//     });

// });

// validation
// Edit Profile
function validateEditProfile() {
    var firstname = document.getElementById('firstname').value;
    var lastname = document.getElementById('lastname').value;
    var phone = document.getElementById('phone').value;
    var description = document.getElementById('description').value;

    if (firstname.length < 3 || firstname.length > 30) {
        alert("Firstname's length are 3 - 30 characters.");
        document.getElementById('firstname').focus();
        return false;

    } else if (lastname.length < 3 || lastname.length > 30) {
        alert("Lastname's length are 3 - 30 characters.");
        document.getElementById('lastname').focus();
        return false;

    } else if (phone.length < 9 || phone.length > 13) {
        alert("Phone's length are 9 - 30 characters");
        document.getElementById('phone').focus();
        return false;

    } else if (description.length > 200) {
        alert("Description's length are under 200 characters.");
        document.getElementById('description').focus();
        return false;
    }
    alert("Update successfully");
    return true;
}

// Add content
function validateAddContent() {
    var title = document.getElementById('title').value;
    var brief = document.getElementById('brief').value;
    var content = document.getElementById('content').value;

    if (title.length < 10 || title.length > 200) {
        alert("Title's length are 10 - 200 characters.");
        document.getElementById('title').focus();
        return false;

    } else if (brief.length < 30 || brief.length > 150) {
        alert("Brief's length are 30 - 150 characters.");
        document.getElementById('brief').focus();
        return false;

    } else if (content.length < 50 || content.length > 1000) {
        alert("Content's length are 50 - 1000 characters.");
        document.getElementById('content').focus();
        return false;
    }
    alert("Input successfully!");
    return true;
}