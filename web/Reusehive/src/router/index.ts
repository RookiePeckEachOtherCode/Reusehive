import {createRouter, createWebHistory} from "vue-router";
import Main from "../layout/main.vue";
import ItemList from "../pages/item-list.vue";
import Userhome from "../pages/userhome.vue";

const router = createRouter({
    end: undefined,
    history: createWebHistory(),
    sensitive: undefined,
    strict: undefined,
    routes: [
        {
            path: "/login",
            name: "login",
            component: () => import("../pages/login.vue"),
        },
        {
            path: "/register",
            name: "register",
            component: () => import("../pages/register.vue")

        },
        {
            path: "/item",
            name: "item",
            component: () => import("../pages/item.vue"),
        },
        {
            path: "/item/new",
            name: "itme-new",
            component: () => import("../pages/item-new.vue"),
        },
        {
            path: "/updateinfo",
            name: "updateinfo",
            component: () => import("../pages/updateinfo.vue"),
        },
        {
            path: "/chat",
            name: "chat",
            component: () => import("../pages/Chat.vue"),
        },
        {
            path: "/purchasedetail",
            name: "PurchaseDetail",
            component: () => import("../pages/purchase-detail.vue")
        },
        {
            path: "/collections",
            name: "collections",
            component: () => import("../pages/Collections.vue")
        },
        {
            path: "/lostfind",
            name: "lostfind",
            component: () => import("../pages/lostfind.vue")
        },
        {
            path: "/myitems",
            name: "myitems",
            component: () => import("../pages/myitems.vue")
        },
        {
            path: "/item-edit",
            name: "item-edit",
            component: () => import("../pages/item-edit.vue")
        },
        {
            path: "/setting",
            name: "setting",
            component: () => import("../pages/setting.vue")
        },
        {
            path: "/user-info",
            name: "user-info",
            component: () => import("../pages/user-info.vue")
        },
        {
            path: "/",
            name: "main",
            component: () => Main,
            children: [
                {
                    path: "message",
                    name: "message",
                    component: () => import("../pages/message.vue"),
                },
                {
                    path: "item-list",
                    name: "item-list",
                    component: () => ItemList
                },

                {
                    path: "purchase",
                    name: "purchase",
                    component: () => import("../pages/purchase.vue"),
                },
                {
                    path: "home",
                    name: "home",
                    component: () => Userhome
                },
            ],
        },
    ]
});
export default router;

const whiteList = ['/login', '/register', '/setting']

router.beforeEach((to, _from, next) => {
        if (localStorage.getItem('token') == null) {
            if (whiteList.indexOf(to.path) !== -1) {
                next()
            } else {
                next({path: '/login'})
            }
        } else {
            next()
        }
    }
)
