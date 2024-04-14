import { createApp } from "vue";
import "./styles.css";
import App from "./App.vue";
import 'tdesign-mobile-vue/es/style/index.css';
const app = createApp(App);
async function  asyncRegister(){
    const createPinia=(await import("pinia")).createPinia;
    app.use(createPinia());
    const router=(await import("./router")).default;
    app.use(router);
    app.mount('#app')

}
asyncRegister();