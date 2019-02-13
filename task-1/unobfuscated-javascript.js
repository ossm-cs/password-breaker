/*
Hey! If you're here but you haven't completed the task in `very-insecure-website.html`,
do that first and come back later.

This is the unobfuscated JavaScript that is in the HTML file, in the line that
starts with `var _0x4ac4=....`. It's here if you want to look at it.
The password and secret keys here are not the same as the ones in the task.

Plug this in to https://obfuscator.io and the result is what's in the HTML thing

Author: Sam Bird
Date: 12 February 2019
*/
var correct = '<whatever the password is>';
function getKey(password) {
  if (password == correct) {
    return '<whatever the secret key is>';
  } else {
    return 'Sorry, that\'s not the right password.'
  }
}

function readInputAndDoThing() {
  var input = document.getElementById('password-entry').value;
  var output = getKey(input);
  document.getElementById('result').innerText = output;
  return false;
}

window.onload = function () {
  document.getElementById('myForm').onsubmit = readInputAndDoThing;
  document.getElementById('submit-password').onclick = readInputAndDoThing;
}