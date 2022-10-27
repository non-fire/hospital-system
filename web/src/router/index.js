import { createRouter, createWebHistory } from 'vue-router'
import UserAccountLoginView from '../views/user/account/UserAccountLoginView'
import UserAccountRegisterView from '../views/user/account/UserAccountRegisterView'
import WelcomePage from '../views/mainpage/WelcomePage'
import ChooseItem from '../views/mainpage/ChooseItem'

import store from '../store/index'

const routes = [
  {
    path: "/",
    name: "home",
    component: WelcomePage,
  },
  {
    path: "/choose/item/",
    name: "choose_item",
    component: ChooseItem,
  },
  {
    path: "/user/account/login/",
    name: "user_account_login",
    component: UserAccountLoginView,
    meta: {
      requestAuth: false,
    }
  },
  {
    path: "/user/account/register/",
    name: "user_account_register",
    component: UserAccountRegisterView,
    meta: {
      requestAuth: false,
    }
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

router.beforeEach((to, from, next) => {
  let flag = 1;
  const jwt_token = localStorage.getItem("jwt_token");

  if (jwt_token) {
    store.commit("updateToken", jwt_token);
    store.dispatch("getinfo", {
      success() {
      },
      error() {
        localStorage.removeItem('jwt_token');
        alert("token无效，请重新登录！");
        store.dispatch("logout");
        router.push({ name: 'user_account_login' });
      }
    })
  } else {
    flag = 2;
  }

  if (to.meta.requestAuth && !store.state.user.is_login) {
    if (flag === 1) {
      next();
    } else {
      next({name: "user_account_login"});
    }
  } else {
    next();
  }
})

export default router
