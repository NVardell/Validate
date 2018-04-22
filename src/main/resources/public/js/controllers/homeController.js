var app = angular.module('validationApp');

app.controller("homeCtrl", function($scope, CONSTANTS) {
    console.log("HOME CONTROLLER!");
    var hc = this;

    hc.regions = CONSTANTS.regions;
    hc.apps = CONSTANTS.applications;
    hc.types = CONSTANTS.types;

    hc.queries = [];
    hc.tableQueries = [];
    hc.region;
    hc.app;
    hc.type;
    hc.property;
    hc.expectedValue;


hc.tableQueries.push({region: "REGION1", app: "APP1",   type: "Property", prop: "asdf",  exp: "asdf"});
hc.tableQueries.push({region: "REGION1", app: "APP2", type: "Config",   prop: "1234",  exp: "1234"});
hc.tableQueries.push({region: "REGION2", app: "APP2", type: "Config",   prop: "1",     exp: "2"});
hc.tableQueries.push({region: "REGION2", app: "APP1",   type: "Start Up", prop: "ass",   exp: "hat"});
// hc.tableQueries.push({region: "REGION1", app: "APP1",   type: "Start Up", prop: "spoon", exp: "fork"});
// hc.tableQueries.push({region: "REGION3",   app: "APP3", type: "Build #",  prop: "black", exp: "white"});
// hc.tableQueries.push({region: "REGION1", app: "APP1", type: "Property", prop: "test",  exp: "again"});

    hc.addQuery = function() {
        hc.tableQueries.push({ region: hc.region, app: hc.app, type: hc.type, prop: hc.property, exp: hc.expectedValue});
        // console.log(hc.tableQueries);
        hc.generateRequestObject();
        resetForm();
    };

    hc.deleteQuery = function(index) {
        console.log(index);
        hc.tableQueries.splice(index, 1);
    };

    hc.copyQuery = function(query){
        hc.region = query.region;
        hc.app = query.app;
        hc.type = query.type;
        hc.property = query.prop;
        hc.expectedValue = query.exp;
    };

    hc.generateRequestObject = function(){
        console.log("Generating Request Object");

        angular.forEach(hc.tableQueries, function(query) {
            var regionIndex = hc.queries.map(findRegion).indexOf(query.region);

            var region = hc.queries[regionIndex];

            console.log(regionIndex);

            if(region){
                console.log("Region is in index.");

                var appIndex = region.apps.map(findApp).indexOf(query.app);
                var regionsApp = region.apps[appIndex];

                if(regionsApp) {
                    console.log("Region has app in list.");
                    regionsApp.queries.push({ type: query.type, prop: query.prop, exp: query.exp });
                } else {
                    region.apps.push({ name: query.app, queries: [{ type: query.type, prop: query.prop, exp: query.exp }] });
                }
            } else {
                hc.queries.push({ region: query.region, apps: [{ name: query.app, queries: [{ type: query.type, prop: query.prop, exp: query.exp }] }] });
            }
        });
        console.log("End of Generating Request");
        console.log(hc.queries);

        // Simple sort function example to sort objects in array by property value
        // objs.sort(function(a,b) {return (a.last_nom > b.last_nom) ? 1 : ((b.last_nom > a.last_nom) ? -1 : 0);} ); 
    };

    hc.createRequestObject = function(){
        console.log("Generating Request Object");

        var regionIndex = hc.queries.map(findRegion).indexOf(hc.region);

        var region = hc.queries[regionIndex];

        console.log(regionIndex);

        if(region){
            console.log("Region is in index.");

            var appIndex = region.apps.map(findApp).indexOf(hc.app);
            var regionsApp = region.apps[appIndex];

            if(regionsApp) {
                console.log("Region has app in list.");
                regionsApp.queries.push({ type: hc.type, prop: hc.property, exp: hc.expectedValue });
            } else {
                region.apps.push({ name: hc.app, queries: [{ type: hc.type, prop: hc.property, exp: hc.expectedValue }] });
            }
        } else {
            hc.queries.push({ region: hc.region, apps: [{ name: hc.app, queries: [{ type: hc.type, prop: hc.property, exp: hc.expectedValue }] }] });
        }

        console.log("End of Generating Request");
        console.log(hc.queries);
    };

    function findRegion(e) {
        return e.region;
    }

    function findApp(e) {
        return e.name;
    }

    function resetForm() {
        hc.queryForm.$setPristine();
        hc.queryForm.$setUntouched();
        hc.region = '';
        hc.app = '';
        hc.type = '';
        hc.property = '';
        hc.expectedValue = '';
    };

    function Region(region, apps) {
        this.region = region;
        this.apps = apps;
    }

    function App(app, queries) {
        this.app = app;
        this.queries = queries;
    };

    function Query(type, property, expectedValue) {
        this.type = type;
        this.prop = property;
        this.exp = expectedValue;
    };
});