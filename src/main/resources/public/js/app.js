var app = angular.module('validationApp', ['ngRoute', 'ngResource', 'ngAnimate', 'ngAria', 'ngMaterial', 'ngMessages']);

// Global Constants
app.constant(
        "CONSTANTS", {
            "regions": [
                {name:"REGION1", value:"REGION1"},
                {name:"REGION2", value:"REGION2"},
                {name:"REGION3", value:"REGION3"}
            ],
            "applications": [
                {name:"APP1", value:"APP1"},
                {name:"APP2", value:"APP2"},
                {name:"APP3", value:"APP3"}
            ],
            "types": [
                {name:"Property", value:"env"},
                {name:"Config",   value:"config"},
                {name:"Firewall", value:"telnet"},
                {name:"Build #",  value:"build"},
                {name:"Start Up", value:"open"}
            ]
        }
    );


// URL Routing
app.config(function($routeProvider, $locationProvider) {
    $routeProvider
        .when("/home", {
            templateUrl: "views/home.html",
            controller: "homeCtrl as hCtrl"
        })
        .when("/history", {
            templateUrl: "views/history.html",
            controller: "historyCtrl as hsCtrl"
        })
        .when("/results", {
            templateUrl: "views/results.html",
            controller: "resultsCtrl as rCtrl"
        })
        .otherwise({ "redirectTo": "/home" });

    $locationProvider.html5Mode(true);
});

// Application Theme
app.config(function($mdIconProvider, $mdThemingProvider) {

    $mdIconProvider.fontSet('md', 'material-icons');

    var greyMap = $mdThemingProvider.extendPalette("blue-grey", {
        "500": "#37474F",
        "800": "#3E5360"
    });

    var orangeMap = $mdThemingProvider.extendPalette("deep-orange", {
        "A200": "#FB8C00",
        "100": "rgba(89, 116, 130, 0.2)"
    });

    $mdThemingProvider.definePalette("myGrey", greyMap);
    $mdThemingProvider.definePalette("myOrange", orangeMap);

    $mdThemingProvider.theme("default")
        .primaryPalette("myGrey")
        .accentPalette("myOrange");
});