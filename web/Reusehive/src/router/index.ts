import { createRouter, createWebHistory } from 'vue-router'
const router=createRouter({
    end: undefined,
    history: createWebHistory(),
    sensitive: undefined,
    strict: undefined,
    routes:[
        {
            path:"/*",
            redirect:"/login"
        },
        {
            path:"/login",
            name:"login",
            component:()=>import("../pages/login.vue")
        }

    ]

})
export default  router