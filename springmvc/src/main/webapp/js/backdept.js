define([
    'jquery',
    'underscore',
    'backbone',
    'jqdate',
    'text!templates/dept.html'], function ($, _, Backbone, jqdate, deptTemplate)
{
    _.templateSettings = { interpolate: /\{\{(.+?)\}\}/g };

    var departments = [];
    var Department = Backbone.Model.extend({
        defaults: {
            deptCode: "NEW",
            deptName: "New Dept",
            deptText: "NEW:New Dept"
        }
    });

    var Departments = Backbone.Collection.extend({
        model: Department,
        url: '/springmvc/api/department'
    });

    var DeptView = Backbone.View.extend({
        tagName: "div",
        className: "bookContainer",
        template: deptTemplate,

        render: function () {
            var tmpl = _.template(this.template); //tmpl is a function that takes a JSON and returns html

            this.$el.html(tmpl(this.model.toJSON())); //this.el is what we defined in tagName. use $el to get access to jQuery html() function
            return this;
        },

        events: {
            "click .delete": "deleteDept"
        },

        deleteDept: function () {
            console.log('Destroying dept id: ' + this.model.get("id"));
            //Delete model
            this.model.destroy({
                error: function (model, response) {
                    console.log("Failed destroying dept");
                },
                success: function (model, response) {
                    console.log("Succeeded in destroying dept");
                }
            });

            //Delete view
            this.remove();
        }
    });

    var BackDept = Backbone.View.extend({
        el: $("#depts"),

        initialize: function () {
            this.collection = new Departments();
            this.collection.fetch({
                error: function () {
                    console.log(arguments);
                }
            });
            this.render();

            this.collection.on("add", this.renderDept, this);
            this.collection.on("remove", this.removeDept, this);
            this.collection.on("reset", this.render, this);
        },

        render: function () {
            var that = this;
            _.each(this.collection.models, function (item) {
                that.renderDept(item);
            });
        },

        events: {
            "click #add": "addDept"
        },

        addDept: function (e) {
            e.preventDefault();

            var formData = {};

            $("#addDept div").children("input").each(function (i, el) {
                if ($(el).val() !== "") {
                    formData[el.id] = $(el).val();
                }
            });

            departments.push(formData);

            var newDept = this.collection.create(formData, {
                wait: true,
                success: function(resp){
                    console.log("Add of new dept succeeded: " + newDept);
                    console.log(resp);
                },
                error: function(err){
                    console.log("Add of new dept failed");
                    console.log(err);
                }
            });
        },

        removeDept: function (removedDept) {
            var removedDeptData = removedDept.attributes;

            _.each(removedDeptData, function (val, key) {
                if (removedDeptData[key] === removedDept.defaults[key]) {
                    delete removedDeptData[key];
                }
            });

            _.each(departments, function (dept) {
                if (_.isEqual(dept, removedDeptData)) {
                    departments.splice(_.indexOf(departments, dept), 1);
                }
            });
        },

        renderDept: function (item) {
            var deptView = new DeptView({
                model: item
            });
            var tempDeptView = deptView.render().el;
            this.$el.append(tempDeptView);
        },

        bbdate: function(inDate)
        {
            var newDate = new Date(inDate);
            var returnValue = $.format.date(newDate, 'MM/dd/yyyy');
            return returnValue;
        }

    });


    return BackDept;

});
