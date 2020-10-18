# Homework 2

## Telnet 1
```console
LLMBP@litvaluk:~$ telnet 147.32.233.18 8888
Trying 147.32.233.18...
Connected to 147.32.233.18.
Escape character is '^]'.
GET /NI-AM1-ApplicationProtocols/httpTelnet1 HTTP/1.1
Host: 147.32.233.18
User-Agent: fit-telnet
Accept: text/html
Accept-Charset: utf-8
Accept-Language: en-US

HTTP/1.1 200 OK
Server: Apache-Coyote/1.1
Content-Type: text/html;charset=UTF-8
Content-Length: 3
Date: Sun, 18 Oct 2020 14:21:36 GMT

OK
```

## Telnet 2
```console
LLMBP@litvaluk:~$ telnet 147.32.233.18 8888
Trying 147.32.233.18...
Connected to 147.32.233.18.
Escape character is '^]'.
POST /NI-AM1-ApplicationProtocols/httpTelnet2 HTTP/1.1
Host: 147.32.233.18:8888
Referer: mi-mdw
Content-Type: application/x-www-form-urlencoded
Content-Length: 8

data=fit
HTTP/1.1 200 OK
Server: Apache-Coyote/1.1
Content-Type: text/html;charset=UTF-8
Content-Length: 3
Date: Sun, 18 Oct 2020 14:21:41 GMT

OK
```


## Curl
```console
LLMBP@litvaluk:~$ curl 'http://147.32.233.18:8888/NI-AM1-ApplicationProtocols/protocol/welcome'
OK
Your next page is /protocol/get
send GET parameter "name" with value "happened" 
set Header "Accept" to "text/plain" 
LLMBP@litvaluk:~$ curl --request GET 'http://147.32.233.18:8888/NI-AM1-ApplicationProtocols/protocol/get?name=happened' --header 'Accept: text/plain'
OK
Your next page is /protocol/post 
send POST parameter "name" with value "associated"
and set Header "Accept" is "text/plain" 
and set Header "Accept-Language" is "en-US" 
LLMBP@litvaluk:~$ curl --request POST 'http://147.32.233.18:8888/NI-AM1-ApplicationProtocols/protocol/post?name=associated' --header 'Accept: text/plain' --header 'Accept-Language: en-US'
OK
Your next page is /protocol/referer 
change referer to value "trivial"
set Header "Accept" is "text/html" 
LLMBP@litvaluk:~$ curl 'http://147.32.233.18:8888/NI-AM1-ApplicationProtocols/protocol/referer' --header 'Accept: text/html' --referer 'trivial'  
OK
Your next page is /protocol/useragent
and change User-Agent to value "harm"
and set Header "Accept-Language" is "en-US" 
LLMBP@litvaluk:~$ curl 'http://147.32.233.18:8888/NI-AM1-ApplicationProtocols/protocol/useragent' --header 'Accept-Language: en-US' --user-agent 'harm'
OK
Your next page is /protocol/cookie 
send cookie called "name" with value "may"
LLMBP@litvaluk:~$ curl 'http://147.32.233.18:8888/NI-AM1-ApplicationProtocols/protocol/cookie' --cookie 'name=may'   
OK
Your next page is /protocol/auth 
authenticate by "supposedly:combat"
set Header "Accept" is "text/html" 
LLMBP@litvaluk:~$ curl 'http://147.32.233.18:8888/NI-AM1-ApplicationProtocols/protocol/auth' --header 'Accept: text/html' --user 'supposedly:combat'
OK
Your final result is: heading
```