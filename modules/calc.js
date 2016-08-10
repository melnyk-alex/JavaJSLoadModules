// import
var App = Java.type('ua.com.codefire.jsloader.App');

// body
var app = new App();
app.name = 'Calc JS module.';
app.description = 'Simple calculator JS module.';
app.main = 'main';

function main() {
    print("a + b = c");
    var a = 3, b = 6;
    var c = a + b;
    print(a, b, c)
}