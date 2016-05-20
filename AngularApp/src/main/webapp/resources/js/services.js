'use strict';

/* Services */

var AppServices = angular.module('AngularSpringApp.services', ['ngResources']);

var baseUrl = 'http://localhost\\:8080';
AppServices.factory('getAllBlogs', function($resource){
	return $resource(baseUrl + 'rest/blogs', {},{

	  'get':    {method:'GET'},
	  'save':   {method:'POST'},
	  'query':  {method:'GET', isArray:true},
	  'remove': {method:'DELETE'},
	  'delete': {method:'DELETE'}
    })
 });

AppServices.value('version', '0.1');
