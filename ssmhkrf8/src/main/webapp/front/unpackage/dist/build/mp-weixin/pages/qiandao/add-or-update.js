(global["webpackJsonp"]=global["webpackJsonp"]||[]).push([["pages/qiandao/add-or-update"],{"2cda":function(n,e,t){"use strict";t.r(e);var r=t("fe36"),i=t("3b40");for(var a in i)"default"!==a&&function(n){t.d(e,n,(function(){return i[n]}))}(a);t("cde2");var u,o=t("f0c5"),c=Object(o["a"])(i["default"],r["b"],r["c"],!1,null,"564a71ee",null,!1,r["a"],u);e["default"]=c.exports},"3b40":function(n,e,t){"use strict";t.r(e);var r=t("e231"),i=t.n(r);for(var a in r)"default"!==a&&function(n){t.d(e,n,(function(){return r[n]}))}(a);e["default"]=i.a},"420e":function(n,e,t){},7230:function(n,e,t){"use strict";(function(n){t("fd01");r(t("66fd"));var e=r(t("2cda"));function r(n){return n&&n.__esModule?n:{default:n}}n(e.default)}).call(this,t("543d")["createPage"])},cde2:function(n,e,t){"use strict";var r=t("420e"),i=t.n(r);i.a},e231:function(n,e,t){"use strict";(function(n){Object.defineProperty(e,"__esModule",{value:!0}),e.default=void 0;var r=i(t("a34a"));function i(n){return n&&n.__esModule?n:{default:n}}function a(n,e,t,r,i,a,u){try{var o=n[a](u),c=o.value}catch(s){return void t(s)}o.done?e(c):Promise.resolve(c).then(r,i)}function u(n){return function(){var e=this,t=arguments;return new Promise((function(r,i){var u=n.apply(e,t);function o(n){a(u,r,i,o,c,"next",n)}function c(n){a(u,r,i,o,c,"throw",n)}o(void 0)}))}}var o=function(){Promise.all([t.e("common/vendor"),t.e("components/w-picker/w-picker")]).then(function(){return resolve(t("d193"))}.bind(null,t)).catch(t.oe)},c={data:function(){return{ruleForm:{yonghuming:"",xingming:"",zhaopian:"",suozaididian:"",qiandaoshijian:"",beizhu:"",clicknum:""},user:{},ro:{yonghuming:!1,xingming:!1,zhaopian:!1,suozaididian:!1,qiandaoshijian:!1,beizhu:!1,clicknum:!1}}},components:{wPicker:o},computed:{},onLoad:function(e){var t=this;return u(r.default.mark((function i(){var a,u,o,c;return r.default.wrap((function(i){while(1)switch(i.prev=i.next){case 0:return t.ruleForm.qiandaoshijian=t.$utils.getCurDateTime(),a=n.getStorageSync("nowTable"),i.next=4,t.$api.session(a);case 4:if(u=i.sent,t.user=u.data,t.ruleForm.yonghuming=t.user.yonghuming,t.ruleForm.xingming=t.user.xingming,t.ruleForm.userid=n.getStorageSync("userid"),e.refid&&(t.ruleForm.refid=e.refid,t.ruleForm.nickname=n.getStorageSync("nickname")),!e.id){i.next=16;break}return t.ruleForm.id=e.id,i.next=14,t.$api.info("qiandao",t.ruleForm.id);case 14:u=i.sent,t.ruleForm=u.data;case 16:if(!e.cross){i.next=51;break}o=n.getStorageSync("crossObj"),i.t0=r.default.keys(o);case 19:if((i.t1=i.t0()).done){i.next=51;break}if(c=i.t1.value,"yonghuming"!=c){i.next=25;break}return t.ruleForm.yonghuming=o[c],t.ro.yonghuming=!0,i.abrupt("continue",19);case 25:if("xingming"!=c){i.next=29;break}return t.ruleForm.xingming=o[c],t.ro.xingming=!0,i.abrupt("continue",19);case 29:if("zhaopian"!=c){i.next=33;break}return t.ruleForm.zhaopian=o[c],t.ro.zhaopian=!0,i.abrupt("continue",19);case 33:if("suozaididian"!=c){i.next=37;break}return t.ruleForm.suozaididian=o[c],t.ro.suozaididian=!0,i.abrupt("continue",19);case 37:if("qiandaoshijian"!=c){i.next=41;break}return t.ruleForm.qiandaoshijian=o[c],t.ro.qiandaoshijian=!0,i.abrupt("continue",19);case 41:if("beizhu"!=c){i.next=45;break}return t.ruleForm.beizhu=o[c],t.ro.beizhu=!0,i.abrupt("continue",19);case 45:if("clicknum"!=c){i.next=49;break}return t.ruleForm.clicknum=o[c],t.ro.clicknum=!0,i.abrupt("continue",19);case 49:i.next=19;break;case 51:t.styleChange();case 52:case"end":return i.stop()}}),i)})))()},methods:{styleChange:function(){this.$nextTick((function(){}))},qiandaoshijianConfirm:function(n){console.log(n),this.ruleForm.qiandaoshijian=n.result,this.$forceUpdate()},zhaopianTap:function(){var n=this;this.$api.upload((function(e){n.ruleForm.zhaopian=n.$base.url+"upload/"+e.file,n.$forceUpdate(),n.$nextTick((function(){n.styleChange()}))}))},getUUID:function(){return(new Date).getTime()},onSubmitTap:function(){var n=this;return u(r.default.mark((function e(){return r.default.wrap((function(e){while(1)switch(e.prev=e.next){case 0:if(!n.ruleForm.clicknum||n.$validate.isIntNumer(n.ruleForm.clicknum)){e.next=3;break}return n.$utils.msg("点击次数应输入整数"),e.abrupt("return");case 3:if(!n.ruleForm.id){e.next=8;break}return e.next=6,n.$api.update("qiandao",n.ruleForm);case 6:e.next=10;break;case 8:return e.next=10,n.$api.add("qiandao",n.ruleForm);case 10:n.$utils.msgBack("提交成功");case 11:case"end":return e.stop()}}),e)})))()},optionsChange:function(n){this.index=n.target.value},bindDateChange:function(n){this.date=n.target.value},getDate:function(n){var e=new Date,t=e.getFullYear(),r=e.getMonth()+1,i=e.getDate();return"start"===n?t-=60:"end"===n&&(t+=2),r=r>9?r:"0"+r,i=i>9?i:"0"+i,"".concat(t,"-").concat(r,"-").concat(i)},toggleTab:function(n){this.$refs[n].show()}}};e.default=c}).call(this,t("543d")["default"])},fe36:function(n,e,t){"use strict";t.d(e,"b",(function(){return i})),t.d(e,"c",(function(){return a})),t.d(e,"a",(function(){return r}));var r={wPicker:function(){return Promise.all([t.e("common/vendor"),t.e("components/w-picker/w-picker")]).then(t.bind(null,"d193"))}},i=function(){var n=this,e=n.$createElement;n._self._c},a=[]}},[["7230","common/runtime","common/vendor"]]]);