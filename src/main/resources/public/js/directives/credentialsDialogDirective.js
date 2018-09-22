var app = angular.module('validationApp');

app.directive('showCredentialsDialogButton', function() {
    return {
        restrict: 'EA',
        controller: 'dialogCtrl',
        controllerAs: 'dCtrl',
        template: '<md-button class="popup-btn" ng-click="dCtrl.openDialog()">Run</md-button>'
    };
});