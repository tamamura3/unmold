//////////////////////////////////////////////////////////////REGISTER
function validateUserForm() {
	// MAIL
	var mail = document.forms.userForm.mail.value;
	if (mail === null || mail == "") {
		alert("Mail address must be filled out.")
		return false;
	}
	if (!validateMail(mail)) {
		alert("Mail address is not valid.")
		return false;
	}
	if (mail.length >= 200) {
		alert("Mail address is too long...")
		return false;
	}
	// NAME
	var username = document.forms.userForm.name.value;
	if (username === null || username === "") {
		alert("Name must be filled out.")
		return false;
	}
	if (!validate(username)) {
		alert("Letters[A-Z], Numbers[0-9] and Underscore[_] can be used in Name)")
		return false;
	}
	if (username.length >= 15) {
		alert("Username cannot be longer than 15 characters")
		return false;
	}
	// PASSWORD
	var password = document.forms.userForm.password.value;
	if (password === null || password === "") {
		alert("password must be filled out.")
		return false;
	}
	if (password.length >= 50) {
		alert("Your password is too long!")
		return false;
	}
	return true;
}

// MAIL ADDRESS OR NOT
function validateMail(mail) {
	// メールアドレス判別の決まり文句
	var regex = /^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/;
	var regex2 = /^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}\.[a-zA-Z]{2,3}$/;
	// testはマッチしたらtrueを返す
	var addresPattern1 = regex.test(mail);
	var addresPattern2 = regex2.test(mail);
	if(addresPattern1 || addresPattern2){
		return true;
	}
}

// MADE OF [A-Za-z0-9_] OR NOT
function validate(name) {
	var regex = /\w/g; // \w == [A-Za-z0-9_]
	return regex.test(name);
}

// ////////////////////////////////////////////////////////////REVIEW
function validateReviewForm() {
	var reviewText = document.forms.reviewForm.text.value;
	if (reviewText === null || reviewText === "") {
		alert("Review text must be filled out.");
		return false;
	}
	if (reviewText.length >= 3500) {
		alert("Sorry, Your review is too long!")
		return false;
	}
	return true;
}

// ////////////////////////////////////////////////////////////CONTACT
function validateContactForm() {
	// NAME
	var name = document.forms.contactForm.name.value;
	if (name === null || name === "") {
		alert("Name must be filled out.");
		return false;
	}
	if (!validate(name)) {
		alert("Letters[A-Z], Numbers[0-9] and Underscore[_] can be used in Name.")
		return false;
	}
	if (name.length >= 15) {
		alert("Name cannot be longer than 15 characters.")
		return false;
	}
	// MAIL
	var mail = document.forms.contactForm.mail.value;
	if (mail === null || mail == "") {
		alert("Mail address must be filled out.")
		return false;
	}
	if (!validateMail(mail)) {
		alert("Mail address is not valid.")
		return false;
	}
	if (mail.length >= 200) {
		alert("Mail address is too long...")
		return false;
	}
	// TEXT
	var contactText = document.forms.contactForm.text.value;
	if (contactText === null || contactText === "") {
		alert("Review text must be filled out.");
		return false;
	}
	if (contactTexts.length >= 3500) {
		alert("Sorry, Your text is too long!")
		return false;
	}
	return true;
}
// ////////////////////////////////////////////////////////////EDIT MAIL AND
// PASSWORD
function validateEditInfo() {

	var mail = document.forms.editForm.mail.value;
	if (mail === null || mail == "") {
		alert("Mail address must be filled out.")
		return false;
	}
	if (!validateMail(mail)) {
		alert("Mail address is not valid.")
		return false;
	}
	if (mail.length >= 200) {
		alert("Mail address is too long...")
		return false;
	}

	var password = document.forms.editForm.passwordForEditMail.value;
	if (password === null || password === "") {
		alert("password must be filled out.")
		return false;
	}
	if (password.length >= 50) {
		alert("Your password is too long!")
		return false;
	}
	return true;
}
// EDIT PASSWORD
function validateEditPassword() {
	var currentPassword = document.forms.editPasswordForm.currentPassword.value;
	if (currentPassword === null || currentPassword === "") {
		alert("password must be filled out.")
		return false;
	}
	if (currentPassword.length >= 50) {
		alert("Your password is too long!")
		return false;
	}
	var newPassword = document.forms.editPasswordForm.newPassword.value;
	var newPassword2 = document.forms.editPasswordForm.newPassword2.value;
	if (!(newPassword === newPassword2)) {
		alert("Enter same new password");
		return false;
	}
	if (newPassword === null || newPassword === "") {
		alert("password must be filled out.")
		return false;
	}
	if (newPassword.length >= 50) {
		alert("Your password is too long!")
		return false;
	}
	if (newPassword2 === null || newPassword2 === "") {
		alert("password must be filled out.")
		return false;
	}
	if (newPassword2.length >= 50) {
		alert("Your password is too long!")
		return false;
	}
	return true;
}

