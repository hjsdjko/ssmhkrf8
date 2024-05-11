const base = {
    get() {
        return {
            url : "http://localhost:8080/ssmhkrf8/",
            name: "ssmhkrf8",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ssmhkrf8/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "博客小程序"
        } 
    }
}
export default base
