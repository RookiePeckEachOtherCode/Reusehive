import {$http} from "./index";

export const loginApi = (data: { password: string; username: string }) => {

    return $http({
        method: "post",
        // url: "http://127.0.0.1:4523/m1/4280410-3922518-default/user/login",
        url: "http://127.0.0.1:8888/user/login",
        params: data,
        headers: {},
    });
};

export const registerApi = (data: {
    password: string,
    name: string,
    gender:0,
    grade:2077,
    academy:"计算机",
    phone_number:"null",
    social_info:"null",
    avatar_img:"https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png",
    back_img:"https://pic3.zhimg.com/v2-289ee4a9294859f66831465efe6aca5a_r.jpg",
}) => {
    return $http({
        method: "post",
        url: "http://127.0.0.1:8888/user/register",
        params: data,
    });
};

export const userChatInfoApi = () => {
    return $http({
        method: "get",
        url: "http://127.0.0.1:8888/user/chatsinfo",
    });
};

export const getUserInfoByUidApi = (data: { id: string }) => {
    const url = "http://127.0.0.1:8888/user/" + data.id;
    return $http({
        method: "get",
        url: url,
    });
};
export const getUserInfoByName=(data:{name:string})=>{
    return $http({
      method:"get",
      //url:"http://127.0.0.1:8888/user/name/" +data.name,
        url:"http://127.0.0.1:4523/m1/4280410-0-default/user/name/"+data.name
    })

}
export const UploadUserInfo=(data:{
  formdata:{
    name:string,
    password:string,
    grade:string,
    academy:string,
    phone_number:string,
    social_info:string,
    avatar_img:string,
    back_img:string,
  }
})=>{
  return $http({
    method:"post",
    params:data,
    url:"http://127.0.0.1:8888/user/update",
  })
}
export const getAllUserInfoApi = () => {
    return $http({
        method: "get",
        url: "http://127.0.0.1:8888/user/all",
    })
}
export const verifylogin=()=>{
    return $http({
        method:"get",
        url:"http://127.0.0.1:8888/user/verify",
        //url:"http://127.0.0.1:4523/m1/4280410-0-default/user/verify"
    })
}

export const getUserItemList=(data:{id:string})=>{
    return $http({
        method:"get",
        //url:"http://127.0.0.1:8888/item/user/"+data.id
        url:"http://127.0.0.1:4523/m1/4280410-0-default/item/user/"+data.id
        })
}