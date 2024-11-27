# 브라우저에서 자바스크립트 사용

자바스크립트는 브라우저를 위해서 태어났다. 
브라우저에서 표현되는 html, css를 코드로 제어해서 사용자가 버튼을 누르면 색상을 변경하거나 하는 상호작용을 하려는 목적으로 사용됐다.(왜 과거형인지 나중에 설명함)

그래서 브라우저에서 자바스크립트를 사용할 때는

```javascript
var table = document.getElementById('table'); // 도큐먼트는 객체에서 getElementById() 메서드를 호출해서 테이블 객체를 찾는다.

table.style.backgroundColor = 'red'; // 테이블의 스타일 중 배경색을 빨간색으로 변경한다.
```

