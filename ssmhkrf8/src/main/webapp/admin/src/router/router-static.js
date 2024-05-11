import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import yonghu from '@/views/modules/yonghu/list'
    import chat from '@/views/modules/chat/list'
    import discussbowenxinxi from '@/views/modules/discussbowenxinxi/list'
    import bowenxinxi from '@/views/modules/bowenxinxi/list'
    import wodebowen from '@/views/modules/wodebowen/list'
    import qiandao from '@/views/modules/qiandao/list'
    import storeup from '@/views/modules/storeup/list'
    import config from '@/views/modules/config/list'
    import bowenleixing from '@/views/modules/bowenleixing/list'
    import discusswodebowen from '@/views/modules/discusswodebowen/list'
    import gerenmingpianfenxiang from '@/views/modules/gerenmingpianfenxiang/list'


//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/yonghu',
        name: '用户',
        component: yonghu
      }
      ,{
	path: '/chat',
        name: '联系客服',
        component: chat
      }
      ,{
	path: '/discussbowenxinxi',
        name: '博文信息评论',
        component: discussbowenxinxi
      }
      ,{
	path: '/bowenxinxi',
        name: '博文信息',
        component: bowenxinxi
      }
      ,{
	path: '/wodebowen',
        name: '我的博文',
        component: wodebowen
      }
      ,{
	path: '/qiandao',
        name: '签到',
        component: qiandao
      }
      ,{
	path: '/storeup',
        name: '我的收藏管理',
        component: storeup
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
      ,{
	path: '/bowenleixing',
        name: '博文类型',
        component: bowenleixing
      }
      ,{
	path: '/discusswodebowen',
        name: '我的博文评论',
        component: discusswodebowen
      }
      ,{
	path: '/gerenmingpianfenxiang',
        name: '个人名片分享',
        component: gerenmingpianfenxiang
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
