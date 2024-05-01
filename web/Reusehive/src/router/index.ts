import {createRouter, createWebHistory} from "vue-router";
import Main from "../layout/main.vue";

const router = createRouter({
    end: undefined,
    history: createWebHistory(),
    sensitive: undefined,
    strict: undefined,
    routes: [
        {
            path: "/login",
            name: "login",
            component: () => import("../pages/Login.vue"),
        },
        {
            path: "/bar",
            name: "bar",
            component: () => import("../layout/TabBar.vue")
        },
        {
            path: "/register",
            name: "register",
            component: () => import("../pages/Register.vue")

        },
        {
            path: "/item-detail",
            name: "item-detail",
            component: () => import("../pages/ItemDetail.vue"),
        },
        {
            path: "/item/new",
            name: "item-new",
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
                    meta: {
                        showFather: true,
                    }
                },
                {
                    path: "item-list",
                    name: "item-list",
                    component: () => import("../pages/ItemList.vue"),
                    meta: {
                        showFather: true,
                    }
                },

                {
                    path: "purchase",
                    name: "purchase",
                    component: () => import("../pages/purchase.vue"),
                    meta: {
                        showFather: true,
                    }
                },
                {
                    path: "home",
                    name: "home",
                    component: () => import("../pages/userhome.vue"),
                    meta: {
                        showFather: true,
                    }
                },
                {
                    path: "/collections",
                    name: "collections",
                    component: () => import("../pages/Collections.vue"),
                    meta: {
                        showFather: true,
                    }
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
