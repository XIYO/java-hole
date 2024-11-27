function Person(name, age) { // 대문자로 시작해서 new 키워드로 인스턴스를 만들어야 한다. 결국 생성자 함수라는 의미다.
    this.name = name;
    this._age = age;
}

Person.prototype.getAge = function() {
    return this._age;
}

// 그러나 프로토타입은 사용하는 부분이 선언부보다 위에 있으면 안된다. (위짤붙 안해준다. 호이스팅이 안된다.)
Person.prototype.setAge = function(age) {
    this._age = age;
}

// 자바랑 똑같이 뉴 키워드를 통해 인스턴스를 만든다.
var person = new Person("김길동", 30);
person.name = "김길동";
person.setAge(15);
console.log(person); // 이름, 나이가 다 나온다. (프라이빗 변수가 없다.)