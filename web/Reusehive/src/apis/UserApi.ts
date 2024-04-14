import {$http} from "./index";

export const loginApi=(data:{password:string;username:string})=>{
    return $http({
        method:"post",
        url:"http://127.0.0.1:4523/m1/4280410-3922518-default/user/login",
        params:data,
        headers:{
        },
    });
}

export const registerApi=(data:{password:string;username:string })=>{
    return $http({
        method:"post",
        url:"http://127.0.0.1:4523/m1/4280410-0-default/user/register",
        params:data
    })
}