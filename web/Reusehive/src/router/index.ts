import {createRouter, createWebHistory} from "vue-router";
import {verifylogin} from "../apis/UserApi.ts";
const router = createRouter({
  end: undefined,
  history: createWebHistory(),
  sensitive: undefined,
  strict: undefined,
  routes: [
    {
      path: "/*",
      redirect: "/login",
    },
    {
      path: "/login",
      name: "login",
      component: () => import("../pages/login.vue"),
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
      path:"/purchasedetail",
      name:"PurchaseDetail",
      component:()=>import("../pages/purchase-detail.vue")
    },
    {
      path:"/collections",
      name:"collections",
      component:()=>import("../pages/Collections.vue")
    },
      {
          path: "/main",
          name: "main",
          component: () => import("../layout/main.vue"),
          children: [


              {
                  path: "message",
                  name: "message",
                  component: () => import("../pages/message.vue"),
              },
              {
                  path: "item-list",
                  name: "item-list",
                  component: () => import("../pages/item-list.vue"),
              },

              {
                  path: "purchase",
                  name: "purchase",
                  component: () => import("../pages/purchase.vue"),
              },
              {
                  path: "home",
                  name: "home",
                  component: () => import("../pages/userhome.vue"),
              },
          ],
      },
      ]
});
// router.beforeEach(async (to, from, next) => {
//     const res= await verifylogin();
//     if (res.data === false) {
//         router.push("/login")
//     } else {
//         next()
//     }
// })
export default router;
