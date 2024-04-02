// vue 모듈에서 createApp() 함수를 import 한다.
import { createApp } from 'vue'
// App.vue 컴포넌트를 import한다.
import App from './App.vue'

// bootstrap 모듈을 import한다.
import 'bootstrap'
// bootstrap css와 js를 import한다.
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.min.js'

// index.html의 <div id="app"></div>에 App.vue 컴포넌트를 마운트(부착)시킨다.
createApp(App).mount('#app')
