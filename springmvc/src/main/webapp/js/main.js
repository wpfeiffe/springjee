var App = {};

require.config({
    baseUrl: '/springmvc/js',
    paths: {
        jquery: 'jquery-1.8.1.min',
        underscore: 'underscore',
        backbone: 'backbone',
        text: 'text',
        jqdate: 'jquery.dateFormat-1.0'
    },
    shim: {
        jquery: {
            exports: "$"
        },
        underscore: {
            exports: "_"
        },
        backbone: {
            deps: ["underscore", "jquery"],
            exports: "Backbone"
        },
        jqdate: {
            deps: ["jquery"]
        }
    }
});

require(['backdept'], function (BackDept) {
    App.backdept = new BackDept();
    console.info("Hello main.js");
});