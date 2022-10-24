angular.module("udemyProject").service("usersAPI", function($http){
    var _saveUser = function(user){
        return $http.post("http://localhost:8080/users", user);
    }
   
    var _getUsers = function(){
        return $http.get("http://localhost:8080/users");
    }

    var _deleteUsers = function(users){
        users.forEach(user => {
            return $http.delete("http://localhost:8080/id=" + user);
        });
        
    } 

    return {
        getUsers: _getUsers,
        saveUser: _saveUser,
        deleteUsers: _deleteUsers
    }
})