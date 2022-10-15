import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-live-list',
  templateUrl: './live-list.component.html',
  styleUrls: ['./live-list.component.css']
})
export class LiveListComponent implements OnInit {

  hide = true;
  Logado = false;

  constructor() { }

  ngOnInit(): void {
  }

  public test() {
    var url = 'http://localhost:8080/Login'

    const jsonObject = {
      name: 'asdasodias',
      login: 'asdasdioa@hotmail.com',
      exam: 123123,
      myList: [
        'first',
        'second',
        'third'
      ]
    }

    fetch(url, {
      method: "POST",
      body: JSON.stringify(jsonObject),
      headers: {
        'Content-Type': 'application/json',
      }
    }).then(function (response) {
      console.log(response.ok);
      return response.json();
    }).then(function (data) {
      console.log(JSON.stringify(data));
    })["catch"](function (error) {
      alert("ERROOO");
      console.log(error);
    });
  }
}
