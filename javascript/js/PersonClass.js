class Person {
    #age = 0;

    constructor(name, age) {
        this.name = name;
        this.#age = age;
    }

    getAge() {
        return this.#age;
    }

    setAge(age) {
        this.#age = age;
    }
}

var person = new Person("김길동", 30);
person.name = "김길동";
person.setAge(15);
console.log(person); // 프라이빗 변수라서 나이는 출력이 안된다.
console.log(person.getAge()); // 따로 출력해야한다.