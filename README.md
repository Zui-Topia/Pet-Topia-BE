#F7DF1E
<svg role="img" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><title>JavaScript</title><path d="M0 0h24v24H0V0zm22.034 18.276c-.175-1.095-.888-2.015-3.003-2.873-.736-.345-1.554-.585-1.797-1.14-.091-.33-.105-.51-.046-.705.15-.646.915-.84 1.515-.66.39.12.75.42.976.9 1.034-.676 1.034-.676 1.755-1.125-.27-.42-.404-.601-.586-.78-.63-.705-1.469-1.065-2.834-1.034l-.705.089c-.676.165-1.32.525-1.71 1.005-1.14 1.291-.811 3.541.569 4.471 1.365 1.02 3.361 1.244 3.616 2.205.24 1.17-.87 1.545-1.966 1.41-.811-.18-1.26-.586-1.755-1.336l-1.83 1.051c.21.48.45.689.81 1.109 1.74 1.756 6.09 1.666 6.871-1.004.029-.09.24-.705.074-1.65l.046.067zm-8.983-7.245h-2.248c0 1.938-.009 3.864-.009 5.805 0 1.232.063 2.363-.138 2.711-.33.689-1.18.601-1.566.48-.396-.196-.597-.466-.83-.855-.063-.105-.11-.196-.127-.196l-1.825 1.125c.305.63.75 1.172 1.324 1.517.855.51 2.004.675 3.207.405.783-.226 1.458-.691 1.811-1.411.51-.93.402-2.07.397-3.346.012-2.054 0-4.109 0-6.179l.004-.056z"/></svg>



프로젝트명 : THE PETOPIA <br/> 
프로젝트 기간 : 06/17 ~ 06/24 <br/> 
프로젝트 소개 : <br/> 
최근 반려동물 보유 가구 수가 증가하면서 관련한 시장 규모가 크게 확대되고 있습니다. <br/> 반려동물을 가족처럼 여기는 사람들을 뜻하는 신조어 '펫펨족'(Pet + Family)도 생겨나고 있습니다.<br/> 오프라인 유통업계는 반려동물과 함께하는 고객을 위해 펫 전용 공간과 '개모차' 대여 서비스 등 다양한 펫 프렌들리 서비스를 제공하고 있지만,<br/> 이들 서비스에 대한 정보 부족으로 활용에 어려움을 겪고 있습니다.<br/> 이에 이상적인 반려동물 공간, '펫+유토피아' 합성어인 ‘더 페토피아 (The Petopia)'를 기획하여 <br/>백화점에서 반려견과 함께하는 최적의 환경을 제공하고자 합니다.

백엔드 

객체 관계 다이어그램 ( ERD ) 


<img width="634" alt="스크린샷 2024-07-09 오전 9 26 14" src="https://github.com/Zui-Topia/Pet-Topia-BE/assets/129404679/d09f4b23-dac6-46ef-995e-3f04f1276dc8">

개발참여자 ( 최유경 정은찬 임재성 김도연 ). 

commit convention
<aside>
✅

### 1. 커밋 유형 지정

- 커밋 유형은 영어 소문자로 작성하기
    
    
    | 커밋 유형 | 의미 |
    | --- | --- |
    | feat | 새로운 기능 추가 |
    | build | 빌드 관련 파일 수정에 대한 커밋 
    ex) application.properties  |
    | fix | 버그 수정 |
    | docs | 문서 수정 |
    | style | 코드 formatting, 세미콜론 누락, 코드 자체의 변경이 없는 경우 |
    | refactor | 코드 리팩토링 |
    | test | 테스트 코드, 리팩토링 테스트 코드 추가 |
    | chore | 패키지 매니저 수정, 그 외 기타 수정 ex) .gitignore |
    | design | CSS 등 사용자 UI 디자인 변경 |
    | comment | 필요한 주석 추가 및 변경 |
    | rename | 파일 또는 폴더 명을 수정하거나 옮기는 작업만인 경우 |
    | remove | 파일을 삭제하는 작업만 수행한 경우 |

### 2. 제목과 본문을 빈행으로 분리

- 커밋 유형 이후 제목과 본문은 한글로 작성하여 내용이 잘 전달될 수 있도록 할 것
- 본문에는 변경한 내용과 이유 설명 (어떻게보다는 무엇 & 왜를 설명)

### 3. 커밋 유형을 적고 한 칸 띄고 콜론 적고 한 칸 띈 후 제목 작성하기

```bash
git commit -m "feat : 제목
- 체크 -> 
- "

"feat : 타이틀 - 컴포넌트"
```

### 4. 끝에는 `.` 금지

### 5. 제목은 영문 기준 50자 이내로 할 것

### 6. 자신의 코드가 직관적으로 바로 파악할 수 있다고 생각하지 말자

### 7. 여러가지 항목이 있다면 글머리 기호를 통해 가독성 높이기

```
- 변경 내용 1
- 변경 내용 2
- 변경 내용 3
```

</aside>
