/**
 * Created by colinlacy on 1/29/15.
 */
angular.module('factorLink')
.directive('navEval', function($location) {
        return {
            restrict: 'A',
            link: function (scope, elem, attr) {
                var path = $location.path(),
                    href = attr.href;
                if (path === href) {
                    $(elem).addClass('active');
                } else {
                    $(elem).removeClass('active');
                }
            }
        };
    });