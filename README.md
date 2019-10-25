# moonbtBlog
開頭先感謝 李仁密 老師

### 説明
這是一個新時代的部落格網格，使用sementic UI，也進行了手機端的適應。
[moonbtBlogDemo](http://54.187.138.200/)

### 項目地圖
* src
  - main
    - java
      - com.moon.blog
        - aspect ：注入log日志的類
        - dao    ：鏈接mysql的類
        - service：處理業務邏輯的類
        - web    : servlet,轉發請求等等
        - po     : 實體類(blog、tag、type、user、comment)
        - ulti   ：輔助類
        - handler: server内部處理錯誤,轉發到error頁面
        - interceptor:攔截非登錄用戶，進入後臺
        - vo     :處理首頁blog的輔助類
    - resources
      - i18n:多囯語言配置
      - static
        - css
        - lib
        - images
        - js
      - templates:相關靜態頁面
