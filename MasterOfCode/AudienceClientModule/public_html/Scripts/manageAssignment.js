angular.module('audienceClient')
        .controller('manageAssignmentController', function ($scope) {
            
            
            $scope.info = {
                authorName: "Jan Klaassen",
                orgaName: "Company BV",
                date: "24-05-2015",
                startTime: "14:00",
                endTime: "14:20",
                description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam faucibus fermentum pulvinar. Proin tristique ipsum id libero consectetur faucibus. " +
                        "Quisque volutpat risus in finibus pulvinar. Aliquam non libero vitae sapien mattis ultrices. Etiam a mi sed purus auctor malesuada vitae non nunc. " +
                        "Sed vel nisi felis. Vivamus quis consectetur dui, ut mattis metus. Nulla a augue nisl."
            };
            
        });

