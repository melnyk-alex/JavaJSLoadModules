// import
var App = Java.type('ua.com.codefire.jsloader.App');

// body
var app = new App();
app.name = 'Test JS module.';
app.description = 'Simple module for testing JS in Java.';
app.main = 'main';

function main() {
    var a = 5;
    print(a);
}