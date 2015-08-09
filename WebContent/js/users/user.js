/*GET*/
function signIn() {
    var userName = jQuery("#userName").val();
    var password = jQuery.trim(jQuery("#password").val());
    var hashPassword = md5(password);
    var url = TBIS_USER_URI + SIGNIN_PATH + "?name=" + userName + "&password=" + hashPassword;
    restGet(url, GET_METHOD, renderSignIn);
}
/*RENDER*/
function renderCreate(data) {
    jQuery('#resultDiv').html("id=" + data.userId);
}
function renderUpdate(data) {
    var usersDiv = jQuery("#usersDiv");
    usersDiv.html("<div><span style='width:100px;display:inline-block;'>User ID</span>");
    usersDiv.append("<span style='width:100px;display:inline-block;'>User Name</span>");
    usersDiv.append("<span style='width:100px;display:inline-block;'>User Role</span></div>");
    usersDiv.append("<div><span style='width:100px;display:inline-block;'>");
    usersDiv.append(data.userId);
    usersDiv.append("</span><span style='width:100px;display:inline-block;'>");
    usersDiv.append(data.userName);
    usersDiv.append("</span><span style='width:100px;display:inline-block;'>");
    usersDiv.append(data.userRole);
    usersDiv.append("</span></div>");
}
function renderSignIn(data) {
    if (data.id != null && data.name != null && data.role != null) {
        storage.setItem("userId", data.id);
        storage.setItem("userName", data.name);
        storage.setItem("userRole", data.role);
        window.location.href = "index.html";
    } else {
        //TODO
    }
}