(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-8fb28914"],{"26e3":function(e,t,s){"use strict";var r=function(){var e=this,t=e.$createElement,s=e._self._c||t;return s("form",{staticClass:"column",on:{submit:function(t){return t.preventDefault(),e.submit(t)}}},[s("label",{attrs:{for:"email"}},[e._v("email")]),s("input",{directives:[{name:"model",rawName:"v-model",value:e.username,expression:"username"}],ref:"emailField",attrs:{type:"email",required:""},domProps:{value:e.username},on:{input:function(t){t.target.composing||(e.username=t.target.value)}}}),s("label",{attrs:{for:"password"}},[e._v("password")]),s("input",{directives:[{name:"model",rawName:"v-model",value:e.password,expression:"password"}],ref:"passField",attrs:{type:"password",required:""},domProps:{value:e.password},on:{input:function(t){t.target.composing||(e.password=t.target.value)}}}),s("div",{staticClass:"row between"},[s("router-link",{staticClass:"link",attrs:{id:"link-home",to:"/"}},[e._v("BACK")]),s("a",{staticClass:"link",on:{click:e.submit}},[e._v("SUBMIT")])],1)])},a=[],i=s("f54e"),n={name:"UserAuthForm",props:{type:{type:String}},data:function(){return{username:"",password:""}},methods:{submit:function(){if(this.formIsValid()){var e={username:this.username,password:this.password};this.$store.dispatch(this.operation,e)}else i["a"].error("Improper input")},formIsValid:function(){var e=/\S+@\S+\.\S+/,t=e.test(String(this.$refs.emailField.value).toLowerCase()),s=""!==this.$refs.passField.value;return t&&s}},computed:{operation:function(){return"login"===this.type?"LOGIN":"REGISTER"}}},o=n,u=s("2877"),l=Object(u["a"])(o,r,a,!1,null,"1220a4e1",null);t["a"]=l.exports},"73cf":function(e,t,s){"use strict";s.r(t);var r=function(){var e=this,t=e.$createElement,s=e._self._c||t;return s("div",{staticClass:"column"},[s("div",{staticClass:"row around"},[s("TimeAndDate")],1),s("div",{staticClass:"row around"},[s("UserAuthForm",{attrs:{type:"register"}})],1)])},a=[],i=s("50a7"),n=s("26e3"),o={name:"Register",components:{TimeAndDate:i["a"],UserAuthForm:n["a"]}},u=o,l=s("2877"),m=Object(l["a"])(u,r,a,!1,null,null,null);t["default"]=m.exports}}]);
//# sourceMappingURL=chunk-8fb28914.9d67d390.js.map