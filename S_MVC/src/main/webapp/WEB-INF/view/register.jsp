<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
<script type="text/javascript" src="/MVC/javaScript/register.js"></script>
</head>
<body>
	<div>회원가입 페이지</div>
	<div>
		<form action="/MVC/view/registerOk.do" method="post" onsubmit="return createFrom(this)">
			<div>
				<div>아이디</div>
				<span>* <input type="text" name="id"/>
					<button type="button">아이디 중복</button>
				</span>
			</div>
			<div>
				<div>비밀번호</div>
				<span>* <input type="password" name="password">
				</span>
			</div>
			<div>
				<div>비밀번호 확인</div>
				<span>* <input type="password" name="passwordCheck">
				</span>
			</div>
			<div>
				<div>이름</div>
				<span>*
					<input type="text" name="name"/>
				</span>
			</div>

			<div>
				<div>주민번호</div>
				<span>*
					<input type="text" name="jumin1"/>
					<span>
					-
					</span>
					<input type="text" name="jumin2"/>
				</span>
			</div>
			<div>
				<div>이메일</div>
				<span>
					<input type="email" name="email"/>
				</span>
			</div>
			<div>
				<div>우편번호</div>
				<span>
					<input type="text" name="zipcode"/>
					<button type="button">우편번호검색</button>
				</span>
			</div>

			<div>
				<div>주소</div>
				<span>
					<input type="text" name="address"/>
				</span>
			</div>
			<div>
				<div>직업</div>
				<span>
					<select name="job">
						<option>직업을 선택하세요.</option>
						<option value=' '>무직</option>
						<option value='programmer'>프로그래머</option>
						<option value='designer'>디자이너</option>
					</select>
				</span>
			</div>
			<div>
				<div>메일수신</div>
				<span>
					<input type="radio" name="mailing" value="yes"/>
					<label for="yes">yes</label>
					<input type="radio" name="mailing" value="no"/>
					<label for="no">no</label>
				</span>
			</div>
			<div>
				<div>관심분야</div>
				<span>
					<input type="checkbox" name="interest" value="경제" />
					<label for="경제">경제</label>
					<input type="checkbox" name="interest" value="IT" />
					<label for="IT">IT</label>
					<input type="checkbox" name="interest" value="음악" />
					<label for="음악">음악</label>
					<input type="checkbox" name="interest" value="미술" />
					<label for="미술">미술</label>
					<input type="hidden" name="resultInterest"/>
				</span>
			</div>

			<div style="text-align: center;">
				<span>
					<input type="submit" value="가입" />
					<input type="reset" value="취소" />
				</span>
			</div>

		</form>
	</div>
</body>
</html>