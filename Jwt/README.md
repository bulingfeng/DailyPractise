服务
```jshelllanguage
1. AutherServer-授权服务器
2. ResourceServer-资源服务器
```

命令行请求步骤
1. 请求令牌
request param:
```jshelllanguage
curl -X POST --user 'clientapp:123' -d 'grant_type=password&username=user&password=123456' http://localhost:8080/oauth/token
```
response token
```json
{
  "access_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1NzU5MTc3MDMsInVzZXJfbmFtZSI6InVzZXIiLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwianRpIjoiMmY1YzZiN2EtMzRiYi00NWNlLWIzMDctMmMxOWRiMjI2YmU4IiwiY2xpZW50X2lkIjoiY2xpZW50YXBwIiwic2NvcGUiOlsicmVhZCJdfQ.hAVd65fjEJ-NGGWGY4T0WdkanQoRi6Fz2lYP808Vd4I",
  "token_type": "bearer",
  "refresh_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJ1c2VyIiwic2NvcGUiOlsicmVhZCJdLCJhdGkiOiIyZjVjNmI3YS0zNGJiLTQ1Y2UtYjMwNy0yYzE5ZGIyMjZiZTgiLCJleHAiOjE1Nzg0NjY1MDMsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJqdGkiOiIwYjIwNGMyYS1jMjQ5LTRlNTQtYTEzMy00NzBhZGIzMTQ4MDMiLCJjbGllbnRfaWQiOiJjbGllbnRhcHAifQ.qpnySqUQywYIoHdEuVlrAglT6jyY2oRK6CFMq7JCcMQ",
  "expires_in": 43199,
  "scope": "read",
  "jti": "2f5c6b7a-34bb-45ce-b307-2c19db226be8"
}
```
2. 携带jwt请求资源
http://localhost:8081/api/hi
Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1NzU5MTc3MDMsInVzZXJfbmFtZSI6InVzZXIiLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwianRpIjoiMmY1YzZiN2EtMzRiYi00NWNlLWIzMDctMmMxOWRiMjI2YmU4IiwiY2xpZW50X2lkIjoiY2xpZW50YXBwIiwic2NvcGUiOlsicmVhZCJdfQ.hAVd65fjEJ-NGGWGY4T0WdkanQoRi6Fz2lYP808Vd4I

postman请求步骤
1. 先把clientapp:123转换为base64编码
```jshelllanguage
Y2xpZW50YXBwOjEyMw==
```
2. 请求获取token
需要用x-www-from-urlencoded模式 输入grant_type=password username=user password=123456
Authorization使用的value值为base64转码后 加个Basic
Authorization Basic Y2xpZW50YXBwOjEyMw==
3. 得到token信息
```json
{
  "access_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1NzU5MTc3MDMsInVzZXJfbmFtZSI6InVzZXIiLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwianRpIjoiMmY1YzZiN2EtMzRiYi00NWNlLWIzMDctMmMxOWRiMjI2YmU4IiwiY2xpZW50X2lkIjoiY2xpZW50YXBwIiwic2NvcGUiOlsicmVhZCJdfQ.hAVd65fjEJ-NGGWGY4T0WdkanQoRi6Fz2lYP808Vd4I",
  "token_type": "bearer",
  "refresh_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJ1c2VyIiwic2NvcGUiOlsicmVhZCJdLCJhdGkiOiIyZjVjNmI3YS0zNGJiLTQ1Y2UtYjMwNy0yYzE5ZGIyMjZiZTgiLCJleHAiOjE1Nzg0NjY1MDMsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJqdGkiOiIwYjIwNGMyYS1jMjQ5LTRlNTQtYTEzMy00NzBhZGIzMTQ4MDMiLCJjbGllbnRfaWQiOiJjbGllbnRhcHAifQ.qpnySqUQywYIoHdEuVlrAglT6jyY2oRK6CFMq7JCcMQ",
  "expires_in": 43199,
  "scope": "read",
  "jti": "2f5c6b7a-34bb-45ce-b307-2c19db226be8"
}
```
4. 使用access_token来请求资源数据
Authorization Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1NzU5MTc3MDMsInVzZXJfbmFtZSI6InVzZXIiLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwianRpIjoiMmY1YzZiN2EtMzRiYi00NWNlLWIzMDctMmMxOWRiMjI2YmU4IiwiY2xpZW50X2lkIjoiY2xpZW50YXBwIiwic2NvcGUiOlsicmVhZCJdfQ.hAVd65fjEJ-NGGWGY4T0WdkanQoRi6Fz2lYP808Vd4I


参考文章
```jshelllanguage
https://segmentfault.com/a/1190000018771279
https://blog.csdn.net/zxw75192/article/details/91664061
http://corpus.hubwiz.com/2/node.js/29317156.html
```