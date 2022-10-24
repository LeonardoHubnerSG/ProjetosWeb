angular.module("udemyProject").controller("udemyProjectCtrl", function($scope, $state, usersAPI){
    $scope.app = "Udemy Project";
    $scope.user = {};
    $scope.users = [];

    var loadUsers = function(){
        usersAPI.getUsers().then(function (response){
            $scope.users = response.data;
        }).catch(function (response, status){
            $scope.message = "Aconteceu um problema: " + response; 
        })
    }
    
    $scope.saveUser = function(user){
        usersAPI.saveUser(user).then(function(){
            delete $scope.user;
            alert("Usuário salvo com sucesso!");
            //$scope.userForm.$setPristine();
            navigateToListUser();
        })
    }

    $scope.deleteUsers = function (users) {
		$scope.users = users.filter(function (user) {
			if (!user.selected) return user;
		});
		$scope.verifySelectedUsers($scope.users);
	};

	$scope.verifySelectedUsers = function (users) {
		$scope.hasSelectedUser = users.some(function (user) {
			return user.selected;
		});
	};

    $scope.navigateToNewUser = function () {
        $state.go('insertUser');
    };

    var navigateToListUser = function () {
        loadUsers();
        $state.go('initialPage');
    };

    

    loadUsers();
});