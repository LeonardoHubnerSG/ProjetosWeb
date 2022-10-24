angular.module("udemyProject").config(['$stateProvider', function($stateProvider){
    $stateProvider
    .state('initialPage',{
        url: '/',
        templateUrl: 'view/userList.html',
        controller: 'udemyProjectCtrl'
    })
    .state('insertUser',{
        url: '/newUser',
        templateUrl: 'view/newUser.html',
        controller: 'udemyProjectCtrl'
    })

    // $stateProvider.state('initialPage',{
    //     url: '/userList',
    //     template: 'userList.html',
    //     controller: 'udemyProjectCtrl'
    // });
}]);

