var app = angular.module('validationApp');

app.controller("menuCtrl", function($scope) {
    console.log("MENU CONTROLLER!");
    var mc = this;

    mc.navOptions = [
        'home',
        'results',
        'history'
    ];

    // Make 'Home' menu option active
    mc.selectedIndex = 0;

    // Updates 'active' menu option
    mc.select = function(i) {
        mc.selectedIndex = i;
    };

});