<!--
	<script>
		Vue.js 자바스크립트 코드를 정의하는 영역이다.

		data(): function() {}
		data() {} 위를 줄여서 이렇게 적을 수 있다.
			data는 이 애플리케이션에서 사용되는 값을 반환하는 함수다.
			data 함수가 반환하는 값은 script와 template에서 사용가능하다.

	<template>
		HTML 뷰 템플릿을 정의하는 영역이다.
		뷰 템플릿에서는 {{ 표현식 }}을 사용해서 data() 함수가 제공하는 값을 표현할 수 있다.
		{{ 표현식 }}을 사용해서 script 영역의 값을 표현할 수 있는데, 이를 "데이터바인딩"이라고 한다.

		v-model은 "양방향 데이터 바인딩"을 지원한다.
		{{ 표현식 }}은 "단방향 데이터 바인딩"을 지원한다.

		양방향 데이터 바인딩
			- 변수의 값을 폼 입력필드에 표현할 수 있다.
			- 폼 입력필드의 값이 변경되면 변수의 값이 변경된다.
		단방향 데이터 바인딩
			- 변수의 값을 뷰 템플릿에 표현할 수 있다.
			- 변수의 값이 변경되는 뷰 템플릿도 자동으로 갱신된다.

    <style scoped>
		뷰 템플릿에 적용할 css를 정의하는 영역이다.
  -->
  <script>
  export default {
      data() {
          return {
              memberList:[],
              showForm: false,
              email: '',
              password: '',
              name: '',
              tel: ''
          }
      },
      // Vue.js의 라이프사이클 메소드다.
      // created() 메소드는 Vue.js 애플리케이션이 생성된 직후에 실행된다.
      created() {
          this.getMembers();
      },
      methods: {	// methods: 이 컴포넌트 안에서 사용되는 메소드를 정의하기 위해 사용한다
          clearFields() {
              this.email = '';
              this.password = '';
              this.name = '';
              this.tel = '';
          },
          toggleShowForm() {
              this.showForm = !this.showForm;
          },
          // rest api를 호출해서 모든 사용자 정보를 조회한다.
          // 조회된 회원목록을 memberList에 저장한다.
          async getMembers() {
              let response = await fetch('http://localhost/api/v1/members');
              let jsonData = await response.json();
              // jsonData -> {status:200, message:"OK", items:[{}, {}, {}]}
              if(jsonData.status == 200) {
                  this.memberList = jsonData.items;
              }
          },
          // rest api를 호출해서 지정된 회원 정보를 삭제한다.
          // memberList에서 지정된 회원정보를 제거한다.
          async deleteMember(id) {
              let response = await fetch('http://localhost/api/v1/members/' + id, {
                  method: 'DELETE',
                  mode: 'cors'	// cors(교차 출처 리소스 허용)을 설정한다. cross origin resource sharing
              });
              let jsonData = await response.json();
              // jsonData -> {status:200, message:"[21]번 회원정보가 삭제되었습니다.", items:[]}
              if (jsonData.status == 200) {
                  let foundIndex = this.memberList.findIndex(member => member.id == id);
                  this.memberList.splice(foundIndex, 1);
              }
          },
          // rest api를 호출해서 새 회원정보를 저장시킨다.
          // memberList에 새 회원정보를 추가한다.
          async saveMember(email, password, name, tel) {
              let data = {email, password, name, tel};	// {email:email, password:password, ...}와 동일한 표현식이다/
                                                          //   ^--- 프로퍼티명이다.
              let response = await fetch('http://localhost/api/v1/members', {
                  method: 'POST',
                  mode: 'cors',
                  headers: {
                      'Content-Type': 'application/json'
                  },
                  body: JSON.stringify(data)
              });
              let jsonData = await response.json();
              // jsonData -> {status: 200, message: 'OK', items:[{id:31, email:'kang@gmail.com', name:'강감찬', tel:'010-2222-3333'}]}
              // jsonData.items에는 신규 등록된 회원정보 하나가 들어있다.
              if (jsonData.status == 200) {
                  // memberList 배열의 끝에 새 회원정보를 추가한다.
                  this.memberList.push(jsonData.items[0]);
              }
              this.clearFields();
          }
      }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
  }
</script>

<template>
<div class="container">
  <div class="row mb-3">
      <div class="col-12">
          <h1>회원관리</h1>

          <table class="table">
              <thead>
                  <tr>
                      <th>순번</th>
                      <th>번호</th>
                      <th>이름</th>
                      <th>이메일</th>
                      <th></th>
                  </tr>
              </thead>
              <tbody>
                  <tr v-for="(member, index) in memberList">
                      <td>{{ index + 1 }}</td>
                      <td>{{ member.id }}</td>
                      <td>{{ member.name }}</td>
                      <td>{{ member.email }}</td>
                      <td>
                                                                          <!--@대신 v-on:click로 사용해도 된다. -->
                          <button class="btn btn-outline-secondary btn-sm me-1" @click="deleteMember(member.id)">삭제</button>
                          <button class="btn btn-outline-secondary btn-sm">수정</button>
                      </td>
                  </tr>
              </tbody>
          </table>
          <div class="text-end">
              <button class="btn btn-primary btn-sm" @click="toggleShowForm">신규 회원 등록</button>
          </div>
      </div>
  </div>
  <div v-if="showForm" class="row mb-3">
      <div class="col-12">
          <form action="" class="border bg-light p-3">
              <div class="form-group mb-3">
                  <label for="" class="form-label">이메일</label>
                  <input type="text" class="form-control" v-model="email">
              </div>
              <div class="form-group mb-3">
                  <label for="" class="form-label">비밀번호</label>
                  <input type="text" class="form-control" v-model="password">
              </div>
              <div class="form-group mb-3">
                  <label for="" class="form-label">이름</label>
                  <input type="text" class="form-control" v-model="name">
              </div>
              <div class="form-group mb-3">
                  <label for="" class="form-label">전화번호</label>
                  <input type="text" class="form-control" v-model="tel">
              </div>
              <div class="text-end">
                  <button type="button" class="btn btn-secondary btn-sm me-1" @click="toggleShowForm">취소</button>
                  <button type="button" class="btn btn-primary btn-sm" @click="saveMember(email, password, name, tel)">등록</button>
              </div>
          </form>
      </div>
  </div>
</div>
</template>

<style scoped>
</style>
