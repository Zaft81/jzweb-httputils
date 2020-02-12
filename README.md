老旧系统通信组件
企业中有很多正常服役的Jee老系统，它们与新老系统之间的通信是一件比较麻烦的时候。因此，从自己的项目中剥离出来此组件。

使用方法：
```
@Autowired
private HttpHandleService httpHandleService;


Object obj = httpHandleService.handle(company,"",null);



```

