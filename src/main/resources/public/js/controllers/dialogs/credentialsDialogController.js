var app = angular.module('validationApp');

app.controller("dialogCtrl", function() {
    var dc = this;

    var numOfPieces = 36;
    var popup, popupsCont;
    var frag = document.createDocumentFragment();

    dc.init = function() {
        console.log("Dialog Init Method!");
        for (var i = 1; i <= numOfPieces; i++) {
            var piece = document.createElement('div');
            piece.classList.add('popup__piece');
            insertInnerPieces(piece, 3);
            frag.appendChild(piece);
        }
        document.querySelector('.popup__pieces').appendChild(frag);

        popupsCont = document.querySelector('.popups-cont');
        popup = document.querySelector('.popup');
    };

    dc.openDialog = function() {
        dc.init();
        popupsCont.classList.add('s--popup-active');
        popup.classList.add('s--active');
    };

    dc.closeDialog = function() {
        popupsCont.classList.remove('s--popup-active');
        popup.classList.remove('s--active');
        popup.classList.add('s--closed');
        setTimeout(function() { popup.classList.remove('s--closed'); }, 900);
    };

    function insertInnerPieces(element, innerPieces) {
        for (var i = 0; i < innerPieces; i++) {
            var inner = document.createElement('div');
            inner.classList.add('popup__piece-inner');
            element.appendChild(inner);
        }
    }
});