// ////////////////////////////////////////////////////////////RESET
// PASSWORD(input mail to send reset-mail)

function validateResetPassword() {
	var mail = document.forms.mailForResetPassword.mail.value;

	var mail = document.forms.editForm.mail.value;
	if (mail === null || mail == "") {
		alert("Mail address must be filled out.")
		return false;
	}
	if (!validateMail(mail)) {
		alert("Mail address is not valid.")
		return false;
	}
	if (mail.length >= 200) {
		alert("Mail address is too long...")
		return false;
	}
	return true;
}

// ////////////////////////////////////////////////////////////INPUT NEW
// PASSWORD

function validateNewPassword() {
	var password = document.forms.newPassForm.password.value;
	if (password === null || password === "") {
		alert("password must be filled out.")
		return false;
	}
	if (password.length >= 50) {
		alert("Your password is too long!")
		return false;
	}

	return true;
}

// ////////////////////////////////////////////////////////////DELETE REVIEW
// CONFIRM

function confirmDeleteReview() {
	var result = window.confirm("Are you sure you want to delete this review?");
	if (result) {
		return true;
	} else {
		return false;
	}
}

//////////////////////////////////////////////////////////////DELETE REVIEW
//CONFIRM

function confirmRemoveChallenge() {
	var result = window.confirm("Are you sure you want to remove this challenge from your list?");
	if (result) {
		return true;
	} else {
		return false;
	}
}

//////////////////////////////////////////////////////////////LOGOUT
//CONFIRM

function confirmLogout() {
	var result = window.confirm("Are you sure you want to log out?");
	if (result) {
		return true;
	} else {
		return false;
	}
}

//////////////////////////////////////////////////////////////DROPDOWN MENU

//ドロップダウンコンテンツのクラスにshowを加えたり消したりする
//今のドロップダウンコンテンツのクラスの状態をstateに格納
//もしshowが追加された状態（ドロップが開かれている）なら、キャンセルの画像に切り替え
//もしshowなしならハンバーガーのアイコンに
function dropdown(){
	document.getElementById("dropdown-wrapper-id").classList.toggle("show");
	var state = document.getElementById("dropdown-wrapper-id");
	if(state.className === "dropdown-wrapper show"){
		document.getElementById("dropbtn-icon-id").src = "/GetOut/image/cancel.png";
	}else{
		document.getElementById("dropbtn-icon-id").src = "/GetOut/image/hamburger.png";
	}
}

//あとでやる
window.onclick = function(event) {
	  if (!event.target.matches('.dropbtn-icon')) {

	    var dropdowns = document.getElementsByClassName("dropdown-wrapper");
	    var i;
	    for (i = 0; i < dropdowns.length; i++) {
	      var openDropdown = dropdowns[i];
	      if (openDropdown.classList.contains('show')) {
	        openDropdown.classList.remove('show');
	        document.getElementById("dropbtn-icon-id").src = "/GetOut/image/hamburger.png";
	      }
	    }
	  }
	}

// ////////////////////////////////////////////////////////////OTHER

function confirmSignout() {
	return false;
}