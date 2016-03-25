<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp" />
<div class="container" style="width:1000px; margin:0 auto;">
	<div class="row display-table">
    <div class="col-xs-12 col-sm-4 display-cell" >
	    <ul class="nav nav-pills nav-stacked">
	    	<li class="dropdown active"><a onclick="opr.sysout()">배열출력</a></li>
	    	<li class="dropdown active"><a onclick="opr.score()">어벤저스</a>	</li>
	    	<li class="dropdown active"><a onclick="opr.grade()">성적계산기</a></li>
	    	<li class="dropdown active"><a onclick="opr.gender()">성별 구분하기</a></li>
	    	<li class="dropdown active"><a onclick="opr.bigNum()">최대값</a></li>
	    	<li class="dropdown active"><a onclick="opr.gugudan()">구구단</a></li>
	    	<li class="dropdown active"><a onclick="opr.sum1to100()">1~100까지의 합계</a></li>
	    	<li class="dropdown active"><a onclick="opr.oddSum()">홀수짝수 합</a></li>
	    	<li class="dropdown active"><a onclick="liveScript()">라이브스크립트 호출</a></li>
	    </ul>
    </div>
    <div class="col-xs-12 col-sm-8 display-cell" id="result" style="border: 1px solid black;height: 500px">
        text
    </div>
</div>
<script type="text/javascript">
	function liveScript() {
		alert('라이브스크립트 시절(객체기반언어가 아닌 시절) 은 이렇게 했답니다.');
	}
	
	var opr = {
		sysout : function() {
			var result = '';
			var arr = ['사과', '배', '감', '귤'];
			
			for ( var i in arr) {
				result += arr[i] + '&nbsp;';
			}
			
			document.getElementById("result").innerHTML = result;
		},
		score : function() {
			var result = '';
			var avengers = [];
			avengers.push({name : '아이언', kor : 90, eng : 90, math : 90});
			avengers.push({name : '헐크', kor : 80, eng : 80, math : 80});
			avengers.push({name : '캡아', kor : 70, eng : 70, math : 70});
			
			for ( var i in avengers) {
				avengers[i].getSum = function() {
					return this.kor + this.eng + this.math;
				}
				avengers[i].getAvg = function() {
					return this.getSum() / 3;
				}
				console.log('이름 : ' + avengers[i].name + ', 합계 : ' + avengers[i].getSum() + ', 평균 : ' + avengers[i].getAvg() + '\n');
			}
			
			result = '====== 어벤져스 성적표 ======<br/>';
			result += '이름&nbsp;&nbsp;&nbsp;&nbsp;국어&nbsp;&nbsp;영어&nbsp;&nbsp;수학&nbsp;&nbsp;총점&nbsp;&nbsp;평균<br/>';
			result += '---------------------------------------<br/>';
			for ( var i in avengers) {
				{
					with(avengers[i]){
						result += name + ':&nbsp;&nbsp;&nbsp;' + kor + ':&nbsp;&nbsp;' + eng + ':&nbsp;&nbsp;' + math + ':&nbsp;&nbsp;' 
						+ getSum() + ':&nbsp;&nbsp;' + getAvg() + '<br/>';
					}
				}
			}
			/*
				with 키워드는 배열에 담긴 하나의 객체를 의미한다.
				즉, 예를 들어
				var iron = {name : '아이언', kor : 90, eng : 90, math : 90}
				이렇게 선언된 하나이 객체를 avengers.push(iron) 이라고 줄 경우
				출력문에서 with 를 사용하지 않는다면 iron.name 이런 식으로 일일히
				명시해야 하기 때문에 with 를 사용한다.
			*/
			document.getElementById("result").innerHTML = result;
		}, 
		grade : function() {
			/*
				평균 90 이상 A
				80 B
				70 C
				60 D
				미만 F
			*/
			var result = '';
			var kor = Number(prompt('국어점수')), eng = Number(prompt('영어점수')), math = Number(prompt('수학점수'));
			var avg = (kor + eng + math) / 3;
			
			result = '국어 : ' + kor + '\t 영어 : ' + eng + '\t 수학 : ' + math + '\t 평균 : ' + avg + '\t 결과 : ';
			if (avg >= 90) {
				result += 'A';
			} else if (avg >= 80) {
				result += 'B';
			} else if (avg >= 70) {
				result += 'C';
			} else if (avg >= 60) {
				result += 'D';
			} else {
				result += 'F';
			}
			
			document.getElementById("result").innerHTML = result;
		},
		gender : function() {
			/* 
			800101-1234567 일 경우 flag 값은 1 이다라고 정의함
			*/
			var ssn = prompt('800101-1234567 로 입력해주세요');
			var flag = ssn.charAt(7); // 라면 성별을 판별하는 로직을 switch - case 로 완성하시오
			// 자바의 switch case 와 동일
			
			switch (flag) {
			case '1':case '3':
				result = '남자';
				break;
			case '2':case '4':
				result = '여자';
				break;
			case '5':case '6':
				result = '외국인';
				break;
	
			default:
				result = "잘못된 주민번호입니다.";
				return;
			}
			
			document.getElementById("result").innerHTML = "입력한 주민번호 성별 : " + result;
		},
		bigNum : function() {
			/* 80, 70, 60 일 경우 if 문으로 최대값 을 구하는 로직을 완성하시오 */
			var a = Number(prompt('숫자')), b = Number(prompt('숫자')), c = Number(prompt('숫자'));
			var big = a;
			
			if (big < b) {
				big = b;
			}
			
			if (big < c) {
				big = c;
			}
			
			document.getElementById("result").innerHTML = "최대값 : " + big;
		},
		gugudan : function() {
			var result = '';
			var i=1, j=Number(prompt('출력할 단'));
			for (i = 1; i < 10; i++) {
				result += j + ' * ' + i + ' = ' + j*i + '<br/>';
			}
			
			document.getElementById("result").innerHTML = j + "단 : <br/>" + result;
		},
		sum1to100 : function() {
			var sum=0, i=0;
			
			while (i<101) {
				/* 1부터 100까지의 합을 출력하시오*/
				sum += i;
				i++;
			}
		
			document.getElementById("result").innerHTML = "1부터 100까지의 합 : " + sum;
		},
		oddSum : function() {
			var oddSum=0,evenSum=0,limit=prompt('홀수 짝수의 합을 구하기 위한 한계값 입력');
			for (var i = 0; i <= limit; i++) {
				// 1부터 100 까지 수 중에서 홀수의 합 oddSum 과 
				// 짝수들의 합 evenSum 을 구하시오
				if (i % 2 == 0) {
					evenSum += i;
				} else {
					oddSum += i;
				}
			}
			
			document.getElementById("result").innerHTML = "홀수의 합 : " + oddSum + ", 짝수의 합 : " + evenSum;
		}
	}
</script>